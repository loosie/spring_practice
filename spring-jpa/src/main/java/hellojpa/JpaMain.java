package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // META-INF -> persistence-unit name :hello
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        try{
//            1.멤버 저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            --em save--
//            em.persist(member);

//            2.멤버 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");

//            jpql 멤버 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5) // pagination
//                    .setMaxResults(10) // pagination
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.getName() = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("loosie");

            //영속
//            System.out.println("=====BEFORE=====");
//            em.persist(member);
//            System.out.println("=====AFTER=====");

            // 1차 캐시 조회
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("loosie");
//            em.persist(member);

//            Member member1 = em.find(Member.class, 101L);
//            System.out.println("member1.getId() = " + member1.getId());;
//            System.out.println("member1.getName() = " + member1.getName());


            //DB에서 조회
//            Member member1 = em.find(Member.class, 101L); //DB
//            Member member2 = em.find(Member.class, 101L); // 1차

            // 영속 엔티티 동일성 보장
//            System.out.println(member1 == member2); // true

            // 트랜잭션을 지원하는 쓰기 지연
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("-------------");

            // 변경감지
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ");
//
//            System.out.println("-------------");

            // em.flush() 사용
//            Member m ember = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("-------------");

            // 준영속 상태
//            Member member = em.find(Member.class, 150L); // 1차 캐시 저장
//            member.setName("AAAAAA");
//
//            em.clear(); // 영속성 컨텍스트 초기화
//
//            Member member2 = em.find(Member.class, 150L); // 다시 1차 캐시 저장
//            System.out.println("===============");


            // EnumType.STRING vs ORDINAL TEST
            // ORDINAL 사용 x -> Enum 데이터 추가시 기존에 DB에 저장된 타입들 변경 안되어서 혼선 발생
//            Member member = new Member();
//            member.setId(3L);
//            member.setUsername("loosie3");
//            member.setRoleType(RoleType.GUSET);


            // 기본 키 매핑
//            Member member = new Member();
//            member.setUsername("B");


            //객체를 테이블에 맞추어 모델링
//            //팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            //회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            //연관관계가 없음
//            Team findTeam = em.find(Team.class, findMember.getTeamId());


//            //단방향 연관관계
//            //팀 저장
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            //회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
//            em.persist(member);
//
//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//
//            //참조를 사용해서 연관관계 조회
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam.getName() = " + findTeam.getName());
//            // 새로운 팀B
//            Team teamB = new Team();
//            teamB.setName("TeamB");
//            em.persist(teamB);
//
//            // 회원1에 새로운 팀B 설정
//            member.setTeam(teamB);
//            //참조를 사용해서 연관관계 조회
//            Team findTeam2 = findMember.getTeam();
//            System.out.println("findTeam2.getName() = " + findTeam2.getName());
//            em.persist(member);


            // 양방향 연관관계
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            //회원 저장
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            // 역방향 조회
//            List<Member> members =findMember.getTeam().getMembers();
//
//            for(Member m : members){
//                System.out.println("m = " + m.getName());
//            }

            // 양방향 연관관계 주의할 점
            //1. 연관관계의 주인에 값 입력 x
            //2. 양방향 매핑시 연관관계의 주인에 값을 입력해야 한다.
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team); // * Member 방향 연관관계 편의 메소드 생성 *
//            team.addMember(member); // * Team 방향 연관관계 편의 메소드 생성 *

            //역방향(주인이 아닌 방향)만 연관관계 설정
//            team.getMembers().add(member);

            //연관관계의 주인에 값 설정
//            member.getTeam(team);

            // toString무한루프 
//            Team findTeam = em.find(Team.class, team.getId());
//            System.out.println("findTeam = " + findTeam);

//            em.persist(member);

            // 일대다 매핑 테스트
//            Member member = new Member();
//            member.setName("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);

            // 상속관계 매핑
//            Movie movie = new Movie();
//            movie.setDirector("a2aaa");
//            movie.setActor("bbb2b");
//            movie.setName("라라2라");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);

            // @MappedSuperclass 예시
//            Member member = new Member();
//            member.setName("user1");
//            member.setCreatedBy("lee");
//            member.setCreatedDate(LocalDateTime.now());
//
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // 프록시
//            Member member = em.find(Member.class, 1L);
//
//            printMember(member);
//            printMemberAndTeam(member);

