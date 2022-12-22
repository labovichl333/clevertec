# ClevertecTestTask
## Консольное приложение
Корректные параметры:
- для `itemId-quantity` это `int-int` 
- для карты это `discountCard-int` 
- файлы типа `String`

Примечания:
- файл с картами должен быть последним, а файл с продуктами предпоследним;
Пример запуска приложения в консоли:
````
java by.clevertec.testTask.CheckRunner 3-3 2-5 1-6 card-722 products.txt cards.txt
````

## Web приложение
Корректные параметры:
- для `itemid` это `itemid=int`
- для `quantityid` это `quantityid=int`
- для `discountCard` это `discountCard=int`
- файлы типа `String`



Для запуска Web, достаточно запустить main в классе ClevertecApplication. 
Пример запроса Web приложения:
````
http://localhost:8081/check?item1=1&quantity1=5&item2=3&quantity2=1&discountCard=452&productFile=products.txt&cardFile=discountCards.txt
````

