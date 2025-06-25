package dto;



import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres.")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo.")
    @Positive(message = "El precio debe ser un valor positivo.")
    private BigDecimal precio;

    @NotNull(message = "El stock no puede ser nulo.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private int stock;
}