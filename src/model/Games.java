package model;

public class Games {
	private int id;
	private String name;
    private int category;
    private int library;
    private int score;
    private int timePlayed;
    private int play_count;
    private int completed;
    private String completed_date;
    private int hidden;
    private String path;
    private String release_date;
    private String developer;
    private String series;
    private String play_mode;
    private String status;
    private String last_played;
    private String rating;
    private int platform;
    private String publisher;
    private String region;
    private String version;
    private String added;
    private String modified;
    private int favorite;
    private int statistic;
    private int portable;
    private String image;
    private String notes;

	public Games(int id, String name, int category, int library, int score, int timePlayed, int play_count,
				int completed, String completed_date, int hidden, String path, String release_date,
				String developer, String series, String play_mode, String status, String last_played,
				String rating, int platform, String publisher, String region, String version, String added, String modified,
				int favorite, int statistic, int portable, String image, String notes) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.library = library;
		this.score = score;
		this.timePlayed = timePlayed;
		this.play_count = play_count;
		this.completed = completed;
		this.completed_date = completed_date;
		this.hidden = hidden;
		this.path = path;
		this.release_date = release_date;
		this.developer = developer;
		this.series = series;
		this.play_mode = play_mode;
		this.status = status;
		this.last_played = last_played;
		this.rating = rating;
		this.platform = platform;
		this.publisher = publisher;
		this.region = region;
		this.version = version;
		this.added = added;
		this.modified = modified;
		this.favorite = favorite;
		this.statistic = statistic;
		this.portable = portable;
		this.image = image;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getLibrary() {
		return library;
	}

	public void setLibrary(int library) {
		this.library = library;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}

	public int getPlayCount() {
		return play_count;
	}

	public void setPlayCount(int play_count) {
		this.play_count = play_count;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public String getCompletedDate() {
		return completed_date;
	}

	public void setCompletedDate(String completed_date) {
		this.completed_date = completed_date;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getReleaseDate() {
		return release_date;
	}

	public void setReleaseDate(String release_date) {
		this.release_date = release_date;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getPlayMode() {
		return play_mode;
	}

	public void setPlayMode(String play_mode) {
		this.play_mode = play_mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastPlayed() {
		return last_played;
	}

	public void setLastPlayed(String last_played) {
		this.last_played = last_played;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public int getFavorite() {
		return favorite;
	}

	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}

	public int getStatistic() {
		return statistic;
	}

	public void setStatistic(int statistic) {
		this.statistic = statistic;
	}

	public int getPortable() {
		return portable;
	}

	public void setPortable(int portable) {
		this.portable = portable;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}