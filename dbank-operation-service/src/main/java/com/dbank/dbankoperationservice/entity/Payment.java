package com.dbank.dbankoperationservice.entity;

import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import com.dbank.dbankoperationservice.entity.enums.PaymentStatus;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "t_payment", schema = "operation_service")
@SuperBuilder
@AllArgsConstructor
public class Payment extends AbstractEntity{

    @Column(name = "user_id", nullable = false)
    Long userId;

    @ManyToOne
    @JoinColumn(name = "from_card_id")
    @Cascade(CascadeType.REMOVE)
    Card fromCard;

    @Column(name = "payment_date", nullable = false)
    LocalDateTime paymentDate;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    CurrencyType currency;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "account_currency")
    @Enumerated(EnumType.STRING)
    CurrencyType accountCurrency;

    @Column(name = "account_currency_amount")
    BigDecimal accountCurrencyAmount;

    @Column(name = "recipient_account_number")
    Long recipientAccountNumber;

    @Column(name = "recipient_details")
    String recipientDetails;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    @Column(name = "payment_details")
    String paymentDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        if (!super.equals(o)) return false;

        if (!Objects.equals(userId, payment.userId)) return false;
        if (!Objects.equals(fromCard, payment.fromCard)) return false;
        if (!Objects.equals(paymentDate, payment.paymentDate)) return false;
        if (currency != payment.currency) return false;
        if (!Objects.equals(amount, payment.amount)) return false;
        if (accountCurrency != payment.accountCurrency) return false;
        if (!Objects.equals(accountCurrencyAmount, payment.accountCurrencyAmount))
            return false;
        if (!Objects.equals(recipientAccountNumber, payment.recipientAccountNumber))
            return false;
        return Objects.equals(recipientDetails, payment.recipientDetails);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (fromCard != null ? fromCard.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (accountCurrency != null ? accountCurrency.hashCode() : 0);
        result = 31 * result + (accountCurrencyAmount != null ? accountCurrencyAmount.hashCode() : 0);
        result = 31 * result + (recipientAccountNumber != null ? recipientAccountNumber.hashCode() : 0);
        result = 31 * result + (recipientDetails != null ? recipientDetails.hashCode() : 0);
        return result;
    }
}
