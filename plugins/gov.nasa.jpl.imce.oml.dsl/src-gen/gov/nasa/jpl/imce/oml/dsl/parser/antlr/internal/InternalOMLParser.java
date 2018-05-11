package gov.nasa.jpl.imce.oml.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import gov.nasa.jpl.imce.oml.dsl.services.OMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOMLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_ID", "RULE_PATTERN", "RULE_LANG_TAG", "RULE_TRUE", "RULE_FALSE", "RULE_DATE_TIME", "RULE_QUOTED_STRING_VALUE", "RULE_RAW_STRING_VALUE", "RULE_UUID", "RULE_URI", "RULE_REAL", "RULE_RATIONAL", "RULE_FLOAT", "RULE_DIGITS", "RULE_DECIMAL", "RULE_DIGIT", "RULE_DIGIT19", "RULE_DIGIT02", "RULE_DIGIT03", "RULE_DIGIT05", "RULE_YEAR_FRAG", "RULE_MONTH_FRAG", "RULE_DAY_FRAG", "RULE_HOUR_FRAG", "RULE_MINUTE_FRAG", "RULE_SECOND_FRAG", "RULE_END_OF_DAY_FRAG", "RULE_TIMEZONE_FRAG", "RULE_ALPHA", "RULE_SCHEME", "RULE_HEX_DIGIT", "RULE_PCT_ENCODED", "RULE_UNRESERVED", "RULE_DIGIT04", "RULE_DEC_OCTET", "RULE_IPV4_ADDRESS", "RULE_IUSER_PART", "RULE_IUSER_INFO", "RULE_IUNRESERVED_PART", "RULE_IUNRESERVED", "RULE_IHOST", "RULE_PORT", "RULE_IAUTHORITY", "RULE_IPCHAR", "RULE_ISEGMENT", "RULE_IPATH", "RULE_IHIER_PART", "RULE_IFRAGMENT", "RULE_CONSTANT_NAME", "RULE_LETTER", "RULE_LETTER_DIGIT", "RULE_LETTER_DIGIT_PREFIX", "RULE_LETTER_DIGIT_SUFFIX", "RULE_ID_PREFIX", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_LETTER", "RULE_HEX", "RULE_DEC", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'descriptionBox'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'reifiedRelationshipRestriction'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'rule'", "'infers'", "'if'", "'&&'", "'('", "')'", "'invSource'", "'invTarget'", "'inv'", "'anonymousConceptUnion'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'subObjectPropertyOf'", "'subDataPropertyOf'", "'someData'", "'every'", "'^^'", "'allData'", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int RULE_HEX=64;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int RULE_IHOST=46;
    public static final int RULE_DATE_TIME=11;
    public static final int RULE_ABBREV_IRI=4;
    public static final int RULE_IUSER_INFO=43;
    public static final int RULE_LANG_TAG=8;
    public static final int RULE_QUOTED_STRING_VALUE=12;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int RULE_ISEGMENT=50;
    public static final int T__134=134;
    public static final int RULE_ID=6;
    public static final int RULE_DEC=65;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_REAL=16;
    public static final int RULE_DIGIT=21;
    public static final int RULE_HEX_LETTER=63;
    public static final int RULE_RATIONAL=17;
    public static final int RULE_DAY_FRAG=28;
    public static final int RULE_UUID=14;
    public static final int RULE_LETTER_DIGIT_SUFFIX=58;
    public static final int RULE_ML_COMMENT=66;
    public static final int T__129=129;
    public static final int T__69=69;
    public static final int RULE_FALSE=10;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int T__164=164;
    public static final int T__163=163;
    public static final int RULE_IRI=5;
    public static final int T__160=160;
    public static final int RULE_IHIER_PART=52;
    public static final int RULE_HOUR_FRAG=29;
    public static final int RULE_YEAR_FRAG=26;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__155=155;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int RULE_PATTERN=7;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int RULE_DEC_OCTET=40;
    public static final int RULE_RAW_STRING_VALUE=13;
    public static final int RULE_LETTER=55;
    public static final int RULE_UNRESERVED=38;
    public static final int RULE_FLOAT=18;
    public static final int RULE_HEX_DIGIT=36;
    public static final int RULE_IUSER_PART=42;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RULE_HEX_8DIGITS=60;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_IPATH=51;
    public static final int RULE_IPCHAR=49;
    public static final int RULE_HEX_12DIGITS=62;
    public static final int RULE_SECOND_FRAG=31;
    public static final int RULE_IAUTHORITY=48;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int RULE_TIMEZONE_FRAG=33;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_LETTER_DIGIT=56;
    public static final int RULE_ID_PREFIX=59;
    public static final int RULE_IUNRESERVED_PART=44;
    public static final int RULE_DECIMAL=20;
    public static final int RULE_URI=15;
    public static final int RULE_MONTH_FRAG=27;
    public static final int RULE_CONSTANT_NAME=54;
    public static final int RULE_LETTER_DIGIT_PREFIX=57;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int RULE_ALPHA=34;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int RULE_SCHEME=35;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int RULE_PORT=47;
    public static final int T__120=120;
    public static final int RULE_DIGITS=19;
    public static final int RULE_SL_COMMENT=67;
    public static final int RULE_END_OF_DAY_FRAG=32;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int RULE_TRUE=9;
    public static final int RULE_IUNRESERVED=45;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int RULE_DIGIT19=22;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int RULE_MINUTE_FRAG=30;
    public static final int RULE_HEX_4DIGITS=61;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_DIGIT03=24;
    public static final int RULE_DIGIT02=23;
    public static final int RULE_WS=68;
    public static final int RULE_DIGIT05=25;
    public static final int RULE_DIGIT04=39;
    public static final int RULE_IFRAGMENT=53;
    public static final int RULE_PCT_ENCODED=37;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_IPV4_ADDRESS=41;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalOMLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOMLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOMLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOML.g"; }



     	private OMLGrammarAccess grammarAccess;

        public InternalOMLParser(TokenStream input, OMLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Extent";
       	}

       	@Override
       	protected OMLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleExtent"
    // InternalOML.g:78:1: entryRuleExtent returns [EObject current=null] : iv_ruleExtent= ruleExtent EOF ;
    public final EObject entryRuleExtent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtent = null;


        try {
            // InternalOML.g:78:47: (iv_ruleExtent= ruleExtent EOF )
            // InternalOML.g:79:2: iv_ruleExtent= ruleExtent EOF
            {
             newCompositeNode(grammarAccess.getExtentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtent=ruleExtent();

            state._fsp--;

             current =iv_ruleExtent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtent"


    // $ANTLR start "ruleExtent"
    // InternalOML.g:85:1: ruleExtent returns [EObject current=null] : ( () ( (lv_modules_1_0= ruleModule ) )* ) ;
    public final EObject ruleExtent() throws RecognitionException {
        EObject current = null;

        EObject lv_modules_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:91:2: ( ( () ( (lv_modules_1_0= ruleModule ) )* ) )
            // InternalOML.g:92:2: ( () ( (lv_modules_1_0= ruleModule ) )* )
            {
            // InternalOML.g:92:2: ( () ( (lv_modules_1_0= ruleModule ) )* )
            // InternalOML.g:93:3: () ( (lv_modules_1_0= ruleModule ) )*
            {
            // InternalOML.g:93:3: ()
            // InternalOML.g:94:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtentAccess().getExtentAction_0(),
            					current);
            			

            }

            // InternalOML.g:100:3: ( (lv_modules_1_0= ruleModule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==69||LA1_0==71||(LA1_0>=161 && LA1_0<=164)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOML.g:101:4: (lv_modules_1_0= ruleModule )
            	    {
            	    // InternalOML.g:101:4: (lv_modules_1_0= ruleModule )
            	    // InternalOML.g:102:5: lv_modules_1_0= ruleModule
            	    {

            	    					newCompositeNode(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_modules_1_0=ruleModule();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getExtentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"modules",
            	    						lv_modules_1_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.Module");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtent"


    // $ANTLR start "entryRuleAnnotationProperty"
    // InternalOML.g:123:1: entryRuleAnnotationProperty returns [EObject current=null] : iv_ruleAnnotationProperty= ruleAnnotationProperty EOF ;
    public final EObject entryRuleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationProperty = null;


        try {
            // InternalOML.g:123:59: (iv_ruleAnnotationProperty= ruleAnnotationProperty EOF )
            // InternalOML.g:124:2: iv_ruleAnnotationProperty= ruleAnnotationProperty EOF
            {
             newCompositeNode(grammarAccess.getAnnotationPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationProperty=ruleAnnotationProperty();

            state._fsp--;

             current =iv_ruleAnnotationProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationProperty"


    // $ANTLR start "ruleAnnotationProperty"
    // InternalOML.g:130:1: ruleAnnotationProperty returns [EObject current=null] : (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) ) ;
    public final EObject ruleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_abbrevIRI_1_0=null;
        Token otherlv_2=null;
        Token lv_iri_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:136:2: ( (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) ) )
            // InternalOML.g:137:2: (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) )
            {
            // InternalOML.g:137:2: (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) )
            // InternalOML.g:138:3: otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyAccess().getAnnotationPropertyKeyword_0());
            		
            // InternalOML.g:142:3: ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) )
            // InternalOML.g:143:4: (lv_abbrevIRI_1_0= RULE_ABBREV_IRI )
            {
            // InternalOML.g:143:4: (lv_abbrevIRI_1_0= RULE_ABBREV_IRI )
            // InternalOML.g:144:5: lv_abbrevIRI_1_0= RULE_ABBREV_IRI
            {
            lv_abbrevIRI_1_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_5); 

            					newLeafNode(lv_abbrevIRI_1_0, grammarAccess.getAnnotationPropertyAccess().getAbbrevIRIABBREV_IRITerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"abbrevIRI",
            						lv_abbrevIRI_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ABBREV_IRI");
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:164:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:165:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:165:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:166:5: lv_iri_3_0= RULE_IRI
            {
            lv_iri_3_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

            					newLeafNode(lv_iri_3_0, grammarAccess.getAnnotationPropertyAccess().getIriIRITerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationProperty"


    // $ANTLR start "entryRuleAnnotationPropertyValue"
    // InternalOML.g:186:1: entryRuleAnnotationPropertyValue returns [EObject current=null] : iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF ;
    public final EObject entryRuleAnnotationPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationPropertyValue = null;


        try {
            // InternalOML.g:186:64: (iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF )
            // InternalOML.g:187:2: iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getAnnotationPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationPropertyValue=ruleAnnotationPropertyValue();

            state._fsp--;

             current =iv_ruleAnnotationPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationPropertyValue"


    // $ANTLR start "ruleAnnotationPropertyValue"
    // InternalOML.g:193:1: ruleAnnotationPropertyValue returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteralString ) ) ) ;
    public final EObject ruleAnnotationPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:199:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteralString ) ) ) )
            // InternalOML.g:200:2: (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteralString ) ) )
            {
            // InternalOML.g:200:2: (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteralString ) ) )
            // InternalOML.g:201:3: otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= ruleLiteralString ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyValueAccess().getCommercialAtKeyword_0());
            		
            // InternalOML.g:205:3: ( (otherlv_1= RULE_ABBREV_IRI ) )
            // InternalOML.g:206:4: (otherlv_1= RULE_ABBREV_IRI )
            {
            // InternalOML.g:206:4: (otherlv_1= RULE_ABBREV_IRI )
            // InternalOML.g:207:5: otherlv_1= RULE_ABBREV_IRI
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyValueRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:222:3: ( (lv_value_3_0= ruleLiteralString ) )
            // InternalOML.g:223:4: (lv_value_3_0= ruleLiteralString )
            {
            // InternalOML.g:223:4: (lv_value_3_0= ruleLiteralString )
            // InternalOML.g:224:5: lv_value_3_0= ruleLiteralString
            {

            					newCompositeNode(grammarAccess.getAnnotationPropertyValueAccess().getValueLiteralStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleLiteralString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAnnotationPropertyValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationPropertyValue"


    // $ANTLR start "entryRuleModule"
    // InternalOML.g:245:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalOML.g:245:47: (iv_ruleModule= ruleModule EOF )
            // InternalOML.g:246:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalOML.g:252:1: ruleModule returns [EObject current=null] : (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminologyBox_0 = null;

        EObject this_DescriptionBox_1 = null;



        	enterRule();

        try {
            // InternalOML.g:258:2: ( (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox ) )
            // InternalOML.g:259:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )
            {
            // InternalOML.g:259:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalOML.g:260:3: this_TerminologyBox_0= ruleTerminologyBox
                    {

                    			newCompositeNode(grammarAccess.getModuleAccess().getTerminologyBoxParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyBox_0=ruleTerminologyBox();

                    state._fsp--;


                    			current = this_TerminologyBox_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:269:3: this_DescriptionBox_1= ruleDescriptionBox
                    {

                    			newCompositeNode(grammarAccess.getModuleAccess().getDescriptionBoxParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DescriptionBox_1=ruleDescriptionBox();

                    state._fsp--;


                    			current = this_DescriptionBox_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleTerminologyBox"
    // InternalOML.g:281:1: entryRuleTerminologyBox returns [EObject current=null] : iv_ruleTerminologyBox= ruleTerminologyBox EOF ;
    public final EObject entryRuleTerminologyBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBox = null;


        try {
            // InternalOML.g:281:55: (iv_ruleTerminologyBox= ruleTerminologyBox EOF )
            // InternalOML.g:282:2: iv_ruleTerminologyBox= ruleTerminologyBox EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBoxRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBox=ruleTerminologyBox();

            state._fsp--;

             current =iv_ruleTerminologyBox; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBox"


    // $ANTLR start "ruleTerminologyBox"
    // InternalOML.g:288:1: ruleTerminologyBox returns [EObject current=null] : (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph ) ;
    public final EObject ruleTerminologyBox() throws RecognitionException {
        EObject current = null;

        EObject this_Bundle_0 = null;

        EObject this_TerminologyGraph_1 = null;



        	enterRule();

        try {
            // InternalOML.g:294:2: ( (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph ) )
            // InternalOML.g:295:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )
            {
            // InternalOML.g:295:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalOML.g:296:3: this_Bundle_0= ruleBundle
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAccess().getBundleParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Bundle_0=ruleBundle();

                    state._fsp--;


                    			current = this_Bundle_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:305:3: this_TerminologyGraph_1= ruleTerminologyGraph
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAccess().getTerminologyGraphParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyGraph_1=ruleTerminologyGraph();

                    state._fsp--;


                    			current = this_TerminologyGraph_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBox"


    // $ANTLR start "entryRuleTerminologyGraph"
    // InternalOML.g:317:1: entryRuleTerminologyGraph returns [EObject current=null] : iv_ruleTerminologyGraph= ruleTerminologyGraph EOF ;
    public final EObject entryRuleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyGraph = null;


        try {
            // InternalOML.g:317:57: (iv_ruleTerminologyGraph= ruleTerminologyGraph EOF )
            // InternalOML.g:318:2: iv_ruleTerminologyGraph= ruleTerminologyGraph EOF
            {
             newCompositeNode(grammarAccess.getTerminologyGraphRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyGraph=ruleTerminologyGraph();

            state._fsp--;

             current =iv_ruleTerminologyGraph; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyGraph"


    // $ANTLR start "ruleTerminologyGraph"
    // InternalOML.g:324:1: ruleTerminologyGraph returns [EObject current=null] : ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'terminology' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token lv_iri_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_annotationProperties_0_0 = null;

        EObject lv_annotations_1_0 = null;

        Enumerator lv_kind_2_0 = null;

        EObject lv_boxAxioms_6_0 = null;

        EObject lv_boxStatements_7_0 = null;



        	enterRule();

        try {
            // InternalOML.g:330:2: ( ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'terminology' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:331:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'terminology' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:331:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'terminology' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' )
            // InternalOML.g:332:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'terminology' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}'
            {
            // InternalOML.g:332:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==69) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOML.g:333:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    {
            	    // InternalOML.g:333:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    // InternalOML.g:334:5: lv_annotationProperties_0_0= ruleAnnotationProperty
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotationProperties_0_0=ruleAnnotationProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotationProperties",
            	    						lv_annotationProperties_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalOML.g:351:3: ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==71) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalOML.g:352:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:352:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:353:5: lv_annotations_1_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_1_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_1_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalOML.g:370:3: ( (lv_kind_2_0= ruleTerminologyKind ) )
            // InternalOML.g:371:4: (lv_kind_2_0= ruleTerminologyKind )
            {
            // InternalOML.g:371:4: (lv_kind_2_0= ruleTerminologyKind )
            // InternalOML.g:372:5: lv_kind_2_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
            lv_kind_2_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,72,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_3());
            		
            // InternalOML.g:393:3: ( (lv_iri_4_0= RULE_IRI ) )
            // InternalOML.g:394:4: (lv_iri_4_0= RULE_IRI )
            {
            // InternalOML.g:394:4: (lv_iri_4_0= RULE_IRI )
            // InternalOML.g:395:5: lv_iri_4_0= RULE_IRI
            {
            lv_iri_4_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_4_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyGraphRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_4_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_5=(Token)match(input,73,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:415:3: ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )*
            loop6:
            do {
                int alt6=3;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // InternalOML.g:416:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:416:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:417:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:417:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:418:6: lv_boxAxioms_6_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_boxAxioms_6_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxAxioms",
            	    							lv_boxAxioms_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:436:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:436:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:437:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:437:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:438:6: lv_boxStatements_7_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_boxStatements_7_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyGraph"


    // $ANTLR start "entryRuleBundle"
    // InternalOML.g:464:1: entryRuleBundle returns [EObject current=null] : iv_ruleBundle= ruleBundle EOF ;
    public final EObject entryRuleBundle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundle = null;


        try {
            // InternalOML.g:464:47: (iv_ruleBundle= ruleBundle EOF )
            // InternalOML.g:465:2: iv_ruleBundle= ruleBundle EOF
            {
             newCompositeNode(grammarAccess.getBundleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBundle=ruleBundle();

            state._fsp--;

             current =iv_ruleBundle; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBundle"


    // $ANTLR start "ruleBundle"
    // InternalOML.g:471:1: ruleBundle returns [EObject current=null] : ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'bundle' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleBundle() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token lv_iri_4_0=null;
        Token otherlv_5=null;
        Token otherlv_10=null;
        EObject lv_annotationProperties_0_0 = null;

        EObject lv_annotations_1_0 = null;

        Enumerator lv_kind_2_0 = null;

        EObject lv_boxAxioms_6_0 = null;

        EObject lv_boxStatements_7_0 = null;

        EObject lv_bundleStatements_8_0 = null;

        EObject lv_bundleAxioms_9_0 = null;



        	enterRule();

        try {
            // InternalOML.g:477:2: ( ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'bundle' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' ) )
            // InternalOML.g:478:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'bundle' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' )
            {
            // InternalOML.g:478:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'bundle' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' )
            // InternalOML.g:479:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleTerminologyKind ) ) otherlv_3= 'bundle' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}'
            {
            // InternalOML.g:479:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==69) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalOML.g:480:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    {
            	    // InternalOML.g:480:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    // InternalOML.g:481:5: lv_annotationProperties_0_0= ruleAnnotationProperty
            	    {

            	    					newCompositeNode(grammarAccess.getBundleAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotationProperties_0_0=ruleAnnotationProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBundleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotationProperties",
            	    						lv_annotationProperties_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalOML.g:498:3: ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==71) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalOML.g:499:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:499:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:500:5: lv_annotations_1_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_1_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBundleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_1_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalOML.g:517:3: ( (lv_kind_2_0= ruleTerminologyKind ) )
            // InternalOML.g:518:4: (lv_kind_2_0= ruleTerminologyKind )
            {
            // InternalOML.g:518:4: (lv_kind_2_0= ruleTerminologyKind )
            // InternalOML.g:519:5: lv_kind_2_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
            lv_kind_2_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBundleRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,75,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getBundleAccess().getBundleKeyword_3());
            		
            // InternalOML.g:540:3: ( (lv_iri_4_0= RULE_IRI ) )
            // InternalOML.g:541:4: (lv_iri_4_0= RULE_IRI )
            {
            // InternalOML.g:541:4: (lv_iri_4_0= RULE_IRI )
            // InternalOML.g:542:5: lv_iri_4_0= RULE_IRI
            {
            lv_iri_4_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_4_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_4_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_5=(Token)match(input,73,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:562:3: ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )*
            loop9:
            do {
                int alt9=5;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalOML.g:563:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:563:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:564:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:564:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:565:6: lv_boxAxioms_6_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_boxAxioms_6_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxAxioms",
            	    							lv_boxAxioms_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:583:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:583:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:584:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:584:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:585:6: lv_boxStatements_7_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_boxStatements_7_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:603:4: ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) )
            	    {
            	    // InternalOML.g:603:4: ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) )
            	    // InternalOML.g:604:5: (lv_bundleStatements_8_0= ruleTerminologyBundleStatement )
            	    {
            	    // InternalOML.g:604:5: (lv_bundleStatements_8_0= ruleTerminologyBundleStatement )
            	    // InternalOML.g:605:6: lv_bundleStatements_8_0= ruleTerminologyBundleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_6_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_bundleStatements_8_0=ruleTerminologyBundleStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"bundleStatements",
            	    							lv_bundleStatements_8_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:623:4: ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) )
            	    {
            	    // InternalOML.g:623:4: ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) )
            	    // InternalOML.g:624:5: (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom )
            	    {
            	    // InternalOML.g:624:5: (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom )
            	    // InternalOML.g:625:6: lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_6_3_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_bundleAxioms_9_0=ruleTerminologyBundleAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"bundleAxioms",
            	    							lv_bundleAxioms_9_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_10=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBundle"


    // $ANTLR start "entryRuleDescriptionBox"
    // InternalOML.g:651:1: entryRuleDescriptionBox returns [EObject current=null] : iv_ruleDescriptionBox= ruleDescriptionBox EOF ;
    public final EObject entryRuleDescriptionBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBox = null;


        try {
            // InternalOML.g:651:55: (iv_ruleDescriptionBox= ruleDescriptionBox EOF )
            // InternalOML.g:652:2: iv_ruleDescriptionBox= ruleDescriptionBox EOF
            {
             newCompositeNode(grammarAccess.getDescriptionBoxRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionBox=ruleDescriptionBox();

            state._fsp--;

             current =iv_ruleDescriptionBox; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionBox"


    // $ANTLR start "ruleDescriptionBox"
    // InternalOML.g:658:1: ruleDescriptionBox returns [EObject current=null] : ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleDescriptionKind ) ) otherlv_3= 'descriptionBox' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' ) ;
    public final EObject ruleDescriptionBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token lv_iri_4_0=null;
        Token otherlv_5=null;
        Token otherlv_15=null;
        EObject lv_annotationProperties_0_0 = null;

        EObject lv_annotations_1_0 = null;

        Enumerator lv_kind_2_0 = null;

        EObject lv_closedWorldDefinitions_6_0 = null;

        EObject lv_descriptionBoxRefinements_7_0 = null;

        EObject lv_conceptInstances_8_0 = null;

        EObject lv_reifiedRelationshipInstances_9_0 = null;

        EObject lv_reifiedRelationshipInstanceDomains_10_0 = null;

        EObject lv_reifiedRelationshipInstanceRanges_11_0 = null;

        EObject lv_unreifiedRelationshipInstanceTuples_12_0 = null;

        EObject lv_singletonScalarDataPropertyValues_13_0 = null;

        EObject lv_singletonStructuredDataPropertyValues_14_0 = null;



        	enterRule();

        try {
            // InternalOML.g:664:2: ( ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleDescriptionKind ) ) otherlv_3= 'descriptionBox' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' ) )
            // InternalOML.g:665:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleDescriptionKind ) ) otherlv_3= 'descriptionBox' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' )
            {
            // InternalOML.g:665:2: ( ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleDescriptionKind ) ) otherlv_3= 'descriptionBox' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' )
            // InternalOML.g:666:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )* ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_2_0= ruleDescriptionKind ) ) otherlv_3= 'descriptionBox' ( (lv_iri_4_0= RULE_IRI ) ) otherlv_5= '{' ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}'
            {
            // InternalOML.g:666:3: ( (lv_annotationProperties_0_0= ruleAnnotationProperty ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==69) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalOML.g:667:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    {
            	    // InternalOML.g:667:4: (lv_annotationProperties_0_0= ruleAnnotationProperty )
            	    // InternalOML.g:668:5: lv_annotationProperties_0_0= ruleAnnotationProperty
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_annotationProperties_0_0=ruleAnnotationProperty();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotationProperties",
            	    						lv_annotationProperties_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalOML.g:685:3: ( (lv_annotations_1_0= ruleAnnotationPropertyValue ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==71) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOML.g:686:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:686:4: (lv_annotations_1_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:687:5: lv_annotations_1_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_annotations_1_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_1_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalOML.g:704:3: ( (lv_kind_2_0= ruleDescriptionKind ) )
            // InternalOML.g:705:4: (lv_kind_2_0= ruleDescriptionKind )
            {
            // InternalOML.g:705:4: (lv_kind_2_0= ruleDescriptionKind )
            // InternalOML.g:706:5: lv_kind_2_0= ruleDescriptionKind
            {

            					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_kind_2_0=ruleDescriptionKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,76,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_3());
            		
            // InternalOML.g:727:3: ( (lv_iri_4_0= RULE_IRI ) )
            // InternalOML.g:728:4: (lv_iri_4_0= RULE_IRI )
            {
            // InternalOML.g:728:4: (lv_iri_4_0= RULE_IRI )
            // InternalOML.g:729:5: lv_iri_4_0= RULE_IRI
            {
            lv_iri_4_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_4_0, grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_4_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_5=(Token)match(input,73,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:749:3: ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*
            loop12:
            do {
                int alt12=10;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // InternalOML.g:750:4: ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    {
            	    // InternalOML.g:750:4: ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    // InternalOML.g:751:5: (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    {
            	    // InternalOML.g:751:5: (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    // InternalOML.g:752:6: lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_closedWorldDefinitions_6_0=ruleDescriptionBoxExtendsClosedWorldDefinitions();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"closedWorldDefinitions",
            	    							lv_closedWorldDefinitions_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxExtendsClosedWorldDefinitions");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:770:4: ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) )
            	    {
            	    // InternalOML.g:770:4: ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) )
            	    // InternalOML.g:771:5: (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement )
            	    {
            	    // InternalOML.g:771:5: (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement )
            	    // InternalOML.g:772:6: lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_descriptionBoxRefinements_7_0=ruleDescriptionBoxRefinement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"descriptionBoxRefinements",
            	    							lv_descriptionBoxRefinements_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxRefinement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:790:4: ( (lv_conceptInstances_8_0= ruleConceptInstance ) )
            	    {
            	    // InternalOML.g:790:4: ( (lv_conceptInstances_8_0= ruleConceptInstance ) )
            	    // InternalOML.g:791:5: (lv_conceptInstances_8_0= ruleConceptInstance )
            	    {
            	    // InternalOML.g:791:5: (lv_conceptInstances_8_0= ruleConceptInstance )
            	    // InternalOML.g:792:6: lv_conceptInstances_8_0= ruleConceptInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_6_2_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_conceptInstances_8_0=ruleConceptInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conceptInstances",
            	    							lv_conceptInstances_8_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ConceptInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:810:4: ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) )
            	    {
            	    // InternalOML.g:810:4: ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) )
            	    // InternalOML.g:811:5: (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance )
            	    {
            	    // InternalOML.g:811:5: (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance )
            	    // InternalOML.g:812:6: lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_6_3_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstances_9_0=ruleReifiedRelationshipInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstances",
            	    							lv_reifiedRelationshipInstances_9_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:830:4: ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) )
            	    {
            	    // InternalOML.g:830:4: ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) )
            	    // InternalOML.g:831:5: (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain )
            	    {
            	    // InternalOML.g:831:5: (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain )
            	    // InternalOML.g:832:6: lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_6_4_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstanceDomains_10_0=ruleReifiedRelationshipInstanceDomain();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstanceDomains",
            	    							lv_reifiedRelationshipInstanceDomains_10_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceDomain");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:850:4: ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) )
            	    {
            	    // InternalOML.g:850:4: ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) )
            	    // InternalOML.g:851:5: (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange )
            	    {
            	    // InternalOML.g:851:5: (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange )
            	    // InternalOML.g:852:6: lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_6_5_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstanceRanges_11_0=ruleReifiedRelationshipInstanceRange();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstanceRanges",
            	    							lv_reifiedRelationshipInstanceRanges_11_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceRange");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:870:4: ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    {
            	    // InternalOML.g:870:4: ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    // InternalOML.g:871:5: (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple )
            	    {
            	    // InternalOML.g:871:5: (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple )
            	    // InternalOML.g:872:6: lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_6_6_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_unreifiedRelationshipInstanceTuples_12_0=ruleUnreifiedRelationshipInstanceTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"unreifiedRelationshipInstanceTuples",
            	    							lv_unreifiedRelationshipInstanceTuples_12_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationshipInstanceTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:890:4: ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:890:4: ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    // InternalOML.g:891:5: (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:891:5: (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    // InternalOML.g:892:6: lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_6_7_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_singletonScalarDataPropertyValues_13_0=ruleSingletonInstanceScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"singletonScalarDataPropertyValues",
            	    							lv_singletonScalarDataPropertyValues_13_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:910:4: ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    {
            	    // InternalOML.g:910:4: ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    // InternalOML.g:911:5: (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    {
            	    // InternalOML.g:911:5: (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    // InternalOML.g:912:6: lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_6_8_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_singletonStructuredDataPropertyValues_14_0=ruleSingletonInstanceStructuredDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"singletonStructuredDataPropertyValues",
            	    							lv_singletonStructuredDataPropertyValues_14_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceStructuredDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_15=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionBox"


    // $ANTLR start "entryRuleTerminologyBoxAxiom"
    // InternalOML.g:938:1: entryRuleTerminologyBoxAxiom returns [EObject current=null] : iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF ;
    public final EObject entryRuleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxAxiom = null;


        try {
            // InternalOML.g:938:60: (iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF )
            // InternalOML.g:939:2: iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBoxAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBoxAxiom=ruleTerminologyBoxAxiom();

            state._fsp--;

             current =iv_ruleTerminologyBoxAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBoxAxiom"


    // $ANTLR start "ruleTerminologyBoxAxiom"
    // InternalOML.g:945:1: ruleTerminologyBoxAxiom returns [EObject current=null] : (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) ;
    public final EObject ruleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptDesignationTerminologyAxiom_0 = null;

        EObject this_TerminologyExtensionAxiom_1 = null;

        EObject this_TerminologyNestingAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:951:2: ( (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) )
            // InternalOML.g:952:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            {
            // InternalOML.g:952:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalOML.g:953:3: this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getConceptDesignationTerminologyAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConceptDesignationTerminologyAxiom_0=ruleConceptDesignationTerminologyAxiom();

                    state._fsp--;


                    			current = this_ConceptDesignationTerminologyAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:962:3: this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyExtensionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyExtensionAxiom_1=ruleTerminologyExtensionAxiom();

                    state._fsp--;


                    			current = this_TerminologyExtensionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:971:3: this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxAxiomAccess().getTerminologyNestingAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TerminologyNestingAxiom_2=ruleTerminologyNestingAxiom();

                    state._fsp--;


                    			current = this_TerminologyNestingAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBoxAxiom"


    // $ANTLR start "entryRuleBundledTerminologyAxiom"
    // InternalOML.g:983:1: entryRuleBundledTerminologyAxiom returns [EObject current=null] : iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF ;
    public final EObject entryRuleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundledTerminologyAxiom = null;


        try {
            // InternalOML.g:983:64: (iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF )
            // InternalOML.g:984:2: iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF
            {
             newCompositeNode(grammarAccess.getBundledTerminologyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBundledTerminologyAxiom=ruleBundledTerminologyAxiom();

            state._fsp--;

             current =iv_ruleBundledTerminologyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBundledTerminologyAxiom"


    // $ANTLR start "ruleBundledTerminologyAxiom"
    // InternalOML.g:990:1: ruleBundledTerminologyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:996:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:997:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:997:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) )
            // InternalOML.g:998:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:998:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==71) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOML.g:999:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:999:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1000:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBundledTerminologyAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_1=(Token)match(input,77,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_1());
            		
            // InternalOML.g:1021:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1022:4: ( ruleExternalReference )
            {
            // InternalOML.g:1022:4: ( ruleExternalReference )
            // InternalOML.g:1023:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundledTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBundledTerminologyAxiom"


    // $ANTLR start "entryRuleConceptDesignationTerminologyAxiom"
    // InternalOML.g:1041:1: entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null] : iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF ;
    public final EObject entryRuleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptDesignationTerminologyAxiom = null;


        try {
            // InternalOML.g:1041:75: (iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF )
            // InternalOML.g:1042:2: iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF
            {
             newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptDesignationTerminologyAxiom=ruleConceptDesignationTerminologyAxiom();

            state._fsp--;

             current =iv_ruleConceptDesignationTerminologyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptDesignationTerminologyAxiom"


    // $ANTLR start "ruleConceptDesignationTerminologyAxiom"
    // InternalOML.g:1048:1: ruleConceptDesignationTerminologyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' ) ;
    public final EObject ruleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1054:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:1055:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:1055:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:1056:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}'
            {
            // InternalOML.g:1056:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==71) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalOML.g:1057:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1057:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1058:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_1=(Token)match(input,78,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,79,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_3());
            		
            // InternalOML.g:1087:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1088:4: ( ruleExternalReference )
            {
            // InternalOML.g:1088:4: ( ruleExternalReference )
            // InternalOML.g:1089:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_4_0());
            				
            pushFollow(FOLLOW_20);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,80,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_5());
            		
            // InternalOML.g:1107:3: ( ( ruleReference ) )
            // InternalOML.g:1108:4: ( ruleReference )
            {
            // InternalOML.g:1108:4: ( ruleReference )
            // InternalOML.g:1109:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptDesignationTerminologyAxiom"


    // $ANTLR start "entryRuleTerminologyExtensionAxiom"
    // InternalOML.g:1131:1: entryRuleTerminologyExtensionAxiom returns [EObject current=null] : iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF ;
    public final EObject entryRuleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtensionAxiom = null;


        try {
            // InternalOML.g:1131:66: (iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF )
            // InternalOML.g:1132:2: iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyExtensionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyExtensionAxiom=ruleTerminologyExtensionAxiom();

            state._fsp--;

             current =iv_ruleTerminologyExtensionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyExtensionAxiom"


    // $ANTLR start "ruleTerminologyExtensionAxiom"
    // InternalOML.g:1138:1: ruleTerminologyExtensionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1144:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:1145:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:1145:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:1146:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:1146:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==71) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalOML.g:1147:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1147:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1148:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyExtensionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_1=(Token)match(input,81,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_1());
            		
            // InternalOML.g:1169:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1170:4: ( ruleExternalReference )
            {
            // InternalOML.g:1170:4: ( ruleExternalReference )
            // InternalOML.g:1171:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyExtensionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyExtensionAxiom"


    // $ANTLR start "entryRuleTerminologyNestingAxiom"
    // InternalOML.g:1189:1: entryRuleTerminologyNestingAxiom returns [EObject current=null] : iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF ;
    public final EObject entryRuleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyNestingAxiom = null;


        try {
            // InternalOML.g:1189:64: (iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF )
            // InternalOML.g:1190:2: iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyNestingAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyNestingAxiom=ruleTerminologyNestingAxiom();

            state._fsp--;

             current =iv_ruleTerminologyNestingAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyNestingAxiom"


    // $ANTLR start "ruleTerminologyNestingAxiom"
    // InternalOML.g:1196:1: ruleTerminologyNestingAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' ) ;
    public final EObject ruleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1202:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:1203:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:1203:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:1204:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}'
            {
            // InternalOML.g:1204:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==71) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalOML.g:1205:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1205:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1206:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_24);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyNestingAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_1=(Token)match(input,82,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,83,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_3());
            		
            // InternalOML.g:1235:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1236:4: ( ruleExternalReference )
            {
            // InternalOML.g:1236:4: ( ruleExternalReference )
            // InternalOML.g:1237:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_4_0());
            				
            pushFollow(FOLLOW_26);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,84,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_5());
            		
            // InternalOML.g:1255:3: ( ( ruleReference ) )
            // InternalOML.g:1256:4: ( ruleReference )
            {
            // InternalOML.g:1256:4: ( ruleReference )
            // InternalOML.g:1257:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyNestingAxiom"


    // $ANTLR start "entryRuleTerminologyBoxStatement"
    // InternalOML.g:1279:1: entryRuleTerminologyBoxStatement returns [EObject current=null] : iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF ;
    public final EObject entryRuleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxStatement = null;


        try {
            // InternalOML.g:1279:64: (iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF )
            // InternalOML.g:1280:2: iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBoxStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBoxStatement=ruleTerminologyBoxStatement();

            state._fsp--;

             current =iv_ruleTerminologyBoxStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBoxStatement"


    // $ANTLR start "ruleTerminologyBoxStatement"
    // InternalOML.g:1286:1: ruleTerminologyBoxStatement returns [EObject current=null] : (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) ;
    public final EObject ruleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TermAxiom_0 = null;

        EObject this_Term_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1292:2: ( (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) )
            // InternalOML.g:1293:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            {
            // InternalOML.g:1293:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalOML.g:1294:3: this_TermAxiom_0= ruleTermAxiom
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getTermAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TermAxiom_0=ruleTermAxiom();

                    state._fsp--;


                    			current = this_TermAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1303:3: this_Term_1= ruleTerm
                    {

                    			newCompositeNode(grammarAccess.getTerminologyBoxStatementAccess().getTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Term_1=ruleTerm();

                    state._fsp--;


                    			current = this_Term_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBoxStatement"


    // $ANTLR start "entryRuleTerm"
    // InternalOML.g:1315:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalOML.g:1315:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalOML.g:1316:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalOML.g:1322:1: ruleTerm returns [EObject current=null] : (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship | this_Rule_4= ruleRule ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEntity_0 = null;

        EObject this_EntityRelationship_1 = null;

        EObject this_Datatype_2 = null;

        EObject this_DataRelationship_3 = null;

        EObject this_Rule_4 = null;



        	enterRule();

        try {
            // InternalOML.g:1328:2: ( (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship | this_Rule_4= ruleRule ) )
            // InternalOML.g:1329:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship | this_Rule_4= ruleRule )
            {
            // InternalOML.g:1329:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship | this_Rule_4= ruleRule )
            int alt19=5;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalOML.g:1330:3: this_AtomicEntity_0= ruleAtomicEntity
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getAtomicEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicEntity_0=ruleAtomicEntity();

                    state._fsp--;


                    			current = this_AtomicEntity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1339:3: this_EntityRelationship_1= ruleEntityRelationship
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getEntityRelationshipParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityRelationship_1=ruleEntityRelationship();

                    state._fsp--;


                    			current = this_EntityRelationship_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1348:3: this_Datatype_2= ruleDatatype
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getDatatypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Datatype_2=ruleDatatype();

                    state._fsp--;


                    			current = this_Datatype_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:1357:3: this_DataRelationship_3= ruleDataRelationship
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataRelationship_3=ruleDataRelationship();

                    state._fsp--;


                    			current = this_DataRelationship_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:1366:3: this_Rule_4= ruleRule
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getRuleParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rule_4=ruleRule();

                    state._fsp--;


                    			current = this_Rule_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtomicEntity"
    // InternalOML.g:1378:1: entryRuleAtomicEntity returns [EObject current=null] : iv_ruleAtomicEntity= ruleAtomicEntity EOF ;
    public final EObject entryRuleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEntity = null;


        try {
            // InternalOML.g:1378:53: (iv_ruleAtomicEntity= ruleAtomicEntity EOF )
            // InternalOML.g:1379:2: iv_ruleAtomicEntity= ruleAtomicEntity EOF
            {
             newCompositeNode(grammarAccess.getAtomicEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicEntity=ruleAtomicEntity();

            state._fsp--;

             current =iv_ruleAtomicEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicEntity"


    // $ANTLR start "ruleAtomicEntity"
    // InternalOML.g:1385:1: ruleAtomicEntity returns [EObject current=null] : (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) ;
    public final EObject ruleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Aspect_0 = null;

        EObject this_Concept_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1391:2: ( (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) )
            // InternalOML.g:1392:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            {
            // InternalOML.g:1392:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalOML.g:1393:3: this_Aspect_0= ruleAspect
                    {

                    			newCompositeNode(grammarAccess.getAtomicEntityAccess().getAspectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Aspect_0=ruleAspect();

                    state._fsp--;


                    			current = this_Aspect_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1402:3: this_Concept_1= ruleConcept
                    {

                    			newCompositeNode(grammarAccess.getAtomicEntityAccess().getConceptParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concept_1=ruleConcept();

                    state._fsp--;


                    			current = this_Concept_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicEntity"


    // $ANTLR start "entryRuleEntityRelationship"
    // InternalOML.g:1414:1: entryRuleEntityRelationship returns [EObject current=null] : iv_ruleEntityRelationship= ruleEntityRelationship EOF ;
    public final EObject entryRuleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRelationship = null;


        try {
            // InternalOML.g:1414:59: (iv_ruleEntityRelationship= ruleEntityRelationship EOF )
            // InternalOML.g:1415:2: iv_ruleEntityRelationship= ruleEntityRelationship EOF
            {
             newCompositeNode(grammarAccess.getEntityRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityRelationship=ruleEntityRelationship();

            state._fsp--;

             current =iv_ruleEntityRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityRelationship"


    // $ANTLR start "ruleEntityRelationship"
    // InternalOML.g:1421:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction | this_UnreifiedRelationship_2= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_ReifiedRelationshipRestriction_1 = null;

        EObject this_UnreifiedRelationship_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1427:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction | this_UnreifiedRelationship_2= ruleUnreifiedRelationship ) )
            // InternalOML.g:1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction | this_UnreifiedRelationship_2= ruleUnreifiedRelationship )
            {
            // InternalOML.g:1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction | this_UnreifiedRelationship_2= ruleUnreifiedRelationship )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalOML.g:1429:3: this_ReifiedRelationship_0= ruleReifiedRelationship
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationship_0=ruleReifiedRelationship();

                    state._fsp--;


                    			current = this_ReifiedRelationship_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1438:3: this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getReifiedRelationshipRestrictionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationshipRestriction_1=ruleReifiedRelationshipRestriction();

                    state._fsp--;


                    			current = this_ReifiedRelationshipRestriction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1447:3: this_UnreifiedRelationship_2= ruleUnreifiedRelationship
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnreifiedRelationship_2=ruleUnreifiedRelationship();

                    state._fsp--;


                    			current = this_UnreifiedRelationship_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityRelationship"


    // $ANTLR start "entryRuleDatatype"
    // InternalOML.g:1459:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOML.g:1459:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOML.g:1460:2: iv_ruleDatatype= ruleDatatype EOF
            {
             newCompositeNode(grammarAccess.getDatatypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // InternalOML.g:1466:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1472:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOML.g:1473:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOML.g:1473:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalOML.g:1474:3: this_ScalarDataRange_0= ruleScalarDataRange
                    {

                    			newCompositeNode(grammarAccess.getDatatypeAccess().getScalarDataRangeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarDataRange_0=ruleScalarDataRange();

                    state._fsp--;


                    			current = this_ScalarDataRange_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1483:3: this_Structure_1= ruleStructure
                    {

                    			newCompositeNode(grammarAccess.getDatatypeAccess().getStructureParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Structure_1=ruleStructure();

                    state._fsp--;


                    			current = this_Structure_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleScalarDataRange"
    // InternalOML.g:1495:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOML.g:1495:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOML.g:1496:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
            {
             newCompositeNode(grammarAccess.getScalarDataRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarDataRange=ruleScalarDataRange();

            state._fsp--;

             current =iv_ruleScalarDataRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarDataRange"


    // $ANTLR start "ruleScalarDataRange"
    // InternalOML.g:1502:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1508:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOML.g:1509:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOML.g:1509:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalOML.g:1510:3: this_Scalar_0= ruleScalar
                    {

                    			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getScalarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Scalar_0=ruleScalar();

                    state._fsp--;


                    			current = this_Scalar_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1519:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
                    {

                    			newCompositeNode(grammarAccess.getScalarDataRangeAccess().getRestrictedDataRangeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RestrictedDataRange_1=ruleRestrictedDataRange();

                    state._fsp--;


                    			current = this_RestrictedDataRange_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarDataRange"


    // $ANTLR start "entryRuleRestrictedDataRange"
    // InternalOML.g:1531:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOML.g:1531:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOML.g:1532:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
            {
             newCompositeNode(grammarAccess.getRestrictedDataRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRestrictedDataRange=ruleRestrictedDataRange();

            state._fsp--;

             current =iv_ruleRestrictedDataRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestrictedDataRange"


    // $ANTLR start "ruleRestrictedDataRange"
    // InternalOML.g:1538:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
    public final EObject ruleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_BinaryScalarRestriction_0 = null;

        EObject this_IRIScalarRestriction_1 = null;

        EObject this_NumericScalarRestriction_2 = null;

        EObject this_PlainLiteralScalarRestriction_3 = null;

        EObject this_ScalarOneOfRestriction_4 = null;

        EObject this_StringScalarRestriction_5 = null;

        EObject this_SynonymScalarRestriction_6 = null;

        EObject this_TimeScalarRestriction_7 = null;



        	enterRule();

        try {
            // InternalOML.g:1544:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOML.g:1545:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOML.g:1545:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalOML.g:1546:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getBinaryScalarRestrictionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryScalarRestriction_0=ruleBinaryScalarRestriction();

                    state._fsp--;


                    			current = this_BinaryScalarRestriction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1555:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getIRIScalarRestrictionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_IRIScalarRestriction_1=ruleIRIScalarRestriction();

                    state._fsp--;


                    			current = this_IRIScalarRestriction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1564:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getNumericScalarRestrictionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericScalarRestriction_2=ruleNumericScalarRestriction();

                    state._fsp--;


                    			current = this_NumericScalarRestriction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:1573:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getPlainLiteralScalarRestrictionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PlainLiteralScalarRestriction_3=rulePlainLiteralScalarRestriction();

                    state._fsp--;


                    			current = this_PlainLiteralScalarRestriction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:1582:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getScalarOneOfRestrictionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarOneOfRestriction_4=ruleScalarOneOfRestriction();

                    state._fsp--;


                    			current = this_ScalarOneOfRestriction_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:1591:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getStringScalarRestrictionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringScalarRestriction_5=ruleStringScalarRestriction();

                    state._fsp--;


                    			current = this_StringScalarRestriction_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalOML.g:1600:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getSynonymScalarRestrictionParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_SynonymScalarRestriction_6=ruleSynonymScalarRestriction();

                    state._fsp--;


                    			current = this_SynonymScalarRestriction_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalOML.g:1609:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
                    {

                    			newCompositeNode(grammarAccess.getRestrictedDataRangeAccess().getTimeScalarRestrictionParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeScalarRestriction_7=ruleTimeScalarRestriction();

                    state._fsp--;


                    			current = this_TimeScalarRestriction_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestrictedDataRange"


    // $ANTLR start "entryRuleDataRelationship"
    // InternalOML.g:1621:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOML.g:1621:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOML.g:1622:2: iv_ruleDataRelationship= ruleDataRelationship EOF
            {
             newCompositeNode(grammarAccess.getDataRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataRelationship=ruleDataRelationship();

            state._fsp--;

             current =iv_ruleDataRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataRelationship"


    // $ANTLR start "ruleDataRelationship"
    // InternalOML.g:1628:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1634:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOML.g:1635:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOML.g:1635:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalOML.g:1636:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityStructuredDataPropertyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityStructuredDataProperty_0=ruleEntityStructuredDataProperty();

                    state._fsp--;


                    			current = this_EntityStructuredDataProperty_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1645:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getEntityScalarDataPropertyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataProperty_1=ruleEntityScalarDataProperty();

                    state._fsp--;


                    			current = this_EntityScalarDataProperty_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1654:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getStructuredDataPropertyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StructuredDataProperty_2=ruleStructuredDataProperty();

                    state._fsp--;


                    			current = this_StructuredDataProperty_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:1663:3: this_ScalarDataProperty_3= ruleScalarDataProperty
                    {

                    			newCompositeNode(grammarAccess.getDataRelationshipAccess().getScalarDataPropertyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarDataProperty_3=ruleScalarDataProperty();

                    state._fsp--;


                    			current = this_ScalarDataProperty_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataRelationship"


    // $ANTLR start "entryRuleTermAxiom"
    // InternalOML.g:1675:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOML.g:1675:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOML.g:1676:2: iv_ruleTermAxiom= ruleTermAxiom EOF
            {
             newCompositeNode(grammarAccess.getTermAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTermAxiom=ruleTermAxiom();

            state._fsp--;

             current =iv_ruleTermAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTermAxiom"


    // $ANTLR start "ruleTermAxiom"
    // InternalOML.g:1682:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_EntityStructuredDataPropertyRestrictionAxiom_2 = null;

        EObject this_ScalarOneOfLiteralAxiom_3 = null;

        EObject this_SpecializationAxiom_4 = null;

        EObject this_SubObjectPropertyOfAxiom_5 = null;

        EObject this_SubDataPropertyOfAxiom_6 = null;



        	enterRule();

        try {
            // InternalOML.g:1688:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom ) )
            // InternalOML.g:1689:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )
            {
            // InternalOML.g:1689:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )
            int alt26=7;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalOML.g:1690:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityRestrictionAxiom_0=ruleEntityRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1699:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityScalarDataPropertyRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyRestrictionAxiom_1=ruleEntityScalarDataPropertyRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1708:3: this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getEntityStructuredDataPropertyRestrictionAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityStructuredDataPropertyRestrictionAxiom_2=ruleEntityStructuredDataPropertyRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityStructuredDataPropertyRestrictionAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:1717:3: this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarOneOfLiteralAxiom_3=ruleScalarOneOfLiteralAxiom();

                    state._fsp--;


                    			current = this_ScalarOneOfLiteralAxiom_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:1726:3: this_SpecializationAxiom_4= ruleSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecializationAxiom_4=ruleSpecializationAxiom();

                    state._fsp--;


                    			current = this_SpecializationAxiom_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:1735:3: this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSubObjectPropertyOfAxiomParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubObjectPropertyOfAxiom_5=ruleSubObjectPropertyOfAxiom();

                    state._fsp--;


                    			current = this_SubObjectPropertyOfAxiom_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalOML.g:1744:3: this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSubDataPropertyOfAxiomParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubDataPropertyOfAxiom_6=ruleSubDataPropertyOfAxiom();

                    state._fsp--;


                    			current = this_SubDataPropertyOfAxiom_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTermAxiom"


    // $ANTLR start "entryRuleEntityRestrictionAxiom"
    // InternalOML.g:1756:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1756:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1757:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityRestrictionAxiom=ruleEntityRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityRestrictionAxiom"


    // $ANTLR start "ruleEntityRestrictionAxiom"
    // InternalOML.g:1763:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1769:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1770:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1770:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalOML.g:1771:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityExistentialRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityExistentialRestrictionAxiom_0=ruleEntityExistentialRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityExistentialRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1780:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityRestrictionAxiomAccess().getEntityUniversalRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityUniversalRestrictionAxiom_1=ruleEntityUniversalRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityUniversalRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyRestrictionAxiom"
    // InternalOML.g:1792:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1792:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1793:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyRestrictionAxiom=ruleEntityScalarDataPropertyRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyRestrictionAxiom"
    // InternalOML.g:1799:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1805:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1806:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1806:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalOML.g:1807:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyExistentialRestrictionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyExistentialRestrictionAxiom_0=ruleEntityScalarDataPropertyExistentialRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyExistentialRestrictionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1816:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyParticularRestrictionAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyParticularRestrictionAxiom_1=ruleEntityScalarDataPropertyParticularRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyParticularRestrictionAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1825:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
                    {

                    			newCompositeNode(grammarAccess.getEntityScalarDataPropertyRestrictionAxiomAccess().getEntityScalarDataPropertyUniversalRestrictionAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EntityScalarDataPropertyUniversalRestrictionAxiom_2=ruleEntityScalarDataPropertyUniversalRestrictionAxiom();

                    state._fsp--;


                    			current = this_EntityScalarDataPropertyUniversalRestrictionAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyRestrictionAxiom"


    // $ANTLR start "entryRuleEntityStructuredDataPropertyRestrictionAxiom"
    // InternalOML.g:1837:1: entryRuleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1837:85: (iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1838:2: iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityStructuredDataPropertyRestrictionAxiom=ruleEntityStructuredDataPropertyRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityStructuredDataPropertyRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityStructuredDataPropertyRestrictionAxiom"


    // $ANTLR start "ruleEntityStructuredDataPropertyRestrictionAxiom"
    // InternalOML.g:1844:1: ruleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom ;
    public final EObject ruleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataPropertyParticularRestrictionAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1850:2: (this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom )
            // InternalOML.g:1851:2: this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom
            {

            		newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRestrictionAxiomAccess().getEntityStructuredDataPropertyParticularRestrictionAxiomParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_EntityStructuredDataPropertyParticularRestrictionAxiom_0=ruleEntityStructuredDataPropertyParticularRestrictionAxiom();

            state._fsp--;


            		current = this_EntityStructuredDataPropertyParticularRestrictionAxiom_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityStructuredDataPropertyRestrictionAxiom"


    // $ANTLR start "entryRuleSpecializationAxiom"
    // InternalOML.g:1862:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1862:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1863:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecializationAxiom=ruleSpecializationAxiom();

            state._fsp--;

             current =iv_ruleSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecializationAxiom"


    // $ANTLR start "ruleSpecializationAxiom"
    // InternalOML.g:1869:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1875:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1876:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1876:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalOML.g:1877:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getConceptSpecializationAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConceptSpecializationAxiom_0=ruleConceptSpecializationAxiom();

                    state._fsp--;


                    			current = this_ConceptSpecializationAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1886:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getAspectSpecializationAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AspectSpecializationAxiom_1=ruleAspectSpecializationAxiom();

                    state._fsp--;


                    			current = this_AspectSpecializationAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:1895:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getSpecializationAxiomAccess().getReifiedRelationshipSpecializationAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationshipSpecializationAxiom_2=ruleReifiedRelationshipSpecializationAxiom();

                    state._fsp--;


                    			current = this_ReifiedRelationshipSpecializationAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecializationAxiom"


    // $ANTLR start "entryRuleTerminologyBundleStatement"
    // InternalOML.g:1907:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1907:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1908:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBundleStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBundleStatement=ruleTerminologyBundleStatement();

            state._fsp--;

             current =iv_ruleTerminologyBundleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBundleStatement"


    // $ANTLR start "ruleTerminologyBundleStatement"
    // InternalOML.g:1914:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1920:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1921:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
            {

            		newCompositeNode(grammarAccess.getTerminologyBundleStatementAccess().getRootConceptTaxonomyAxiomParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_RootConceptTaxonomyAxiom_0=ruleRootConceptTaxonomyAxiom();

            state._fsp--;


            		current = this_RootConceptTaxonomyAxiom_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBundleStatement"


    // $ANTLR start "entryRuleTerminologyBundleAxiom"
    // InternalOML.g:1932:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1932:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1933:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
            {
             newCompositeNode(grammarAccess.getTerminologyBundleAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerminologyBundleAxiom=ruleTerminologyBundleAxiom();

            state._fsp--;

             current =iv_ruleTerminologyBundleAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerminologyBundleAxiom"


    // $ANTLR start "ruleTerminologyBundleAxiom"
    // InternalOML.g:1939:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1945:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1946:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
            {

            		newCompositeNode(grammarAccess.getTerminologyBundleAxiomAccess().getBundledTerminologyAxiomParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_BundledTerminologyAxiom_0=ruleBundledTerminologyAxiom();

            state._fsp--;


            		current = this_BundledTerminologyAxiom_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyBundleAxiom"


    // $ANTLR start "entryRuleDisjointUnionOfConceptsAxiom"
    // InternalOML.g:1957:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1957:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1958:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
            {
             newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDisjointUnionOfConceptsAxiom=ruleDisjointUnionOfConceptsAxiom();

            state._fsp--;

             current =iv_ruleDisjointUnionOfConceptsAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisjointUnionOfConceptsAxiom"


    // $ANTLR start "ruleDisjointUnionOfConceptsAxiom"
    // InternalOML.g:1964:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1970:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1971:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1971:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalOML.g:1972:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
                    {

                    			newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getAnonymousConceptUnionAxiomParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AnonymousConceptUnionAxiom_0=ruleAnonymousConceptUnionAxiom();

                    state._fsp--;


                    			current = this_AnonymousConceptUnionAxiom_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:1981:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
                    {

                    			newCompositeNode(grammarAccess.getDisjointUnionOfConceptsAxiomAccess().getSpecificDisjointConceptAxiomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecificDisjointConceptAxiom_1=ruleSpecificDisjointConceptAxiom();

                    state._fsp--;


                    			current = this_SpecificDisjointConceptAxiom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisjointUnionOfConceptsAxiom"


    // $ANTLR start "entryRuleAspect"
    // InternalOML.g:1993:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1993:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1994:2: iv_ruleAspect= ruleAspect EOF
            {
             newCompositeNode(grammarAccess.getAspectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAspect=ruleAspect();

            state._fsp--;

             current =iv_ruleAspect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAspect"


    // $ANTLR start "ruleAspect"
    // InternalOML.g:2000:1: ruleAspect returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2006:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2007:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2007:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2008:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2008:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==71) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:2009:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2009:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2010:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getAspectAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAspectRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_1=(Token)match(input,85,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getAspectAccess().getAspectKeyword_1());
            		
            // InternalOML.g:2031:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2032:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2032:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2033:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspect"


    // $ANTLR start "entryRuleConcept"
    // InternalOML.g:2053:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:2053:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:2054:2: iv_ruleConcept= ruleConcept EOF
            {
             newCompositeNode(grammarAccess.getConceptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcept=ruleConcept();

            state._fsp--;

             current =iv_ruleConcept; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcept"


    // $ANTLR start "ruleConcept"
    // InternalOML.g:2060:1: ruleConcept returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2066:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2067:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2067:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2068:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2068:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==71) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOML.g:2069:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2069:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2070:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConceptRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_1=(Token)match(input,86,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptAccess().getConceptKeyword_1());
            		
            // InternalOML.g:2091:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2092:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2092:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2093:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcept"


    // $ANTLR start "entryRuleReifiedRelationship"
    // InternalOML.g:2113:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:2113:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:2114:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationship=ruleReifiedRelationship();

            state._fsp--;

             current =iv_ruleReifiedRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationship"


    // $ANTLR start "ruleReifiedRelationship"
    // InternalOML.g:2120:1: ruleReifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) ;
    public final EObject ruleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_isFunctional_5_0=null;
        Token lv_isInverseFunctional_6_0=null;
        Token lv_isEssential_7_0=null;
        Token lv_isInverseEssential_8_0=null;
        Token lv_isSymmetric_9_0=null;
        Token lv_isAsymmetric_10_0=null;
        Token lv_isReflexive_11_0=null;
        Token lv_isIrreflexive_12_0=null;
        Token lv_isTransitive_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_forwardProperty_16_0 = null;

        EObject lv_inverseProperty_19_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2126:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) )
            // InternalOML.g:2127:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            {
            // InternalOML.g:2127:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            // InternalOML.g:2128:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}'
            {
            // InternalOML.g:2128:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==71) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:2129:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2129:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2130:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_30);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_1=(Token)match(input,87,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_1());
            		
            // InternalOML.g:2151:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2152:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2152:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2153:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:2173:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2174:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2174:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2175:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2178:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2179:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2179:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop34:
            do {
                int alt34=10;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // InternalOML.g:2180:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2180:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2181:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2181:116: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2182:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2185:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2185:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2185:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2185:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2185:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2186:10: lv_isFunctional_5_0= 'functional'
            	    {
            	    lv_isFunctional_5_0=(Token)match(input,88,FOLLOW_31); 

            	    										newLeafNode(lv_isFunctional_5_0, grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isFunctional", true, "functional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:2203:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2203:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2204:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2204:116: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2205:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2208:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2208:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2208:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2208:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2208:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2209:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_6_0=(Token)match(input,89,FOLLOW_31); 

            	    										newLeafNode(lv_isInverseFunctional_6_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseFunctional", true, "inverseFunctional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:2226:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2226:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2227:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2227:116: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2228:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2231:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2231:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2231:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2231:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2231:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2232:10: lv_isEssential_7_0= 'essential'
            	    {
            	    lv_isEssential_7_0=(Token)match(input,90,FOLLOW_31); 

            	    										newLeafNode(lv_isEssential_7_0, grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isEssential", true, "essential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:2249:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2249:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2250:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2250:116: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2251:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2254:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2254:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2254:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2254:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2254:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2255:10: lv_isInverseEssential_8_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_8_0=(Token)match(input,91,FOLLOW_31); 

            	    										newLeafNode(lv_isInverseEssential_8_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseEssential", true, "inverseEssential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:2272:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2272:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2273:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2273:116: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2274:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2277:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2277:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2277:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2277:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2277:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2278:10: lv_isSymmetric_9_0= 'symmetric'
            	    {
            	    lv_isSymmetric_9_0=(Token)match(input,92,FOLLOW_31); 

            	    										newLeafNode(lv_isSymmetric_9_0, grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isSymmetric", true, "symmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:2295:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2295:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2296:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2296:116: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2297:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2300:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2300:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2300:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2300:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2300:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2301:10: lv_isAsymmetric_10_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_10_0=(Token)match(input,93,FOLLOW_31); 

            	    										newLeafNode(lv_isAsymmetric_10_0, grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isAsymmetric", true, "asymmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:2318:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2318:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2319:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2319:116: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2320:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2323:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2323:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2323:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2323:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2323:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2324:10: lv_isReflexive_11_0= 'reflexive'
            	    {
            	    lv_isReflexive_11_0=(Token)match(input,94,FOLLOW_31); 

            	    										newLeafNode(lv_isReflexive_11_0, grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isReflexive", true, "reflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:2341:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2341:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2342:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2342:116: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2343:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2346:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2346:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2346:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2346:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2346:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2347:10: lv_isIrreflexive_12_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_12_0=(Token)match(input,95,FOLLOW_31); 

            	    										newLeafNode(lv_isIrreflexive_12_0, grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isIrreflexive", true, "irreflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:2364:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2364:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2365:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2365:116: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2366:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2369:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2369:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2369:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2369:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2369:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2370:10: lv_isTransitive_13_0= 'transitive'
            	    {
            	    lv_isTransitive_13_0=(Token)match(input,96,FOLLOW_31); 

            	    										newLeafNode(lv_isTransitive_13_0, grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isTransitive", true, "transitive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            				

            }

            otherlv_14=(Token)match(input,97,FOLLOW_5); 

            			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_5());
            		
            otherlv_15=(Token)match(input,70,FOLLOW_28); 

            			newLeafNode(otherlv_15, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_6());
            		
            // InternalOML.g:2402:3: ( (lv_forwardProperty_16_0= ruleForwardProperty ) )
            // InternalOML.g:2403:4: (lv_forwardProperty_16_0= ruleForwardProperty )
            {
            // InternalOML.g:2403:4: (lv_forwardProperty_16_0= ruleForwardProperty )
            // InternalOML.g:2404:5: lv_forwardProperty_16_0= ruleForwardProperty
            {

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getForwardPropertyForwardPropertyParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_32);
            lv_forwardProperty_16_0=ruleForwardProperty();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReifiedRelationshipRule());
            					}
            					set(
            						current,
            						"forwardProperty",
            						lv_forwardProperty_16_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ForwardProperty");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:2421:3: (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==98) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOML.g:2422:4: otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) )
                    {
                    otherlv_17=(Token)match(input,98,FOLLOW_5); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0());
                    			
                    otherlv_18=(Token)match(input,70,FOLLOW_28); 

                    				newLeafNode(otherlv_18, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalOML.g:2430:4: ( (lv_inverseProperty_19_0= ruleInverseProperty ) )
                    // InternalOML.g:2431:5: (lv_inverseProperty_19_0= ruleInverseProperty )
                    {
                    // InternalOML.g:2431:5: (lv_inverseProperty_19_0= ruleInverseProperty )
                    // InternalOML.g:2432:6: lv_inverseProperty_19_0= ruleInverseProperty
                    {

                    						newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getInversePropertyInversePropertyParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_inverseProperty_19_0=ruleInverseProperty();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getReifiedRelationshipRule());
                    						}
                    						set(
                    							current,
                    							"inverseProperty",
                    							lv_inverseProperty_19_0,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.InverseProperty");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_20=(Token)match(input,99,FOLLOW_5); 

            			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_9());
            		
            otherlv_21=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_21, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_10());
            		
            // InternalOML.g:2458:3: ( ( ruleReference ) )
            // InternalOML.g:2459:4: ( ruleReference )
            {
            // InternalOML.g:2459:4: ( ruleReference )
            // InternalOML.g:2460:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_11_0());
            				
            pushFollow(FOLLOW_34);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_23=(Token)match(input,100,FOLLOW_5); 

            			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_12());
            		
            otherlv_24=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_24, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_13());
            		
            // InternalOML.g:2482:3: ( ( ruleReference ) )
            // InternalOML.g:2483:4: ( ruleReference )
            {
            // InternalOML.g:2483:4: ( ruleReference )
            // InternalOML.g:2484:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_14_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_26=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_26, grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationship"


    // $ANTLR start "entryRuleForwardProperty"
    // InternalOML.g:2506:1: entryRuleForwardProperty returns [EObject current=null] : iv_ruleForwardProperty= ruleForwardProperty EOF ;
    public final EObject entryRuleForwardProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForwardProperty = null;


        try {
            // InternalOML.g:2506:56: (iv_ruleForwardProperty= ruleForwardProperty EOF )
            // InternalOML.g:2507:2: iv_ruleForwardProperty= ruleForwardProperty EOF
            {
             newCompositeNode(grammarAccess.getForwardPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForwardProperty=ruleForwardProperty();

            state._fsp--;

             current =iv_ruleForwardProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForwardProperty"


    // $ANTLR start "ruleForwardProperty"
    // InternalOML.g:2513:1: ruleForwardProperty returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleForwardProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOML.g:2519:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalOML.g:2520:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalOML.g:2520:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalOML.g:2521:3: (lv_name_0_0= RULE_ID )
            {
            // InternalOML.g:2521:3: (lv_name_0_0= RULE_ID )
            // InternalOML.g:2522:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getForwardPropertyAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getForwardPropertyRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForwardProperty"


    // $ANTLR start "entryRuleInverseProperty"
    // InternalOML.g:2541:1: entryRuleInverseProperty returns [EObject current=null] : iv_ruleInverseProperty= ruleInverseProperty EOF ;
    public final EObject entryRuleInverseProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverseProperty = null;


        try {
            // InternalOML.g:2541:56: (iv_ruleInverseProperty= ruleInverseProperty EOF )
            // InternalOML.g:2542:2: iv_ruleInverseProperty= ruleInverseProperty EOF
            {
             newCompositeNode(grammarAccess.getInversePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInverseProperty=ruleInverseProperty();

            state._fsp--;

             current =iv_ruleInverseProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInverseProperty"


    // $ANTLR start "ruleInverseProperty"
    // InternalOML.g:2548:1: ruleInverseProperty returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleInverseProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOML.g:2554:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalOML.g:2555:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalOML.g:2555:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalOML.g:2556:3: (lv_name_0_0= RULE_ID )
            {
            // InternalOML.g:2556:3: (lv_name_0_0= RULE_ID )
            // InternalOML.g:2557:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getInversePropertyAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getInversePropertyRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInverseProperty"


    // $ANTLR start "entryRuleReifiedRelationshipRestriction"
    // InternalOML.g:2576:1: entryRuleReifiedRelationshipRestriction returns [EObject current=null] : iv_ruleReifiedRelationshipRestriction= ruleReifiedRelationshipRestriction EOF ;
    public final EObject entryRuleReifiedRelationshipRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipRestriction = null;


        try {
            // InternalOML.g:2576:71: (iv_ruleReifiedRelationshipRestriction= ruleReifiedRelationshipRestriction EOF )
            // InternalOML.g:2577:2: iv_ruleReifiedRelationshipRestriction= ruleReifiedRelationshipRestriction EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipRestriction=ruleReifiedRelationshipRestriction();

            state._fsp--;

             current =iv_ruleReifiedRelationshipRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipRestriction"


    // $ANTLR start "ruleReifiedRelationshipRestriction"
    // InternalOML.g:2583:1: ruleReifiedRelationshipRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'source' otherlv_5= '=' ( ( ruleReference ) ) otherlv_7= 'target' otherlv_8= '=' ( ( ruleReference ) ) otherlv_10= '}' ) ;
    public final EObject ruleReifiedRelationshipRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2589:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'source' otherlv_5= '=' ( ( ruleReference ) ) otherlv_7= 'target' otherlv_8= '=' ( ( ruleReference ) ) otherlv_10= '}' ) )
            // InternalOML.g:2590:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'source' otherlv_5= '=' ( ( ruleReference ) ) otherlv_7= 'target' otherlv_8= '=' ( ( ruleReference ) ) otherlv_10= '}' )
            {
            // InternalOML.g:2590:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'source' otherlv_5= '=' ( ( ruleReference ) ) otherlv_7= 'target' otherlv_8= '=' ( ( ruleReference ) ) otherlv_10= '}' )
            // InternalOML.g:2591:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'source' otherlv_5= '=' ( ( ruleReference ) ) otherlv_7= 'target' otherlv_8= '=' ( ( ruleReference ) ) otherlv_10= '}'
            {
            // InternalOML.g:2591:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==71) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:2592:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2592:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2593:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_35);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_1=(Token)match(input,101,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipRestrictionAccess().getReifiedRelationshipRestrictionKeyword_1());
            		
            // InternalOML.g:2614:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2615:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2615:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2616:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_33); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,99,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceKeyword_4());
            		
            otherlv_5=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2644:3: ( ( ruleReference ) )
            // InternalOML.g:2645:4: ( ruleReference )
            {
            // InternalOML.g:2645:4: ( ruleReference )
            // InternalOML.g:2646:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipRestrictionAccess().getSourceEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_34);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,100,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetKeyword_7());
            		
            otherlv_8=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_8, grammarAccess.getReifiedRelationshipRestrictionAccess().getEqualsSignKeyword_8());
            		
            // InternalOML.g:2668:3: ( ( ruleReference ) )
            // InternalOML.g:2669:4: ( ruleReference )
            {
            // InternalOML.g:2669:4: ( ruleReference )
            // InternalOML.g:2670:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipRestrictionAccess().getTargetEntityCrossReference_9_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getReifiedRelationshipRestrictionAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipRestriction"


    // $ANTLR start "entryRuleUnreifiedRelationship"
    // InternalOML.g:2692:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:2692:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2693:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
            {
             newCompositeNode(grammarAccess.getUnreifiedRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnreifiedRelationship=ruleUnreifiedRelationship();

            state._fsp--;

             current =iv_ruleUnreifiedRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreifiedRelationship"


    // $ANTLR start "ruleUnreifiedRelationship"
    // InternalOML.g:2699:1: ruleUnreifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) ;
    public final EObject ruleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_isFunctional_5_0=null;
        Token lv_isInverseFunctional_6_0=null;
        Token lv_isEssential_7_0=null;
        Token lv_isInverseEssential_8_0=null;
        Token lv_isSymmetric_9_0=null;
        Token lv_isAsymmetric_10_0=null;
        Token lv_isReflexive_11_0=null;
        Token lv_isIrreflexive_12_0=null;
        Token lv_isTransitive_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2705:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) )
            // InternalOML.g:2706:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            {
            // InternalOML.g:2706:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            // InternalOML.g:2707:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}'
            {
            // InternalOML.g:2707:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==71) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOML.g:2708:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2708:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2709:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnreifiedRelationshipRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_1=(Token)match(input,102,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1());
            		
            // InternalOML.g:2730:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2731:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2731:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2732:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:2752:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2753:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2753:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2754:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2757:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2758:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2758:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop38:
            do {
                int alt38=10;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalOML.g:2759:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2759:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2760:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2760:118: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2761:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2764:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2764:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2764:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2764:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2764:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2765:10: lv_isFunctional_5_0= 'functional'
            	    {
            	    lv_isFunctional_5_0=(Token)match(input,88,FOLLOW_37); 

            	    										newLeafNode(lv_isFunctional_5_0, grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_4_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isFunctional", true, "functional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:2782:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2782:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2783:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2783:118: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2784:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2787:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2787:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2787:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2787:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2787:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2788:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_6_0=(Token)match(input,89,FOLLOW_37); 

            	    										newLeafNode(lv_isInverseFunctional_6_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_4_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseFunctional", true, "inverseFunctional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:2805:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2805:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2806:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2806:118: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2807:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2810:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2810:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2810:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2810:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2810:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2811:10: lv_isEssential_7_0= 'essential'
            	    {
            	    lv_isEssential_7_0=(Token)match(input,90,FOLLOW_37); 

            	    										newLeafNode(lv_isEssential_7_0, grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_4_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isEssential", true, "essential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:2828:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2828:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2829:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2829:118: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2830:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2833:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2833:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2833:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2833:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2833:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2834:10: lv_isInverseEssential_8_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_8_0=(Token)match(input,91,FOLLOW_37); 

            	    										newLeafNode(lv_isInverseEssential_8_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_4_3_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseEssential", true, "inverseEssential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:2851:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2851:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2852:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2852:118: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2853:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2856:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2856:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2856:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2856:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2856:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2857:10: lv_isSymmetric_9_0= 'symmetric'
            	    {
            	    lv_isSymmetric_9_0=(Token)match(input,92,FOLLOW_37); 

            	    										newLeafNode(lv_isSymmetric_9_0, grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_4_4_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isSymmetric", true, "symmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:2874:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2874:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2875:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2875:118: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2876:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2879:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2879:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2879:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2879:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2879:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2880:10: lv_isAsymmetric_10_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_10_0=(Token)match(input,93,FOLLOW_37); 

            	    										newLeafNode(lv_isAsymmetric_10_0, grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_4_5_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isAsymmetric", true, "asymmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:2897:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2897:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2898:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2898:118: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2899:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2902:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2902:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2902:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2902:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2902:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2903:10: lv_isReflexive_11_0= 'reflexive'
            	    {
            	    lv_isReflexive_11_0=(Token)match(input,94,FOLLOW_37); 

            	    										newLeafNode(lv_isReflexive_11_0, grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_4_6_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isReflexive", true, "reflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:2920:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2920:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2921:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2921:118: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2922:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2925:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2925:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2925:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2925:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2925:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2926:10: lv_isIrreflexive_12_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_12_0=(Token)match(input,95,FOLLOW_37); 

            	    										newLeafNode(lv_isIrreflexive_12_0, grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_4_7_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isIrreflexive", true, "irreflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:2943:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2943:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2944:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2944:118: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2945:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2948:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2948:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2948:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2948:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2948:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2949:10: lv_isTransitive_13_0= 'transitive'
            	    {
            	    lv_isTransitive_13_0=(Token)match(input,96,FOLLOW_37); 

            	    										newLeafNode(lv_isTransitive_13_0, grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_4_8_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isTransitive", true, "transitive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            				

            }

            otherlv_14=(Token)match(input,99,FOLLOW_5); 

            			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_5());
            		
            otherlv_15=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_6());
            		
            // InternalOML.g:2981:3: ( ( ruleReference ) )
            // InternalOML.g:2982:4: ( ruleReference )
            {
            // InternalOML.g:2982:4: ( ruleReference )
            // InternalOML.g:2983:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_7_0());
            				
            pushFollow(FOLLOW_34);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,100,FOLLOW_5); 

            			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_8());
            		
            otherlv_18=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_18, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_9());
            		
            // InternalOML.g:3005:3: ( ( ruleReference ) )
            // InternalOML.g:3006:4: ( ruleReference )
            {
            // InternalOML.g:3006:4: ( ruleReference )
            // InternalOML.g:3007:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_10_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_20=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreifiedRelationship"


    // $ANTLR start "entryRuleScalar"
    // InternalOML.g:3029:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:3029:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:3030:2: iv_ruleScalar= ruleScalar EOF
            {
             newCompositeNode(grammarAccess.getScalarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalar=ruleScalar();

            state._fsp--;

             current =iv_ruleScalar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalar"


    // $ANTLR start "ruleScalar"
    // InternalOML.g:3036:1: ruleScalar returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3042:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:3043:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:3043:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:3044:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:3044:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==71) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOML.g:3045:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3045:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3046:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_38);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScalarRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_1=(Token)match(input,103,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarAccess().getScalarKeyword_1());
            		
            // InternalOML.g:3067:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3068:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3068:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3069:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalar"


    // $ANTLR start "entryRuleStructure"
    // InternalOML.g:3089:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:3089:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:3090:2: iv_ruleStructure= ruleStructure EOF
            {
             newCompositeNode(grammarAccess.getStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructure=ruleStructure();

            state._fsp--;

             current =iv_ruleStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructure"


    // $ANTLR start "ruleStructure"
    // InternalOML.g:3096:1: ruleStructure returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3102:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:3103:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:3103:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:3104:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:3104:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==71) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalOML.g:3105:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3105:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3106:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStructureAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStructureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_1=(Token)match(input,104,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructureAccess().getStructureKeyword_1());
            		
            // InternalOML.g:3127:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3128:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3128:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3129:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructure"


    // $ANTLR start "entryRuleEntityStructuredDataProperty"
    // InternalOML.g:3149:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:3149:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:3150:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
            {
             newCompositeNode(grammarAccess.getEntityStructuredDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityStructuredDataProperty=ruleEntityStructuredDataProperty();

            state._fsp--;

             current =iv_ruleEntityStructuredDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityStructuredDataProperty"


    // $ANTLR start "ruleEntityStructuredDataProperty"
    // InternalOML.g:3156:1: ruleEntityStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
    public final EObject ruleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isIdentityCriteria_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3162:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:3163:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:3163:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:3164:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:3164:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==71) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalOML.g:3165:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3165:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3166:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_40);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_1=(Token)match(input,105,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:3187:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==106) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalOML.g:3188:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:3188:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:3189:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,106,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:3201:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3202:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3202:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3203:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_3_0, grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,73,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:3227:3: ( ( ruleReference ) )
            // InternalOML.g:3228:4: ( ruleReference )
            {
            // InternalOML.g:3228:4: ( ruleReference )
            // InternalOML.g:3229:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_43);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:3247:3: ( ( ruleReference ) )
            // InternalOML.g:3248:4: ( ruleReference )
            {
            // InternalOML.g:3248:4: ( ruleReference )
            // InternalOML.g:3249:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_8_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityStructuredDataProperty"


    // $ANTLR start "entryRuleEntityScalarDataProperty"
    // InternalOML.g:3271:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:3271:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:3272:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataProperty=ruleEntityScalarDataProperty();

            state._fsp--;

             current =iv_ruleEntityScalarDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataProperty"


    // $ANTLR start "ruleEntityScalarDataProperty"
    // InternalOML.g:3278:1: ruleEntityScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
    public final EObject ruleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isIdentityCriteria_2_0=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3284:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:3285:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:3285:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:3286:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:3286:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==71) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalOML.g:3287:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3287:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3288:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_44);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_1=(Token)match(input,109,FOLLOW_41); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3309:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==106) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalOML.g:3310:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:3310:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:3311:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,106,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:3323:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3324:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3324:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3325:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_3_0, grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,73,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:3349:3: ( ( ruleReference ) )
            // InternalOML.g:3350:4: ( ruleReference )
            {
            // InternalOML.g:3350:4: ( ruleReference )
            // InternalOML.g:3351:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_43);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:3369:3: ( ( ruleReference ) )
            // InternalOML.g:3370:4: ( ruleReference )
            {
            // InternalOML.g:3370:4: ( ruleReference )
            // InternalOML.g:3371:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_8_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataProperty"


    // $ANTLR start "entryRuleStructuredDataProperty"
    // InternalOML.g:3393:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:3393:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:3394:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
            {
             newCompositeNode(grammarAccess.getStructuredDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataProperty=ruleStructuredDataProperty();

            state._fsp--;

             current =iv_ruleStructuredDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredDataProperty"


    // $ANTLR start "ruleStructuredDataProperty"
    // InternalOML.g:3400:1: ruleStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
    public final EObject ruleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3406:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3407:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3407:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3408:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3408:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==71) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalOML.g:3409:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3409:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3410:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStructuredDataPropertyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_1=(Token)match(input,110,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:3431:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3432:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3432:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3433:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3457:3: ( ( ruleReference ) )
            // InternalOML.g:3458:4: ( ruleReference )
            {
            // InternalOML.g:3458:4: ( ruleReference )
            // InternalOML.g:3459:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_5_0());
            				
            pushFollow(FOLLOW_43);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3477:3: ( ( ruleReference ) )
            // InternalOML.g:3478:4: ( ruleReference )
            {
            // InternalOML.g:3478:4: ( ruleReference )
            // InternalOML.g:3479:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuredDataProperty"


    // $ANTLR start "entryRuleScalarDataProperty"
    // InternalOML.g:3501:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:3501:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:3502:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
            {
             newCompositeNode(grammarAccess.getScalarDataPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarDataProperty=ruleScalarDataProperty();

            state._fsp--;

             current =iv_ruleScalarDataProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarDataProperty"


    // $ANTLR start "ruleScalarDataProperty"
    // InternalOML.g:3508:1: ruleScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
    public final EObject ruleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3514:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3515:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3515:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3516:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3516:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==71) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalOML.g:3517:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3517:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3518:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_46);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScalarDataPropertyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_1=(Token)match(input,111,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3539:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3540:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3540:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3541:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3565:3: ( ( ruleReference ) )
            // InternalOML.g:3566:4: ( ruleReference )
            {
            // InternalOML.g:3566:4: ( ruleReference )
            // InternalOML.g:3567:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_5_0());
            				
            pushFollow(FOLLOW_43);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3585:3: ( ( ruleReference ) )
            // InternalOML.g:3586:4: ( ruleReference )
            {
            // InternalOML.g:3586:4: ( ruleReference )
            // InternalOML.g:3587:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarDataProperty"


    // $ANTLR start "entryRuleRule"
    // InternalOML.g:3609:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalOML.g:3609:45: (iv_ruleRule= ruleRule EOF )
            // InternalOML.g:3610:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalOML.g:3616:1: ruleRule returns [EObject current=null] : this_ChainRule_0= ruleChainRule ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChainRule_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3622:2: (this_ChainRule_0= ruleChainRule )
            // InternalOML.g:3623:2: this_ChainRule_0= ruleChainRule
            {

            		newCompositeNode(grammarAccess.getRuleAccess().getChainRuleParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ChainRule_0=ruleChainRule();

            state._fsp--;


            		current = this_ChainRule_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleChainRule"
    // InternalOML.g:3634:1: entryRuleChainRule returns [EObject current=null] : iv_ruleChainRule= ruleChainRule EOF ;
    public final EObject entryRuleChainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChainRule = null;


        try {
            // InternalOML.g:3634:50: (iv_ruleChainRule= ruleChainRule EOF )
            // InternalOML.g:3635:2: iv_ruleChainRule= ruleChainRule EOF
            {
             newCompositeNode(grammarAccess.getChainRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleChainRule=ruleChainRule();

            state._fsp--;

             current =iv_ruleChainRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChainRule"


    // $ANTLR start "ruleChainRule"
    // InternalOML.g:3641:1: ruleChainRule returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) ) ;
    public final EObject ruleChainRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_firstSegment_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3647:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) ) )
            // InternalOML.g:3648:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) )
            {
            // InternalOML.g:3648:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) )
            // InternalOML.g:3649:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) )
            {
            otherlv_0=(Token)match(input,112,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getChainRuleAccess().getRuleKeyword_0());
            		
            // InternalOML.g:3653:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3654:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3654:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3655:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(lv_name_1_0, grammarAccess.getChainRuleAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChainRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getChainRuleAccess().getInfersKeyword_2());
            		
            // InternalOML.g:3675:3: ( ( ruleReference ) )
            // InternalOML.g:3676:4: ( ruleReference )
            {
            // InternalOML.g:3676:4: ( ruleReference )
            // InternalOML.g:3677:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChainRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,114,FOLLOW_49); 

            			newLeafNode(otherlv_4, grammarAccess.getChainRuleAccess().getIfKeyword_4());
            		
            // InternalOML.g:3695:3: ( (lv_firstSegment_5_0= ruleRuleBodySegment ) )
            // InternalOML.g:3696:4: (lv_firstSegment_5_0= ruleRuleBodySegment )
            {
            // InternalOML.g:3696:4: (lv_firstSegment_5_0= ruleRuleBodySegment )
            // InternalOML.g:3697:5: lv_firstSegment_5_0= ruleRuleBodySegment
            {

            					newCompositeNode(grammarAccess.getChainRuleAccess().getFirstSegmentRuleBodySegmentParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_firstSegment_5_0=ruleRuleBodySegment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChainRuleRule());
            					}
            					set(
            						current,
            						"firstSegment",
            						lv_firstSegment_5_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.RuleBodySegment");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChainRule"


    // $ANTLR start "entryRuleRuleBodySegment"
    // InternalOML.g:3718:1: entryRuleRuleBodySegment returns [EObject current=null] : iv_ruleRuleBodySegment= ruleRuleBodySegment EOF ;
    public final EObject entryRuleRuleBodySegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleBodySegment = null;


        try {
            // InternalOML.g:3718:56: (iv_ruleRuleBodySegment= ruleRuleBodySegment EOF )
            // InternalOML.g:3719:2: iv_ruleRuleBodySegment= ruleRuleBodySegment EOF
            {
             newCompositeNode(grammarAccess.getRuleBodySegmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleBodySegment=ruleRuleBodySegment();

            state._fsp--;

             current =iv_ruleRuleBodySegment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleBodySegment"


    // $ANTLR start "ruleRuleBodySegment"
    // InternalOML.g:3725:1: ruleRuleBodySegment returns [EObject current=null] : ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? ) ;
    public final EObject ruleRuleBodySegment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_predicate_0_0 = null;

        EObject lv_nextSegment_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3731:2: ( ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? ) )
            // InternalOML.g:3732:2: ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? )
            {
            // InternalOML.g:3732:2: ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? )
            // InternalOML.g:3733:3: ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )?
            {
            // InternalOML.g:3733:3: ( (lv_predicate_0_0= ruleSegmentPredicate ) )
            // InternalOML.g:3734:4: (lv_predicate_0_0= ruleSegmentPredicate )
            {
            // InternalOML.g:3734:4: (lv_predicate_0_0= ruleSegmentPredicate )
            // InternalOML.g:3735:5: lv_predicate_0_0= ruleSegmentPredicate
            {

            					newCompositeNode(grammarAccess.getRuleBodySegmentAccess().getPredicateSegmentPredicateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_50);
            lv_predicate_0_0=ruleSegmentPredicate();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleBodySegmentRule());
            					}
            					set(
            						current,
            						"predicate",
            						lv_predicate_0_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.SegmentPredicate");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:3752:3: (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==115) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalOML.g:3753:4: otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) )
                    {
                    otherlv_1=(Token)match(input,115,FOLLOW_49); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleBodySegmentAccess().getAmpersandAmpersandKeyword_1_0());
                    			
                    // InternalOML.g:3757:4: ( (lv_nextSegment_2_0= ruleRuleBodySegment ) )
                    // InternalOML.g:3758:5: (lv_nextSegment_2_0= ruleRuleBodySegment )
                    {
                    // InternalOML.g:3758:5: (lv_nextSegment_2_0= ruleRuleBodySegment )
                    // InternalOML.g:3759:6: lv_nextSegment_2_0= ruleRuleBodySegment
                    {

                    						newCompositeNode(grammarAccess.getRuleBodySegmentAccess().getNextSegmentRuleBodySegmentParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_nextSegment_2_0=ruleRuleBodySegment();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleBodySegmentRule());
                    						}
                    						set(
                    							current,
                    							"nextSegment",
                    							lv_nextSegment_2_0,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.RuleBodySegment");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleBodySegment"


    // $ANTLR start "entryRuleSegmentPredicate"
    // InternalOML.g:3781:1: entryRuleSegmentPredicate returns [EObject current=null] : iv_ruleSegmentPredicate= ruleSegmentPredicate EOF ;
    public final EObject entryRuleSegmentPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSegmentPredicate = null;


        try {
            // InternalOML.g:3781:57: (iv_ruleSegmentPredicate= ruleSegmentPredicate EOF )
            // InternalOML.g:3782:2: iv_ruleSegmentPredicate= ruleSegmentPredicate EOF
            {
             newCompositeNode(grammarAccess.getSegmentPredicateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSegmentPredicate=ruleSegmentPredicate();

            state._fsp--;

             current =iv_ruleSegmentPredicate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSegmentPredicate"


    // $ANTLR start "ruleSegmentPredicate"
    // InternalOML.g:3788:1: ruleSegmentPredicate returns [EObject current=null] : ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) ) ;
    public final EObject ruleSegmentPredicate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;


        	enterRule();

        try {
            // InternalOML.g:3794:2: ( ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) ) )
            // InternalOML.g:3795:2: ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) )
            {
            // InternalOML.g:3795:2: ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) )
            int alt48=6;
            switch ( input.LA(1) ) {
            case RULE_ABBREV_IRI:
            case RULE_ID:
                {
                alt48=1;
                }
                break;
            case 99:
                {
                alt48=2;
                }
                break;
            case 118:
                {
                alt48=3;
                }
                break;
            case 100:
                {
                alt48=4;
                }
                break;
            case 119:
                {
                alt48=5;
                }
                break;
            case 120:
                {
                alt48=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalOML.g:3796:3: ( ( ruleQNAME ) )
                    {
                    // InternalOML.g:3796:3: ( ( ruleQNAME ) )
                    // InternalOML.g:3797:4: ( ruleQNAME )
                    {
                    // InternalOML.g:3797:4: ( ruleQNAME )
                    // InternalOML.g:3798:5: ruleQNAME
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    					}
                    				

                    					newCompositeNode(grammarAccess.getSegmentPredicateAccess().getPredicatePredicateCrossReference_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    ruleQNAME();

                    state._fsp--;


                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:3813:3: (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
                    {
                    // InternalOML.g:3813:3: (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
                    // InternalOML.g:3814:4: otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,99,FOLLOW_51); 

                    				newLeafNode(otherlv_1, grammarAccess.getSegmentPredicateAccess().getSourceKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,116,FOLLOW_21); 

                    				newLeafNode(otherlv_2, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOML.g:3822:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3823:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3823:5: ( ruleQNAME )
                    // InternalOML.g:3824:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOML.g:3844:3: (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' )
                    {
                    // InternalOML.g:3844:3: (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' )
                    // InternalOML.g:3845:4: otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,118,FOLLOW_51); 

                    				newLeafNode(otherlv_5, grammarAccess.getSegmentPredicateAccess().getInvSourceKeyword_2_0());
                    			
                    otherlv_6=(Token)match(input,116,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalOML.g:3853:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3854:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3854:5: ( ruleQNAME )
                    // InternalOML.g:3855:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_2_3());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOML.g:3875:3: (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' )
                    {
                    // InternalOML.g:3875:3: (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' )
                    // InternalOML.g:3876:4: otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,100,FOLLOW_51); 

                    				newLeafNode(otherlv_9, grammarAccess.getSegmentPredicateAccess().getTargetKeyword_3_0());
                    			
                    otherlv_10=(Token)match(input,116,FOLLOW_21); 

                    				newLeafNode(otherlv_10, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalOML.g:3884:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3885:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3885:5: ( ruleQNAME )
                    // InternalOML.g:3886:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_3_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOML.g:3906:3: (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' )
                    {
                    // InternalOML.g:3906:3: (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' )
                    // InternalOML.g:3907:4: otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')'
                    {
                    otherlv_13=(Token)match(input,119,FOLLOW_51); 

                    				newLeafNode(otherlv_13, grammarAccess.getSegmentPredicateAccess().getInvTargetKeyword_4_0());
                    			
                    otherlv_14=(Token)match(input,116,FOLLOW_21); 

                    				newLeafNode(otherlv_14, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalOML.g:3915:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3916:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3916:5: ( ruleQNAME )
                    // InternalOML.g:3917:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_16, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_3());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOML.g:3937:3: (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' )
                    {
                    // InternalOML.g:3937:3: (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' )
                    // InternalOML.g:3938:4: otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')'
                    {
                    otherlv_17=(Token)match(input,120,FOLLOW_51); 

                    				newLeafNode(otherlv_17, grammarAccess.getSegmentPredicateAccess().getInvKeyword_5_0());
                    			
                    otherlv_18=(Token)match(input,116,FOLLOW_21); 

                    				newLeafNode(otherlv_18, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalOML.g:3946:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3947:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3947:5: ( ruleQNAME )
                    // InternalOML.g:3948:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,117,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_5_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSegmentPredicate"


    // $ANTLR start "entryRuleAnonymousConceptUnionAxiom"
    // InternalOML.g:3971:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:3971:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:3972:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
            {
             newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnonymousConceptUnionAxiom=ruleAnonymousConceptUnionAxiom();

            state._fsp--;

             current =iv_ruleAnonymousConceptUnionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnonymousConceptUnionAxiom"


    // $ANTLR start "ruleAnonymousConceptUnionAxiom"
    // InternalOML.g:3978:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
    public final EObject ruleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_disjunctions_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3984:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:3985:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:3985:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:3986:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:3986:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==71) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalOML.g:3987:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3987:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3988:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_53);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_1=(Token)match(input,121,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:4013:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:4014:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:4014:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:4015:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_52); 

            					newLeafNode(lv_name_3_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnonymousConceptUnionAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,117,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,73,FOLLOW_54); 

            			newLeafNode(otherlv_5, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:4039:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==71||LA50_0==121||LA50_0==123) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalOML.g:4040:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:4040:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:4041:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_disjunctions_6_0=ruleDisjointUnionOfConceptsAxiom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"disjunctions",
            	    						lv_disjunctions_6_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_7=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnonymousConceptUnionAxiom"


    // $ANTLR start "entryRuleRootConceptTaxonomyAxiom"
    // InternalOML.g:4066:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:4066:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:4067:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
            {
             newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRootConceptTaxonomyAxiom=ruleRootConceptTaxonomyAxiom();

            state._fsp--;

             current =iv_ruleRootConceptTaxonomyAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRootConceptTaxonomyAxiom"


    // $ANTLR start "ruleRootConceptTaxonomyAxiom"
    // InternalOML.g:4073:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
    public final EObject ruleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_disjunctions_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4079:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:4080:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:4080:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:4081:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:4081:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==71) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalOML.g:4082:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4082:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4083:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_55);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_1=(Token)match(input,122,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:4108:3: ( ( ruleReference ) )
            // InternalOML.g:4109:4: ( ruleReference )
            {
            // InternalOML.g:4109:4: ( ruleReference )
            // InternalOML.g:4110:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,117,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,73,FOLLOW_54); 

            			newLeafNode(otherlv_5, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:4132:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==71||LA52_0==121||LA52_0==123) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalOML.g:4133:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:4133:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:4134:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_disjunctions_6_0=ruleDisjointUnionOfConceptsAxiom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"disjunctions",
            	    						lv_disjunctions_6_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_7=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRootConceptTaxonomyAxiom"


    // $ANTLR start "entryRuleSpecificDisjointConceptAxiom"
    // InternalOML.g:4159:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:4159:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:4160:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
            {
             newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecificDisjointConceptAxiom=ruleSpecificDisjointConceptAxiom();

            state._fsp--;

             current =iv_ruleSpecificDisjointConceptAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificDisjointConceptAxiom"


    // $ANTLR start "ruleSpecificDisjointConceptAxiom"
    // InternalOML.g:4166:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4172:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) )
            // InternalOML.g:4173:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
            {
            // InternalOML.g:4173:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
            // InternalOML.g:4174:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')'
            {
            // InternalOML.g:4174:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==71) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalOML.g:4175:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4175:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4176:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_56);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSpecificDisjointConceptAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_1=(Token)match(input,123,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:4201:3: ( ( ruleQNAME ) )
            // InternalOML.g:4202:4: ( ruleQNAME )
            {
            // InternalOML.g:4202:4: ( ruleQNAME )
            // InternalOML.g:4203:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_52);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,117,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificDisjointConceptAxiom"


    // $ANTLR start "entryRuleEntityExistentialRestrictionAxiom"
    // InternalOML.g:4225:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:4225:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:4226:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityExistentialRestrictionAxiom=ruleEntityExistentialRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityExistentialRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityExistentialRestrictionAxiom"


    // $ANTLR start "ruleEntityExistentialRestrictionAxiom"
    // InternalOML.g:4232:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4238:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) )
            // InternalOML.g:4239:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            {
            // InternalOML.g:4239:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            // InternalOML.g:4240:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) )
            {
            // InternalOML.g:4240:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==71) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalOML.g:4241:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4241:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4242:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_57);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            otherlv_1=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1());
            		
            // InternalOML.g:4263:3: ( ( ruleQNAME ) )
            // InternalOML.g:4264:4: ( ruleQNAME )
            {
            // InternalOML.g:4264:4: ( ruleQNAME )
            // InternalOML.g:4265:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4283:3: ( ( ruleQNAME ) )
            // InternalOML.g:4284:4: ( ruleQNAME )
            {
            // InternalOML.g:4284:4: ( ruleQNAME )
            // InternalOML.g:4285:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_59);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4303:3: ( ( ruleQNAME ) )
            // InternalOML.g:4304:4: ( ruleQNAME )
            {
            // InternalOML.g:4304:4: ( ruleQNAME )
            // InternalOML.g:4305:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityExistentialRestrictionAxiom"


    // $ANTLR start "entryRuleEntityUniversalRestrictionAxiom"
    // InternalOML.g:4323:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:4323:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:4324:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityUniversalRestrictionAxiom=ruleEntityUniversalRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityUniversalRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityUniversalRestrictionAxiom"


    // $ANTLR start "ruleEntityUniversalRestrictionAxiom"
    // InternalOML.g:4330:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4336:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) )
            // InternalOML.g:4337:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            {
            // InternalOML.g:4337:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            // InternalOML.g:4338:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) )
            {
            // InternalOML.g:4338:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==71) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalOML.g:4339:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4339:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4340:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_60);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_1=(Token)match(input,127,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1());
            		
            // InternalOML.g:4361:3: ( ( ruleQNAME ) )
            // InternalOML.g:4362:4: ( ruleQNAME )
            {
            // InternalOML.g:4362:4: ( ruleQNAME )
            // InternalOML.g:4363:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4381:3: ( ( ruleQNAME ) )
            // InternalOML.g:4382:4: ( ruleQNAME )
            {
            // InternalOML.g:4382:4: ( ruleQNAME )
            // InternalOML.g:4383:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_59);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4401:3: ( ( ruleQNAME ) )
            // InternalOML.g:4402:4: ( ruleQNAME )
            {
            // InternalOML.g:4402:4: ( ruleQNAME )
            // InternalOML.g:4403:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityUniversalRestrictionAxiom"


    // $ANTLR start "entryRuleAspectSpecializationAxiom"
    // InternalOML.g:4421:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:4421:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:4422:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getAspectSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAspectSpecializationAxiom=ruleAspectSpecializationAxiom();

            state._fsp--;

             current =iv_ruleAspectSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAspectSpecializationAxiom"


    // $ANTLR start "ruleAspectSpecializationAxiom"
    // InternalOML.g:4428:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4434:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:4435:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4435:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:4436:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:4436:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==71) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalOML.g:4437:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4437:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4438:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAspectSpecializationAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // InternalOML.g:4455:3: ( ( ruleReference ) )
            // InternalOML.g:4456:4: ( ruleReference )
            {
            // InternalOML.g:4456:4: ( ruleReference )
            // InternalOML.g:4457:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_61);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,128,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2());
            		
            // InternalOML.g:4475:3: ( ( ruleReference ) )
            // InternalOML.g:4476:4: ( ruleReference )
            {
            // InternalOML.g:4476:4: ( ruleReference )
            // InternalOML.g:4477:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAspectSpecializationAxiom"


    // $ANTLR start "entryRuleConceptSpecializationAxiom"
    // InternalOML.g:4495:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:4495:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:4496:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getConceptSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptSpecializationAxiom=ruleConceptSpecializationAxiom();

            state._fsp--;

             current =iv_ruleConceptSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptSpecializationAxiom"


    // $ANTLR start "ruleConceptSpecializationAxiom"
    // InternalOML.g:4502:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4508:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:4509:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4509:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:4510:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:4510:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==71) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalOML.g:4511:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4511:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4512:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConceptSpecializationAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalOML.g:4529:3: ( ( ruleReference ) )
            // InternalOML.g:4530:4: ( ruleReference )
            {
            // InternalOML.g:4530:4: ( ruleReference )
            // InternalOML.g:4531:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0());
            				
            pushFollow(FOLLOW_62);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,129,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2());
            		
            // InternalOML.g:4549:3: ( ( ruleReference ) )
            // InternalOML.g:4550:4: ( ruleReference )
            {
            // InternalOML.g:4550:4: ( ruleReference )
            // InternalOML.g:4551:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptSpecializationAxiom"


    // $ANTLR start "entryRuleReifiedRelationshipSpecializationAxiom"
    // InternalOML.g:4569:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:4569:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:4570:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipSpecializationAxiom=ruleReifiedRelationshipSpecializationAxiom();

            state._fsp--;

             current =iv_ruleReifiedRelationshipSpecializationAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipSpecializationAxiom"


    // $ANTLR start "ruleReifiedRelationshipSpecializationAxiom"
    // InternalOML.g:4576:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4582:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:4583:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4583:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:4584:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:4584:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==71) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalOML.g:4585:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4585:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4586:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            // InternalOML.g:4603:3: ( ( ruleReference ) )
            // InternalOML.g:4604:4: ( ruleReference )
            {
            // InternalOML.g:4604:4: ( ruleReference )
            // InternalOML.g:4605:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipConceptualRelationshipCrossReference_1_0());
            				
            pushFollow(FOLLOW_63);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,130,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2());
            		
            // InternalOML.g:4623:3: ( ( ruleReference ) )
            // InternalOML.g:4624:4: ( ruleReference )
            {
            // InternalOML.g:4624:4: ( ruleReference )
            // InternalOML.g:4625:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipConceptualRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipSpecializationAxiom"


    // $ANTLR start "entryRuleSubObjectPropertyOfAxiom"
    // InternalOML.g:4643:1: entryRuleSubObjectPropertyOfAxiom returns [EObject current=null] : iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF ;
    public final EObject entryRuleSubObjectPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubObjectPropertyOfAxiom = null;


        try {
            // InternalOML.g:4643:65: (iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF )
            // InternalOML.g:4644:2: iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF
            {
             newCompositeNode(grammarAccess.getSubObjectPropertyOfAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubObjectPropertyOfAxiom=ruleSubObjectPropertyOfAxiom();

            state._fsp--;

             current =iv_ruleSubObjectPropertyOfAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubObjectPropertyOfAxiom"


    // $ANTLR start "ruleSubObjectPropertyOfAxiom"
    // InternalOML.g:4650:1: ruleSubObjectPropertyOfAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) ) ;
    public final EObject ruleSubObjectPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4656:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) ) )
            // InternalOML.g:4657:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4657:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) )
            // InternalOML.g:4658:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) )
            {
            // InternalOML.g:4658:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==71) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalOML.g:4659:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4659:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4660:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSubObjectPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubObjectPropertyOfAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            // InternalOML.g:4677:3: ( ( ruleReference ) )
            // InternalOML.g:4678:4: ( ruleReference )
            {
            // InternalOML.g:4678:4: ( ruleReference )
            // InternalOML.g:4679:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubObjectPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipCrossReference_1_0());
            				
            pushFollow(FOLLOW_64);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,131,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubObjectPropertyOfKeyword_2());
            		
            // InternalOML.g:4697:3: ( ( ruleReference ) )
            // InternalOML.g:4698:4: ( ruleReference )
            {
            // InternalOML.g:4698:4: ( ruleReference )
            // InternalOML.g:4699:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubObjectPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSuperPropertyUnreifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubObjectPropertyOfAxiom"


    // $ANTLR start "entryRuleSubDataPropertyOfAxiom"
    // InternalOML.g:4717:1: entryRuleSubDataPropertyOfAxiom returns [EObject current=null] : iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF ;
    public final EObject entryRuleSubDataPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubDataPropertyOfAxiom = null;


        try {
            // InternalOML.g:4717:63: (iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF )
            // InternalOML.g:4718:2: iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF
            {
             newCompositeNode(grammarAccess.getSubDataPropertyOfAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubDataPropertyOfAxiom=ruleSubDataPropertyOfAxiom();

            state._fsp--;

             current =iv_ruleSubDataPropertyOfAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubDataPropertyOfAxiom"


    // $ANTLR start "ruleSubDataPropertyOfAxiom"
    // InternalOML.g:4724:1: ruleSubDataPropertyOfAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) ) ;
    public final EObject ruleSubDataPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4730:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) ) )
            // InternalOML.g:4731:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4731:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) )
            // InternalOML.g:4732:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) )
            {
            // InternalOML.g:4732:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==71) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalOML.g:4733:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4733:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4734:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSubDataPropertyOfAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSubDataPropertyOfAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // InternalOML.g:4751:3: ( ( ruleReference ) )
            // InternalOML.g:4752:4: ( ruleReference )
            {
            // InternalOML.g:4752:4: ( ruleReference )
            // InternalOML.g:4753:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubDataPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyCrossReference_1_0());
            				
            pushFollow(FOLLOW_65);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,132,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSubDataPropertyOfAxiomAccess().getSubDataPropertyOfKeyword_2());
            		
            // InternalOML.g:4771:3: ( ( ruleReference ) )
            // InternalOML.g:4772:4: ( ruleReference )
            {
            // InternalOML.g:4772:4: ( ruleReference )
            // InternalOML.g:4773:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubDataPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubDataPropertyOfAxiomAccess().getSuperPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubDataPropertyOfAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom"
    // InternalOML.g:4791:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:4791:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:4792:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom=ruleEntityScalarDataPropertyExistentialRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyExistentialRestrictionAxiom"
    // InternalOML.g:4798:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4804:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:4805:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4805:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:4806:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:4806:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==71) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalOML.g:4807:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4807:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4808:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_66);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_1=(Token)match(input,133,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1());
            		
            // InternalOML.g:4829:3: ( ( ruleReference ) )
            // InternalOML.g:4830:4: ( ruleReference )
            {
            // InternalOML.g:4830:4: ( ruleReference )
            // InternalOML.g:4831:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4849:3: ( ( ruleReference ) )
            // InternalOML.g:4850:4: ( ruleReference )
            {
            // InternalOML.g:4850:4: ( ruleReference )
            // InternalOML.g:4851:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_59);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4869:3: ( ( ruleReference ) )
            // InternalOML.g:4870:4: ( ruleReference )
            {
            // InternalOML.g:4870:4: ( ruleReference )
            // InternalOML.g:4871:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyExistentialRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyParticularRestrictionAxiom"
    // InternalOML.g:4889:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:4889:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:4890:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom=ruleEntityScalarDataPropertyParticularRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyParticularRestrictionAxiom"
    // InternalOML.g:4896:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_literalValue_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4902:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:4903:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:4903:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:4904:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:4904:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==71) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalOML.g:4905:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4905:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4906:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_67);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_1=(Token)match(input,134,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:4927:3: ( ( ruleReference ) )
            // InternalOML.g:4928:4: ( ruleReference )
            {
            // InternalOML.g:4928:4: ( ruleReference )
            // InternalOML.g:4929:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4947:3: ( ( ruleReference ) )
            // InternalOML.g:4948:4: ( ruleReference )
            {
            // InternalOML.g:4948:4: ( ruleReference )
            // InternalOML.g:4949:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:4967:3: ( (lv_literalValue_6_0= ruleLiteralValue ) )
            // InternalOML.g:4968:4: (lv_literalValue_6_0= ruleLiteralValue )
            {
            // InternalOML.g:4968:4: (lv_literalValue_6_0= ruleLiteralValue )
            // InternalOML.g:4969:5: lv_literalValue_6_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_69);
            lv_literalValue_6_0=ruleLiteralValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            					set(
            						current,
            						"literalValue",
            						lv_literalValue_6_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:4986:3: (otherlv_7= '^^' ( ( ruleReference ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==135) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalOML.g:4987:4: otherlv_7= '^^' ( ( ruleReference ) )
                    {
                    otherlv_7=(Token)match(input,135,FOLLOW_21); 

                    				newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_7_0());
                    			
                    // InternalOML.g:4991:4: ( ( ruleReference ) )
                    // InternalOML.g:4992:5: ( ruleReference )
                    {
                    // InternalOML.g:4992:5: ( ruleReference )
                    // InternalOML.g:4993:6: ruleReference
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getValueTypeDataRangeCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom"
    // InternalOML.g:5012:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:5012:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:5013:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom=ruleEntityScalarDataPropertyUniversalRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom"


    // $ANTLR start "ruleEntityScalarDataPropertyUniversalRestrictionAxiom"
    // InternalOML.g:5019:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5025:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:5026:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:5026:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:5027:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:5027:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==71) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalOML.g:5028:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5028:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5029:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_70);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

            otherlv_1=(Token)match(input,136,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1());
            		
            // InternalOML.g:5050:3: ( ( ruleReference ) )
            // InternalOML.g:5051:4: ( ruleReference )
            {
            // InternalOML.g:5051:4: ( ruleReference )
            // InternalOML.g:5052:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:5070:3: ( ( ruleReference ) )
            // InternalOML.g:5071:4: ( ruleReference )
            {
            // InternalOML.g:5071:4: ( ruleReference )
            // InternalOML.g:5072:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_59);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:5090:3: ( ( ruleReference ) )
            // InternalOML.g:5091:4: ( ruleReference )
            {
            // InternalOML.g:5091:4: ( ruleReference )
            // InternalOML.g:5092:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityScalarDataPropertyUniversalRestrictionAxiom"


    // $ANTLR start "entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom"
    // InternalOML.g:5110:1: entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:5110:95: (iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:5111:2: iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF
            {
             newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom=ruleEntityStructuredDataPropertyParticularRestrictionAxiom();

            state._fsp--;

             current =iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "ruleEntityStructuredDataPropertyParticularRestrictionAxiom"
    // InternalOML.g:5117:1: ruleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_structuredDataPropertyRestrictions_7_0 = null;

        EObject lv_scalarDataPropertyRestrictions_8_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5123:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) )
            // InternalOML.g:5124:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            {
            // InternalOML.g:5124:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            // InternalOML.g:5125:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}'
            {
            // InternalOML.g:5125:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==71) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalOML.g:5126:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5126:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5127:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_67);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            otherlv_1=(Token)match(input,134,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:5148:3: ( ( ruleReference ) )
            // InternalOML.g:5149:4: ( ruleReference )
            {
            // InternalOML.g:5149:4: ( ruleReference )
            // InternalOML.g:5150:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:5168:3: ( ( ruleReference ) )
            // InternalOML.g:5169:4: ( ruleReference )
            {
            // InternalOML.g:5169:4: ( ruleReference )
            // InternalOML.g:5170:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,70,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
            		
            otherlv_6=(Token)match(input,73,FOLLOW_71); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalOML.g:5192:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop66:
            do {
                int alt66=3;
                alt66 = dfa66.predict(input);
                switch (alt66) {
            	case 1 :
            	    // InternalOML.g:5193:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5193:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5194:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5194:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:5195:6: lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_structuredDataPropertyRestrictions_7_0=ruleRestrictionStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredDataPropertyRestrictions",
            	    							lv_structuredDataPropertyRestrictions_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5213:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5213:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:5214:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5214:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:5215:6: lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_scalarDataPropertyRestrictions_8_0=ruleRestrictionScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyRestrictions",
            	    							lv_scalarDataPropertyRestrictions_8_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            otherlv_9=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityStructuredDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "entryRuleRestrictionStructuredDataPropertyTuple"
    // InternalOML.g:5241:1: entryRuleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:5241:79: (iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF )
            // InternalOML.g:5242:2: iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF
            {
             newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRestrictionStructuredDataPropertyTuple=ruleRestrictionStructuredDataPropertyTuple();

            state._fsp--;

             current =iv_ruleRestrictionStructuredDataPropertyTuple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestrictionStructuredDataPropertyTuple"


    // $ANTLR start "ruleRestrictionStructuredDataPropertyTuple"
    // InternalOML.g:5248:1: ruleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_structuredDataPropertyRestrictions_4_0 = null;

        EObject lv_scalarDataPropertyRestrictions_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5254:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:5255:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:5255:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:5256:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:5256:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==71) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalOML.g:5257:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5257:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5258:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            // InternalOML.g:5275:3: ( ( ruleReference ) )
            // InternalOML.g:5276:4: ( ruleReference )
            {
            // InternalOML.g:5276:4: ( ruleReference )
            // InternalOML.g:5277:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_1_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,73,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5299:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop68:
            do {
                int alt68=3;
                alt68 = dfa68.predict(input);
                switch (alt68) {
            	case 1 :
            	    // InternalOML.g:5300:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5300:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5301:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5301:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:5302:6: lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_structuredDataPropertyRestrictions_4_0=ruleRestrictionStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredDataPropertyRestrictions",
            	    							lv_structuredDataPropertyRestrictions_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5320:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5320:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:5321:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5321:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:5322:6: lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_scalarDataPropertyRestrictions_5_0=ruleRestrictionScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyRestrictions",
            	    							lv_scalarDataPropertyRestrictions_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestrictionStructuredDataPropertyTuple"


    // $ANTLR start "entryRuleRestrictionScalarDataPropertyValue"
    // InternalOML.g:5348:1: entryRuleRestrictionScalarDataPropertyValue returns [EObject current=null] : iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF ;
    public final EObject entryRuleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5348:75: (iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF )
            // InternalOML.g:5349:2: iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRestrictionScalarDataPropertyValue=ruleRestrictionScalarDataPropertyValue();

            state._fsp--;

             current =iv_ruleRestrictionScalarDataPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestrictionScalarDataPropertyValue"


    // $ANTLR start "ruleRestrictionScalarDataPropertyValue"
    // InternalOML.g:5355:1: ruleRestrictionScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5361:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:5362:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:5362:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:5363:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:5363:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==71) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalOML.g:5364:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5364:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5365:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRestrictionScalarDataPropertyValueRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            // InternalOML.g:5382:3: ( ( ruleReference ) )
            // InternalOML.g:5383:4: ( ruleReference )
            {
            // InternalOML.g:5383:4: ( ruleReference )
            // InternalOML.g:5384:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRestrictionScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_1_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:5402:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:5403:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:5403:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:5404:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_69);
            lv_scalarPropertyValue_3_0=ruleLiteralValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRestrictionScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:5421:3: (otherlv_4= '^^' ( ( ruleReference ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==135) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalOML.g:5422:4: otherlv_4= '^^' ( ( ruleReference ) )
                    {
                    otherlv_4=(Token)match(input,135,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
                    			
                    // InternalOML.g:5426:4: ( ( ruleReference ) )
                    // InternalOML.g:5427:5: ( ruleReference )
                    {
                    // InternalOML.g:5427:5: ( ruleReference )
                    // InternalOML.g:5428:6: ruleReference
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRestrictionScalarDataPropertyValueRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestrictionScalarDataPropertyValue"


    // $ANTLR start "entryRuleBinaryScalarRestriction"
    // InternalOML.g:5447:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:5447:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:5448:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getBinaryScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryScalarRestriction=ruleBinaryScalarRestriction();

            state._fsp--;

             current =iv_ruleBinaryScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryScalarRestriction"


    // $ANTLR start "ruleBinaryScalarRestriction"
    // InternalOML.g:5454:1: ruleBinaryScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) ;
    public final EObject ruleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_length_6_0 = null;

        AntlrDatatypeRuleToken lv_minLength_8_0 = null;

        AntlrDatatypeRuleToken lv_maxLength_10_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5460:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) )
            // InternalOML.g:5461:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            {
            // InternalOML.g:5461:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            // InternalOML.g:5462:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}'
            {
            // InternalOML.g:5462:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==71) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalOML.g:5463:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5463:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5464:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_72);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_1=(Token)match(input,137,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5485:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5486:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5486:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5487:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_73); 

            			newLeafNode(otherlv_3, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5507:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5508:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5508:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) )
            // InternalOML.g:5509:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5512:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* )
            // InternalOML.g:5513:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )*
            {
            // InternalOML.g:5513:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )*
            loop72:
            do {
                int alt72=4;
                int LA72_0 = input.LA(1);

                if ( LA72_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt72=1;
                }
                else if ( LA72_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt72=2;
                }
                else if ( LA72_0 == 140 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt72=3;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalOML.g:5514:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5514:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5515:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5515:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5516:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5519:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5519:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5519:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5519:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,138,FOLLOW_74); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5523:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5524:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5524:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5525:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_73);
            	    lv_length_6_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5548:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5548:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5549:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5549:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5550:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5553:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5553:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5553:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5553:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,139,FOLLOW_74); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5557:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5558:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5558:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5559:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_73);
            	    lv_minLength_8_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:5582:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5582:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5583:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5583:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5584:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5587:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5587:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5587:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5587:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,140,FOLLOW_74); 

            	    									newLeafNode(otherlv_9, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5591:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5592:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5592:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5593:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_73);
            	    lv_maxLength_10_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_11=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_11, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5627:3: ( ( ruleReference ) )
            // InternalOML.g:5628:4: ( ruleReference )
            {
            // InternalOML.g:5628:4: ( ruleReference )
            // InternalOML.g:5629:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryScalarRestriction"


    // $ANTLR start "entryRuleIRIScalarRestriction"
    // InternalOML.g:5651:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:5651:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:5652:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getIRIScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIRIScalarRestriction=ruleIRIScalarRestriction();

            state._fsp--;

             current =iv_ruleIRIScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIRIScalarRestriction"


    // $ANTLR start "ruleIRIScalarRestriction"
    // InternalOML.g:5658:1: ruleIRIScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_pattern_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_length_6_0 = null;

        AntlrDatatypeRuleToken lv_minLength_8_0 = null;

        AntlrDatatypeRuleToken lv_maxLength_10_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5664:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5665:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5665:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5666:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5666:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==71) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalOML.g:5667:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5667:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5668:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_75);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            otherlv_1=(Token)match(input,142,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5689:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5690:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5690:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5691:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5711:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5712:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5712:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            // InternalOML.g:5713:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5716:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            // InternalOML.g:5717:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            {
            // InternalOML.g:5717:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            loop74:
            do {
                int alt74=5;
                int LA74_0 = input.LA(1);

                if ( LA74_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt74=1;
                }
                else if ( LA74_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt74=2;
                }
                else if ( LA74_0 == 140 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt74=3;
                }
                else if ( LA74_0 == 143 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt74=4;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalOML.g:5718:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5718:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5719:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5719:117: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5720:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5723:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5723:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5723:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5723:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,138,FOLLOW_74); 

            	    									newLeafNode(otherlv_5, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5727:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5728:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5728:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5729:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_length_6_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5752:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5752:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5753:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5753:117: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5754:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5757:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5757:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5757:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5757:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,139,FOLLOW_74); 

            	    									newLeafNode(otherlv_7, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5761:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5762:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5762:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5763:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_minLength_8_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:5786:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5786:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5787:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5787:117: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5788:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5791:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5791:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5791:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5791:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,140,FOLLOW_74); 

            	    									newLeafNode(otherlv_9, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5795:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5796:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5796:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5797:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_maxLength_10_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:5820:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5820:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:5821:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5821:117: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:5822:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5825:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:5825:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5825:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:5825:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,143,FOLLOW_77); 

            	    									newLeafNode(otherlv_11, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5829:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:5830:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:5830:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:5831:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_76); 

            	    											newLeafNode(lv_pattern_12_0, grammarAccess.getIRIScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5864:3: ( ( ruleReference ) )
            // InternalOML.g:5865:4: ( ruleReference )
            {
            // InternalOML.g:5865:4: ( ruleReference )
            // InternalOML.g:5866:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIRIScalarRestriction"


    // $ANTLR start "entryRuleNumericScalarRestriction"
    // InternalOML.g:5888:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:5888:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:5889:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getNumericScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericScalarRestriction=ruleNumericScalarRestriction();

            state._fsp--;

             current =iv_ruleNumericScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericScalarRestriction"


    // $ANTLR start "ruleNumericScalarRestriction"
    // InternalOML.g:5895:1: ruleNumericScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_minInclusive_6_0 = null;

        EObject lv_maxInclusive_8_0 = null;

        EObject lv_minExclusive_10_0 = null;

        EObject lv_maxExclusive_12_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5901:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5902:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5902:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5903:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5903:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==71) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalOML.g:5904:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5904:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5905:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_78);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            otherlv_1=(Token)match(input,144,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5926:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5927:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5927:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5928:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_79); 

            			newLeafNode(otherlv_3, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5948:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5949:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5949:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            // InternalOML.g:5950:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5953:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            // InternalOML.g:5954:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            {
            // InternalOML.g:5954:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            loop76:
            do {
                int alt76=5;
                int LA76_0 = input.LA(1);

                if ( LA76_0 == 145 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt76=1;
                }
                else if ( LA76_0 == 146 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt76=2;
                }
                else if ( LA76_0 == 147 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt76=3;
                }
                else if ( LA76_0 == 148 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt76=4;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalOML.g:5955:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5955:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5956:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5956:121: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5957:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5960:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5960:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5960:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5960:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_5=(Token)match(input,145,FOLLOW_68); 

            	    									newLeafNode(otherlv_5, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5964:9: ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5965:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5965:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    // InternalOML.g:5966:11: lv_minInclusive_6_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_minInclusive_6_0=ruleLiteralNumber();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minInclusive",
            	    												lv_minInclusive_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5989:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5989:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5990:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5990:121: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5991:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5994:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5994:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5994:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5994:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_7=(Token)match(input,146,FOLLOW_68); 

            	    									newLeafNode(otherlv_7, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5998:9: ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5999:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5999:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    // InternalOML.g:6000:11: lv_maxInclusive_8_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_maxInclusive_8_0=ruleLiteralNumber();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxInclusive",
            	    												lv_maxInclusive_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:6023:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6023:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:6024:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6024:121: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:6025:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6028:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:6028:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6028:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:6028:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_9=(Token)match(input,147,FOLLOW_68); 

            	    									newLeafNode(otherlv_9, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6032:9: ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    // InternalOML.g:6033:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:6033:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    // InternalOML.g:6034:11: lv_minExclusive_10_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_minExclusive_10_0=ruleLiteralNumber();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minExclusive",
            	    												lv_minExclusive_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:6057:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6057:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:6058:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6058:121: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:6059:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6062:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:6062:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6062:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:6062:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_11=(Token)match(input,148,FOLLOW_68); 

            	    									newLeafNode(otherlv_11, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6066:9: ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    // InternalOML.g:6067:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:6067:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    // InternalOML.g:6068:11: lv_maxExclusive_12_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_maxExclusive_12_0=ruleLiteralNumber();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxExclusive",
            	    												lv_maxExclusive_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralNumber");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6102:3: ( ( ruleReference ) )
            // InternalOML.g:6103:4: ( ruleReference )
            {
            // InternalOML.g:6103:4: ( ruleReference )
            // InternalOML.g:6104:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericScalarRestriction"


    // $ANTLR start "entryRulePlainLiteralScalarRestriction"
    // InternalOML.g:6126:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:6126:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:6127:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlainLiteralScalarRestriction=rulePlainLiteralScalarRestriction();

            state._fsp--;

             current =iv_rulePlainLiteralScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlainLiteralScalarRestriction"


    // $ANTLR start "rulePlainLiteralScalarRestriction"
    // InternalOML.g:6133:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) ;
    public final EObject rulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_pattern_12_0=null;
        Token otherlv_13=null;
        Token lv_langRange_14_0=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_length_6_0 = null;

        AntlrDatatypeRuleToken lv_minLength_8_0 = null;

        AntlrDatatypeRuleToken lv_maxLength_10_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6139:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) )
            // InternalOML.g:6140:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            {
            // InternalOML.g:6140:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            // InternalOML.g:6141:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}'
            {
            // InternalOML.g:6141:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==71) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOML.g:6142:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6142:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6143:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_80);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            otherlv_1=(Token)match(input,149,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6164:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6165:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6165:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6166:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_81); 

            			newLeafNode(otherlv_3, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6186:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6187:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6187:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) )
            // InternalOML.g:6188:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6191:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* )
            // InternalOML.g:6192:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )*
            {
            // InternalOML.g:6192:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )*
            loop78:
            do {
                int alt78=6;
                int LA78_0 = input.LA(1);

                if ( LA78_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt78=1;
                }
                else if ( LA78_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt78=2;
                }
                else if ( LA78_0 == 140 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt78=3;
                }
                else if ( LA78_0 == 143 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt78=4;
                }
                else if ( LA78_0 == 150 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
                    alt78=5;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalOML.g:6193:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6193:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6194:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6194:126: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6195:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6198:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6198:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6198:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6198:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,138,FOLLOW_74); 

            	    									newLeafNode(otherlv_5, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6202:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6203:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6203:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6204:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_81);
            	    lv_length_6_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:6227:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6227:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6228:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6228:126: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6229:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6232:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6232:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6232:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6232:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,139,FOLLOW_74); 

            	    									newLeafNode(otherlv_7, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6236:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6237:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6237:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6238:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_81);
            	    lv_minLength_8_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:6261:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6261:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6262:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6262:126: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6263:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6266:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6266:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6266:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6266:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,140,FOLLOW_74); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6270:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6271:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6271:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6272:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_81);
            	    lv_maxLength_10_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:6295:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6295:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:6296:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6296:126: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:6297:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6300:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:6300:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6300:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:6300:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,143,FOLLOW_77); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6304:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:6305:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:6305:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:6306:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_81); 

            	    											newLeafNode(lv_pattern_12_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:6328:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6328:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) )
            	    // InternalOML.g:6329:5: {...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:6329:126: ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) )
            	    // InternalOML.g:6330:6: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:6333:9: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) )
            	    // InternalOML.g:6333:10: {...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6333:19: (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) )
            	    // InternalOML.g:6333:20: otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) )
            	    {
            	    otherlv_13=(Token)match(input,150,FOLLOW_82); 

            	    									newLeafNode(otherlv_13, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0());
            	    								
            	    // InternalOML.g:6337:9: ( (lv_langRange_14_0= RULE_LANG_TAG ) )
            	    // InternalOML.g:6338:10: (lv_langRange_14_0= RULE_LANG_TAG )
            	    {
            	    // InternalOML.g:6338:10: (lv_langRange_14_0= RULE_LANG_TAG )
            	    // InternalOML.g:6339:11: lv_langRange_14_0= RULE_LANG_TAG
            	    {
            	    lv_langRange_14_0=(Token)match(input,RULE_LANG_TAG,FOLLOW_81); 

            	    											newLeafNode(lv_langRange_14_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeLANG_TAGTerminalRuleCall_4_4_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"langRange",
            	    												lv_langRange_14_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LANG_TAG");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_15=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6372:3: ( ( ruleReference ) )
            // InternalOML.g:6373:4: ( ruleReference )
            {
            // InternalOML.g:6373:4: ( ruleReference )
            // InternalOML.g:6374:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlainLiteralScalarRestriction"


    // $ANTLR start "entryRuleScalarOneOfRestriction"
    // InternalOML.g:6396:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:6396:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:6397:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
            {
             newCompositeNode(grammarAccess.getScalarOneOfRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarOneOfRestriction=ruleScalarOneOfRestriction();

            state._fsp--;

             current =iv_ruleScalarOneOfRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarOneOfRestriction"


    // $ANTLR start "ruleScalarOneOfRestriction"
    // InternalOML.g:6403:1: ruleScalarOneOfRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6409:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:6410:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:6410:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:6411:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:6411:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==71) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalOML.g:6412:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6412:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6413:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_83);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScalarOneOfRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            otherlv_1=(Token)match(input,151,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1());
            		
            // InternalOML.g:6434:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6435:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6435:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6436:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_84); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:6460:3: ( ( ruleReference ) )
            // InternalOML.g:6461:4: ( ruleReference )
            {
            // InternalOML.g:6461:4: ( ruleReference )
            // InternalOML.g:6462:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarOneOfRestriction"


    // $ANTLR start "entryRuleScalarOneOfLiteralAxiom"
    // InternalOML.g:6484:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:6484:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:6485:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
            {
             newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarOneOfLiteralAxiom=ruleScalarOneOfLiteralAxiom();

            state._fsp--;

             current =iv_ruleScalarOneOfLiteralAxiom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarOneOfLiteralAxiom"


    // $ANTLR start "ruleScalarOneOfLiteralAxiom"
    // InternalOML.g:6491:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6497:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:6498:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:6498:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:6499:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:6499:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==71) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalOML.g:6500:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6500:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6501:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_85);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScalarOneOfLiteralAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);

            otherlv_1=(Token)match(input,152,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1());
            		
            // InternalOML.g:6522:3: ( ( ruleReference ) )
            // InternalOML.g:6523:4: ( ruleReference )
            {
            // InternalOML.g:6523:4: ( ruleReference )
            // InternalOML.g:6524:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:6542:3: ( (lv_value_4_0= ruleLiteralValue ) )
            // InternalOML.g:6543:4: (lv_value_4_0= ruleLiteralValue )
            {
            // InternalOML.g:6543:4: (lv_value_4_0= ruleLiteralValue )
            // InternalOML.g:6544:5: lv_value_4_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_69);
            lv_value_4_0=ruleLiteralValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScalarOneOfLiteralAxiomRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:6561:3: (otherlv_5= '^^' ( ( ruleReference ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==135) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalOML.g:6562:4: otherlv_5= '^^' ( ( ruleReference ) )
                    {
                    otherlv_5=(Token)match(input,135,FOLLOW_21); 

                    				newLeafNode(otherlv_5, grammarAccess.getScalarOneOfLiteralAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_5_0());
                    			
                    // InternalOML.g:6566:4: ( ( ruleReference ) )
                    // InternalOML.g:6567:5: ( ruleReference )
                    {
                    // InternalOML.g:6567:5: ( ruleReference )
                    // InternalOML.g:6568:6: ruleReference
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueTypeDataRangeCrossReference_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarOneOfLiteralAxiom"


    // $ANTLR start "entryRuleStringScalarRestriction"
    // InternalOML.g:6587:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:6587:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:6588:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getStringScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringScalarRestriction=ruleStringScalarRestriction();

            state._fsp--;

             current =iv_ruleStringScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringScalarRestriction"


    // $ANTLR start "ruleStringScalarRestriction"
    // InternalOML.g:6594:1: ruleStringScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_pattern_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        AntlrDatatypeRuleToken lv_length_6_0 = null;

        AntlrDatatypeRuleToken lv_minLength_8_0 = null;

        AntlrDatatypeRuleToken lv_maxLength_10_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6600:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:6601:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:6601:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:6602:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:6602:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==71) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalOML.g:6603:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6603:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6604:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_86);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

            otherlv_1=(Token)match(input,153,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6625:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6626:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6626:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6627:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6647:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6648:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6648:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            // InternalOML.g:6649:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6652:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            // InternalOML.g:6653:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            {
            // InternalOML.g:6653:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            loop83:
            do {
                int alt83=5;
                int LA83_0 = input.LA(1);

                if ( LA83_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt83=1;
                }
                else if ( LA83_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt83=2;
                }
                else if ( LA83_0 == 140 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt83=3;
                }
                else if ( LA83_0 == 143 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt83=4;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalOML.g:6654:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6654:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6655:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6655:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6656:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6659:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6659:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6659:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6659:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,138,FOLLOW_74); 

            	    									newLeafNode(otherlv_5, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6663:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6664:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6664:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6665:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_length_6_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:6688:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6688:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6689:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6689:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6690:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6693:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6693:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6693:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6693:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,139,FOLLOW_74); 

            	    									newLeafNode(otherlv_7, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6697:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6698:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6698:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6699:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_minLength_8_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:6722:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6722:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6723:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6723:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6724:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6727:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6727:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6727:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6727:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,140,FOLLOW_74); 

            	    									newLeafNode(otherlv_9, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6731:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6732:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6732:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6733:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_76);
            	    lv_maxLength_10_0=rulePositiveIntegerLiteral();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PositiveIntegerLiteral");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:6756:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6756:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:6757:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6757:120: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:6758:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6761:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:6761:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6761:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:6761:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,143,FOLLOW_77); 

            	    									newLeafNode(otherlv_11, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6765:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:6766:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:6766:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:6767:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_76); 

            	    											newLeafNode(lv_pattern_12_0, grammarAccess.getStringScalarRestrictionAccess().getPatternPATTERNTerminalRuleCall_4_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.PATTERN");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6800:3: ( ( ruleReference ) )
            // InternalOML.g:6801:4: ( ruleReference )
            {
            // InternalOML.g:6801:4: ( ruleReference )
            // InternalOML.g:6802:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringScalarRestriction"


    // $ANTLR start "entryRuleSynonymScalarRestriction"
    // InternalOML.g:6824:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:6824:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:6825:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getSynonymScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSynonymScalarRestriction=ruleSynonymScalarRestriction();

            state._fsp--;

             current =iv_ruleSynonymScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSynonymScalarRestriction"


    // $ANTLR start "ruleSynonymScalarRestriction"
    // InternalOML.g:6831:1: ruleSynonymScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6837:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:6838:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:6838:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:6839:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:6839:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==71) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalOML.g:6840:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6840:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6841:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_87);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSynonymScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            otherlv_1=(Token)match(input,154,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6862:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6863:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6863:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6864:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_84); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:6888:3: ( ( ruleReference ) )
            // InternalOML.g:6889:4: ( ruleReference )
            {
            // InternalOML.g:6889:4: ( ruleReference )
            // InternalOML.g:6890:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSynonymScalarRestriction"


    // $ANTLR start "entryRuleTimeScalarRestriction"
    // InternalOML.g:6912:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:6912:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:6913:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
            {
             newCompositeNode(grammarAccess.getTimeScalarRestrictionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeScalarRestriction=ruleTimeScalarRestriction();

            state._fsp--;

             current =iv_ruleTimeScalarRestriction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeScalarRestriction"


    // $ANTLR start "ruleTimeScalarRestriction"
    // InternalOML.g:6919:1: ruleTimeScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_minInclusive_6_0 = null;

        EObject lv_maxInclusive_8_0 = null;

        EObject lv_minExclusive_10_0 = null;

        EObject lv_maxExclusive_12_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6925:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:6926:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:6926:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:6927:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:6927:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==71) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalOML.g:6928:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6928:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6929:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_88);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

            otherlv_1=(Token)match(input,155,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6950:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6951:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6951:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6952:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_79); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6972:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6973:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6973:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            // InternalOML.g:6974:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6977:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            // InternalOML.g:6978:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            {
            // InternalOML.g:6978:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            loop86:
            do {
                int alt86=5;
                int LA86_0 = input.LA(1);

                if ( LA86_0 == 145 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt86=1;
                }
                else if ( LA86_0 == 146 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt86=2;
                }
                else if ( LA86_0 == 147 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt86=3;
                }
                else if ( LA86_0 == 148 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt86=4;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalOML.g:6979:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6979:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6980:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6980:118: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6981:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6984:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6984:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6984:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6984:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_5=(Token)match(input,145,FOLLOW_89); 

            	    									newLeafNode(otherlv_5, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6988:9: ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6989:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6989:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    // InternalOML.g:6990:11: lv_minInclusive_6_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_minInclusive_6_0=ruleLiteralDateTime();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minInclusive",
            	    												lv_minInclusive_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:7013:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:7013:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:7014:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:7014:118: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:7015:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:7018:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:7018:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:7018:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:7018:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_7=(Token)match(input,146,FOLLOW_89); 

            	    									newLeafNode(otherlv_7, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:7022:9: ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:7023:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:7023:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    // InternalOML.g:7024:11: lv_maxInclusive_8_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_maxInclusive_8_0=ruleLiteralDateTime();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxInclusive",
            	    												lv_maxInclusive_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:7047:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:7047:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:7048:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:7048:118: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:7049:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:7052:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:7052:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:7052:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:7052:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_9=(Token)match(input,147,FOLLOW_89); 

            	    									newLeafNode(otherlv_9, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:7056:9: ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:7057:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:7057:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    // InternalOML.g:7058:11: lv_minExclusive_10_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_minExclusive_10_0=ruleLiteralDateTime();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"minExclusive",
            	    												lv_minExclusive_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:7081:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:7081:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:7082:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:7082:118: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:7083:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:7086:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:7086:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:7086:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:7086:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_11=(Token)match(input,148,FOLLOW_89); 

            	    									newLeafNode(otherlv_11, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:7090:9: ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:7091:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:7091:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    // InternalOML.g:7092:11: lv_maxExclusive_12_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_79);
            	    lv_maxExclusive_12_0=ruleLiteralDateTime();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"maxExclusive",
            	    												lv_maxExclusive_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralDateTime");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,141,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:7126:3: ( ( ruleReference ) )
            // InternalOML.g:7127:4: ( ruleReference )
            {
            // InternalOML.g:7127:4: ( ruleReference )
            // InternalOML.g:7128:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeScalarRestriction"


    // $ANTLR start "entryRuleConceptualEntitySingletonInstance"
    // InternalOML.g:7150:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:7150:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:7151:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
            {
             newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptualEntitySingletonInstance=ruleConceptualEntitySingletonInstance();

            state._fsp--;

             current =iv_ruleConceptualEntitySingletonInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptualEntitySingletonInstance"


    // $ANTLR start "ruleConceptualEntitySingletonInstance"
    // InternalOML.g:7157:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:7163:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:7164:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:7164:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalOML.g:7165:3: this_ConceptInstance_0= ruleConceptInstance
                    {

                    			newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceAccess().getConceptInstanceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConceptInstance_0=ruleConceptInstance();

                    state._fsp--;


                    			current = this_ConceptInstance_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:7174:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
                    {

                    			newCompositeNode(grammarAccess.getConceptualEntitySingletonInstanceAccess().getReifiedRelationshipInstanceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReifiedRelationshipInstance_1=ruleReifiedRelationshipInstance();

                    state._fsp--;


                    			current = this_ReifiedRelationshipInstance_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptualEntitySingletonInstance"


    // $ANTLR start "entryRuleDescriptionBoxExtendsClosedWorldDefinitions"
    // InternalOML.g:7186:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:7186:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:7187:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
            {
             newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionBoxExtendsClosedWorldDefinitions=ruleDescriptionBoxExtendsClosedWorldDefinitions();

            state._fsp--;

             current =iv_ruleDescriptionBoxExtendsClosedWorldDefinitions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionBoxExtendsClosedWorldDefinitions"


    // $ANTLR start "ruleDescriptionBoxExtendsClosedWorldDefinitions"
    // InternalOML.g:7193:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7199:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:7200:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:7200:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:7201:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:7201:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==71) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalOML.g:7202:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7202:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7203:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_23);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            otherlv_1=(Token)match(input,81,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1());
            		
            // InternalOML.g:7224:3: ( ( ruleExternalReference ) )
            // InternalOML.g:7225:4: ( ruleExternalReference )
            {
            // InternalOML.g:7225:4: ( ruleExternalReference )
            // InternalOML.g:7226:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionBoxExtendsClosedWorldDefinitions"


    // $ANTLR start "entryRuleDescriptionBoxRefinement"
    // InternalOML.g:7244:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:7244:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:7245:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionBoxRefinementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionBoxRefinement=ruleDescriptionBoxRefinement();

            state._fsp--;

             current =iv_ruleDescriptionBoxRefinement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionBoxRefinement"


    // $ANTLR start "ruleDescriptionBoxRefinement"
    // InternalOML.g:7251:1: ruleDescriptionBoxRefinement returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7257:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:7258:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:7258:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:7259:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:7259:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==71) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalOML.g:7260:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7260:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7261:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_90);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxRefinementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);

            otherlv_1=(Token)match(input,156,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1());
            		
            // InternalOML.g:7282:3: ( ( ruleExternalReference ) )
            // InternalOML.g:7283:4: ( ruleExternalReference )
            {
            // InternalOML.g:7283:4: ( ruleExternalReference )
            // InternalOML.g:7284:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxRefinementRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionBoxRefinement"


    // $ANTLR start "entryRuleSingletonInstanceScalarDataPropertyValue"
    // InternalOML.g:7302:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:7302:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:7303:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingletonInstanceScalarDataPropertyValue=ruleSingletonInstanceScalarDataPropertyValue();

            state._fsp--;

             current =iv_ruleSingletonInstanceScalarDataPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingletonInstanceScalarDataPropertyValue"


    // $ANTLR start "ruleSingletonInstanceScalarDataPropertyValue"
    // InternalOML.g:7309:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7315:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:7316:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:7316:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:7317:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:7317:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==71) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalOML.g:7318:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7318:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7319:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            // InternalOML.g:7336:3: ( ( ruleReference ) )
            // InternalOML.g:7337:4: ( ruleReference )
            {
            // InternalOML.g:7337:4: ( ruleReference )
            // InternalOML.g:7338:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:7356:3: ( ( ruleReference ) )
            // InternalOML.g:7357:4: ( ruleReference )
            {
            // InternalOML.g:7357:4: ( ruleReference )
            // InternalOML.g:7358:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:7376:3: ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) )
            // InternalOML.g:7377:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            {
            // InternalOML.g:7377:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            // InternalOML.g:7378:5: lv_scalarPropertyValue_5_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_69);
            lv_scalarPropertyValue_5_0=ruleLiteralValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_5_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:7395:3: (otherlv_6= '^^' ( ( ruleReference ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==135) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalOML.g:7396:4: otherlv_6= '^^' ( ( ruleReference ) )
                    {
                    otherlv_6=(Token)match(input,135,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_6_0());
                    			
                    // InternalOML.g:7400:4: ( ( ruleReference ) )
                    // InternalOML.g:7401:5: ( ruleReference )
                    {
                    // InternalOML.g:7401:5: ( ruleReference )
                    // InternalOML.g:7402:6: ruleReference
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_6_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingletonInstanceScalarDataPropertyValue"


    // $ANTLR start "entryRuleSingletonInstanceStructuredDataPropertyValue"
    // InternalOML.g:7421:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:7421:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:7422:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingletonInstanceStructuredDataPropertyValue=ruleSingletonInstanceStructuredDataPropertyValue();

            state._fsp--;

             current =iv_ruleSingletonInstanceStructuredDataPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingletonInstanceStructuredDataPropertyValue"


    // $ANTLR start "ruleSingletonInstanceStructuredDataPropertyValue"
    // InternalOML.g:7428:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_structuredPropertyTuples_6_0 = null;

        EObject lv_scalarDataPropertyValues_7_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7434:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:7435:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:7435:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            // InternalOML.g:7436:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}'
            {
            // InternalOML.g:7436:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==71) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalOML.g:7437:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7437:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7438:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);

            // InternalOML.g:7455:3: ( ( ruleReference ) )
            // InternalOML.g:7456:4: ( ruleReference )
            {
            // InternalOML.g:7456:4: ( ruleReference )
            // InternalOML.g:7457:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:7475:3: ( ( ruleReference ) )
            // InternalOML.g:7476:4: ( ruleReference )
            {
            // InternalOML.g:7476:4: ( ruleReference )
            // InternalOML.g:7477:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_3_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,70,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_4());
            		
            otherlv_5=(Token)match(input,73,FOLLOW_71); 

            			newLeafNode(otherlv_5, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:7499:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*
            loop93:
            do {
                int alt93=3;
                alt93 = dfa93.predict(input);
                switch (alt93) {
            	case 1 :
            	    // InternalOML.g:7500:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:7500:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:7501:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:7501:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:7502:6: lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_structuredPropertyTuples_6_0=ruleStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:7520:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:7520:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:7521:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:7521:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:7522:6: lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_scalarDataPropertyValues_7_0=ruleScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            otherlv_8=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingletonInstanceStructuredDataPropertyValue"


    // $ANTLR start "entryRuleStructuredDataPropertyTuple"
    // InternalOML.g:7548:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:7548:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:7549:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
            {
             newCompositeNode(grammarAccess.getStructuredDataPropertyTupleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStructuredDataPropertyTuple=ruleStructuredDataPropertyTuple();

            state._fsp--;

             current =iv_ruleStructuredDataPropertyTuple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructuredDataPropertyTuple"


    // $ANTLR start "ruleStructuredDataPropertyTuple"
    // InternalOML.g:7555:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_structuredPropertyTuples_4_0 = null;

        EObject lv_scalarDataPropertyValues_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7561:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:7562:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:7562:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:7563:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:7563:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==71) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalOML.g:7564:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7564:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7565:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // InternalOML.g:7582:3: ( ( ruleReference ) )
            // InternalOML.g:7583:4: ( ruleReference )
            {
            // InternalOML.g:7583:4: ( ruleReference )
            // InternalOML.g:7584:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_1_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,73,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:7606:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*
            loop95:
            do {
                int alt95=3;
                alt95 = dfa95.predict(input);
                switch (alt95) {
            	case 1 :
            	    // InternalOML.g:7607:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:7607:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:7608:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:7608:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:7609:6: lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_structuredPropertyTuples_4_0=ruleStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:7627:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:7627:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:7628:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:7628:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:7629:6: lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_71);
            	    lv_scalarDataPropertyValues_5_0=ruleScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructuredDataPropertyTuple"


    // $ANTLR start "entryRuleScalarDataPropertyValue"
    // InternalOML.g:7655:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:7655:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:7656:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getScalarDataPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarDataPropertyValue=ruleScalarDataPropertyValue();

            state._fsp--;

             current =iv_ruleScalarDataPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarDataPropertyValue"


    // $ANTLR start "ruleScalarDataPropertyValue"
    // InternalOML.g:7662:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7668:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:7669:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:7669:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:7670:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:7670:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==71) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalOML.g:7671:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7671:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7672:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_21);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop96;
                }
            } while (true);

            // InternalOML.g:7689:3: ( ( ruleReference ) )
            // InternalOML.g:7690:4: ( ruleReference )
            {
            // InternalOML.g:7690:4: ( ruleReference )
            // InternalOML.g:7691:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_1_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_68); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:7709:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:7710:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:7710:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:7711:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_69);
            lv_scalarPropertyValue_3_0=ruleLiteralValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LiteralValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOML.g:7728:3: (otherlv_4= '^^' ( ( ruleReference ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==135) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalOML.g:7729:4: otherlv_4= '^^' ( ( ruleReference ) )
                    {
                    otherlv_4=(Token)match(input,135,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
                    			
                    // InternalOML.g:7733:4: ( ( ruleReference ) )
                    // InternalOML.g:7734:5: ( ruleReference )
                    {
                    // InternalOML.g:7734:5: ( ruleReference )
                    // InternalOML.g:7735:6: ruleReference
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getValueTypeDataRangeCrossReference_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScalarDataPropertyValue"


    // $ANTLR start "entryRuleConceptInstance"
    // InternalOML.g:7754:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:7754:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:7755:2: iv_ruleConceptInstance= ruleConceptInstance EOF
            {
             newCompositeNode(grammarAccess.getConceptInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConceptInstance=ruleConceptInstance();

            state._fsp--;

             current =iv_ruleConceptInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConceptInstance"


    // $ANTLR start "ruleConceptInstance"
    // InternalOML.g:7761:1: ruleConceptInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
    public final EObject ruleConceptInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7767:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:7768:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:7768:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:7769:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:7769:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==71) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalOML.g:7770:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7770:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7771:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_91);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConceptInstanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);

            otherlv_1=(Token)match(input,157,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7796:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:7797:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:7797:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:7798:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_92); 

            					newLeafNode(lv_name_3_0, grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,158,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:7818:3: ( ( ruleReference ) )
            // InternalOML.g:7819:4: ( ruleReference )
            {
            // InternalOML.g:7819:4: ( ruleReference )
            // InternalOML.g:7820:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,117,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConceptInstance"


    // $ANTLR start "entryRuleReifiedRelationshipInstance"
    // InternalOML.g:7842:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:7842:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:7843:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipInstance=ruleReifiedRelationshipInstance();

            state._fsp--;

             current =iv_ruleReifiedRelationshipInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipInstance"


    // $ANTLR start "ruleReifiedRelationshipInstance"
    // InternalOML.g:7849:1: ruleReifiedRelationshipInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
    public final EObject ruleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7855:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:7856:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:7856:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:7857:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:7857:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==71) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalOML.g:7858:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7858:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7859:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_93);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);

            otherlv_1=(Token)match(input,159,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7884:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:7885:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:7885:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:7886:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_92); 

            					newLeafNode(lv_name_3_0, grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,158,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:7906:3: ( ( ruleReference ) )
            // InternalOML.g:7907:4: ( ruleReference )
            {
            // InternalOML.g:7907:4: ( ruleReference )
            // InternalOML.g:7908:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonConceptualRelationshipClassifierConceptualRelationshipCrossReference_5_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,117,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipInstance"


    // $ANTLR start "entryRuleReifiedRelationshipInstanceDomain"
    // InternalOML.g:7930:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:7930:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:7931:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipInstanceDomain=ruleReifiedRelationshipInstanceDomain();

            state._fsp--;

             current =iv_ruleReifiedRelationshipInstanceDomain; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipInstanceDomain"


    // $ANTLR start "ruleReifiedRelationshipInstanceDomain"
    // InternalOML.g:7937:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7943:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:7944:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:7944:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:7945:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:7945:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==71) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalOML.g:7946:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7946:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7947:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_94);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);

            otherlv_1=(Token)match(input,107,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7972:3: ( ( ruleReference ) )
            // InternalOML.g:7973:4: ( ruleReference )
            {
            // InternalOML.g:7973:4: ( ruleReference )
            // InternalOML.g:7974:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,117,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:7996:3: ( ( ruleReference ) )
            // InternalOML.g:7997:4: ( ruleReference )
            {
            // InternalOML.g:7997:4: ( ruleReference )
            // InternalOML.g:7998:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipInstanceDomain"


    // $ANTLR start "entryRuleReifiedRelationshipInstanceRange"
    // InternalOML.g:8016:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:8016:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:8017:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
            {
             newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReifiedRelationshipInstanceRange=ruleReifiedRelationshipInstanceRange();

            state._fsp--;

             current =iv_ruleReifiedRelationshipInstanceRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReifiedRelationshipInstanceRange"


    // $ANTLR start "ruleReifiedRelationshipInstanceRange"
    // InternalOML.g:8023:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8029:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:8030:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:8030:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:8031:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:8031:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==71) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalOML.g:8032:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:8032:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:8033:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_95);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);

            otherlv_1=(Token)match(input,108,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1());
            		
            otherlv_2=(Token)match(input,116,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:8058:3: ( ( ruleReference ) )
            // InternalOML.g:8059:4: ( ruleReference )
            {
            // InternalOML.g:8059:4: ( ruleReference )
            // InternalOML.g:8060:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_52);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,117,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:8082:3: ( ( ruleReference ) )
            // InternalOML.g:8083:4: ( ruleReference )
            {
            // InternalOML.g:8083:4: ( ruleReference )
            // InternalOML.g:8084:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_6_0());
            				
            pushFollow(FOLLOW_2);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReifiedRelationshipInstanceRange"


    // $ANTLR start "entryRuleUnreifiedRelationshipInstanceTuple"
    // InternalOML.g:8102:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:8102:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:8103:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
            {
             newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnreifiedRelationshipInstanceTuple=ruleUnreifiedRelationshipInstanceTuple();

            state._fsp--;

             current =iv_ruleUnreifiedRelationshipInstanceTuple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreifiedRelationshipInstanceTuple"


    // $ANTLR start "ruleUnreifiedRelationshipInstanceTuple"
    // InternalOML.g:8109:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
    public final EObject ruleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8115:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:8116:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:8116:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:8117:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:8117:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==71) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalOML.g:8118:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:8118:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:8119:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_96);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationPropertyValue");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop102;
                }
            } while (true);

            otherlv_1=(Token)match(input,160,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_97); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3());
            		
            // InternalOML.g:8148:3: ( ( ruleReference ) )
            // InternalOML.g:8149:4: ( ruleReference )
            {
            // InternalOML.g:8149:4: ( ruleReference )
            // InternalOML.g:8150:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5());
            		
            // InternalOML.g:8168:3: ( ( ruleReference ) )
            // InternalOML.g:8169:4: ( ruleReference )
            {
            // InternalOML.g:8169:4: ( ruleReference )
            // InternalOML.g:8170:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0());
            				
            pushFollow(FOLLOW_43);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7());
            		
            // InternalOML.g:8188:3: ( ( ruleReference ) )
            // InternalOML.g:8189:4: ( ruleReference )
            {
            // InternalOML.g:8189:4: ( ruleReference )
            // InternalOML.g:8190:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_8_0());
            				
            pushFollow(FOLLOW_22);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreifiedRelationshipInstanceTuple"


    // $ANTLR start "entryRuleReference"
    // InternalOML.g:8212:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:8212:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:8213:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalOML.g:8219:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8225:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:8226:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:8226:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_IRI) ) {
                alt103=1;
            }
            else if ( (LA103_0==RULE_ABBREV_IRI||LA103_0==RULE_ID) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalOML.g:8227:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8235:3: this_QNAME_1= ruleQNAME
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getQNAMEParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QNAME_1=ruleQNAME();

                    state._fsp--;


                    			current.merge(this_QNAME_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleExternalReference"
    // InternalOML.g:8249:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:8249:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:8250:2: iv_ruleExternalReference= ruleExternalReference EOF
            {
             newCompositeNode(grammarAccess.getExternalReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalReference=ruleExternalReference();

            state._fsp--;

             current =iv_ruleExternalReference.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalReference"


    // $ANTLR start "ruleExternalReference"
    // InternalOML.g:8256:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:8262:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:8263:2: this_IRI_0= RULE_IRI
            {
            this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

            		current.merge(this_IRI_0);
            	

            		newLeafNode(this_IRI_0, grammarAccess.getExternalReferenceAccess().getIRITerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalReference"


    // $ANTLR start "entryRuleQNAME"
    // InternalOML.g:8273:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:8273:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:8274:2: iv_ruleQNAME= ruleQNAME EOF
            {
             newCompositeNode(grammarAccess.getQNAMERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQNAME=ruleQNAME();

            state._fsp--;

             current =iv_ruleQNAME.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQNAME"


    // $ANTLR start "ruleQNAME"
    // InternalOML.g:8280:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8286:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:8287:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:8287:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_ABBREV_IRI) ) {
                alt104=1;
            }
            else if ( (LA104_0==RULE_ID) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // InternalOML.g:8288:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8296:3: this_ValidID_1= ruleValidID
                    {

                    			newCompositeNode(grammarAccess.getQNAMEAccess().getValidIDParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValidID_1=ruleValidID();

                    state._fsp--;


                    			current.merge(this_ValidID_1);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQNAME"


    // $ANTLR start "entryRuleValidID"
    // InternalOML.g:8310:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:8310:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:8311:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalOML.g:8317:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:8323:2: (this_ID_0= RULE_ID )
            // InternalOML.g:8324:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalOML.g:8334:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // InternalOML.g:8334:53: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalOML.g:8335:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalOML.g:8341:1: ruleLiteralValue returns [EObject current=null] : (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) ;
    public final EObject ruleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralBoolean_0 = null;

        EObject this_LiteralDateTime_1 = null;

        EObject this_LiteralString_2 = null;

        EObject this_LiteralUUID_3 = null;

        EObject this_LiteralURI_4 = null;

        EObject this_LiteralNumber_5 = null;



        	enterRule();

        try {
            // InternalOML.g:8347:2: ( (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) )
            // InternalOML.g:8348:2: (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            {
            // InternalOML.g:8348:2: (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            int alt105=6;
            switch ( input.LA(1) ) {
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt105=1;
                }
                break;
            case RULE_DATE_TIME:
                {
                alt105=2;
                }
                break;
            case RULE_QUOTED_STRING_VALUE:
            case RULE_RAW_STRING_VALUE:
                {
                alt105=3;
                }
                break;
            case RULE_UUID:
                {
                alt105=4;
                }
                break;
            case RULE_URI:
                {
                alt105=5;
                }
                break;
            case RULE_REAL:
            case RULE_RATIONAL:
            case RULE_FLOAT:
            case RULE_DIGITS:
            case RULE_DECIMAL:
                {
                alt105=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // InternalOML.g:8349:3: this_LiteralBoolean_0= ruleLiteralBoolean
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralBooleanParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralBoolean_0=ruleLiteralBoolean();

                    state._fsp--;


                    			current = this_LiteralBoolean_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8358:3: this_LiteralDateTime_1= ruleLiteralDateTime
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralDateTimeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralDateTime_1=ruleLiteralDateTime();

                    state._fsp--;


                    			current = this_LiteralDateTime_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:8367:3: this_LiteralString_2= ruleLiteralString
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralStringParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralString_2=ruleLiteralString();

                    state._fsp--;


                    			current = this_LiteralString_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:8376:3: this_LiteralUUID_3= ruleLiteralUUID
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralUUIDParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralUUID_3=ruleLiteralUUID();

                    state._fsp--;


                    			current = this_LiteralUUID_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:8385:3: this_LiteralURI_4= ruleLiteralURI
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralURIParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralURI_4=ruleLiteralURI();

                    state._fsp--;


                    			current = this_LiteralURI_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:8394:3: this_LiteralNumber_5= ruleLiteralNumber
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralNumberParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralNumber_5=ruleLiteralNumber();

                    state._fsp--;


                    			current = this_LiteralNumber_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleLiteralBoolean"
    // InternalOML.g:8406:1: entryRuleLiteralBoolean returns [EObject current=null] : iv_ruleLiteralBoolean= ruleLiteralBoolean EOF ;
    public final EObject entryRuleLiteralBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBoolean = null;


        try {
            // InternalOML.g:8406:55: (iv_ruleLiteralBoolean= ruleLiteralBoolean EOF )
            // InternalOML.g:8407:2: iv_ruleLiteralBoolean= ruleLiteralBoolean EOF
            {
             newCompositeNode(grammarAccess.getLiteralBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralBoolean=ruleLiteralBoolean();

            state._fsp--;

             current =iv_ruleLiteralBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralBoolean"


    // $ANTLR start "ruleLiteralBoolean"
    // InternalOML.g:8413:1: ruleLiteralBoolean returns [EObject current=null] : ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) ) ;
    public final EObject ruleLiteralBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool_1_1=null;
        Token lv_bool_1_2=null;


        	enterRule();

        try {
            // InternalOML.g:8419:2: ( ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) ) )
            // InternalOML.g:8420:2: ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) )
            {
            // InternalOML.g:8420:2: ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) )
            // InternalOML.g:8421:3: () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) )
            {
            // InternalOML.g:8421:3: ()
            // InternalOML.g:8422:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralBooleanAccess().getLiteralBooleanAction_0(),
            					current);
            			

            }

            // InternalOML.g:8428:3: ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) )
            // InternalOML.g:8429:4: ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) )
            {
            // InternalOML.g:8429:4: ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) )
            // InternalOML.g:8430:5: (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE )
            {
            // InternalOML.g:8430:5: (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_TRUE) ) {
                alt106=1;
            }
            else if ( (LA106_0==RULE_FALSE) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalOML.g:8431:6: lv_bool_1_1= RULE_TRUE
                    {
                    lv_bool_1_1=(Token)match(input,RULE_TRUE,FOLLOW_2); 

                    						newLeafNode(lv_bool_1_1, grammarAccess.getLiteralBooleanAccess().getBoolTRUETerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralBooleanRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"bool",
                    							lv_bool_1_1,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.TRUE");
                    					

                    }
                    break;
                case 2 :
                    // InternalOML.g:8446:6: lv_bool_1_2= RULE_FALSE
                    {
                    lv_bool_1_2=(Token)match(input,RULE_FALSE,FOLLOW_2); 

                    						newLeafNode(lv_bool_1_2, grammarAccess.getLiteralBooleanAccess().getBoolFALSETerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralBooleanRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"bool",
                    							lv_bool_1_2,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.FALSE");
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralBoolean"


    // $ANTLR start "entryRuleLiteralDateTime"
    // InternalOML.g:8467:1: entryRuleLiteralDateTime returns [EObject current=null] : iv_ruleLiteralDateTime= ruleLiteralDateTime EOF ;
    public final EObject entryRuleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralDateTime = null;


        try {
            // InternalOML.g:8467:56: (iv_ruleLiteralDateTime= ruleLiteralDateTime EOF )
            // InternalOML.g:8468:2: iv_ruleLiteralDateTime= ruleLiteralDateTime EOF
            {
             newCompositeNode(grammarAccess.getLiteralDateTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralDateTime=ruleLiteralDateTime();

            state._fsp--;

             current =iv_ruleLiteralDateTime; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralDateTime"


    // $ANTLR start "ruleLiteralDateTime"
    // InternalOML.g:8474:1: ruleLiteralDateTime returns [EObject current=null] : ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) ) ;
    public final EObject ruleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8480:2: ( ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) ) )
            // InternalOML.g:8481:2: ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) )
            {
            // InternalOML.g:8481:2: ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) )
            // InternalOML.g:8482:3: () ( (lv_dateTime_1_0= RULE_DATE_TIME ) )
            {
            // InternalOML.g:8482:3: ()
            // InternalOML.g:8483:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0(),
            					current);
            			

            }

            // InternalOML.g:8489:3: ( (lv_dateTime_1_0= RULE_DATE_TIME ) )
            // InternalOML.g:8490:4: (lv_dateTime_1_0= RULE_DATE_TIME )
            {
            // InternalOML.g:8490:4: (lv_dateTime_1_0= RULE_DATE_TIME )
            // InternalOML.g:8491:5: lv_dateTime_1_0= RULE_DATE_TIME
            {
            lv_dateTime_1_0=(Token)match(input,RULE_DATE_TIME,FOLLOW_2); 

            					newLeafNode(lv_dateTime_1_0, grammarAccess.getLiteralDateTimeAccess().getDateTimeDATE_TIMETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralDateTimeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"dateTime",
            						lv_dateTime_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.DATE_TIME");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralDateTime"


    // $ANTLR start "entryRuleLiteralString"
    // InternalOML.g:8511:1: entryRuleLiteralString returns [EObject current=null] : iv_ruleLiteralString= ruleLiteralString EOF ;
    public final EObject entryRuleLiteralString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralString = null;


        try {
            // InternalOML.g:8511:54: (iv_ruleLiteralString= ruleLiteralString EOF )
            // InternalOML.g:8512:2: iv_ruleLiteralString= ruleLiteralString EOF
            {
             newCompositeNode(grammarAccess.getLiteralStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralString=ruleLiteralString();

            state._fsp--;

             current =iv_ruleLiteralString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralString"


    // $ANTLR start "ruleLiteralString"
    // InternalOML.g:8518:1: ruleLiteralString returns [EObject current=null] : (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString ) ;
    public final EObject ruleLiteralString() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralQuotedString_0 = null;

        EObject this_LiteralRawString_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8524:2: ( (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString ) )
            // InternalOML.g:8525:2: (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString )
            {
            // InternalOML.g:8525:2: (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==RULE_QUOTED_STRING_VALUE) ) {
                alt107=1;
            }
            else if ( (LA107_0==RULE_RAW_STRING_VALUE) ) {
                alt107=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // InternalOML.g:8526:3: this_LiteralQuotedString_0= ruleLiteralQuotedString
                    {

                    			newCompositeNode(grammarAccess.getLiteralStringAccess().getLiteralQuotedStringParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralQuotedString_0=ruleLiteralQuotedString();

                    state._fsp--;


                    			current = this_LiteralQuotedString_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8535:3: this_LiteralRawString_1= ruleLiteralRawString
                    {

                    			newCompositeNode(grammarAccess.getLiteralStringAccess().getLiteralRawStringParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralRawString_1=ruleLiteralRawString();

                    state._fsp--;


                    			current = this_LiteralRawString_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralString"


    // $ANTLR start "entryRuleLiteralQuotedString"
    // InternalOML.g:8547:1: entryRuleLiteralQuotedString returns [EObject current=null] : iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF ;
    public final EObject entryRuleLiteralQuotedString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralQuotedString = null;


        try {
            // InternalOML.g:8547:60: (iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF )
            // InternalOML.g:8548:2: iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF
            {
             newCompositeNode(grammarAccess.getLiteralQuotedStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralQuotedString=ruleLiteralQuotedString();

            state._fsp--;

             current =iv_ruleLiteralQuotedString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralQuotedString"


    // $ANTLR start "ruleLiteralQuotedString"
    // InternalOML.g:8554:1: ruleLiteralQuotedString returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) ) ;
    public final EObject ruleLiteralQuotedString() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8560:2: ( ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) ) )
            // InternalOML.g:8561:2: ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) )
            {
            // InternalOML.g:8561:2: ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) )
            // InternalOML.g:8562:3: () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) )
            {
            // InternalOML.g:8562:3: ()
            // InternalOML.g:8563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralQuotedStringAccess().getLiteralQuotedStringAction_0(),
            					current);
            			

            }

            // InternalOML.g:8569:3: ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) )
            // InternalOML.g:8570:4: (lv_string_1_0= RULE_QUOTED_STRING_VALUE )
            {
            // InternalOML.g:8570:4: (lv_string_1_0= RULE_QUOTED_STRING_VALUE )
            // InternalOML.g:8571:5: lv_string_1_0= RULE_QUOTED_STRING_VALUE
            {
            lv_string_1_0=(Token)match(input,RULE_QUOTED_STRING_VALUE,FOLLOW_2); 

            					newLeafNode(lv_string_1_0, grammarAccess.getLiteralQuotedStringAccess().getStringQUOTED_STRING_VALUETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralQuotedStringRule());
            					}
            					setWithLastConsumed(
            						current,
            						"string",
            						lv_string_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.QUOTED_STRING_VALUE");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralQuotedString"


    // $ANTLR start "entryRuleLiteralRawString"
    // InternalOML.g:8591:1: entryRuleLiteralRawString returns [EObject current=null] : iv_ruleLiteralRawString= ruleLiteralRawString EOF ;
    public final EObject entryRuleLiteralRawString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRawString = null;


        try {
            // InternalOML.g:8591:57: (iv_ruleLiteralRawString= ruleLiteralRawString EOF )
            // InternalOML.g:8592:2: iv_ruleLiteralRawString= ruleLiteralRawString EOF
            {
             newCompositeNode(grammarAccess.getLiteralRawStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRawString=ruleLiteralRawString();

            state._fsp--;

             current =iv_ruleLiteralRawString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralRawString"


    // $ANTLR start "ruleLiteralRawString"
    // InternalOML.g:8598:1: ruleLiteralRawString returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) ) ;
    public final EObject ruleLiteralRawString() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8604:2: ( ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) ) )
            // InternalOML.g:8605:2: ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) )
            {
            // InternalOML.g:8605:2: ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) )
            // InternalOML.g:8606:3: () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) )
            {
            // InternalOML.g:8606:3: ()
            // InternalOML.g:8607:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRawStringAccess().getLiteralRawStringAction_0(),
            					current);
            			

            }

            // InternalOML.g:8613:3: ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) )
            // InternalOML.g:8614:4: (lv_string_1_0= RULE_RAW_STRING_VALUE )
            {
            // InternalOML.g:8614:4: (lv_string_1_0= RULE_RAW_STRING_VALUE )
            // InternalOML.g:8615:5: lv_string_1_0= RULE_RAW_STRING_VALUE
            {
            lv_string_1_0=(Token)match(input,RULE_RAW_STRING_VALUE,FOLLOW_2); 

            					newLeafNode(lv_string_1_0, grammarAccess.getLiteralRawStringAccess().getStringRAW_STRING_VALUETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralRawStringRule());
            					}
            					setWithLastConsumed(
            						current,
            						"string",
            						lv_string_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.RAW_STRING_VALUE");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRawString"


    // $ANTLR start "entryRuleUUIDDataType"
    // InternalOML.g:8635:1: entryRuleUUIDDataType returns [String current=null] : iv_ruleUUIDDataType= ruleUUIDDataType EOF ;
    public final String entryRuleUUIDDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUUIDDataType = null;


        try {
            // InternalOML.g:8635:52: (iv_ruleUUIDDataType= ruleUUIDDataType EOF )
            // InternalOML.g:8636:2: iv_ruleUUIDDataType= ruleUUIDDataType EOF
            {
             newCompositeNode(grammarAccess.getUUIDDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUUIDDataType=ruleUUIDDataType();

            state._fsp--;

             current =iv_ruleUUIDDataType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUUIDDataType"


    // $ANTLR start "ruleUUIDDataType"
    // InternalOML.g:8642:1: ruleUUIDDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UUID_0= RULE_UUID ;
    public final AntlrDatatypeRuleToken ruleUUIDDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_UUID_0=null;


        	enterRule();

        try {
            // InternalOML.g:8648:2: (this_UUID_0= RULE_UUID )
            // InternalOML.g:8649:2: this_UUID_0= RULE_UUID
            {
            this_UUID_0=(Token)match(input,RULE_UUID,FOLLOW_2); 

            		current.merge(this_UUID_0);
            	

            		newLeafNode(this_UUID_0, grammarAccess.getUUIDDataTypeAccess().getUUIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUUIDDataType"


    // $ANTLR start "entryRuleLiteralUUID"
    // InternalOML.g:8659:1: entryRuleLiteralUUID returns [EObject current=null] : iv_ruleLiteralUUID= ruleLiteralUUID EOF ;
    public final EObject entryRuleLiteralUUID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralUUID = null;


        try {
            // InternalOML.g:8659:52: (iv_ruleLiteralUUID= ruleLiteralUUID EOF )
            // InternalOML.g:8660:2: iv_ruleLiteralUUID= ruleLiteralUUID EOF
            {
             newCompositeNode(grammarAccess.getLiteralUUIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralUUID=ruleLiteralUUID();

            state._fsp--;

             current =iv_ruleLiteralUUID; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralUUID"


    // $ANTLR start "ruleLiteralUUID"
    // InternalOML.g:8666:1: ruleLiteralUUID returns [EObject current=null] : ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) ) ;
    public final EObject ruleLiteralUUID() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_uuid_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8672:2: ( ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) ) )
            // InternalOML.g:8673:2: ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) )
            {
            // InternalOML.g:8673:2: ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) )
            // InternalOML.g:8674:3: () ( (lv_uuid_1_0= ruleUUIDDataType ) )
            {
            // InternalOML.g:8674:3: ()
            // InternalOML.g:8675:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0(),
            					current);
            			

            }

            // InternalOML.g:8681:3: ( (lv_uuid_1_0= ruleUUIDDataType ) )
            // InternalOML.g:8682:4: (lv_uuid_1_0= ruleUUIDDataType )
            {
            // InternalOML.g:8682:4: (lv_uuid_1_0= ruleUUIDDataType )
            // InternalOML.g:8683:5: lv_uuid_1_0= ruleUUIDDataType
            {

            					newCompositeNode(grammarAccess.getLiteralUUIDAccess().getUuidUUIDDataTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_uuid_1_0=ruleUUIDDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralUUIDRule());
            					}
            					set(
            						current,
            						"uuid",
            						lv_uuid_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.UUIDDataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralUUID"


    // $ANTLR start "entryRuleURIDataType"
    // InternalOML.g:8704:1: entryRuleURIDataType returns [String current=null] : iv_ruleURIDataType= ruleURIDataType EOF ;
    public final String entryRuleURIDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIDataType = null;


        try {
            // InternalOML.g:8704:51: (iv_ruleURIDataType= ruleURIDataType EOF )
            // InternalOML.g:8705:2: iv_ruleURIDataType= ruleURIDataType EOF
            {
             newCompositeNode(grammarAccess.getURIDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURIDataType=ruleURIDataType();

            state._fsp--;

             current =iv_ruleURIDataType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIDataType"


    // $ANTLR start "ruleURIDataType"
    // InternalOML.g:8711:1: ruleURIDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_URI_0= RULE_URI ;
    public final AntlrDatatypeRuleToken ruleURIDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_URI_0=null;


        	enterRule();

        try {
            // InternalOML.g:8717:2: (this_URI_0= RULE_URI )
            // InternalOML.g:8718:2: this_URI_0= RULE_URI
            {
            this_URI_0=(Token)match(input,RULE_URI,FOLLOW_2); 

            		current.merge(this_URI_0);
            	

            		newLeafNode(this_URI_0, grammarAccess.getURIDataTypeAccess().getURITerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIDataType"


    // $ANTLR start "entryRuleLiteralURI"
    // InternalOML.g:8728:1: entryRuleLiteralURI returns [EObject current=null] : iv_ruleLiteralURI= ruleLiteralURI EOF ;
    public final EObject entryRuleLiteralURI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralURI = null;


        try {
            // InternalOML.g:8728:51: (iv_ruleLiteralURI= ruleLiteralURI EOF )
            // InternalOML.g:8729:2: iv_ruleLiteralURI= ruleLiteralURI EOF
            {
             newCompositeNode(grammarAccess.getLiteralURIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralURI=ruleLiteralURI();

            state._fsp--;

             current =iv_ruleLiteralURI; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralURI"


    // $ANTLR start "ruleLiteralURI"
    // InternalOML.g:8735:1: ruleLiteralURI returns [EObject current=null] : ( () ( (lv_uri_1_0= ruleURIDataType ) ) ) ;
    public final EObject ruleLiteralURI() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_uri_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8741:2: ( ( () ( (lv_uri_1_0= ruleURIDataType ) ) ) )
            // InternalOML.g:8742:2: ( () ( (lv_uri_1_0= ruleURIDataType ) ) )
            {
            // InternalOML.g:8742:2: ( () ( (lv_uri_1_0= ruleURIDataType ) ) )
            // InternalOML.g:8743:3: () ( (lv_uri_1_0= ruleURIDataType ) )
            {
            // InternalOML.g:8743:3: ()
            // InternalOML.g:8744:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralURIAccess().getLiteralURIAction_0(),
            					current);
            			

            }

            // InternalOML.g:8750:3: ( (lv_uri_1_0= ruleURIDataType ) )
            // InternalOML.g:8751:4: (lv_uri_1_0= ruleURIDataType )
            {
            // InternalOML.g:8751:4: (lv_uri_1_0= ruleURIDataType )
            // InternalOML.g:8752:5: lv_uri_1_0= ruleURIDataType
            {

            					newCompositeNode(grammarAccess.getLiteralURIAccess().getUriURIDataTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_uri_1_0=ruleURIDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralURIRule());
            					}
            					set(
            						current,
            						"uri",
            						lv_uri_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.URIDataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralURI"


    // $ANTLR start "entryRuleLiteralNumber"
    // InternalOML.g:8773:1: entryRuleLiteralNumber returns [EObject current=null] : iv_ruleLiteralNumber= ruleLiteralNumber EOF ;
    public final EObject entryRuleLiteralNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNumber = null;


        try {
            // InternalOML.g:8773:54: (iv_ruleLiteralNumber= ruleLiteralNumber EOF )
            // InternalOML.g:8774:2: iv_ruleLiteralNumber= ruleLiteralNumber EOF
            {
             newCompositeNode(grammarAccess.getLiteralNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralNumber=ruleLiteralNumber();

            state._fsp--;

             current =iv_ruleLiteralNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralNumber"


    // $ANTLR start "ruleLiteralNumber"
    // InternalOML.g:8780:1: ruleLiteralNumber returns [EObject current=null] : (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal ) ;
    public final EObject ruleLiteralNumber() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralReal_0 = null;

        EObject this_LiteralRational_1 = null;

        EObject this_LiteralFloat_2 = null;

        EObject this_LiteralDecimal_3 = null;



        	enterRule();

        try {
            // InternalOML.g:8786:2: ( (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal ) )
            // InternalOML.g:8787:2: (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal )
            {
            // InternalOML.g:8787:2: (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal )
            int alt108=4;
            switch ( input.LA(1) ) {
            case RULE_REAL:
                {
                alt108=1;
                }
                break;
            case RULE_RATIONAL:
                {
                alt108=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt108=3;
                }
                break;
            case RULE_DIGITS:
            case RULE_DECIMAL:
                {
                alt108=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalOML.g:8788:3: this_LiteralReal_0= ruleLiteralReal
                    {

                    			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralRealParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralReal_0=ruleLiteralReal();

                    state._fsp--;


                    			current = this_LiteralReal_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8797:3: this_LiteralRational_1= ruleLiteralRational
                    {

                    			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralRationalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralRational_1=ruleLiteralRational();

                    state._fsp--;


                    			current = this_LiteralRational_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:8806:3: this_LiteralFloat_2= ruleLiteralFloat
                    {

                    			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralFloatParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralFloat_2=ruleLiteralFloat();

                    state._fsp--;


                    			current = this_LiteralFloat_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:8815:3: this_LiteralDecimal_3= ruleLiteralDecimal
                    {

                    			newCompositeNode(grammarAccess.getLiteralNumberAccess().getLiteralDecimalParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralDecimal_3=ruleLiteralDecimal();

                    state._fsp--;


                    			current = this_LiteralDecimal_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralNumber"


    // $ANTLR start "entryRuleLiteralReal"
    // InternalOML.g:8827:1: entryRuleLiteralReal returns [EObject current=null] : iv_ruleLiteralReal= ruleLiteralReal EOF ;
    public final EObject entryRuleLiteralReal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralReal = null;


        try {
            // InternalOML.g:8827:52: (iv_ruleLiteralReal= ruleLiteralReal EOF )
            // InternalOML.g:8828:2: iv_ruleLiteralReal= ruleLiteralReal EOF
            {
             newCompositeNode(grammarAccess.getLiteralRealRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralReal=ruleLiteralReal();

            state._fsp--;

             current =iv_ruleLiteralReal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralReal"


    // $ANTLR start "ruleLiteralReal"
    // InternalOML.g:8834:1: ruleLiteralReal returns [EObject current=null] : ( () ( (lv_real_1_0= RULE_REAL ) ) ) ;
    public final EObject ruleLiteralReal() throws RecognitionException {
        EObject current = null;

        Token lv_real_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8840:2: ( ( () ( (lv_real_1_0= RULE_REAL ) ) ) )
            // InternalOML.g:8841:2: ( () ( (lv_real_1_0= RULE_REAL ) ) )
            {
            // InternalOML.g:8841:2: ( () ( (lv_real_1_0= RULE_REAL ) ) )
            // InternalOML.g:8842:3: () ( (lv_real_1_0= RULE_REAL ) )
            {
            // InternalOML.g:8842:3: ()
            // InternalOML.g:8843:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRealAccess().getLiteralRealAction_0(),
            					current);
            			

            }

            // InternalOML.g:8849:3: ( (lv_real_1_0= RULE_REAL ) )
            // InternalOML.g:8850:4: (lv_real_1_0= RULE_REAL )
            {
            // InternalOML.g:8850:4: (lv_real_1_0= RULE_REAL )
            // InternalOML.g:8851:5: lv_real_1_0= RULE_REAL
            {
            lv_real_1_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

            					newLeafNode(lv_real_1_0, grammarAccess.getLiteralRealAccess().getRealREALTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralRealRule());
            					}
            					setWithLastConsumed(
            						current,
            						"real",
            						lv_real_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.REAL");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralReal"


    // $ANTLR start "entryRuleLiteralRational"
    // InternalOML.g:8871:1: entryRuleLiteralRational returns [EObject current=null] : iv_ruleLiteralRational= ruleLiteralRational EOF ;
    public final EObject entryRuleLiteralRational() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRational = null;


        try {
            // InternalOML.g:8871:56: (iv_ruleLiteralRational= ruleLiteralRational EOF )
            // InternalOML.g:8872:2: iv_ruleLiteralRational= ruleLiteralRational EOF
            {
             newCompositeNode(grammarAccess.getLiteralRationalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralRational=ruleLiteralRational();

            state._fsp--;

             current =iv_ruleLiteralRational; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralRational"


    // $ANTLR start "ruleLiteralRational"
    // InternalOML.g:8878:1: ruleLiteralRational returns [EObject current=null] : ( () ( (lv_rational_1_0= ruleRationalDataType ) ) ) ;
    public final EObject ruleLiteralRational() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_rational_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8884:2: ( ( () ( (lv_rational_1_0= ruleRationalDataType ) ) ) )
            // InternalOML.g:8885:2: ( () ( (lv_rational_1_0= ruleRationalDataType ) ) )
            {
            // InternalOML.g:8885:2: ( () ( (lv_rational_1_0= ruleRationalDataType ) ) )
            // InternalOML.g:8886:3: () ( (lv_rational_1_0= ruleRationalDataType ) )
            {
            // InternalOML.g:8886:3: ()
            // InternalOML.g:8887:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRationalAccess().getLiteralRationalAction_0(),
            					current);
            			

            }

            // InternalOML.g:8893:3: ( (lv_rational_1_0= ruleRationalDataType ) )
            // InternalOML.g:8894:4: (lv_rational_1_0= ruleRationalDataType )
            {
            // InternalOML.g:8894:4: (lv_rational_1_0= ruleRationalDataType )
            // InternalOML.g:8895:5: lv_rational_1_0= ruleRationalDataType
            {

            					newCompositeNode(grammarAccess.getLiteralRationalAccess().getRationalRationalDataTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_rational_1_0=ruleRationalDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralRationalRule());
            					}
            					set(
            						current,
            						"rational",
            						lv_rational_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.RationalDataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralRational"


    // $ANTLR start "entryRuleRationalDataType"
    // InternalOML.g:8916:1: entryRuleRationalDataType returns [String current=null] : iv_ruleRationalDataType= ruleRationalDataType EOF ;
    public final String entryRuleRationalDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRationalDataType = null;


        try {
            // InternalOML.g:8916:56: (iv_ruleRationalDataType= ruleRationalDataType EOF )
            // InternalOML.g:8917:2: iv_ruleRationalDataType= ruleRationalDataType EOF
            {
             newCompositeNode(grammarAccess.getRationalDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRationalDataType=ruleRationalDataType();

            state._fsp--;

             current =iv_ruleRationalDataType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRationalDataType"


    // $ANTLR start "ruleRationalDataType"
    // InternalOML.g:8923:1: ruleRationalDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RATIONAL_0= RULE_RATIONAL ;
    public final AntlrDatatypeRuleToken ruleRationalDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RATIONAL_0=null;


        	enterRule();

        try {
            // InternalOML.g:8929:2: (this_RATIONAL_0= RULE_RATIONAL )
            // InternalOML.g:8930:2: this_RATIONAL_0= RULE_RATIONAL
            {
            this_RATIONAL_0=(Token)match(input,RULE_RATIONAL,FOLLOW_2); 

            		current.merge(this_RATIONAL_0);
            	

            		newLeafNode(this_RATIONAL_0, grammarAccess.getRationalDataTypeAccess().getRATIONALTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRationalDataType"


    // $ANTLR start "entryRuleLiteralFloat"
    // InternalOML.g:8940:1: entryRuleLiteralFloat returns [EObject current=null] : iv_ruleLiteralFloat= ruleLiteralFloat EOF ;
    public final EObject entryRuleLiteralFloat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFloat = null;


        try {
            // InternalOML.g:8940:53: (iv_ruleLiteralFloat= ruleLiteralFloat EOF )
            // InternalOML.g:8941:2: iv_ruleLiteralFloat= ruleLiteralFloat EOF
            {
             newCompositeNode(grammarAccess.getLiteralFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralFloat=ruleLiteralFloat();

            state._fsp--;

             current =iv_ruleLiteralFloat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFloat"


    // $ANTLR start "ruleLiteralFloat"
    // InternalOML.g:8947:1: ruleLiteralFloat returns [EObject current=null] : ( () ( (lv_float_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleLiteralFloat() throws RecognitionException {
        EObject current = null;

        Token lv_float_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8953:2: ( ( () ( (lv_float_1_0= RULE_FLOAT ) ) ) )
            // InternalOML.g:8954:2: ( () ( (lv_float_1_0= RULE_FLOAT ) ) )
            {
            // InternalOML.g:8954:2: ( () ( (lv_float_1_0= RULE_FLOAT ) ) )
            // InternalOML.g:8955:3: () ( (lv_float_1_0= RULE_FLOAT ) )
            {
            // InternalOML.g:8955:3: ()
            // InternalOML.g:8956:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralFloatAccess().getLiteralFloatAction_0(),
            					current);
            			

            }

            // InternalOML.g:8962:3: ( (lv_float_1_0= RULE_FLOAT ) )
            // InternalOML.g:8963:4: (lv_float_1_0= RULE_FLOAT )
            {
            // InternalOML.g:8963:4: (lv_float_1_0= RULE_FLOAT )
            // InternalOML.g:8964:5: lv_float_1_0= RULE_FLOAT
            {
            lv_float_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

            					newLeafNode(lv_float_1_0, grammarAccess.getLiteralFloatAccess().getFloatFLOATTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralFloatRule());
            					}
            					setWithLastConsumed(
            						current,
            						"float",
            						lv_float_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.FLOAT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFloat"


    // $ANTLR start "entryRuleLiteralDecimal"
    // InternalOML.g:8984:1: entryRuleLiteralDecimal returns [EObject current=null] : iv_ruleLiteralDecimal= ruleLiteralDecimal EOF ;
    public final EObject entryRuleLiteralDecimal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralDecimal = null;


        try {
            // InternalOML.g:8984:55: (iv_ruleLiteralDecimal= ruleLiteralDecimal EOF )
            // InternalOML.g:8985:2: iv_ruleLiteralDecimal= ruleLiteralDecimal EOF
            {
             newCompositeNode(grammarAccess.getLiteralDecimalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralDecimal=ruleLiteralDecimal();

            state._fsp--;

             current =iv_ruleLiteralDecimal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralDecimal"


    // $ANTLR start "ruleLiteralDecimal"
    // InternalOML.g:8991:1: ruleLiteralDecimal returns [EObject current=null] : ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) ) ;
    public final EObject ruleLiteralDecimal() throws RecognitionException {
        EObject current = null;

        Token lv_decimal_1_0=null;
        Token lv_decimal_2_0=null;


        	enterRule();

        try {
            // InternalOML.g:8997:2: ( ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) ) )
            // InternalOML.g:8998:2: ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) )
            {
            // InternalOML.g:8998:2: ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_DIGITS) ) {
                alt109=1;
            }
            else if ( (LA109_0==RULE_DECIMAL) ) {
                alt109=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalOML.g:8999:3: ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) )
                    {
                    // InternalOML.g:8999:3: ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) )
                    // InternalOML.g:9000:4: () ( (lv_decimal_1_0= RULE_DIGITS ) )
                    {
                    // InternalOML.g:9000:4: ()
                    // InternalOML.g:9001:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLiteralDecimalAccess().getLiteralDecimalAction_0_0(),
                    						current);
                    				

                    }

                    // InternalOML.g:9007:4: ( (lv_decimal_1_0= RULE_DIGITS ) )
                    // InternalOML.g:9008:5: (lv_decimal_1_0= RULE_DIGITS )
                    {
                    // InternalOML.g:9008:5: (lv_decimal_1_0= RULE_DIGITS )
                    // InternalOML.g:9009:6: lv_decimal_1_0= RULE_DIGITS
                    {
                    lv_decimal_1_0=(Token)match(input,RULE_DIGITS,FOLLOW_2); 

                    						newLeafNode(lv_decimal_1_0, grammarAccess.getLiteralDecimalAccess().getDecimalDIGITSTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralDecimalRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"decimal",
                    							lv_decimal_1_0,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:9027:3: ( (lv_decimal_2_0= RULE_DECIMAL ) )
                    {
                    // InternalOML.g:9027:3: ( (lv_decimal_2_0= RULE_DECIMAL ) )
                    // InternalOML.g:9028:4: (lv_decimal_2_0= RULE_DECIMAL )
                    {
                    // InternalOML.g:9028:4: (lv_decimal_2_0= RULE_DECIMAL )
                    // InternalOML.g:9029:5: lv_decimal_2_0= RULE_DECIMAL
                    {
                    lv_decimal_2_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    					newLeafNode(lv_decimal_2_0, grammarAccess.getLiteralDecimalAccess().getDecimalDECIMALTerminalRuleCall_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getLiteralDecimalRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"decimal",
                    						lv_decimal_2_0,
                    						"gov.nasa.jpl.imce.oml.dsl.OML.DECIMAL");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralDecimal"


    // $ANTLR start "entryRulePositiveIntegerLiteral"
    // InternalOML.g:9049:1: entryRulePositiveIntegerLiteral returns [String current=null] : iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF ;
    public final String entryRulePositiveIntegerLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveIntegerLiteral = null;


        try {
            // InternalOML.g:9049:62: (iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF )
            // InternalOML.g:9050:2: iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF
            {
             newCompositeNode(grammarAccess.getPositiveIntegerLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePositiveIntegerLiteral=rulePositiveIntegerLiteral();

            state._fsp--;

             current =iv_rulePositiveIntegerLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositiveIntegerLiteral"


    // $ANTLR start "rulePositiveIntegerLiteral"
    // InternalOML.g:9056:1: rulePositiveIntegerLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DIGITS_0= RULE_DIGITS ;
    public final AntlrDatatypeRuleToken rulePositiveIntegerLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DIGITS_0=null;


        	enterRule();

        try {
            // InternalOML.g:9062:2: (this_DIGITS_0= RULE_DIGITS )
            // InternalOML.g:9063:2: this_DIGITS_0= RULE_DIGITS
            {
            this_DIGITS_0=(Token)match(input,RULE_DIGITS,FOLLOW_2); 

            		current.merge(this_DIGITS_0);
            	

            		newLeafNode(this_DIGITS_0, grammarAccess.getPositiveIntegerLiteralAccess().getDIGITSTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositiveIntegerLiteral"


    // $ANTLR start "ruleTerminologyKind"
    // InternalOML.g:9073:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:9079:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:9080:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:9080:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==161) ) {
                alt110=1;
            }
            else if ( (LA110_0==162) ) {
                alt110=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalOML.g:9081:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:9081:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:9082:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,161,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:9089:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:9089:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:9090:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,162,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTerminologyKindAccess().getClosedWorldDesignationsEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerminologyKind"


    // $ANTLR start "ruleDescriptionKind"
    // InternalOML.g:9100:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:9106:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:9107:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:9107:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==163) ) {
                alt111=1;
            }
            else if ( (LA111_0==164) ) {
                alt111=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalOML.g:9108:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:9108:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:9109:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,163,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:9116:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:9116:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:9117:4: enumLiteral_1= 'partial'
                    {
                    enumLiteral_1=(Token)match(input,164,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDescriptionKindAccess().getPartialEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescriptionKind"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA95 dfa95 = new DFA95(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\105\2\4\2\uffff\2\106\1\5\1\14\1\105\2\107";
    static final String dfa_3s = "\1\u00a4\2\4\2\uffff\2\106\1\5\1\15\3\u00a4";
    static final String dfa_4s = "\3\uffff\1\1\1\2\7\uffff";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\2\131\uffff\2\3\2\4",
            "\1\5",
            "\1\6",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\13",
            "\1\1\1\uffff\1\2\131\uffff\2\3\2\4",
            "\1\2\131\uffff\2\3\2\4",
            "\1\2\131\uffff\2\3\2\4"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "259:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )";
        }
    }
    static final String dfa_7s = "\16\uffff";
    static final String dfa_8s = "\1\105\2\4\2\110\2\106\2\uffff\1\5\1\14\1\105\2\107";
    static final String dfa_9s = "\1\u00a2\2\4\2\113\2\106\2\uffff\1\5\1\15\3\u00a2";
    static final String dfa_10s = "\7\uffff\1\1\1\2\5\uffff";
    static final String dfa_11s = "\16\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\1\uffff\1\2\131\uffff\1\3\1\4",
            "\1\5",
            "\1\6",
            "\1\10\2\uffff\1\7",
            "\1\10\2\uffff\1\7",
            "\1\11",
            "\1\12",
            "",
            "",
            "\1\13",
            "\1\14\1\15",
            "\1\1\1\uffff\1\2\131\uffff\1\3\1\4",
            "\1\2\131\uffff\1\3\1\4",
            "\1\2\131\uffff\1\3\1\4"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "295:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )";
        }
    }
    static final String dfa_13s = "\11\uffff";
    static final String dfa_14s = "\1\4\1\uffff\1\4\2\uffff\1\106\1\14\2\4";
    static final String dfa_15s = "\1\u009b\1\uffff\1\4\2\uffff\1\106\1\15\2\u009b";
    static final String dfa_16s = "\1\uffff\1\3\1\uffff\1\1\1\2\4\uffff";
    static final String dfa_17s = "\11\uffff}>";
    static final String[] dfa_18s = {
            "\3\4\100\uffff\1\2\2\uffff\1\1\3\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\4\4\13\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\3\4\100\uffff\1\2\6\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\3\4\14\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "\3\4\100\uffff\1\2\6\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\3\4\14\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 415:3: ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )*";
        }
    }
    static final String dfa_19s = "\13\uffff";
    static final String dfa_20s = "\1\4\1\uffff\1\4\4\uffff\1\106\1\14\2\4";
    static final String dfa_21s = "\1\u009b\1\uffff\1\4\4\uffff\1\106\1\15\2\u009b";
    static final String dfa_22s = "\1\uffff\1\5\1\uffff\1\1\1\2\1\3\1\4\4\uffff";
    static final String dfa_23s = "\13\uffff}>";
    static final String[] dfa_24s = {
            "\3\4\100\uffff\1\2\2\uffff\1\1\2\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\4\4\11\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11\1\12",
            "\3\4\100\uffff\1\2\5\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\3\4\12\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "\3\4\100\uffff\1\2\5\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\5\4\3\uffff\3\4\12\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "()* loopback of 562:3: ( ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )*";
        }
    }
    static final String dfa_25s = "\30\uffff";
    static final String dfa_26s = "\1\4\1\uffff\1\4\7\uffff\3\175\1\106\1\4\1\14\3\106\2\4\1\11\2\uffff";
    static final String dfa_27s = "\1\u00a0\1\uffff\1\4\7\uffff\3\175\1\106\1\6\1\15\3\106\2\u00a0\1\111\2\uffff";
    static final String dfa_28s = "\1\uffff\1\12\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\14\uffff\1\11\1\10";
    static final String dfa_29s = "\30\uffff}>";
    static final String[] dfa_30s = {
            "\1\13\1\12\1\14\100\uffff\1\2\2\uffff\1\1\6\uffff\1\3\31\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\17",
            "\1\21\1\20\1\22",
            "\1\23\1\24",
            "\1\25",
            "\1\25",
            "\1\25",
            "\1\13\1\12\1\14\100\uffff\1\2\11\uffff\1\3\31\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "\1\13\1\12\1\14\100\uffff\1\2\11\uffff\1\3\31\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "\14\27\64\uffff\1\26",
            "",
            ""
    };

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "()* loopback of 749:3: ( ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_31s = "\1\107\1\4\3\uffff\1\106\1\14\2\107";
    static final String dfa_32s = "\1\122\1\4\3\uffff\1\106\1\15\2\122";
    static final String dfa_33s = "\2\uffff\1\1\1\2\1\3\4\uffff";
    static final String[] dfa_34s = {
            "\1\1\6\uffff\1\2\2\uffff\1\3\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\1\1\6\uffff\1\2\2\uffff\1\3\1\4",
            "\1\1\6\uffff\1\2\2\uffff\1\3\1\4"
    };
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_17;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "952:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )";
        }
    }
    static final String dfa_35s = "\10\uffff";
    static final String dfa_36s = "\2\4\2\uffff\1\106\1\14\2\4";
    static final String dfa_37s = "\1\u009b\1\4\2\uffff\1\106\1\15\2\u009b";
    static final String dfa_38s = "\2\uffff\1\1\1\2\4\uffff";
    static final String dfa_39s = "\10\uffff}>";
    static final String[] dfa_40s = {
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\5\3\3\uffff\4\3\13\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\5\3\3\uffff\3\3\14\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3",
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\5\3\3\uffff\3\3\14\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3"
    };

    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "1293:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )";
        }
    }
    static final String dfa_41s = "\1\107\1\4\5\uffff\1\106\1\14\2\107";
    static final String dfa_42s = "\1\u009b\1\4\5\uffff\1\106\1\15\2\u009b";
    static final String dfa_43s = "\2\uffff\1\1\1\2\1\3\1\4\1\5\4\uffff";
    static final String[] dfa_44s = {
            "\1\1\15\uffff\2\2\1\3\15\uffff\2\3\2\4\1\5\3\uffff\3\5\1\6\30\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4",
            "\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11\1\12",
            "\1\1\15\uffff\2\2\1\3\15\uffff\2\3\2\4\1\5\3\uffff\3\5\31\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4",
            "\1\1\15\uffff\2\2\1\3\15\uffff\2\3\2\4\1\5\3\uffff\3\5\31\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4"
    };
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_23;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "1329:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship | this_Rule_4= ruleRule )";
        }
    }
    static final String dfa_45s = "\1\107\1\4\2\uffff\1\106\1\14\2\107";
    static final String dfa_46s = "\1\126\1\4\2\uffff\1\106\1\15\2\126";
    static final String[] dfa_47s = {
            "\1\1\15\uffff\1\2\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\15\uffff\1\2\1\3",
            "\1\1\15\uffff\1\2\1\3"
    };
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "1392:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )";
        }
    }
    static final String dfa_48s = "\1\146\1\4\3\uffff\1\106\1\15\2\146";
    static final String[] dfa_49s = {
            "\1\1\17\uffff\1\2\15\uffff\1\3\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\1\1\17\uffff\1\2\15\uffff\1\3\1\4",
            "\1\1\17\uffff\1\2\15\uffff\1\3\1\4"
    };
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_31;
            this.max = dfa_48;
            this.accept = dfa_33;
            this.special = dfa_17;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_ReifiedRelationshipRestriction_1= ruleReifiedRelationshipRestriction | this_UnreifiedRelationship_2= ruleUnreifiedRelationship )";
        }
    }
    static final String[] dfa_50s = {
            "\1\1\37\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\37\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2",
            "\1\1\37\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2"
    };
    static final short[][] dfa_50 = unpackEncodedStringArray(dfa_50s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_50;
        }
        public String getDescription() {
            return "1473:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )";
        }
    }
    static final String[] dfa_51s = {
            "\1\1\37\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\37\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3",
            "\1\1\37\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3"
    };
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "1509:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )";
        }
    }
    static final String dfa_52s = "\1\107\1\4\10\uffff\1\106\1\14\2\107";
    static final String dfa_53s = "\1\u009b\1\4\10\uffff\1\106\1\15\2\u009b";
    static final String dfa_54s = "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff";
    static final String[] dfa_55s = {
            "\1\1\101\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11",
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14\1\15",
            "\1\1\101\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11",
            "\1\1\101\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11"
    };
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[][] dfa_55 = unpackEncodedStringArray(dfa_55s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_11;
            this.transition = dfa_55;
        }
        public String getDescription() {
            return "1545:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )";
        }
    }
    static final String dfa_56s = "\12\uffff";
    static final String dfa_57s = "\1\107\1\4\4\uffff\1\106\1\14\2\107";
    static final String dfa_58s = "\1\157\1\4\4\uffff\1\106\1\15\2\157";
    static final String dfa_59s = "\2\uffff\1\1\1\2\1\3\1\4\4\uffff";
    static final String dfa_60s = "\12\uffff}>";
    static final String[] dfa_61s = {
            "\1\1\41\uffff\1\2\3\uffff\1\3\1\4\1\5",
            "\1\6",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10\1\11",
            "\1\1\41\uffff\1\2\3\uffff\1\3\1\4\1\5",
            "\1\1\41\uffff\1\2\3\uffff\1\3\1\4\1\5"
    };

    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final char[] dfa_57 = DFA.unpackEncodedStringToUnsignedChars(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[][] dfa_61 = unpackEncodedStringArray(dfa_61s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_56;
            this.eof = dfa_56;
            this.min = dfa_57;
            this.max = dfa_58;
            this.accept = dfa_59;
            this.special = dfa_60;
            this.transition = dfa_61;
        }
        public String getDescription() {
            return "1635:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )";
        }
    }
    static final String dfa_62s = "\31\uffff";
    static final String dfa_63s = "\2\4\2\uffff\1\4\1\uffff\3\u0080\1\106\3\175\3\uffff\1\14\3\4\3\106\1\11\1\uffff";
    static final String dfa_64s = "\1\u0098\1\4\2\uffff\1\6\1\uffff\3\u0084\1\106\3\175\3\uffff\1\15\1\6\2\u0098\3\106\1\111\1\uffff";
    static final String dfa_65s = "\2\uffff\1\1\1\2\1\uffff\1\4\7\uffff\1\5\1\6\1\7\10\uffff\1\3";
    static final String dfa_66s = "\31\uffff}>";
    static final String[] dfa_67s = {
            "\1\7\1\6\1\10\100\uffff\1\1\64\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
            "\1\11",
            "",
            "",
            "\1\13\1\12\1\14",
            "",
            "\3\15\1\16\1\17",
            "\3\15\1\16\1\17",
            "\3\15\1\16\1\17",
            "\1\20",
            "\1\21",
            "\1\21",
            "\1\21",
            "",
            "",
            "",
            "\1\22\1\23",
            "\1\25\1\24\1\26",
            "\1\7\1\6\1\10\100\uffff\1\1\64\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
            "\1\7\1\6\1\10\100\uffff\1\1\64\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
            "\1\27",
            "\1\27",
            "\1\27",
            "\14\3\64\uffff\1\30",
            ""
    };

    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final short[][] dfa_67 = unpackEncodedStringArray(dfa_67s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_62;
            this.eof = dfa_62;
            this.min = dfa_63;
            this.max = dfa_64;
            this.accept = dfa_65;
            this.special = dfa_66;
            this.transition = dfa_67;
        }
        public String getDescription() {
            return "1689:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )";
        }
    }
    static final String dfa_68s = "\1\177\1\4\2\uffff\1\106\1\15\2\177";
    static final String[] dfa_69s = {
            "\1\1\64\uffff\1\2\2\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\64\uffff\1\2\2\uffff\1\3",
            "\1\1\64\uffff\1\2\2\uffff\1\3"
    };
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[][] dfa_69 = unpackEncodedStringArray(dfa_69s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_68;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "1770:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_70s = "\1\u0088\1\4\3\uffff\1\106\1\15\2\u0088";
    static final String[] dfa_71s = {
            "\1\1\75\uffff\1\2\1\3\1\uffff\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\1\1\75\uffff\1\2\1\3\1\uffff\1\4",
            "\1\1\75\uffff\1\2\1\3\1\uffff\1\4"
    };
    static final char[] dfa_70 = DFA.unpackEncodedStringToUnsignedChars(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_31;
            this.max = dfa_70;
            this.accept = dfa_33;
            this.special = dfa_17;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "1806:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_72s = "\2\4\3\u0080\1\106\3\uffff\1\14\2\4";
    static final String dfa_73s = "\1\107\1\4\3\u0082\1\106\3\uffff\1\15\2\107";
    static final String dfa_74s = "\6\uffff\1\1\1\3\1\2\3\uffff";
    static final String[] dfa_75s = {
            "\1\3\1\2\1\4\100\uffff\1\1",
            "\1\5",
            "\1\10\1\6\1\7",
            "\1\10\1\6\1\7",
            "\1\10\1\6\1\7",
            "\1\11",
            "",
            "",
            "",
            "\1\12\1\13",
            "\1\3\1\2\1\4\100\uffff\1\1",
            "\1\3\1\2\1\4\100\uffff\1\1"
    };
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final char[] dfa_73 = DFA.unpackEncodedStringToUnsignedChars(dfa_73s);
    static final short[] dfa_74 = DFA.unpackEncodedString(dfa_74s);
    static final short[][] dfa_75 = unpackEncodedStringArray(dfa_75s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_72;
            this.max = dfa_73;
            this.accept = dfa_74;
            this.special = dfa_5;
            this.transition = dfa_75;
        }
        public String getDescription() {
            return "1876:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )";
        }
    }
    static final String dfa_76s = "\1\173\1\4\2\uffff\1\106\1\15\2\173";
    static final String[] dfa_77s = {
            "\1\1\61\uffff\1\2\1\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\61\uffff\1\2\1\uffff\1\3",
            "\1\1\61\uffff\1\2\1\uffff\1\3"
    };
    static final char[] dfa_76 = DFA.unpackEncodedStringToUnsignedChars(dfa_76s);
    static final short[][] dfa_77 = unpackEncodedStringArray(dfa_77s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_76;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_77;
        }
        public String getDescription() {
            return "1971:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )";
        }
    }
    static final String dfa_78s = "\1\130\12\uffff";
    static final String dfa_79s = "\1\141\12\uffff";
    static final String dfa_80s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_81s = "\1\0\12\uffff}>";
    static final String[] dfa_82s = {
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_78 = DFA.unpackEncodedStringToUnsignedChars(dfa_78s);
    static final char[] dfa_79 = DFA.unpackEncodedStringToUnsignedChars(dfa_79s);
    static final short[] dfa_80 = DFA.unpackEncodedString(dfa_80s);
    static final short[] dfa_81 = DFA.unpackEncodedString(dfa_81s);
    static final short[][] dfa_82 = unpackEncodedStringArray(dfa_82s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_78;
            this.max = dfa_79;
            this.accept = dfa_80;
            this.special = dfa_81;
            this.transition = dfa_82;
        }
        public String getDescription() {
            return "()* loopback of 2179:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_0 = input.LA(1);

                         
                        int index34_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA34_0==97) ) {s = 1;}

                        else if ( LA34_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA34_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA34_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA34_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA34_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA34_0 == 93 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA34_0 == 94 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA34_0 == 95 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA34_0 == 96 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                         
                        input.seek(index34_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_83s = "\1\143\12\uffff";
    static final String[] dfa_84s = {
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final short[][] dfa_84 = unpackEncodedStringArray(dfa_84s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_78;
            this.max = dfa_83;
            this.accept = dfa_80;
            this.special = dfa_81;
            this.transition = dfa_84;
        }
        public String getDescription() {
            return "()* loopback of 2758:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_0 = input.LA(1);

                         
                        int index38_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA38_0==99) ) {s = 1;}

                        else if ( LA38_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA38_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA38_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA38_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA38_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA38_0 == 93 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA38_0 == 94 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA38_0 == 95 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA38_0 == 96 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                         
                        input.seek(index38_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_85s = "\15\uffff";
    static final String dfa_86s = "\1\4\1\uffff\1\4\4\106\1\11\1\14\2\uffff\2\4";
    static final String dfa_87s = "\1\112\1\uffff\1\4\4\106\1\111\1\15\2\uffff\2\107";
    static final String dfa_88s = "\1\uffff\1\3\7\uffff\1\1\1\2\2\uffff";
    static final String dfa_89s = "\15\uffff}>";
    static final String[] dfa_90s = {
            "\1\4\1\3\1\5\100\uffff\1\2\2\uffff\1\1",
            "",
            "\1\6",
            "\1\7",
            "\1\7",
            "\1\7",
            "\1\10",
            "\14\12\64\uffff\1\11",
            "\1\13\1\14",
            "",
            "",
            "\1\4\1\3\1\5\100\uffff\1\2",
            "\1\4\1\3\1\5\100\uffff\1\2"
    };

    static final short[] dfa_85 = DFA.unpackEncodedString(dfa_85s);
    static final char[] dfa_86 = DFA.unpackEncodedStringToUnsignedChars(dfa_86s);
    static final char[] dfa_87 = DFA.unpackEncodedStringToUnsignedChars(dfa_87s);
    static final short[] dfa_88 = DFA.unpackEncodedString(dfa_88s);
    static final short[] dfa_89 = DFA.unpackEncodedString(dfa_89s);
    static final short[][] dfa_90 = unpackEncodedStringArray(dfa_90s);

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 5192:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 5299:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_91s = "\1\u009f\1\4\2\uffff\1\106\1\15\2\u009f";
    static final String[] dfa_92s = {
            "\1\1\125\uffff\1\2\1\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\125\uffff\1\2\1\uffff\1\3",
            "\1\1\125\uffff\1\2\1\uffff\1\3"
    };
    static final char[] dfa_91 = DFA.unpackEncodedStringToUnsignedChars(dfa_91s);
    static final short[][] dfa_92 = unpackEncodedStringArray(dfa_92s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_91;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_92;
        }
        public String getDescription() {
            return "7164:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )";
        }
    }

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 7499:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA95 extends DFA {

        public DFA95(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 95;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 7606:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000A0L,0x0000001E00000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A0L,0x0000000600000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000070L,0x9001E3E000E64480L,0x000000000FA14360L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000070L,0x9401E3E000E66480L,0x000000000FA14360L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x00000000000010A0L,0x0000001E00000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000070L,0x0000180000020480L,0x00000001B0000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002080L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004080L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000080L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800080L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x00000003FF000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000080L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000080L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x00000009FF000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000080L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000080L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000040L,0x0000040000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000080L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000070L,0x01C0001800000080L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0008000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000080L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0A00000000000480L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000080L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000080L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000080L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000020L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000040L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x00000000001FFE00L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000100L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000480L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000003C00L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000004000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000BC00L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000010000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000001E2000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000200000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000040BC00L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000800000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000001000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000002000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000004000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000008000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000010000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000020000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000080000000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000080L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000080L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000100000000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});

}