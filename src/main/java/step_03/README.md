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

- [ ] Car 클래스가 필요하다.
  - [ ] Car 클래스는 String final name 인스턴스 변수를 가지는데, name.length()은 5를 초과할 수 없다.
  - [ ] Car 클래스는 isGo() 메서드를 가지며 해당 메서드는 0~9까지의 랜덤 수를 생성해 해당 숫 자가 4이상 일 경우 true를 리턴한다.
  - [ ] Car 클래스는 increasePoint() 메서드를 가지며, isGo()가 true 일 경우 point 인스턴스 변수를 1증가 시킨다.
- [ ] 첫 번째 인자의 값을 ','로 split 해서 Car 객체가 ArrayList로 생성된다.
- [ ] 두 번째 인자의 값이 숫자일 경우 해당 숫자가 Car 클래스의 goal을 결정한다.
- [ ] CarRacing 클래스가 필요하다.
  - [ ] CarRacing 클래스는 List<Car> cars를 가진다.
  - [ ] CarRacing 클래스는 int final goal 클래스 변수를 가진다.
  - [ ] CarRacing 클래스는 while 문으로 1개 이상의 Car의 point 값이 goal 이상일 때까지 Car의 go()를 실행한다.
  - [ ] CarRacing 클래스는 Car들의 point 값을 리턴하는 함수를 가진다.
  - [ ] CarRacing 클래스는 point값이 goal 이상인 Car의 name을 Sting[]로 리턴하는 함수를 가진다.
- [ ] resultView 클래스가 필요하다. 
  - [ ] resultView 클래스는 CarRacing가 제공한 point를 화면에 노출시키는 함수를 가진다.
  - [ ] resultView 클래스는 게임 시작 메시지 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."를 노출하는 함수를 가진다.
  - [ ] resultView 클래스는 CarRacing가 제공한 point값이 goal 이상인 Car의 names를 가지고 최종 우승자를 노출하는 함수를 가진다.

