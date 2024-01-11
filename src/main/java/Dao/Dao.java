package Dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import Dto.AdminDto;
import Dto.MovieDto;

public class Dao {
	//for getting Connection
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary", "root", "root");
			return conn;
			
		}
		
		//save admin details
		public int saveAdmin(AdminDto admin) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("insert into admindetails values(?,?,?,?,?)");
			pst.setInt(1, admin.getaId());
			pst.setString(2, admin.getaName());
			pst.setLong(3, admin.getaContact());
			pst.setString(4, admin.getaEmail());
			pst.setString(5, admin.getaPassword());
			
			return pst.executeUpdate();
			
		}
		public AdminDto findByEmail(String email) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from admindetails where adminEmail=?");
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			
			AdminDto admin=null;
			while(rs.next()) {
				admin=new AdminDto();
			admin.setaId(rs.getInt(1));
			admin.setaName(rs.getString(2));
			admin.setaContact(rs.getLong(3));
			admin.setaEmail(rs.getString(4));
			admin.setaPassword(rs.getString(5));
			}
			return admin;
			
			
		}
		public int saveMovie(MovieDto movie) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
			pst.setInt(1, movie.getmId());
			pst.setString(2, movie.getmName());
			pst.setDouble(3, movie.getmPrice());
			pst.setDouble(4, movie.getmRating());
			pst.setString(5, movie.getmGenre());
			pst.setString(6, movie.getmLanguage());
			Blob imageBlob=new SerialBlob(movie.getMovieImage());
			pst.setBlob(7, imageBlob);
			return pst.executeUpdate();
			
		}
		public List<MovieDto> getAllMovies() throws ClassNotFoundException, SQLException{
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from movie");
			ResultSet rs=pst.executeQuery();
			List<MovieDto> movies=new ArrayList<MovieDto>();
			while(rs.next()) {
				MovieDto movie=new MovieDto();
				movie.setmId(rs.getInt(1));
				movie.setmName(rs.getString(2));
				movie.setmPrice(rs.getDouble(3));
				movie.setmRating(rs.getDouble(4));
				movie.setmGenre(rs.getString(5));
				movie.setmLanguage(rs.getString(6));
				Blob b=rs.getBlob(7);
				byte[] img=b.getBytes(1, (int) b.length());
				movie.setMovieImage(img);
				movies.add(movie);
			}
			return movies;
			
		}
		public int deleteMovie(int id) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("delete from movie where movieId=?");
			pst.setInt(1, id);
			return pst.executeUpdate();
		}
		public MovieDto findByMovieId(int id) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from movie where movieId=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			rs.next();
			MovieDto movie=new MovieDto();
			movie.setmId(rs.getInt(1));
			movie.setmName(rs.getString(2));
			movie.setmPrice(rs.getDouble(3));
			movie.setmRating(rs.getDouble(4));
			movie.setmGenre(rs.getString(5));
			movie.setmLanguage(rs.getString(6));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int) b.length());
			movie.setMovieImage(img);
			return movie;
			
		}
		public int updateMovie(MovieDto movie) throws ClassNotFoundException, SQLException {
			Connection conn=getConnection();
			PreparedStatement pst=conn.prepareStatement("update movie set movieName=?, moviePrice=?, movieRating=?, movieGenre=?, movieLanguage=?, movieImage=? where movieId=?");
			pst.setInt(7, movie.getmId());
			pst.setString(1, movie.getmName());
			pst.setDouble(2, movie.getmPrice());
			pst.setDouble(3, movie.getmRating());
			pst.setString(4, movie.getmGenre());
			pst.setString(5, movie.getmLanguage());
			Blob imageBlob=new SerialBlob(movie.getMovieImage());
			pst.setBlob(6, imageBlob);
			return pst.executeUpdate();
		}
}
