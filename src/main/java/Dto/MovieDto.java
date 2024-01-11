package Dto;

import java.util.Arrays;

public class MovieDto {
	private int mId;
	private String mName;
	private double mPrice;
	private double mRating;
	private String mGenre;
	private String mLanguage;
	private byte[] movieImage;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public double getmPrice() {
		return mPrice;
	}
	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}
	public double getmRating() {
		return mRating;
	}
	public void setmRating(double mRating) {
		this.mRating = mRating;
	}
	public String getmGenre() {
		return mGenre;
	}
	public void setmGenre(String mGenre) {
		this.mGenre = mGenre;
	}
	public String getmLanguage() {
		return mLanguage;
	}
	public void setmLanguage(String mLanguage) {
		this.mLanguage = mLanguage;
	}
	public byte[] getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(byte[] movieImage) {
		this.movieImage = movieImage;
	}
	@Override
	public String toString() {
		return "MovieDto [mId=" + mId + ", mName=" + mName + ", mPrice=" + mPrice + ", mRating=" + mRating + ", mGenre="
				+ mGenre + ", mLanguage=" + mLanguage + ", movieImage=" + Arrays.toString(movieImage) + "]";
	}
	
	
	

}
