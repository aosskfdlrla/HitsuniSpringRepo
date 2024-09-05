package com.hitsuni.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);

            /* 전달 되는 것이 JAVA 코드가 아니라 XML 파일이 들어감 */
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            /* selectOne : 조회 결과가 1행인 경우 사용하는 메소드
            * mapper.xml 파일의 namespace 와 select 태그의 id를 통해 수행 구문을 찾아 온다.
            * */
            java.util.Date date = sqlSession.selectOne("mapper.selectDate");
            System.out.println("data = " + date);
            sqlSession.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
