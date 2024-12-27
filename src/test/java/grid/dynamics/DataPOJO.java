package grid.dynamics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataPOJO {
    @JsonProperty("year")
    int year;
    @JsonProperty("price")
    double price;
    @JsonProperty("CPU model")
    String cpuModel;
    @JsonProperty("Hard disk size")
    String hardDiskSize;
}
