package com.dbank.dbankoperationservice.entity;

import com.dbank.dbankoperationservice.entity.enums.AccountStatus;
import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "t_account", schema = "operation_service")
@SuperBuilder
@AllArgsConstructor
public class Account extends AbstractEntity {

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "account_number", nullable = false)
    Long accountNumber;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    CurrencyType currency;

    @Column(name = "balance")
    BigDecimal balance;

    @Column(name = "is_default")
    boolean isDefault;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    AccountStatus accountStatus;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Card> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        if (isDefault != account.isDefault) return false;
        if (!Objects.equals(userId, account.userId)) return false;
        if (!Objects.equals(accountNumber, account.accountNumber))
            return false;
        if (currency != account.currency) return false;
        if (!Objects.equals(balance, account.balance)) return false;
        if (accountStatus != account.accountStatus) return false;
        return Objects.equals(cards, account.cards);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (isDefault ? 1 : 0);
        result = 31 * result + (accountStatus != null ? accountStatus.hashCode() : 0);
        result = 31 * result + (cards != null ? cards.hashCode() : 0);
        return result;
    }
}
