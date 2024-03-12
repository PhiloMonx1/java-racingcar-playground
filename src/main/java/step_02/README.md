## 기능 요구사항

---

- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 실행 결과
```agsl
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```
---

## Todo List

- [X] Car 클래스가 필요하다.
  - [X] Car 클래스는 String final name 인스턴스 변수를 가지는데, name.length()은 5를 초과할 수 없다.
  - [ ] Car 클래스는 int final goal 클래스 변수를 가진다. //후순위
  - [X] Car 클래스는 int point 인스턴스 변수를 가지는데, isGo() 여부에 따라 증가하며 goal을 초과할 수 없다. (사이드 이펙트?)
  - [X] Car 클래스는 isGo() 메서드를 가지며 해당 메서드는 0~9까지의 랜덤 수를 생성해 해당 숫 자가 4이상 일 경우 true를 리턴한다.
  - [X] Car 클래스는 increasePoint() 메서드를 가지며, isGo()가 true 일 경우 point 인스턴스 변수를 1증가 시킨다.
- [ ] 사용자가 처음 입력한 값을 ','로 split 해서 Car 객체가 Array로 생성된다.
- [ ] 사용자가 두 번째 입력한 값이 숫자일 경우 해당 숫자가 Car 클래스의 goal을 결정한다.
- [ ] CarRacing 클래스가 필요하다.
  - [ ] CarRacing 클래스는 List<Car> cars를 가진다.
  - [ ] CarRacing 클래스는 int final goal 클래스 변수를 가진다. (Car에서도 필요한지 판단 필요)
  - [ ] CarRacing 클래스는 while 문으로 1개 이상의 Car의 point 값이 goal 이상일 때까지 Car의 go()를 실행한다.
  - [ ] CarRacing 클래스는 Car들의 point 값을 리턴하는 함수를 가진다.
  - [ ] CarRacing 클래스는 point값이 goal 이상인 Car의 name을 Sting[]로 리턴하는 함수를 가진다.
- [ ] resultView 클래스가 필요하다. 
  - [ ] resultView 클래스는 CarRacing가 제공한 point를 화면에 노출시키는 함수를 가진다.
  - [ ] resultView 클래스는 게임 시작 메시지 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."를 노출하는 함수를 가진다.
  - [ ] resultView 클래스는 CarRacing가 제공한 point값이 goal 이상인 Car의 names를 가지고 최종 우승자를 노출하는 함수를 가진다.