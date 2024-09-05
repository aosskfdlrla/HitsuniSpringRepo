package com.hitsuni.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/* config 방법
* 1. xml
* 2. java code
*  */
public class Application {
    private static String DRIVER = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://localhost:3307/hbootcamp";
    private static String USER = "hcamper";
    private static String PASSWORD = "12345";

    public static void main(String[] args) {
        /* DB 접속에 관한 설정 */
        // JdbcTransactionFactory : 수동 커밋, ManagedTransactionFactory : 자동 커밋
        Environment environment = new Environment(
                "dev", // 환경정보 이름
                    new JdbcTransactionFactory(), // 트랜잭션 매니저 종류 (JDBC or MANAGED)
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD)  // Connection Pool 사용 유무 (Pooled or UnPooled)
                );

        /* 생성한 환경 설정 정보로 MyBatis 설정 객체 생성 */
        Configuration configuration = new Configuration(environment);

        /* SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 수현체를 생성하기 위한 빌드 역할
        * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /* 설정 객체에 매퍼(Mapper) 등록 */
        configuration.addMapper(Mapper.class);

        /* openSession() : SqlSession 타입의 인터페이스를 반환하는 메소드로 boolean 타입으로 인자 전달
        * - false : DML 수행 후 auto commit 옵션을 false 로 지정
        *  */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        /* getMapper() : Configuration 에 등록된 매퍼를 동일 타입에 대해 반환 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        /* Mapper 인터페이스에 작성 된 메소드 호출하여 select 쿼리 실행 후 반환 값 출력 */
        java.util.Date date = mapper.selectDate();
        System.out.println("date = " + date);

        /* SqlSession 객체 반납 */
        sqlSession.close();
    }
}
