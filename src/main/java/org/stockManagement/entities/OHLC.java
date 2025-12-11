package org.stockManagement.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "ohlc")
public class OHLC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String sym;

    @NotNull
    private float open;

    @NotNull
    private float high;

    @NotNull
    private float low;

    @NotNull
    private float close;

    @NotNull
    private float volume;

    @NotNull
    private String timeStamp;

    // JPA needs this JPA as it uses this to create the object using reflection
    protected OHLC(){}

    public OHLC(String sym, float open, float high, float low, float close, float volume, String timeStamp){
        this.sym = sym;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.timeStamp = timeStamp;
    }
}
