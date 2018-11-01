package DpiDump;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "imsiImei", "appName", "appProto" })
public class Record
{
	/*
	 * 
{
"imsiImei" : "460010000000000",
"appProto" : "app-proto-string",
"appName" : "app-name-string",
"appAttributes":
[
  "appAttributesString1",
  "appAttributesString2"
],
"appGrps" :
[
  "appGrpsString1",
  "appGrpsString2"
],
"uplinkPkt" : 10,
"uplinkBytes" : 1000,
"downlinkPkt" : 10,
"downlinkBytes" : 1000,
"isTetheringDetected" : true,
"url" : "http://123.com",
"destinationIpAddress":"22.22.22.22",
"destinationPort" : 24
}
	 */
    private String appName;

    private String isTetheringDetected = "true";

    private String imsiImei = "460010000000000";

    private String destinationIpAddress;

    private String downlinkPkt;

    private String destinationPort;

    private String uplinkPkt;

    private String[] appGrps;

    private String appProto;

    private String url="http://123.com";

    private String downlinkBytes;

    private String uplinkBytes;

    private String[] appAttributes;

    public String getAppName ()
    {
        return appName;
    }

    public void setAppName (String appName)
    {
        this.appName = appName;
    }

    public String getIsTetheringDetected ()
    {
        return isTetheringDetected;
    }

    public void setIsTetheringDetected (String isTetheringDetected)
    {
        this.isTetheringDetected = isTetheringDetected;
    }

    public String getImsiImei ()
    {
        return imsiImei;
    }

    public void setImsiImei (String imsiImei)
    {
        this.imsiImei = imsiImei;
    }

    public String getDestinationIpAddress ()
    {
        return destinationIpAddress;
    }

    public void setDestinationIpAddress (String destinationIpAddress)
    {
        this.destinationIpAddress = destinationIpAddress;
    }

    public String getDownlinkPkt ()
    {
        return downlinkPkt;
    }

    public void setDownlinkPkt (String downlinkPkt)
    {
        this.downlinkPkt = downlinkPkt;
    }

    public String getDestinationPort ()
    {
        return destinationPort;
    }

    public void setDestinationPort (String destinationPort)
    {
        this.destinationPort = destinationPort;
    }

    public String getUplinkPkt ()
    {
        return uplinkPkt;
    }

    public void setUplinkPkt (String uplinkPkt)
    {
        this.uplinkPkt = uplinkPkt;
    }

    public String[] getAppGrps ()
    {
        return appGrps;
    }

    public void setAppGrps (String[] appGrps)
    {
        this.appGrps = appGrps;
    }

    public String getAppProto ()
    {
        return appProto;
    }

    public void setAppProto (String appProto)
    {
        this.appProto = appProto;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getDownlinkBytes ()
    {
        return downlinkBytes;
    }

    public void setDownlinkBytes (String downlinkBytes)
    {
        this.downlinkBytes = downlinkBytes;
    }

    public String getUplinkBytes ()
    {
        return uplinkBytes;
    }

    public void setUplinkBytes (String uplinkBytes)
    {
        this.uplinkBytes = uplinkBytes;
    }

    public String[] getAppAttributes ()
    {
        return appAttributes;
    }

    public void setAppAttributes (String[] appAttributes)
    {
        this.appAttributes = appAttributes;
    }

    @Override
    public String toString()
    {
        return "[appName = "+appName+", isTetheringDetected = "+isTetheringDetected+", imsiImei = "+imsiImei+", destinationIpAddress = "+destinationIpAddress+", downlinkPkt = "+downlinkPkt+", destinationPort = "+destinationPort+", uplinkPkt = "+uplinkPkt+", appGrps = "+appGrps+", appProto = "+appProto+", url = "+url+", downlinkBytes = "+downlinkBytes+", uplinkBytes = "+uplinkBytes+", appAttributes = "+appAttributes+"]";
    }

}
			
			