## Check List
- [ ] 모든 원시 값을 포장했는가
- [ ] 일급 컬렉션을 사용했는가
- [ ] 들여쓰기가 한 번만 사용 되었는가 (예를 들어 while문 안에 if문이 있으면 들여쓰기는 두 번이다.)
- [ ] else 예약어, 삼항 연산자를 사용하지 않았는가
- [ ] getter, setter를 하나도 사용하지 않았는가
- [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않았는가
- [ ] 모든 메서드의 단위 테스트가 존재하는가
- [ ] MVC 패턴에 맞게 클래스가 단일 원칙을 지키고 있는가

## 구현 설계
1. Domain (Model)
2. ~~View~~
3. Application (Controller)

---

 2번 View 부터 TDD로 구현
> 1. `MessageView` 클래스가 필요하다
> 2. `MessageView` 클래스는 게임과 무관하게 Message를 print 하는 로직만을 가진다. public 하고 static 한 메서드만을 가진다.
> 3. `MessageView` 클래스의 메서드는 어느 것에도 의존되지 않고, 어느 것도 의존하지 않는다. print 메서드는 노출 해야 하는 print 값을 파라미터로 받는다.
> - [X] printGameMessage(GameMessage message) : sout(message)를 한다.
> - [X] printWinners(String[] winnersName) : for (String winnerName : winnersName) winnerName을 ","를 구분하여 묶은 후 우승메시지와 함께 sout한다.
> - [X] printCurrentPointOfCar(String carName, int currentPoint) : sout(carName : repeatedSymbol("-", currentPoint))한다.
> - ~~[ ] printWinners(List<Car> winners) : winners 에서 Car 객체를 하나씩 뽑아 ","로 묶은 후 "가 최종 우승했습니다." 와 결합해서 sout한다~~
> - ~~[ ] printCurrentPointOfCar(Car car) sout(car.name : repeatedSymbol(-, car.point)) 한다.~~
> 4. 게임 관련 메시지를 관리하는 `GameMessage` Enum이 필요하다.

> `MessageView` 클래스의 메서드로 구현하려 했으나 단일 책임 원칙을 지키기 위해 분리한 메서드
>
> [StringUtil.java](utils%2FStringUtil.java) 클래스로 분리하였다.
> - [X] repeatedSymbol(String symblo, int count) : count 만큼 symblo을 반복해서 String으로 만든 후 리턴한다.

> 구현을 하다보니 printWinners(), printCurrentPointOfCar()의 경우 Car 객체가 없는 경우 파라미터를 구현하기 까다롭다는 사실을 알게되었다.
>
> 내가 선택한 방법은 `Car`를 만든 이후 `MessageView` 클래스를 상속하는 `GameMessageView` 클래스를 만드는 것이다. `MessageView`에선
> Car 객체 대신 자바 기본 타입을 가지고 로직을 수행하는 메서드를 구현하고, `GameMessageView` 에선 메서드를 오버라이드 해서 Car 객체를 파라미터로 로직을
> 수행하도록 구현하고자 한다.

---

- [X] Domain `Car` 클래스 구현 (TDD)

> 1. 모든 인스턴스 변수는 원시 값이 아닌 포장된 래퍼 클래스를 사용한다.
> 2. `Car` 클래스의 모든 메서드는 단위 테스트가 가능해야 하며, point 값이 변경되는 로직은 Ramdom에 의존해선 안된다.

---

-[X] `GameMessageView` view 클래스 구현

> 1. MessageView 클래스를 상속한다.
> 2. MessageView 클래스가 가진 protected 메서드를 Override 한다
> 3. Override 한 메서드 내부에선 `Car` 객체를 사용해서 부모의 메서드를 사용한다.

```java
package step_03.view;

import java.util.List;
import step_03.domain.Car;

public class GameMessageView extends MessageView {

  @Override
  public void printWinners(List<Car> winnersName) {
    // winnersName의 Car 객체의 CarPoint 객체의 인스턴스 변수 값을 String[] 만들어 전달해야 한다.
    super.printWinners();
  }

  @Override
  public void printCurrentPointOfCar(Car car) {
    // Car 객체의 CarName의 인스턴스 변수 값과 CarPoint인스턴스 변수 값를 각각 전달해야 한다.
    super.printCurrentPointOfCar();
  }
}
```

> 구현 중 문제가 생겼다. getter를 사용하지 않고 주석에 적힌 요구사항을 어떻게 구현할 수 있을까? Car 객체를 통해 래퍼 클래스들의 인스턴스를 새로 만들어서 전달할 수
> 있을까? 

```java
package step_03.view;

import java.util.List;
import step_03.domain.Car;

public class GameMessageView extends MessageView {

	public void printWinners(List<Car> winnersName) {
		String[] winners = new String[winnersName.size()];
		for (int i = 0; i < winnersName.size(); i++) {
			winners[i] = extractCarName(winnersName.get(i));
		}
		super.printWinners(winners);
	}

	public void printCurrentPointOfCar(Car car) {
		super.printCurrentPointOfCar(extractCarName(car), extractCarPoint(car));
	}

	private String extractCarName(Car car) {
		return car.getCarName().toString();
    }

  private int extractCarPoint(Car car) {
    return car.getCarPoint().getPoint();
  }
}
```

> 결국 `GameMessageView` 를 구현하기 위해서 `Car` 와 래퍼 클래스에 getter 메서드를 만들 수 밖에 없었다.
> 다른 방법의 가능성을 찾아보았으나, 찾지 못했다.

---

-[X] `Racing` Domain 클래스 구현

<details>
  <summary>시행 착오</summary>

> 1. ~~인스턴스 변수는 오직 하나이며 `List<Car> cars` 를 가진다.~~
> 2. ~~cars 인스턴스 변수는 일급컬렉션으로 랩핑한다.~~
> 3. ~~playRacing(int goal) 메서드를 가진다.~~

```java
package step_03.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private final RacingCars cars;

  public RacingGame(RacingCars racingCars) {
    this.cars = racingCars;
  }

  public RacingCars playGame(int goal) {
    List<Car> playCars = cars.getRacingCars();
    List<Car> winners = new ArrayList<>();

    while (winners.isEmpty()) {
      winners = getWinners(playCars, goal);
      playCars = getWinners(playCars, goal);
    }
    return new RacingCars(winners);
  }

  private List<Car> getWinners(List<Car> playCars, int goal) {
    List<Car> winners = new ArrayList<>();

    for (Car car : playCars) {
      if (car.getCarPoint().getPoint() >= goal) {
        winners.add(car);
        continue;
      }
      boolean isMove = getRandomMoveChance();
      car.move(isMove);
    }
    return winners;
  }

  private boolean getRandomMoveChance() {
    Random random = new Random();
    return random.nextInt(10) < 4;
  }
}
```

> 이 상황에서의 playGame()을 보자. 해당 메서드에는 2가지 문제점이 있다.
>
> 1. while 문이 끝나지 않는다.
> 2. 레이싱 중인 Car 들의 진행 상태를 노출하기 위해선 내부에서 printCurrentPointOfCar()를 사용해야 한다.
>
> 여기서 1번 문제점을 좀 더 살펴보자.
>
> while 문이 끝나지 않는 이유는 getWinners() 내부에서 move() 를 통해 변경된 Car 객체들이 새로 반환 될 때 반영되지 않기 때문이다.
> getWinners() 는 goal에 도달한 객체만을 담아서 반환하기 때문, 이 외에도
>
> 1. getWinners() 메서드가 RacingCars 일급 컬렉션을 반환하지 않는 문제
> 2. getWinners() 메서드가 내부에서 랜덤을 직접 사용하고 있어 테스트가 어려운 문제
>
> 등 `RacingGame`을 구현하고 나니 Application 과 View 를 구현하는데 문제가 생기고 있었다.

> 그래서 내가 선택한 방법은 `RacingGame` 클래스의 책임을 줄이는 것이었다.

```java
package step_03.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

  public RacingCars moveCars(RacingCars playCars, boolean[] isMoves) {
    List<Car> movedCars = new ArrayList<>();
    int count = 0;
    for (Car car : playCars.getRacingCars()) {
      movedCars.add(car.move(isMoves[count]));
      count++;
    }
    return new RacingCars(movedCars);
  }

  public List<Car> getWinners(RacingCars playCars, int goal) {
    List<Car> winners = new ArrayList<>();

    for (Car car : playCars.getRacingCars()) {
      if (car.getCarPoint().getPoint() >= goal) {
        winners.add(car);
      }
    }
    return winners;
  }
}
```

</details>

> Todo List를 먼저 작성하고 구현하는 것이 원칙이나, 구현 중 시행 착오를 거치게 되면서 라이브 코딩으로 기능 구현을 마친 후 구현에 대해 적게 되었다.
>
> `Racing` 클래스는 view, random 등에 의존하지 않도록 작성되었다.
>
> moveCars() 메서드는 파라미터로 RacingCars를 받아서 내부의 Car 객체들의 point를 증가시키는 즉, Cars 의 이동을 담당하게 된다. 이 때, 전달한
> Car의 갯수와 동일한 길이의 boolean[] 를 인자로 전달하여, 각 Car가 이동을 할지 하지 않을지 정할 수 있도록 했다.
>
> getWinners() 메서드는 RacingCars 와 int goal 을 파라미터로 받아 RacingCars 내부의 Car 중에서 point 값을 goal과 비교한다. 만약
> 크거나 같을 경우 해당하는 Car 를 List에 담아서 리턴한다.