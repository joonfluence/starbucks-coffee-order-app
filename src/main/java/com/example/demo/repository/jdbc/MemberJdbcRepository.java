package com.example.demo.repository.jdbc;

import com.example.demo.domain.Member;
import com.example.demo.dto.member.MemberSaveDto;
import com.example.demo.dto.member.MemberUpdateDto;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MemberJdbcRepository implements MemberRepository {
    private final DataSource dataSource;
    private final JdbcTemplate template;

    @Override
    public Long save(MemberSaveDto member) {
        String query = "insert into member(name) values(?)";
        return Long.valueOf(template.update(query, member.getName()));
    }

    @Override
    public Member findById(Long memberId) {
        String query = "select * from member where id = ?";
        return template.queryForObject(query, memberRowMapper(), memberId);
    }

    @Override
    public List<Member> findAll() {
        String query = "select m from member m";
        return template.query(query, memberRowMapper());
    }

    @Override
    public void update(MemberUpdateDto dto) {
        String query = "update member set name=? where id = ?";
        template.update(query, dto.getName(), dto.getId());
    }

    @Override
    public void delete(Member member) {
        String query = "delete from member where id = ?";
        template.update(query, member.getId());
    }

    public void close(Connection connection, Statement statement, ResultSet rs){
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(statement);
        //주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야 한다.
        DataSourceUtils.releaseConnection(connection, dataSource);
    }

    public Connection getConnection() throws SQLException {
        //주의! 트랜잭션 동기화를 사용하려면 DataSourceUtils를 사용해야 한다.
        Connection connection = DataSourceUtils.getConnection(dataSource);
        log.info("get connection={}, class={}", connection, connection.getClass());
        return connection;
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            return Member.builder().id(Long.parseLong(rs.getString("id"))).name(rs.getString("name")).build();
        };
    }
}
