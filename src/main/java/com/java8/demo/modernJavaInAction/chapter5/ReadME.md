chapter5. 스트림 활용


`filter`
filter메서드는 프레디케이트(boolean을 반환하는 함수)를 인수로 받아
일치하는것 모든요쇼를 포함하는 스트림을 반환한다.
ex) menu.stream()
.filter(Dish::isVagetarian)
.filter(dish->dish.getCalorie > 400)