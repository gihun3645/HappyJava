## Enum

### 상수 사용시의 문제점

- JDK 5 이전에 어떤 상수들은 표현하고자 한다면 다음과 같은 클래스를 작성했다.

```java
package EnumType;

public class DayType {
    public final static int SUNDAY = 0;
    public final static int MONDAY = 1;
    public final static int TUESDAY = 2;
    public final static int WEDNESDAY = 3;
    public final static int THURSDAY = 4;
    public final static int FRIDAY = 5;
    public final static int SATURDAY = 6;
}
```

- DayType 클래스는 final static int로 정의된 상수를 6개 가지고 있다.

```java
int today = DayType.SUNDAY;
```

- today는 SUNDAY 상수값을 가지게 되니 0이라는 숫자 값을 가지게 된다.
- 아래와 같이 일요일인지 검사할 수도 있다.

```java
if(today == DayType.SUNDAY) {
	System.out.println("일요일 입니다.");
}
```

- 문제는 요일을 나타내는 값이 int형이라는 의미다.

```java
int today = 100;
```

- 정해진 값만 변수에 할당할 수 없다는 문제점이 있다. 이러한 것을 타입에 안전하지 않다고 한다.

### Enum 사용하기

- 클래스를 생성하는 것과 같은 방식으로 Enum을 생성한다.
- 패키지를 생성한다.
- 생성된 패키지 아래에 Day enum을 생성한다.

```java
package EnumType;

public enum Day {
    SUMDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    FRIDAY,
    SATURDAY
}
```

- DAY안에 상수를 나타내는 값을 적는다. 보통 모두 대문자로 표현을 하는데, 상수와 상수는 컴마(,)로 구분을 한다.
- Enum 타입을 필드로 가지는 Today클래스를 다음과 같이 작성한다.

```java
package EnumType;

public class Today {
    private Day day;

    public Day getDay()  {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
```

- Today 클래스의 필드로 Day타입 day가 선언된 것을 볼 수 있다.
- 이제 Today를 사용하는 TodayTest 클래스를 다음과 같이 작성한다.

```java
package EnumType;

public class TodayTest {
	public static void main(String[] args) {
		Today today = new Today();
		// setDay에는 Day 클래스에서 설정한 7가지만 올 수 있다.
		today.setDay(Day.SUNDAY);
		System.out.println(today.getDay());
	}
}
```

위의 코드를 실행하면 다음과 같다.

```java
SUNDAY
```

```java
today.setDay(Day.SUNDAY);
```

- today의 setDay() 메소드에는 Enum 타입인 Day가 전달되야 한다.
- 이 경우 정수로 선언된 상수와 다르게 Day안에 선언된 상수만 값으로 전달 할 수 있다.

```java
today.setDay(100);
```

- 위와 같은 코드는 사용할 수 없다. 이러한 것을 타입에 안전하다(Type-Safety)하다고 말한다.

```java
System.out.println(today.getDay());
```

- today가 가지고 있는 Day 타입의 상수값을 출력한다. 상수 이름이 그대로 출력된다.

### Enum 타입의 특징

- Enum은 타입에 대해 안전하다. 미리 정의된 Enum 변수안의 상수만을 대입할 수 있다.

```java
Day day = Day.SUNDAY;
```

와 같은 코드는 되지만

```java
Day day = 5;
```

와 같은 코드는 사용할 수 없다.

### Enum 타입의 특징

- Enum은 switch문에서 사용가능하다.
- Enum은 switch문에서 사용가능하다. (JDK 7이상 부터는 switch문에서 String도 사용가능하다.)

### Enum 예제

```java
package EnumType;

public class DaySwitchTest {
	public static void main(String[] args) {
	Day day = Day.SUNDAY;

	switch(day) {
		case SUNDAY :
			System.out.println("일요일입니다.");
			break;
			case MONDAY :
				System.out.println("월요일입니다.");
				break;
			default :
				System.out.println("그 밖의 요일");
		}
	}
}
```

- day가 어떤 상수냐에 따라서 알맞은 case부분이 실행된다.
- 이때 조심해야 할 것은 case 다음에는 Day가 가지고 있는 상수의 이름이 나와야 한다는 것이다.
- case 다음에 Day.SUNDAY 라고 사용하면 컴파일 오류가 발생한다. (왜 그런지 궁금합니다.)
- 실행결과

```java
일요일입니다.
```

### Enum 타입이 특징

- Enum 생성자와 값 지정하기
- Enum은 생성자를 가질 수 있다. 단 생성자는 private해야 한다.
- Enum의 생성자는 내부에서만 호출가능하다.

```java
package EnumType;

public enum Gender {
    MALE("XY"),
    FEMALE("XX");

    private String chromosome; // 염색체
    private Gender(String chromosome) {
        this.chromosome = chromosome;
    }
}
```

- Gender Enum 타입은 MALE과 FEMALE 2가지 상수를 가진다.
- 앞의 예제와는 다르게 상수 뒤에 (”XY”)와 (”XX”)가 붙어 있다.
- 상수 뒤에 괄호 열고 닫고 기호가 있으면 Enum의 생성자를 호출하게 돈다.
- 생성자가 호출되며 chromosome가 초기화된다.

위와 같이 값을 지정했다 하더라도 앞에서 설명한 것처럼 사용하면 됩니다.

```java
package EnumType;

public class GenderTest {
	public static void main(String[] args) {
		Gender gender = Gender.MALE;

		System.out.println(gender);
	}
}
```

- Gender타입의 변수 gender에는 Gender.MALE이나 Gender.FEMALE값만 할당할 수 있다.
- 해당 gender를 출력하면 상수이름이 그래도 출력되는 것을 알 수 있다.
- 실행결과
- `MALE`