//            Member member = new Member();
//            member.setName("hello1");
//
//            em.persist(member);
//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            // 프록시 특징 - instance of
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("(refMember instanceof Member) = " + (refMember instanceof Member));
            
            // 프록시 특징 - 영속성 컨텍스트에 이미 있으면 실제 엔티티 반환
//            Member findMember = em.find(Member.class, member.getId());
//            Member refMember = em.getReference(Member.class, member.getId());
//
//            System.out.println("(refMember==findMember) = " + (refMember==findMember));

            // 프록시 특징 - 준영속 상태일 때, 프록시 초기화하면 문제 발생
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
//
//            em.detach(refMember);
//
//            refMember.getName();

            // 프록시 확인
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
            //1
//            refMember.getName();
//            System.out.println("isLoaded=" + emf.getPersistenceUnitUtil().isLoaded(refMember));

            //2
//            System.out.println("refMember.getClass().getName() = " + refMember.getClass().getName());

            //3
//            Hibernate.initialize(refMember); // 강제 초기화

            // 지연로딩 & 즉시로딩
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setName("abcd");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
////            Member m = em.find(Member.class, member1.getId());
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();

            // 영속성 전이 CASCADE
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//
//            // 고아 객체
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

            // 임베디드 타입
//            Member member = new Member();
//            member.setName("abcd");
//            member.setHomeAddress(new Address("city", "street", "101010"));
//            member.setWorkPeriod(new Period());
//            em.persist(member);

            // 값 타입 공유 참조 - 절대 사용 x
//            Address address = new Address("city", "street", "101010");
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(address); // 값 공유 참조
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setHomeAddress(address);// 값 공유 참조
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity"); // 부작용 - 에러 발생

            // 값 타입 복사
//            Address address = new Address("city", "street", "101010");
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode()); // 값 복사
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//
//            member.getHomeAddress().setCity("newCity");

            // 불변 객체
//            Address address = new Address("city", "street", "101010");
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode()); // 값 복사
//            member.setHomeAddress(newAddress);

            // 값 타입 컬렉션
//            Member member = new Member();
//            member.setName("member1");
//            member.setHomeAddress(new Address("city1", "street", "zipcode"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "zipcode"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "zipcode"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            System.out.println("======start=========");
//            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addresses = findMember.getAddressHistory();
//            for(Address address : addresses){
//                System.out.println("address = " + address.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for(String fav : favoriteFoods){
//                System.out.println("fav = " + fav);
//            }

            // 수정
//            Address a =findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            // equals 설정을 해줘야 삭제됨
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "zipcode"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "zipcode"));

            
            // JPQL
//            List<Member> result = em.createQuery(
//                    "select m From Member m where m.name like '%kim%'", Member.class).getResultList();
//            System.out.println("result = " + result.size());
//            for(Member member : result){
//                System.out.println("member = " + member);
//            }

            // Criteria (사용x)
//            //Criteria 사용 준비 
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            //루트 클래스 (조회를 시작할 클래스) 
//            Root<Member> m = query.from(Member.class);
//
//            //쿼리 생성
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> resultList = em.createQuery(cq).getResultList();

            // QueryDSL
//            JPAFactoryQuery query = new JPAQueryFactory(em); 
//            QMember m = QMember.member;
//            List<Member> list = query.selectFrom(m) 
//                    .where(m.age.gt(18)) .orderBy(m.name.desc())  .fetch(); 

            // Native SQL
//            String sql =
//                "SELECT ID, AGE, TEAM_ID, NAME FROM MEMBER WHERE NAME = 'kim'";
//            List<Member> resultList =
//                    em.createNativeQuery(sql, Member.class).getResultList();

            // 프로젝션
//            Member member = new Member();
//            member.setName("member1");
//            member.setAge(20);
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            //SELECT m FROM Member m
//            List<Member> result = em.createQuery("select m From Member m", Member.class)
//                    .getResultList();
//            Member findMember = result.get(0);
//            findMember.setName("change"); // 변경됨 (영속성 컨텍스트 관리 됨)

            // SELECT m.team FROM Member m -> 엔티티 프로젝션
