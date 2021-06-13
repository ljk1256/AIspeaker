package com.eatingtoday.eatingtoday;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resturant {
        private String title;
        private String address;
        private String roadAddress;

        public Resturant(String title, String address, String roadAddress) {
                this.title = title;
                this.address = address;
                this.roadAddress = roadAddress;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getRoadAddress() {
                return roadAddress;
        }

        public void setRoadAddress(String roadAddress) {
                this.roadAddress = roadAddress;
        }


}
