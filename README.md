# 아토리서치 과제



## 사용 기술 스텍
* Spring boot 2.6.7
* JAVA 11
* MariaDB
* Gradle
* JPA
* QueryDsl

-----------

## 구현 API

* 조회 API
* 등록 API
* 수정 API
* 삭제 API
* ALIVE 상태 단일 조회 API
* ALIVE 상태 전체 조회 API
-----------



## API 설명

-----------
### 조회 API

**Method** : *GET* <br>
**API EndPoint** : */api/atto/host/{id}* <br>
**Request** : *Host의 PK* <br>

**호출 성공 예시**

<img width="439" alt="image" src="https://user-images.githubusercontent.com/72774518/171986220-2e262be3-071c-4228-a3a2-bc511e4979c4.png">

**Host의 PK가 존재하지 않을 경우** <br>
<img width="302" alt="image" src="https://user-images.githubusercontent.com/72774518/171986490-d6426639-7579-4cdd-a8bb-455934601b0c.png">

---------
### 등록 API 

**Method** : *POST* <br>
**API EndPoint** : */api/atto/host* <br>
**Request** : <br>
  { "ip": "", <br>
    "name":"" <br>
    } <br>

**호출 성공 예시** <br>

<img width="426" alt="image" src="https://user-images.githubusercontent.com/72774518/171986673-fa40ad35-3c4c-414a-9c1c-528dedaadb16.png">
<br>

**IP & HOST 가 중복일 경우**

<img width="282" alt="image" src="https://user-images.githubusercontent.com/72774518/171987540-e1423d34-b683-410f-8852-3b288095596e.png"> <br>

<img width="278" alt="image" src="https://user-images.githubusercontent.com/72774518/171987547-4548fbbc-ceb6-42a6-9804-d8211ef998c2.png">

**등록된 호스트가 100개 이상일 경우**

<img width="368" alt="image" src="https://user-images.githubusercontent.com/72774518/171987653-982f8834-590a-46f6-9a2c-b9d7137bb141.png">

----------


### 수정 API 

**Method** : *PUT* <br>
**API EndPoint** : */api/atto/host/{id}* <br>
**Request** :  *Host의 PK,* <br>
<br>
  { "ip": "", <br>
    "name":"" <br>
    } <br>
**호출 성공 예시** <br>

<img width="426" alt="image" src="https://user-images.githubusercontent.com/72774518/171986673-fa40ad35-3c4c-414a-9c1c-528dedaadb16.png">
<br>

**IP & HOST 가 중복일 경우**

<img width="282" alt="image" src="https://user-images.githubusercontent.com/72774518/171987540-e1423d34-b683-410f-8852-3b288095596e.png"> <br>

<img width="278" alt="image" src="https://user-images.githubusercontent.com/72774518/171987547-4548fbbc-ceb6-42a6-9804-d8211ef998c2.png">

---------

### 삭제 API 

**Method** : *DELETE* <br>
**API EndPoint** : */api/atto/host/{id}* <br>
**Request** :  *Host의 PK* <br>

**호출 성공 예시** <br>

<img width="426" alt="image" src="https://user-images.githubusercontent.com/72774518/171986673-fa40ad35-3c4c-414a-9c1c-528dedaadb16.png">

-----------


### HOST의 ALIVE 단일 조회 ###


**조회시 해당 IP로 isReachable method 실행하며 결과값이 true이면 lastAliveDate를 현재 시간으로 Update** 

**Method** : *GET* <br>
**API EndPoint** : */api/atto/host/alive/{id}* <br>
**Request** :  *Host의 PK* <br>


 


**호출시 Host의 Alive상태가 trure 일경우** <br>


<img width="486" alt="image" src="https://user-images.githubusercontent.com/72774518/171987816-e786a736-cece-4e26-9d4e-cbf53ceffa8f.png">



**호출시 Host의 Alive상태가 false 일경우** <br>

<img width="494" alt="image" src="https://user-images.githubusercontent.com/72774518/171987850-691b279c-aaf1-4387-bbad-e2895ed4da2e.png">


-----------




### HOST의 ALIVE 전체 조회 ###


**조회시 Host들의 IP로 isReachable method 실행하며 결과값이 true이면 lastAliveDate를 현재 시간으로 Update** 

**Method** : *GET* <br>
**API EndPoint** : */api/atto/host/alive* <br>


**호출 성공 예시** <br>

<img width="641" alt="image" src="https://user-images.githubusercontent.com/72774518/171988082-ffeae656-83c9-4974-b107-bcb988c0b202.png">


**호스트가 모두 Unreachabled일때 조회 결과**

응답까지 걸린 시간 466ms

<img width="1461" alt="image" src="https://user-images.githubusercontent.com/72774518/171988358-87ad50df-ec80-407b-b553-8af6450e33af.png">





