package com.example.api.food.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.lang.reflect.Field;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Table(name = "food")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sampleId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String foodCode;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String dbGroup;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String product;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String foodName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String researchYear;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String makerName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String collectionTime;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String foodGroup;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String groupName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String servingSize;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String servingSizeUnit;

    @Column(name = "total_size_g", columnDefinition = "TEXT")
    private String totalSizeG;

    @Column(columnDefinition = "TEXT")
    private String totalSizeMl;

    @Column(columnDefinition = "TEXT")
    private String energy;

    @Column(columnDefinition = "TEXT")
    private String water;

    @Column(columnDefinition = "TEXT")
    private String protein;

    @Column(columnDefinition = "TEXT")
    private String fat;

    @Column(columnDefinition = "TEXT")
    private String carbohydrate;

    @Column(columnDefinition = "TEXT")
    private String totalSugars;

    @Column(columnDefinition = "TEXT")
    private String sucrose;

    @Column(columnDefinition = "TEXT")
    private String glucose;

    @Column(columnDefinition = "TEXT")
    private String fructose;

    @Column(columnDefinition = "TEXT")
    private String lactose;

    @Column(columnDefinition = "TEXT")
    private String maltose;

    @Column(columnDefinition = "TEXT")
    private String totalDietaryFiber;

    @Column(columnDefinition = "TEXT")
    private String calcium;

    @Column(columnDefinition = "TEXT")
    private String ironMg;

    @Column(columnDefinition = "TEXT")
    private String ironUg;

    @Column(columnDefinition = "TEXT")
    private String magnesium;

    @Column(columnDefinition = "TEXT")
    private String phosphorus;

    @Column(columnDefinition = "TEXT")
    private String potassium;

    @Column(columnDefinition = "TEXT")
    private String sodium;

    @Column(columnDefinition = "TEXT")
    private String zinc;

    @Column(columnDefinition = "TEXT")
    private String copper;

    @Column(columnDefinition = "TEXT")
    private String manganese;

    @Column(columnDefinition = "TEXT")
    private String selenium;

    @Column(columnDefinition = "TEXT")
    private String retinol;

    @Column(columnDefinition = "TEXT")
    private String betaCarotene;

    @Column(name = "vitamin_d3", columnDefinition = "TEXT")
    private String vitaminD3;

    @Column(columnDefinition = "TEXT")
    private String tocopherol;

    @Column(columnDefinition = "TEXT")
    private String tocotrienol;

    @Column(name = "vitamin_b1", columnDefinition = "TEXT")
    private String vitaminB1;

    @Column(name = "vitamin_b2", columnDefinition = "TEXT")
    private String vitaminB2;

    @Column(columnDefinition = "TEXT")
    private String niacin;

    @Column(columnDefinition = "TEXT")
    private String folate;

    @Column(name = "vitamin_b12", columnDefinition = "TEXT")
    private String vitaminB12;

    @Column(name = "vitamin_c", columnDefinition = "TEXT")
    private String vitaminC;

    @Column(columnDefinition = "TEXT")
    private String totalAminoAcid;

    @Column(columnDefinition = "TEXT")
    private String isoleucine;

    @Column(columnDefinition = "TEXT")
    private String leucine;

    @Column(columnDefinition = "TEXT")
    private String lysine;

    @Column(columnDefinition = "TEXT")
    private String methionine;

    @Column(columnDefinition = "TEXT")
    private String phenylalanine;

    @Column(columnDefinition = "TEXT")
    private String threonine;

    @Column(columnDefinition = "TEXT")
    private String valine;

    @Column(columnDefinition = "TEXT")
    private String histidine;

    @Column(columnDefinition = "TEXT")
    private String arginine;

    @Column(columnDefinition = "TEXT")
    private String tyrosine;

    @Column(columnDefinition = "TEXT")
    private String cysteine;

    @Column(columnDefinition = "TEXT")
    private String alanine;

    @Column(columnDefinition = "TEXT")
    private String asparticAcid;

    @Column(columnDefinition = "TEXT")
    private String glutamicAcid;

    @Column(columnDefinition = "TEXT")
    private String glycine;

    @Column(columnDefinition = "TEXT")
    private String proline;

    @Column(columnDefinition = "TEXT")
    private String serine;

    @Column(columnDefinition = "TEXT")
    private String cholesterol;

    @Column(columnDefinition = "TEXT")
    private String totalSaturatedFattyAcid;

    @Column(columnDefinition = "TEXT")
    private String butyricAcid;

    @Column(columnDefinition = "TEXT")
    private String caproicAcid;

    @Column(columnDefinition = "TEXT")
    private String caprylicAcid;

    @Column(columnDefinition = "TEXT")
    private String capricAcid;

    @Column(columnDefinition = "TEXT")
    private String lauricAcid;

    @Column(columnDefinition = "TEXT")
    private String myristicAcid;

    @Column(columnDefinition = "TEXT")
    private String palmiticAcid;

    @Column(columnDefinition = "TEXT")
    private String stearicAcid;

    @Column(columnDefinition = "TEXT")
    private String arachidicAcid;

    @Column(columnDefinition = "TEXT")
    private String myristoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String palmitoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String oleicAcid;

    @Column(columnDefinition = "TEXT")
    private String vaccenicAcid;

    @Column(columnDefinition = "TEXT")
    private String gadoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String linoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String alphaLinolenicAcid;

    @Column(columnDefinition = "TEXT")
    private String gammaLinolenicAcid;

    @Column(columnDefinition = "TEXT")
    private String acosadienoicAcid;

    @Column(columnDefinition = "TEXT")
    private String arachidonicAcid;

    @Column(columnDefinition = "TEXT")
    private String eicosatrienoicAcid;

    @Column(columnDefinition = "TEXT")
    private String eicosapentaenoicAcid;

    @Column(columnDefinition = "TEXT")
    private String dokosapentaenoicAcid;

    @Column(columnDefinition = "TEXT")
    private String dokosahexaenoicAcid;

    @Column(columnDefinition = "TEXT")
    private String transFattyAcids;

    @Column(columnDefinition = "TEXT")
    private String transoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String transLinoleicAcid;

    @Column(columnDefinition = "TEXT")
    private String transLinolenicAcid;

    @Column(columnDefinition = "TEXT")
    private String does;

    @Column(columnDefinition = "TEXT")
    private String caffeine;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String refName;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String organization;

    public void update(Food newFood) {
        for (Field field : Food.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object newValue = field.get(newFood);
                if (newValue != null) {
                    field.set(this, newValue);
                }
            } catch (IllegalAccessException e) {
                log.error("수정 중 에러 발생", e);
            }
        }
    }
}
