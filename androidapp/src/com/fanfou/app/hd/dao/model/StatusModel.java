package com.fanfou.app.hd.dao.model;

import java.util.List;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author mcxiaoke
 * @version 1.0 2011.12.21
 * @version 1.1 2012.02.15
 * 
 */
public class StatusModel extends BaseModel<StatusModel> {

	public static final String TAG = StatusModel.class.getSimpleName();

	private String text;
	private String simpleText;
	private String source;
	private String geo;
	private String media;

	private long userId;
	private String userIdstr;
	private String userScreenName;

	private String inReplyToStatusId;
	private String inReplyToUserId;
	private String inReplyToScreenName;

	private long retweetId;
	private String retweetText;

	private String photoImageUrl;
	private String photoThumbUrl;
	private String photoLargeUrl;

	private boolean truncated;
	private boolean favorited;
	private boolean retweeted;
	private boolean self;

	private boolean read;
	private boolean thread;
	private boolean photo;
	private boolean special;

	private List<String> urls;
	private List<String> hashtags;
	private List<String> mentions;

	private UserModel user;
	
	public StatusModel(){}

	public StatusModel(Parcel in) {
		readBase(in);

		text = in.readString();
		simpleText = in.readString();
		source = in.readString();
		geo = in.readString();
		media = in.readString();

		userId = in.readLong();
		userIdstr = in.readString();
		userScreenName = in.readString();

		inReplyToStatusId = in.readString();
		inReplyToUserId = in.readString();
		inReplyToScreenName = in.readString();

		retweetId = in.readLong();
		retweetText = in.readString();

		photoImageUrl = in.readString();
		photoLargeUrl = in.readString();
		photoThumbUrl = in.readString();

		truncated = in.readInt() == 0 ? false : true;
		favorited = in.readInt() == 0 ? false : true;
		retweeted = in.readInt() == 0 ? false : true;
		self = in.readInt() == 0 ? false : true;

		read = in.readInt() == 0 ? false : true;
		thread = in.readInt() == 0 ? false : true;
		photo = in.readInt() == 0 ? false : true;
		special = in.readInt() == 0 ? false : true;

	}

	@Override
	public ContentValues values() {
		ContentValues cv = convert();

		cv.put(StatusColumns.TEXT, this.text);
		cv.put(StatusColumns.SIMPLE_TEXT, this.simpleText);
		cv.put(StatusColumns.SOURCE, this.source);
		cv.put(StatusColumns.GEO, this.geo);
		cv.put(StatusColumns.MEDIA, this.media);

		cv.put(StatusColumns.USER_ID, this.userId);
		cv.put(StatusColumns.USER_IDSTR, this.userIdstr);
		cv.put(StatusColumns.USER_SCREEN_NAME, this.userScreenName);

		cv.put(StatusColumns.IN_REPLY_TO_STATUS_ID, this.inReplyToStatusId);
		cv.put(StatusColumns.IN_REPLY_TO_USER_ID, this.inReplyToUserId);
		cv.put(StatusColumns.IN_REPLY_TO_SCREEN_NAME, this.inReplyToScreenName);

		cv.put(StatusColumns.RETWEET_ID, this.retweetId);
		cv.put(StatusColumns.RETWEET_TEXT, this.retweetText);

		cv.put(StatusColumns.PHOTO_IMAGE_URL, this.photoImageUrl);
		cv.put(StatusColumns.PHOTO_THUMB_URL, this.photoThumbUrl);
		cv.put(StatusColumns.PHOTO_LARGE_URL, this.photoLargeUrl);

		cv.put(StatusColumns.TRUNCATED, this.truncated);
		cv.put(StatusColumns.FAVORITED, this.favorited);
		cv.put(StatusColumns.RETWEETED, this.retweeted);
		cv.put(StatusColumns.SELF, this.self);

		cv.put(StatusColumns.READ, this.read);
		cv.put(StatusColumns.THREAD, this.thread);
		cv.put(StatusColumns.PHOTO, this.photo);
		cv.put(StatusColumns.SPECIAL, this.special);

		return cv;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		writeBase(dest, flags);

		dest.writeString(text);
		dest.writeString(simpleText);
		dest.writeString(source);
		dest.writeString(geo);
		dest.writeString(media);

		dest.writeLong(userId);
		dest.writeString(userIdstr);
		dest.writeString(userScreenName);

		dest.writeString(inReplyToStatusId);
		dest.writeString(inReplyToUserId);
		dest.writeString(inReplyToScreenName);
		
		dest.writeLong(retweetId);
		dest.writeString(retweetText);

		dest.writeString(photoImageUrl);
		dest.writeString(photoLargeUrl);
		dest.writeString(photoThumbUrl);


		dest.writeInt(truncated ? 1 : 0);
		dest.writeInt(favorited ? 1 : 0);
		dest.writeInt(retweeted ? 1 : 0);
		dest.writeInt(self ? 1 : 0);

		dest.writeInt(read ? 1 : 0);
		dest.writeInt(thread ? 1 : 0);
		dest.writeInt(photo ? 1 : 0);
		dest.writeInt(special ? 1 : 0);

	}

	public static final Parcelable.Creator<StatusModel> CREATOR = new Parcelable.Creator<StatusModel>() {

		@Override
		public StatusModel createFromParcel(Parcel source) {
			return new StatusModel(source);
		}

		@Override
		public StatusModel[] newArray(int size) {
			return new StatusModel[size];
		}
	};

	@Override
	public String toString() {
		return "[Status] " + StatusColumns.ID;
	}

	@Override
	public int describeContents() {
		return 0;
	}

}
