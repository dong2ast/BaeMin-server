# BaeMin-server
server의 작업공간

## 팀원소개

## 역할분담

## 코드컨벤션
- **getter/setter 없이 구현했는가?**

- **핵심 로직을 구현하는 도메인 객체에 getter/setter를 쓰지 않고 구현했는가? 단, DTO는 허용한다.**

- **코드 한 줄에 점(.)을 하나만 허용했는가?**

- **메소드의 인자 수를 제한했는가? 4개 이상의 인자는 허용하지 않는다. 3개도 가능하면 줄이기 위해 노력해 본다.**

- **메소드가 한가지 일만 담당하도록 구현했는가?**

- **클래스를 작게 유지하기 위해 노력했는가?**
    
- **메서드당 line을 10까지만 허용**
    
- **길이가 길어지면 메서드로 분리**

### 변수명 작성 방법
1. 클래스나 메소드명은 파스칼 표기법을 따른다.(모든 단어에서 첫 문자는 대문자 나머지는 소문자)

    ex) HelloWordl, NameViva

2. 변수, 파라미터 등은 카멜 표기법을 따른다.

    ex) helloWordl, nameViva

3. 메서드 이름은 동사/전치사로 시작한다.

    ex) countNumber, withUserId

4. 상수는 대문자로 작성하고 복합어인 경우 '_'를 사용하여 단어를 구분한다.

    ex) public final int SPECIAL_NUMBER = 1;

![image](https://github.com/SOPT-32-CDS/BaeMin-server/assets/31067658/46a03824-1f9c-4a07-b5b4-5931ea5c5d69)


## 깃컨벤션
- 작업 단위로 브랜치 파서 작업 ex) `feat/기능이름`(기능구현 브랜치) `fix/버그이름`(버그수정 브랜치)
- 커밋 메세지는 prefix 붙여서 명확하게 쓰기

> - feat : 새로운 기능과 관련된 것을 의미한다.
> - fix : 오류와 같은 것을 수정했을 때 사용한다.
> - docs : 문서와 관련하여 수정한 부분이 있을 때 사용한다.
> - refactor : 코드의 리팩토링을 의미한다.
> - test : test를 추가하거나 수정했을 때를 의미한다.
> - chore : build와 관련된 부분, 패키지 매니저 설정 등 여러가지 production code와 무관한 부분 들을 의미한다. 말 그대로 자질구레한 일들이다.

- PR comment가 모두 resolve 된 후 merge
- 작업 완료된 후 rebase헤서 충돌 해결 후 PR 생성하기
- squash merge하기

###Commit message 7가지 규칙
- 제목과 본문을 한 줄 띄어 구분
- 제목은 50자 이내
- 제목 첫 글자는 대문자
- 제목 끝에 마침표 X
- 제목은 명령문으로, 과거형 X
- 본문의 각 행은 72자 이내 (줄바꿈 사용)
- 본문은 어떻게 보다 무엇을, 왜에 대하여 설명

## 프로젝트 구조

## ERD
<img width="954" alt="스크린샷 2023-05-17 오후 2 47 55" src="https://github.com/SOPT-32-CDS/BaeMin-server/assets/72637095/12b36a21-9d54-4fbf-bb71-8e589f895e6d">

