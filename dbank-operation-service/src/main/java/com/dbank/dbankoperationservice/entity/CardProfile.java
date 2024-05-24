package com.dbank.dbankoperationservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "t_card_profile", schema = "operation_service")
public class CardProfile extends AbstractEntity{

    @Column(name = "profile_name", nullable = false)
    String profileName;

    @Column(name = "monthly_amount", nullable = false)
    BigDecimal monthlyAmount;

    @Column(name = "valid_period")
    Integer validPeriod;

    @Column(name = "is_active")
    boolean isActive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardProfile that)) return false;
        if (!super.equals(o)) return false;

        if (isActive != that.isActive) return false;
        if (!Objects.equals(profileName, that.profileName)) return false;
        if (!Objects.equals(monthlyAmount, that.monthlyAmount))
            return false;
        return Objects.equals(validPeriod, that.validPeriod);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (profileName != null ? profileName.hashCode() : 0);
        result = 31 * result + (monthlyAmount != null ? monthlyAmount.hashCode() : 0);
        result = 31 * result + (validPeriod != null ? validPeriod.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }
}