package com.atto.atto.domain.host.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.atto.atto.domain.host.entity.QHost.host;

@Repository
@RequiredArgsConstructor
public class HostRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public long checkCount() {
        return queryFactory
                .selectFrom(host)
                .fetch().size();
    }

    public long countByName(String name) {

        return queryFactory
                .selectFrom(host)
                .where(host.name.eq(name))
                .fetch()
                .size();
    }

    public long countByIp(String ip) {

        return queryFactory
                .selectFrom(host)
                .where(host.ip.eq(ip))
                .fetch()
                .size();
    }
}
