package com.jump2digital.challenge.v1.documents;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "playerskins")
public class PlayerSkin {

    @Id
    private String player_skin_id;
    private LocalDate regdate;
    private Skin playerSkin;

    public PlayerSkin(Skin playerSkin) {
        this.playerSkin = playerSkin;
        this.regdate = LocalDate.now();
    }
}

