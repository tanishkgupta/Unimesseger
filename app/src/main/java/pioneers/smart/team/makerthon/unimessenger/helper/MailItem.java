package pioneers.smart.team.makerthon.unimessenger.helper;

import com.amulyakhare.textdrawable.TextDrawable;

import pioneers.smart.team.makerthon.unimessenger.gmailActivity;

public class MailItem
{
    private String mBody;
    private String mSubject;
    private String mSender;
    private String mReceiver;
    private String mAvatar;
    private String mSnippet;

    private String mSenderName;
    private gmailActivity mParent;

    private TextDrawable mDrawable;

    public MailItem(gmailActivity aParent, String aBody, String aSubject, String aTo, String aFrom, String aSnippet)
    {
        this.mParent = aParent;
        this.mBody = aBody;
        this.mSubject = aSubject;
        this.mSender = aFrom;
        this.mReceiver = aTo;
        this.mSnippet = aSnippet;


        this.mAvatar = aFrom.charAt(0) + "";
        this.mSenderName = aFrom.substring(0, aFrom.indexOf('<') - 1);
    }

    public String getBody()
    {
        return mBody;
    }

    public String getSubject()
    {
        return  mSubject;
    }

    public String getSnippet()
    {
        return mSnippet;
    }

    public String getSenderName()
    {
        return  mSenderName;
    }

    public TextDrawable getAvatar()
    {
        if (mDrawable == null)
            mDrawable = mParent.getFancyAvatar(mSender, mAvatar);
        return mDrawable;
    }
}