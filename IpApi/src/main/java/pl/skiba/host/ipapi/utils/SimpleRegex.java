package pl.skiba.host.ipapi.utils;

/**
 * The Class SimpleRegex provides a set of regular expressions used in
 * {@link pl.skiba.host.ipapi.IpApiApplication IpApiApplication}.
 * 
 * @author Tomasz Skiba
 */
public class SimpleRegex {

	/** The Constant regular expression for IPv4 address. */
	public static final String IP_REGEX = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	/** The Constant regular expression for date format. */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
}
