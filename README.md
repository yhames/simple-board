# simple-board

## Dev-Notes

✅ 오늘 한 것 ❎ 앞으로 할 것 ❌ 모르는 것

<details>

<summary>20230506</summary>

✅ `project.board`의 하위가 아닌 `project`의 하위에 파일을 생성해서 `ComponentScan`이 안됨  
→ `@SpringBootApplication`에 `@CompenentScan` 포함되어있음. `@ComponentScan`의 기본 설정값은 해당 클래스의 패키지, `BoardApplication의`
패키지는 `package project.board`이므로 `proejct.board`에 파일을 작성해야 자동 컴포넌트 스캔이 됨.

✅ Thymeleaf 템플릿을 생성해야하는데 귀찮아서 ChatGPT에 작성해달라고 함.  
→ 작성된 템플릿이 괜찮기는 한데 일부 수정해야할 필요가 있어서 수정함. 추후에 화면부분이 깔끔하게 보일 수 있도록 다시 수정할 예정

✅ `PostService`에서 `List<Post>`를 `List<PostResponse>`로 변환해야하는 작업에 `Stream.map()` 사용  
→ 처음에 생각이 안나서 검색해서 복붙함. MVC패턴에서 Controller, Service, Repository 각 계층에서 어떤 클래스를 매개변수로 받고 어떤 클래스로 반환해야하는지 정립이 안되어있음. 또한
스트림을 자주 사용하지 않다보니 사용방법을 까먹어서 스트림 부분 다시 정리해야할듯.

️❎ 예외처리 안됨 → 제목 혹은 내용 없으면 경고창 띄우기

️❎ 공통로직 처리필요 → 작성시간 표시 등

✅ update 기능 구현하면서 Setter 프로퍼티 사용  
→ 생성자 대신 `builder`패턴 사용, `setter`프로퍼티 지양, domain, dao, dto 클래스에 `setter`프로퍼티 삭제, `builder`패턴 적용. 그런데 `PostRepository`에서
update 부분 어떻게 처리할지 모르곘음.
→ setter 대신 변경의 의도를 알 수 있는 메서드(`changePost()`)를 사용

❌ thymeleaf에서 delete 기능 어떻게 구현하는지 모르겠음

❌ thymeleaf에서 http 요청 보내는 방법 모르겠음  
→ 지금까지 사용한 방법은 href 혹은 form 태그였는데, 이 두가지는 get, post 밖에 구현이 안된다. delete나 put, patch를 구현하려면 어떻게 해야하는지 모르겠다.

❌ `@Lob`, `@Entity` 어노테이션 사용제한  
→ 다양한 예제에서 위의 어노테이션을 사용하는데, 이는 Spring Data JPA를 사용해야함. 아직 잘 모르니 공부하고 사용할 예정.

❌ 데이터베이스 어떤걸로 사용할지 못 정함    
→ Spring Data 공부가 부족해서 일단 메모리에 저장하는 방식으로 직접구현.




</details>

<details>

<summary>20230513</summary>

✅ update 기능 구현하면서 Setter 프로퍼티 사용  
→ setter 대신 변경의 의도를 알 수 있는 메서드(`changePost()`)를 사용

✅ Repository 인터페이스에서 PostCreate 사용  
→ PostCreate를 Post로 가공하는 것을 service 계층에 옮겨서 repository가 post를 받을 수 있도록 수정

</details>




