package com.MalmoConcerts.Demo.DTO.Billetto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillettoInfoDTO {

        private String id;

        private String title;

        private String image;

        private String venueName;

        private String startDate;

        private String endDate;

        public BillettoInfoDTO(String id, String title, String image, String venueName, String startDate, String endDate) {
                this.id = id;
                this.title = title;
                this.image = image;
                this.venueName = venueName;
                this.startDate = startDate;
                this.endDate = endDate;
        }

        @Override
        public String toString() {
                return "EventInfoDTO{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", image='" + image + '\'' +
                        ", startDate='" + startDate + '\'' +
                        ", endDate='" + endDate + '\'' +
                        '}';
        }
}
