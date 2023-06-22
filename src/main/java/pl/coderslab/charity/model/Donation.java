package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donation_category")
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Institution institutions;

    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    @NotEmpty
    private String pickUpComment;



}