//            List<Team> result = em.createQuery("select m.team From Member m", Team.class)
//                    .getResultList();

            // SELECT m.address FROM Member m
//            String sql ="select m.address From Member m";
//            em.createQuery(sql, Member.class)
//                    .getResultList();

            // SELECT m.username, m.age FROM Member m
//            em.createQuery("select distinct m.username, m.age From Member m", Member.class)
//                    .getResultList();

            //페이징 쿼리
//            for(int i=0; i<100; i++) {
//                Member member = new Member();
//                member.setName("member"+i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();
//            String jpql = "select m from Member m order by m.age desc";
//            List<Member> resultList = em.createQuery(jpql, Member.class)
//                                    .setFirstResult(1)
//                                    .setMaxResults(10)
//                                    .getResultList();
//            System.out.println("resultList.size() = " + resultList.size());
//            for(Member member : resultList){
//                System.out.println("member = " + member);
//            }

            // 조인
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("teamA");
//            member.setAge(10);
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            String query = "select m from Member m, Team t where m.useranme = t.name";
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();

            // 서브 쿼리 (FROM x)
//            String query = "select mm.age, mm.username " +
//                    "from from (select m.age, m.useranme from Member m) as mm";
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();

            // CASE
//            String query = "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            "     when m.age >= 60 then '경로요금' " +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//            for(String s : resultList){
//                System.out.println("s = " + s);
//            }


            // jpql 함수
//            String query = "select concat('a', 'b') From Member m  ";
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//            for(String s : resultList){
//                System.out.println("s = " + s);
//            }

            // 사용자 정의 함수
//            Member member1 = new Member();
//            member1.setName("memberA");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("memberB");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select function('group_concat', m.username) from Member m";
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//            for(String s : resultList){
//                System.out.println("s = " + s);
//            }

            // 경로 표현식
//            Member member1 = new Member();
//            member1.setName("memberA");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("memberB");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m.team from Member m";
//            List<Team> resultList = em.createQuery(query, Team.class)
//                    .getResultList();
//            for(Team s : resultList){
//                System.out.println("s = " + s);
//            }

            // 페치 조인
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setName("memberA");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("memberB");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setName("memberC");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String jpql = "select m from Member m join fetch m.team";
//            List<Member> members = em.createQuery(jpql, Member.class).getResultList();

//            for (Member member : members) {
//                //페치 조인으로 회원과 팀을 함께 조회해서 지연 로딩X
//                System.out.println("username = " + member.getName() + ", "+
//                        "teamName = " + member.getTeam().getName());
//            }

//            String jpql = "select t from Team t join fetch t.members";
//            List<Team> result = em.createQuery(jpql, Team.class).getResultList();
//            for (Team team : result) {
//                //페치 조인으로 회원과 팀을 함께 조회해서 지연 로딩X
//                System.out.println("team = " + team.getName() + "| members ="+ team.getMembers().size());
//                for(Member member : team.getMembers()){
//                    System.out.println("-> member = " + member);
//                }
//            }

            //엔티티 직접 사용

             // 엔티티를 파라미터로 전달
//            String jpql = "select m from Member m where m = :member";
//            List resultList = em.createQuery(jpql)
//                        .setParameter("member", member1)
//                    .getResultList();
//
//              // 식별자를 직접 전달
//            String jpql2 = "select m from Member m where m.id = :member";
//            List resultList2 = em.createQuery(jpql2)
//                    .setParameter("member", member1)
//                    .getResultList();

            // Named 쿼리 - 어노테이션
//            List<Member> resultList =
//                    em.createNamedQuery("Member.findByUsername", Member.class)
//                            .setParameter("username", "회원1")
//                            .getResultList();
//            for(Member member : resultList){
//                System.out.println("member = " + member);
//            }

            // 벌크 연산
            String qlString = "update Member m set m.age = 20";
            int resultCount = em.createQuery(qlString).executeUpdate();

            System.out.println("resultCount = " + resultCount);
            
            // 트랜잭션 커밋
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }


        emf.close();
    }

    private static void printMember(Member member){
        System.out.println("member = " + member.getName());
    }

//    private static void printMemberAndTeam(Member member){
//        String name = member.getName();
//        System.out.println("name = " + name);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }
}

