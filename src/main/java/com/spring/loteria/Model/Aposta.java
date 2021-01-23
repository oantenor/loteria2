package com.spring.loteria.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

@Entity
@Table(name="APOSTA")
public class Aposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    private String email;

    private String aposta;

    private LocalDate dataAposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAposta() {
        return aposta;
    }

    public void setAposta(){
        Random random = new Random();
        Integer[] nums = new Integer[6];

        int i = 0;

        while(i < 6){
            nums[i] = random.nextInt(60);
            boolean verifica = false;
            for(int j = 0;j < i;j++){
                if(nums[i] == nums[j]){
                    verifica = true;
                    break;
                }
            }
            if(!verifica){
                i++;
            }
        }
        Arrays.sort(nums);
        aposta = Arrays.toString(nums);
    }

    public LocalDate getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(LocalDate dataAposta) {
        this.dataAposta = dataAposta;
    }

}