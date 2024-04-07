package com.example.api.food.dto.request;

import com.example.api.food.entity.Food;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@Schema(description = "식품영양정보 수정을 위한 요청")
public record FoodUpdateRequest(
    @Schema(description = "SAMPLE_ID", example = "D000006-94-AVG") String sampleId,
    @Schema(description = "식품코드", example = "D000006") @NotNull(message = "식품코드를 입력해주세요.") String foodCode,
    @Schema(description = "DB군", example = "음식") String dbGroup,
    @Schema(description = "상용제품", example = "품목대표") String product,
    @Schema(description = "식품명", example = "꿩불고기") String foodName,
    @Schema(description = "연도", example = "2019") String researchYear,
    @Schema(description = "지역 / 제조사", example = "충주") String makerName,
    @Schema(description = "채취시기", example = "평균") String collectionTime,
    @Schema(description = "식품대분류", example = "구이류") String foodGroup,
    @Schema(description = "식품상세분류", example = "육류구이") String groupName,
    @Schema(description = "1회제공량", example = "500") String servingSize,
    @Schema(description = "내용량_단위", example = "g") String servingSizeUnit,
    @Schema(description = "성분표출처", example = "외식영양성분자료집 통합본(2012-2017년)") String refName,
    @Schema(description = "발행기관", example = "식품의약품안전처") String organization,
    
    @Schema(description = "총내용량(g)", example = "-") String totalSizeG,
    @Schema(description = "총내용량(mL)", example = "-") String totalSizeMl,
    @Schema(description = "에너지(㎉)", example = "368.8") String energy,
    @Schema(description = "수분(g)", example = "412.6") String water,
    @Schema(description = "단백질(g)", example = "33.5") String protein,
    @Schema(description = "지방(g)", example = "8.5") String fat,
    @Schema(description = "탄수화물(g)", example = "39.7") String carbohydrate,
    @Schema(description = "총당류(g)", example = "16.9") String totalSugars,
    @Schema(description = "자당(g)", example = "7.2") String sucrose,
    @Schema(description = "포도당(g)", example = "2.8") String glucose,
    @Schema(description = "과당(g)", example = "2.8") String fructose,
    @Schema(description = "유당(g)", example = "0.7") String lactose,
    @Schema(description = "맥아당(g)", example = "3.5") String maltose,
    @Schema(description = "총 식이섬유(g)", example = "9.8") String totalDietaryFiber,
    @Schema(description = "칼슘(㎎)", example = "105.61") String calcium,
    @Schema(description = "철(㎎)", example = "-") String ironMg,
    @Schema(description = "철(㎍)", example = "4") String ironUg,
    @Schema(description = "마그네슘(㎎)", example = "85.39") String magnesium,
    @Schema(description = "인(㎎)", example = "458.05") String phosphorus,
    @Schema(description = "칼륨(㎎)", example = "1243.12") String potassium,
    @Schema(description = "나트륨(㎎)", example = "1264.31") String sodium,
    @Schema(description = "아연(㎎)", example = "3.99") String zinc,
    @Schema(description = "구리(㎎)", example = "0.32") String copper,
    @Schema(description = "망간(㎎)", example = "0.68") String manganese,
    @Schema(description = "셀레늄(㎍)", example = "47.55") String selenium,
    @Schema(description = "레티놀(㎍)", example = "0") String retinol,
    @Schema(description = "베타카로틴(㎍)", example = "1424.58") String betaCarotene,
    @Schema(description = "비타민 D3(㎍)", example = "-") String vitaminD3,
    @Schema(description = "토코페롤(㎎)", example = "8.73") String tocopherol,
    @Schema(description = "토코트리에놀(㎎)", example = "0.06") String tocotrienol,
    @Schema(description = "비타민 B1(㎎)", example = "0") String vitaminB1,
    @Schema(description = "비타민 B2(㎎)", example = "0.33") String vitaminB2,
    @Schema(description = "나이아신(㎎)", example = "3.61") String niacin,
    @Schema(description = "엽산(DFE)(㎍)", example = "63.13") String folate,
    @Schema(description = "비타민 B12(㎍)", example = "0") String vitaminB12,
    @Schema(description = "비타민 C(㎎)", example = "2.99") String vitaminC,
    @Schema(description = "총 아미노산(㎎)", example = "-") String totalAminoAcid,
    @Schema(description = "이소류신(㎎)", example = "1284.38") String isoleucine,
    @Schema(description = "류신(㎎)", example = "2328.6") String leucine,
    @Schema(description = "라이신(㎎)", example = "2484.75") String lysine,
    @Schema(description = "메티오닌(㎎)", example = "645.19") String methionine,
    @Schema(description = "페닐알라닌(㎎)", example = "1274.93") String phenylalanine,
    @Schema(description = "트레오닌(㎎)", example = "1410.84") String threonine,
    @Schema(description = "발린(㎎)", example = "1367.69") String valine,
    @Schema(description = "히스티딘(㎎)", example = "848.54") String histidine,
    @Schema(description = "아르기닌(㎎)", example = "2205.58") String arginine,
    @Schema(description = "티로신(㎎)", example = "919.81") String tyrosine,
    @Schema(description = "시스테인(㎎)", example = "276.5") String cysteine,
    @Schema(description = "알라닌(㎎)", example = "1642.38") String alanine,
    @Schema(description = "아스파르트산(㎎)", example = "2781.77") String asparticAcid,
    @Schema(description = "글루탐산(㎎)", example = "4784.61") String glutamicAcid,
    @Schema(description = "글리신(㎎)", example = "1419.92") String glycine,
    @Schema(description = "프롤린(㎎)", example = "1092.3") String proline,
    @Schema(description = "세린(㎎)", example = "1264.96") String serine,
    @Schema(description = "콜레스테롤(㎎)", example = "106.18") String cholesterol,
    @Schema(description = "총 포화 지방산(g)", example = "1.9") String totalSaturatedFattyAcid,
    @Schema(description = "부티르산(4:0)(g)", example = "0") String butyricAcid,
    @Schema(description = "카프로산(6:0)(g)", example = "0") String caproicAcid,
    @Schema(description = "카프릴산(8:0)(g)", example = "0") String caprylicAcid,
    @Schema(description = "카프르산(10:0)(g)", example = "0") String capricAcid,
    @Schema(description = "라우르산(12:0)(g)", example = "0.01") String lauricAcid,
    @Schema(description = "미리스트산(14:0)(g)", example = "0.03") String myristicAcid,
    @Schema(description = "팔미트산(16:0)(g)", example = "1.28") String palmiticAcid,
    @Schema(description = "스테아르산(18:0)(g)", example = "0.53") String stearicAcid,
    @Schema(description = "아라키드산(20:0)(g)", example = "0.03") String arachidicAcid,
    @Schema(description = "미리스톨레산(14:1)(g)", example = "0") String myristoleicAcid,
    @Schema(description = "팔미톨레산(16:1)(g)", example = "0.08") String palmitoleicAcid,
    @Schema(description = "올레산(18:1(n-9))(g)", example = "2.31") String oleicAcid,
    @Schema(description = "박센산(18:1(n-7))(g)", example = "0.11") String vaccenicAcid,
    @Schema(description = "가돌레산(20:1)(g)", example = "0.03") String gadoleicAcid,
    @Schema(description = "리놀레산(18:2(n-6)c)(g)", example = "3.24") String linoleicAcid,
    @Schema(description = "알파 리놀렌산(18:3(n-3))(g)", example = "0.66") String alphaLinolenicAcid,
    @Schema(description = "감마 리놀렌산(18:3(n-6))(g)", example = "0.02") String gammaLinolenicAcid,
    @Schema(description = "에이코사디에노산(20:2(n-6))(g)", example = "0.01") String acosadienoicAcid,
    @Schema(description = "아라키돈산(20:4(n-6))(g)", example = "0") String arachidonicAcid,
    @Schema(description = "에이코사트리에노산(20:3(n-6))(g)", example = "0.14") String eicosatrienoicAcid,
    @Schema(description = "에이코사펜타에노산(20:5(n-3))(g)", example = "0") String eicosapentaenoicAcid,
    @Schema(description = "도코사펜타에노산(22:5(n-3))(g)", example = "0") String dokosapentaenoicAcid,
    @Schema(description = "도코사헥사에노산(22:6(n-3))(g)", example = "0.02") String dokosahexaenoicAcid,
    @Schema(description = "트랜스 지방산(g)", example = "0.1") String transFattyAcids,
    @Schema(description = "트랜스 올레산(18:1(n-9)t)(g)", example = "0.02") String transoleicAcid,
    @Schema(description = "트랜스 리놀레산(18:2t)(g)", example = "0.05") String transLinoleicAcid,
    @Schema(description = "트랜스 리놀렌산(18:3t)(g)", example = "0") String transLinolenicAcid,
    @Schema(description = "회분(g)", example = "5.8") String does,
    @Schema(description = "카페인(㎎)", example = "-") String caffeine
) {

    public Food toEntity() {
        return Food.builder()
            .sampleId(this.sampleId)
            .foodCode(this.foodCode)
            .dbGroup(this.dbGroup)
            .product(this.product)
            .foodName(this.foodName)
            .researchYear(this.researchYear)
            .makerName(this.makerName)
            .collectionTime(this.collectionTime)
            .foodGroup(this.foodGroup)
            .groupName(this.groupName)
            .servingSize(this.servingSize)
            .servingSizeUnit(this.servingSizeUnit)
            .refName(this.refName)
            .organization(this.organization)
            .totalSizeG(this.totalSizeG)
            .totalSizeMl(this.totalSizeMl)
            .energy(this.energy)
            .water(this.water)
            .protein(this.protein)
            .fat(this.fat)
            .carbohydrate(this.carbohydrate)
            .totalSugars(this.totalSugars)
            .sucrose(this.sucrose)
            .glucose(this.glucose)
            .fructose(this.fructose)
            .lactose(this.lactose)
            .maltose(this.maltose)
            .totalDietaryFiber(this.totalDietaryFiber)
            .calcium(this.calcium)
            .ironMg(this.ironMg)
            .ironUg(this.ironUg)
            .magnesium(this.magnesium)
            .phosphorus(this.phosphorus)
            .potassium(this.potassium)
            .sodium(this.sodium)
            .zinc(this.zinc)
            .copper(this.copper)
            .manganese(this.manganese)
            .selenium(this.selenium)
            .retinol(this.retinol)
            .betaCarotene(this.betaCarotene)
            .vitaminD3(this.vitaminD3)
            .tocopherol(this.tocopherol)
            .tocotrienol(this.tocotrienol)
            .vitaminB1(this.vitaminB1)
            .vitaminB2(this.vitaminB2)
            .niacin(this.niacin)
            .folate(this.folate)
            .vitaminB12(this.vitaminB12)
            .vitaminC(this.vitaminC)
            .totalAminoAcid(this.totalAminoAcid)
            .isoleucine(this.isoleucine)
            .leucine(this.leucine)
            .lysine(this.lysine)
            .methionine(this.methionine)
            .phenylalanine(this.phenylalanine)
            .threonine(this.threonine)
            .valine(this.valine)
            .histidine(this.histidine)
            .arginine(this.arginine)
            .tyrosine(this.tyrosine)
            .cysteine(this.cysteine)
            .alanine(this.alanine)
            .asparticAcid(this.asparticAcid)
            .glutamicAcid(this.glutamicAcid)
            .glycine(this.glycine)
            .proline(this.proline)
            .serine(this.serine)
            .cholesterol(this.cholesterol)
            .totalSaturatedFattyAcid(this.totalSaturatedFattyAcid)
            .butyricAcid(this.butyricAcid)
            .caproicAcid(this.caproicAcid)
            .caprylicAcid(this.caprylicAcid)
            .capricAcid(this.capricAcid)
            .lauricAcid(this.lauricAcid)
            .myristicAcid(this.myristicAcid)
            .palmiticAcid(this.palmiticAcid)
            .stearicAcid(this.stearicAcid)
            .arachidicAcid(this.arachidicAcid)
            .myristoleicAcid(this.myristoleicAcid)
            .palmitoleicAcid(this.palmitoleicAcid)
            .oleicAcid(this.oleicAcid)
            .vaccenicAcid(this.vaccenicAcid)
            .gadoleicAcid(this.gadoleicAcid)
            .linoleicAcid(this.linoleicAcid)
            .alphaLinolenicAcid(this.alphaLinolenicAcid)
            .gammaLinolenicAcid(this.gammaLinolenicAcid)
            .acosadienoicAcid(this.acosadienoicAcid)
            .arachidonicAcid(this.arachidonicAcid)
            .eicosatrienoicAcid(this.eicosatrienoicAcid)
            .eicosapentaenoicAcid(this.eicosapentaenoicAcid)
            .dokosapentaenoicAcid(this.dokosapentaenoicAcid)
            .dokosahexaenoicAcid(this.dokosahexaenoicAcid)
            .transFattyAcids(this.transFattyAcids)
            .transoleicAcid(this.transoleicAcid)
            .transLinoleicAcid(this.transLinoleicAcid)
            .transLinolenicAcid(this.transLinolenicAcid)
            .does(this.does)
            .caffeine(this.caffeine)
            .build();
    }

}
