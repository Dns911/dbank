package com.dbank.dbankoperationservice.entity;

import com.dbank.dbankoperationservice.entity.enums.CardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@SuperBuilder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "t_card", schema = "operation_service")
public class Card extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @Column(name = "card_number", nullable = false)
    Long cardNumber;

    @Column(name = "expire_date", nullable = false)
    LocalDateTime expireDate;

    @Column(name = "card_status", nullable = false)
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @ManyToOne
    @JoinColumn(name = "card_profile_id")
    CardProfile cardProfile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        if (!super.equals(o)) return false;

        if (!Objects.equals(account, card.account)) return false;
        if (!Objects.equals(cardNumber, card.cardNumber)) return false;
        if (!Objects.equals(expireDate, card.expireDate)) return false;
        return Objects.equals(cardProfile, card.cardProfile);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (cardProfile != null ? cardProfile.hashCode() : 0);
        return result;
    }
}
