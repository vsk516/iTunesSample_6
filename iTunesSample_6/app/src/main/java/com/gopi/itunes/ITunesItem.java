package com.gopi.itunes;

/**
 *
 */

public class ITunesItem {

    /*
    {
      "wrapperType": "track",
      "kind": "song",
      "artistId": 270918964,
      "collectionId": 445588151,
      "trackId": 445588240,
     >"artistName": "Pussy",
      "collectionName": "Beach Baby",
     >"trackName": "Pussy (Suck My Pussy)", 0-1
      "collectionCensoredName": "Beach Baby",
      "trackCensoredName": "Pussy (Suck My Pussy)",
      "collectionArtistId": 4035426,
      "collectionArtistName": "Various Artists",
      "artistViewUrl": "https://itunes.apple.com/us/artist/pussy/id270918964?uo=4",
      "collectionViewUrl": "https://itunes.apple.com/us/album/pussy-suck-my-pussy/id445588151?i=445588240&uo=4",
      "trackViewUrl": "https://itunes.apple.com/us/album/pussy-suck-my-pussy/id445588151?i=445588240&uo=4",
      "previewUrl": "http://a1996.phobos.apple.com/us/r30/Music/66/ca/06/mzm.uqbmlorf.aac.p.m4a",
     >"artworkUrl30": "http://is4.mzstatic.com/image/thumb/Music/v4/c0/af/b2/c0afb280-39cc-15df-eb25-9f8558ec485d/source/30x30bb.jpg",
      "artworkUrl60": "http://is4.mzstatic.com/image/thumb/Music/v4/c0/af/b2/c0afb280-39cc-15df-eb25-9f8558ec485d/source/60x60bb.jpg",
     >"artworkUrl100": "http://is4.mzstatic.com/image/thumb/Music/v4/c0/af/b2/c0afb280-39cc-15df-eb25-9f8558ec485d/source/100x100bb.jpg",
      "collectionPrice": 7.99,
     >"trackPrice": 0.99,
      "releaseDate": "2011-05-20T07:00:00Z",
      "collectionExplicitness": "notExplicit",
      "trackExplicitness": "notExplicit",
      "discCount": 1,
      "discNumber": 1,
      "trackCount": 20,
      "trackNumber": 7,
      "trackTimeMillis": 206387,
      "country": "USA",
      "currency": "USD",
      "primaryGenreName": "Pop",
      "isStreamable": true

     >"shortDescription": "You loved him in Shrek…now see where the one-and-only swashbuckling feline found his fame – and a",
     >"longDescription": "You loved him in Shrek, now see where the one-and-only swashbuckling feline found his fame– and a very big pair of boots– in this hilariously funny film.  Lover, fighter and outlaw Puss In Boots (Antonio Banderas) is on the adventure of his nine lives as he teams up with Kitty Softpaws (Salma Hayek) and Humpty Dumpty (Zack Galifianakis) for the ultimate showdown with the notorious Jack and Jill."
    }
     */
    private String trackName;
    private String trackTumbnail;
    private String trackImage;
    private String trackPrice;
    private String shortDescription;
    private String longDescription;
    private String artistName;

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTrackImage() {
        return trackImage;
    }

    public void setTrackImage(String trackImage) {
        this.trackImage = trackImage;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getTrackTumbnail() {
        return trackTumbnail;
    }

    public void setTrackTumbnail(String trackTumbnail) {
        this.trackTumbnail = trackTumbnail;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}