### Enum에 메소드와 변수 선언하기

- Enum안에 선언된 메소드나 변수를 가질 수 있다.
- 또한 Object가 가지고 있는 메소드를 오버라이딩할 수도 있다.
- Gender Enum을 생성할 때 chromosome 필드를 작성했었다.
- 이번엔 Gender Enum에 Object가 가지고 있는 toString() 메소드를 오버라이딩을 한다.

```java
package EnumType;

// enum 타입
public enum Gender {
	MALE("XY");
	FEMALE("XX");
	
	private String chromosome; // 염색체
	private Gender(String chromosome) {
		this.chromosome = chromosome;
	}

	// toString() 메소드를 오버라이딩해서 enum타입을 출력할 수 있다.
	@Override
	public String toString() {
		return "Gender{"+"chromosome='"+chromosome+''\'+'}';
	}

	public void print() {
		system.println("염색체 정보 : "+chromsome);
	}
}
```

```java
package EnumType;

public class GenderTest {
	public static void main(String[] args) {
		Gender gender = Gender.MALE;

		System.out.println(gender);

		gender.print();
	}
}
```

- 실행결과는 다음과 같다.

```java
Gender{chromosome='XY'}
염색체 정보 : XY
```

### Enum값끼리 비교할 때는 == 를 사용한다.

- 아래의 예제와 같이 ==를 이용해서 Enum타입으로 초기화된 변수를 비교할 수 있다.

```java
Day day1 = Day.MONDAY;
Day day2 = Day.MONDAY;

if(day1 == day2) {
	System.out.println("같은 요일입니다.");
}
```

### EnumMap

EnumMap은 Enum타입을 키(key)로 사용할 수 있도록 도와주는 클래스이다.

```java
package EnumType;

// EnumMap은 키값을 Enum 타입만 가질 수 있음
import java.util.EnumMap;

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap emap = new EnumMap(Day.class);
        emap.put(Day.SUNDAY, "일요일은 잠자는 것이 최고!");
        emap.put(Day.FRIDAY, "불금!!");
        emap.put(Day.MONDAY, "월요병.");

        System.out.println(emap.get(Day.SUNDAY));
    }
}
```

```java
EnumMap emap = new EnumMap(Day.class);
```

- EnumMap 객체를 생성하는데, Key로 사용할 Enum 타입 Day.class를 생성자 인자로 전달하였다.

```java
emap.put(Day.SUNDAY, "일요일은 잠자는 것이 최고!");
emap.put(Day.FRIDAY, "불금!!");
emap.put(Day.MONDAY, "월요병.");
```

- 키(key)값으로 Enum타입 Day에서 정의한 상수를 사용하였다.

```java
System.out.println(emap.get(Day.SUNDAY));
```

- Day.SUNDAY 를 키값으로 하는 값을 출력한다.
- 실행결과

```java
일요일은 잠자는 것이 최고
```

### EnumSet

- EnumSet은 Enum 상수를 Set자료구조로 다루기 위한 유용한 메소드

```java
package EnumType;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetTest {
    public static void main(String[] args) {
				// Day가 가지고 있는 모든 상수는 Enumset에다가 넣어줌
        EnumSet eset = EnumSet.allOf(Day.class);

        Iterator<Day> dayIter = eset.iterator();

				// hasNext는 꺼낼 값이 있으면 true를 반환함
        while (dayIter.hasNext()) {
            Day day = dayIter.next();
            System.out.println(day);
        }
        System.out.println("------------------------------------------");
				
				// 월요일부터 수요일까지
        EnumSet eset2 = EnumSet.range(Day.MONDAY, Day.WEDNESDAY);
        Iterator<Day> dayIter2 = eset2.iterator();
        while (dayIter2.hasNext()) {
            Day day = dayIter2.next();
            System.out.println(day);
        }
    }
}
```

### Enum은 인터페이스를 구현하고, 해당 인터페이스를 오버라이딩하여 구현할 수 있다.

Enum은 인터페이스를 구현하고, 해당 인터페이스를 오버라이딩하여 구현할 수 있다.

```java
package EnumType;

public interface Printer {
    public void print();
}
```

```java
package EnumType;

public enum Color implements Printer {
	RED("FF0000");
	GREEN("00FF00");
	BLUE("0000FF");

	private String rgb;
	private Color(String rgb) {
		this.rgb = rgb;
	}

	@Override
	public void print() {
		System.out.println("rgb : "+rgb);
	}
}
```

```java
package EnumType;

public class ColorTest {
	public static void main(String[] args){
		Color color = Color.RED;
		color.print(); // rgb : FF0000
	}
}
```

### Enum은 추상메소드를 가질 수 있다.

- Enum은 추상메소드를 가질 수 있다. 추상 메소드를 가질 경우엔 상수를 정의할 때 추상메소드를 함께 구현해 줘야한다.

```java
package EnumType;

public enum Country {
    KOREA {
        public void print() {
            System.out.println("대한민국");
        }
    },
    JAPAN {
        public void print() {
            System.out.println("일본");
        }
    },
    USA {
        public void print() {
            System.out.println("미국");
        }
    };
    public abstract void print();
}
```

```java
package EnumType;

public class CountryTest {
    public static void main(String[] args) {
        Country country = Country.KOREA;
        country.print();
    }
}
```

```java
country.print();
```

- country에 Country.KOREA 상수를 대입하기 때문에 KOREA 상수에서 구현된 print() 메소드가 사용된다.
- 실행결과

```java
대한민국
```

### 그 밖의 특징들

Enum은 그외에도 다음과 같은 특징을 가지고 있다.

- Enum 객체는 Enum 상수가 처음 호출되거나 참조될 때 생성된다.
- Enum은 Serializable과 Comparable 인터페이스를 이미 구현하고 있다.