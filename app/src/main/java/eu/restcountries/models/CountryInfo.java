
package eu.restcountries.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CountryInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = new ArrayList<String>();
    @SerializedName("relevance")
    @Expose
    private String relevance;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = new ArrayList<Double>();
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("gini")
    @Expose
    private Double gini;
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = new ArrayList<String>();
    @SerializedName("borders")
    @Expose
    private List<String> borders = new ArrayList<String>();
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = new ArrayList<String>();
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = new ArrayList<String>();
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = new ArrayList<String>();
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     * The capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     *
     * @return
     * The altSpellings
     */
    public List<String> getAltSpellings() {
        return altSpellings;
    }

    /**
     *
     * @param altSpellings
     * The altSpellings
     */
    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    /**
     *
     * @return
     * The relevance
     */
    public String getRelevance() {
        return relevance;
    }

    /**
     *
     * @param relevance
     * The relevance
     */
    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    /**
     *
     * @return
     * The region
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     * The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @return
     * The subregion
     */
    public String getSubregion() {
        return subregion;
    }

    /**
     *
     * @param subregion
     * The subregion
     */
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    /**
     *
     * @return
     * The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     *
     * @param population
     * The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     *
     * @return
     * The latlng
     */
    public List<Double> getLatlng() {
        return latlng;
    }

    /**
     *
     * @param latlng
     * The latlng
     */
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    /**
     *
     * @return
     * The demonym
     */
    public String getDemonym() {
        return demonym;
    }

    /**
     *
     * @param demonym
     * The demonym
     */
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    /**
     *
     * @return
     * The area
     */
    public Double getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The gini
     */
    public Double getGini() {
        return gini;
    }

    /**
     *
     * @param gini
     * The gini
     */
    public void setGini(Double gini) {
        this.gini = gini;
    }

    /**
     *
     * @return
     * The timezones
     */
    public List<String> getTimezones() {
        return timezones;
    }

    /**
     *
     * @param timezones
     * The timezones
     */
    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    /**
     *
     * @return
     * The borders
     */
    public List<String> getBorders() {
        return borders;
    }

    /**
     *
     * @param borders
     * The borders
     */
    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    /**
     *
     * @return
     * The nativeName
     */
    public String getNativeName() {
        return nativeName;
    }

    /**
     *
     * @param nativeName
     * The nativeName
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     *
     * @return
     * The callingCodes
     */
    public List<String> getCallingCodes() {
        return callingCodes;
    }

    /**
     *
     * @param callingCodes
     * The callingCodes
     */
    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    /**
     *
     * @return
     * The topLevelDomain
     */
    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    /**
     *
     * @param topLevelDomain
     * The topLevelDomain
     */
    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    /**
     *
     * @return
     * The alpha2Code
     */
    public String getAlpha2Code() {
        return alpha2Code;
    }

    /**
     *
     * @param alpha2Code
     * The alpha2Code
     */
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    /**
     *
     * @return
     * The alpha3Code
     */
    public String getAlpha3Code() {
        return alpha3Code;
    }

    /**
     *
     * @param alpha3Code
     * The alpha3Code
     */
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    /**
     *
     * @return
     * The currencies
     */
    public List<String> getCurrencies() {
        return currencies;
    }

    /**
     *
     * @param currencies
     * The currencies
     */
    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    /**
     *
     * @return
     * The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}