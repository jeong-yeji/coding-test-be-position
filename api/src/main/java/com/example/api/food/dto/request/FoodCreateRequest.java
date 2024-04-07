package com.example.api.food.dto.request;

import com.example.api.food.entity.Food;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record FoodCreateRequest(
    @NotNull(message = "SAMPLE ID를 입력해주세요.") String sampleId,
    @NotNull(message = "식품코드를 입력해주세요.") String foodCode,
    @NotNull(message = "DB군을 입력해주세요.") String dbGroup,
    @NotNull(message = "상용제품을 입력해주세요.") String product,
    @NotNull(message = "식품명을 입력해주세요.") String foodName,
    @NotNull(message = "연도를 입력해주세요.") String researchYear,
    @NotNull(message = "지역/제조사를 입력해주세요.") String makerName,
    @NotNull(message = "채취시기를 입력해주세요.") String collectionTime,
    @NotNull(message = "식품대분류를 입력해주세요.") String foodGroup,
    @NotNull(message = "식품상세분류를 입력해주세요.") String groupName,
    @NotNull(message = "1회제공량을 입력해주세요.") String servingSize,
    @NotNull(message = "내용량 단위를 입력해주세요.") String servingSizeUnit,
    @NotNull(message = "성분표출처를 입력해주세요.") String refName,
    @NotNull(message = "발행기관을 입력해주세요.") String organization,

    String totalSizeG,
    String totalSizeMl,
    String energy,
    String water,
    String protein,
    String fat,
    String carbohydrate,
    String totalSugars,
    String sucrose,
    String glucose,
    String fructose,
    String lactose,
    String maltose,
    String totalDietaryFiber,
    String calcium,
    String ironMg,
    String ironUg,
    String magnesium,
    String phosphorus,
    String potassium,
    String sodium,
    String zinc,
    String copper,
    String manganese,
    String selenium,
    String retinol,
    String betaCarotene,
    String vitaminD3,
    String tocopherol,
    String tocotrienol,
    String vitaminB1,
    String vitaminB2,
    String niacin,
    String folate,
    String vitaminB12,
    String vitaminC,
    String totalAminoAcid,
    String isoleucine,
    String leucine,
    String lysine,
    String methionine,
    String phenylalanine,
    String threonine,
    String valine,
    String histidine,
    String arginine,
    String tyrosine,
    String cysteine,
    String alanine,
    String asparticAcid,
    String glutamicAcid,
    String glycine,
    String proline,
    String serine,
    String cholesterol,
    String totalSaturatedFattyAcid,
    String butyricAcid,
    String caproicAcid,
    String caprylicAcid,
    String capricAcid,
    String lauricAcid,
    String myristicAcid,
    String palmiticAcid,
    String stearicAcid,
    String arachidicAcid,
    String myristoleicAcid,
    String palmitoleicAcid,
    String oleicAcid,
    String vaccenicAcid,
    String gadoleicAcid,
    String linoleicAcid,
    String alphaLinolenicAcid,
    String gammaLinolenicAcid,
    String acosadienoicAcid,
    String arachidonicAcid,
    String eicosatrienoicAcid,
    String eicosapentaenoicAcid,
    String dokosapentaenoicAcid,
    String dokosahexaenoicAcid,
    String transFattyAcids,
    String transoleicAcid,
    String transLinoleicAcid,
    String transLinolenicAcid,
    String does,
    String caffeine
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
