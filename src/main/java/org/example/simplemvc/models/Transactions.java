package org.example.simplemvc.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Transactions {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transaction_id;

    private Date purchased_at;

    public Transactions() {}

    public Transactions(Integer transaction_id, Date purchased_at) {
        this.transaction_id = transaction_id;
        this.purchased_at = purchased_at;
    }

    public Transactions(Date purchased_at) {
        this.purchased_at = purchased_at;
    }


    public Integer getTransaction_id() {return transaction_id;}
    public void setTransaction_id(Integer transaction_id) {this.transaction_id = transaction_id;}

    public Date getPurchased_at() {return purchased_at;}
    public void setPurchased_at(Date purchased_at) {this.purchased_at = purchased_at;}

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_id=" + transaction_id +
                ", purchased_at=" + purchased_at +
                '}';
    }

}
