package com.example.tcc.cardlistiudesign;

public class item {

    int background;
    String profilename;
    int profilephoto;
    int nbfollowers;

    public item(int background, String profilename, int profilephoto, int nbfollowers) {
        this.background = background;
        this.profilename = profilename;
        this.profilephoto = profilephoto;
        this.nbfollowers = nbfollowers;
    }

    public item(){

    }

    public int getBackground() {
        return background;
    }

    public String getProfilename() {
        return profilename;
    }

    public int getProfilephoto() {
        return profilephoto;
    }

    public int getNbfollowers() {
        return nbfollowers;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public void setProfilephoto(int profilephoto) {
        this.profilephoto = profilephoto;
    }

    public void setNbfollowers(int nbfollowers) {
        this.nbfollowers = nbfollowers;
    }
}
