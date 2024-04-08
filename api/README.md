# API 만들기

## 실행 방법
1. 환경변수 작성
    1. `./src/main/resources/env.yml` 작성
        ```yaml
        MYSQL_USER: [사용자명]
        MYSQL_PASSWORD: [비밀번호]
        MYSQL_DATABASE: [DB명]
        MYSQL_HOST: mysql
        ```
    2. `./.env` 작성
       ```
        MYSQL_USER=[사용자명]
        MYSQL_PASSWORD=[비밀번호]
        MYSQL_ROOT_PASSWORD=[루트 비밀번호]
        MYSQL_DATABASE=[DB명]
        ```
2. 실행하기
    ```bash
    docker network create sakak-network
    docker-compose up
    ```

### 참고 사항
- 초기 데이터베이스는 Spring Boot 실행 시 `data-**.sql`에 의해 자동으로 실행됩니다.
- 서버 실행 후 `/api-docs`에서 API 문서를 확인할 수 있습니다.

## 요구사항
- Search API
  - 요청 인자
  
      | 번호 | 변수명 | 타입 | 변수설명 |
      | --- | --- | --- | --- |
      | 1 | food_name | STRING | 식품이름 |
      | 2 | research_year | STRING | 연도(YYYY) |
      | 3 | maker_name | STRING | 지역/제조사 |
      | 4 | food_code | STRING | 식품코드 |
  - 출력항목
  
    | 번호 | 항목 | 설명 |
    | --- | --- | --- |
    | 1 | id | 번호 |
    | 2 | food_cd | 식품코드 |
    | 3 | group_name | 식품군 |
    | 4 | food_name | 식품이름 |
    | 5 | research_year | 조사년도 |
    | 6 | maker_name | 지역/제조사 |
    | 7 | ref_name | 자료출처 |
    | 8 | serving_size | 1회 제공량 |
    | 8 | calorie | 열량(kcal)(1회제공량당) |
    | 10 | carbohydrate | 탄수화물(g)(1회제공량당) |
    | 11 | protein | 단백질(g)(1회제공량당) |
    | 12 | province | 지방(g)(1회제공량당) |
    | 13 | sugars | 총당류(g)(1회제공량당) |
    | 14 | salt | 나트륨(mg)(1회제공량당) |
    | 15 | cholesterol | 콜레스테롤(mg)(1회제공량당) |
    | 16 | saturated_fatty_acids | 포화지방산(g)(1회제공량당) |
    | 17 | trans_fat | 트랜스지방(g)(1회제공량당) |
- CRUD 기능
- DB 실행 파일
- Dockerfile (+ Docker-compose)
- API 문서
