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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_ID", "RULE_PATTERN", "RULE_LANG_TAG", "RULE_TRUE", "RULE_FALSE", "RULE_DATE_TIME", "RULE_QUOTED_STRING_VALUE", "RULE_RAW_STRING_VALUE", "RULE_UUID", "RULE_URI", "RULE_REAL", "RULE_RATIONAL", "RULE_FLOAT", "RULE_DIGITS", "RULE_DECIMAL", "RULE_DIGIT", "RULE_DIGIT19", "RULE_DIGIT02", "RULE_DIGIT03", "RULE_DIGIT05", "RULE_YEAR_FRAG", "RULE_MONTH_FRAG", "RULE_DAY_FRAG", "RULE_HOUR_FRAG", "RULE_MINUTE_FRAG", "RULE_SECOND_FRAG", "RULE_END_OF_DAY_FRAG", "RULE_TIMEZONE_FRAG", "RULE_ALPHA", "RULE_SCHEME", "RULE_HEX_DIGIT", "RULE_PCT_ENCODED", "RULE_UNRESERVED", "RULE_DIGIT04", "RULE_DEC_OCTET", "RULE_IPV4_ADDRESS", "RULE_IUSER_PART", "RULE_IUSER_INFO", "RULE_IUNRESERVED_PART", "RULE_IUNRESERVED", "RULE_IHOST", "RULE_PORT", "RULE_IAUTHORITY", "RULE_IPCHAR", "RULE_ISEGMENT", "RULE_IPATH", "RULE_IHIER_PART", "RULE_IFRAGMENT", "RULE_CONSTANT_NAME", "RULE_LETTER", "RULE_LETTER_DIGIT", "RULE_LETTER_DIGIT_PREFIX", "RULE_LETTER_DIGIT_SUFFIX", "RULE_ID_PREFIX", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_LETTER", "RULE_HEX", "RULE_DEC", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'descriptionBox'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'rule'", "'infers'", "'if'", "'&&'", "'('", "')'", "'invSource'", "'invTarget'", "'inv'", "'anonymousConceptUnion'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'subObjectPropertyOf'", "'subDataPropertyOf'", "'someData'", "'every'", "'^^'", "'allData'", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
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

                if ( (LA1_0==69||LA1_0==71||(LA1_0>=160 && LA1_0<=163)) ) {
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
    // InternalOML.g:1421:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_UnreifiedRelationship_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1427:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) )
            // InternalOML.g:1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            {
            // InternalOML.g:1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            int alt21=2;
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
                    // InternalOML.g:1438:3: this_UnreifiedRelationship_1= ruleUnreifiedRelationship
                    {

                    			newCompositeNode(grammarAccess.getEntityRelationshipAccess().getUnreifiedRelationshipParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnreifiedRelationship_1=ruleUnreifiedRelationship();

                    state._fsp--;


                    			current = this_UnreifiedRelationship_1;
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
    // InternalOML.g:1450:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOML.g:1450:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOML.g:1451:2: iv_ruleDatatype= ruleDatatype EOF
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
    // InternalOML.g:1457:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1463:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOML.g:1464:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOML.g:1464:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalOML.g:1465:3: this_ScalarDataRange_0= ruleScalarDataRange
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
                    // InternalOML.g:1474:3: this_Structure_1= ruleStructure
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
    // InternalOML.g:1486:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOML.g:1486:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOML.g:1487:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
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
    // InternalOML.g:1493:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1499:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOML.g:1500:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOML.g:1500:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalOML.g:1501:3: this_Scalar_0= ruleScalar
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
                    // InternalOML.g:1510:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
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
    // InternalOML.g:1522:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOML.g:1522:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOML.g:1523:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
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
    // InternalOML.g:1529:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
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
            // InternalOML.g:1535:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOML.g:1536:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOML.g:1536:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt24=8;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalOML.g:1537:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
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
                    // InternalOML.g:1546:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
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
                    // InternalOML.g:1555:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
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
                    // InternalOML.g:1564:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
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
                    // InternalOML.g:1573:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
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
                    // InternalOML.g:1582:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
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
                    // InternalOML.g:1591:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
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
                    // InternalOML.g:1600:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
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
    // InternalOML.g:1612:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOML.g:1612:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOML.g:1613:2: iv_ruleDataRelationship= ruleDataRelationship EOF
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
    // InternalOML.g:1619:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1625:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOML.g:1626:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOML.g:1626:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt25=4;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalOML.g:1627:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
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
                    // InternalOML.g:1636:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
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
                    // InternalOML.g:1645:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
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
                    // InternalOML.g:1654:3: this_ScalarDataProperty_3= ruleScalarDataProperty
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
    // InternalOML.g:1666:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOML.g:1666:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOML.g:1667:2: iv_ruleTermAxiom= ruleTermAxiom EOF
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
    // InternalOML.g:1673:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom ) ;
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
            // InternalOML.g:1679:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom ) )
            // InternalOML.g:1680:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )
            {
            // InternalOML.g:1680:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )
            int alt26=7;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalOML.g:1681:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
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
                    // InternalOML.g:1690:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1699:3: this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1708:3: this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom
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
                    // InternalOML.g:1717:3: this_SpecializationAxiom_4= ruleSpecializationAxiom
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
                    // InternalOML.g:1726:3: this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom
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
                    // InternalOML.g:1735:3: this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom
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
    // InternalOML.g:1747:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1747:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1748:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
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
    // InternalOML.g:1754:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1760:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1761:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1761:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalOML.g:1762:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
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
                    // InternalOML.g:1771:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
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
    // InternalOML.g:1783:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1783:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1784:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1790:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1796:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1797:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1797:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt28=3;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalOML.g:1798:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
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
                    // InternalOML.g:1807:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
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
                    // InternalOML.g:1816:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
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
    // InternalOML.g:1828:1: entryRuleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1828:85: (iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1829:2: iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1835:1: ruleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom ;
    public final EObject ruleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataPropertyParticularRestrictionAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1841:2: (this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom )
            // InternalOML.g:1842:2: this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom
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
    // InternalOML.g:1853:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1853:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1854:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
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
    // InternalOML.g:1860:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1866:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1867:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1867:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalOML.g:1868:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
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
                    // InternalOML.g:1877:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
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
                    // InternalOML.g:1886:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
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
    // InternalOML.g:1898:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1898:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1899:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
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
    // InternalOML.g:1905:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1911:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1912:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
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
    // InternalOML.g:1923:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1923:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1924:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
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
    // InternalOML.g:1930:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1936:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1937:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
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
    // InternalOML.g:1948:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1948:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1949:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
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
    // InternalOML.g:1955:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1961:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1962:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1962:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalOML.g:1963:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
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
                    // InternalOML.g:1972:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
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
    // InternalOML.g:1984:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1984:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1985:2: iv_ruleAspect= ruleAspect EOF
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
    // InternalOML.g:1991:1: ruleAspect returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1997:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:1998:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:1998:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:1999:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:1999:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==71) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:2000:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2000:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2001:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            		
            // InternalOML.g:2022:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2023:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2023:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2024:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2044:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:2044:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:2045:2: iv_ruleConcept= ruleConcept EOF
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
    // InternalOML.g:2051:1: ruleConcept returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2057:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2058:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2058:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2059:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2059:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==71) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOML.g:2060:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2060:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2061:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            		
            // InternalOML.g:2082:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2083:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2083:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2084:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2104:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:2104:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:2105:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
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
    // InternalOML.g:2111:1: ruleReifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) ;
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
            // InternalOML.g:2117:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) )
            // InternalOML.g:2118:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            {
            // InternalOML.g:2118:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            // InternalOML.g:2119:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_forwardProperty_16_0= ruleForwardProperty ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}'
            {
            // InternalOML.g:2119:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==71) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:2120:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2120:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2121:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            		
            // InternalOML.g:2142:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2143:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2143:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2144:5: lv_name_2_0= RULE_ID
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
            		
            // InternalOML.g:2164:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2165:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2165:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2166:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2169:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2170:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2170:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop34:
            do {
                int alt34=10;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // InternalOML.g:2171:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2171:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2172:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2172:116: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2173:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2176:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2176:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2176:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2176:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2176:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2177:10: lv_isFunctional_5_0= 'functional'
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
            	    // InternalOML.g:2194:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2194:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2195:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2195:116: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2196:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2199:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2199:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2199:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2199:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2199:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2200:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
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
            	    // InternalOML.g:2217:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2217:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2218:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2218:116: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2219:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2222:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2222:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2222:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2222:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2222:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2223:10: lv_isEssential_7_0= 'essential'
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
            	    // InternalOML.g:2240:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2240:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2241:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2241:116: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2242:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2245:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2245:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2245:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2245:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2245:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2246:10: lv_isInverseEssential_8_0= 'inverseEssential'
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
            	    // InternalOML.g:2263:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2263:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2264:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2264:116: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2265:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2268:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2268:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2268:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2268:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2268:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2269:10: lv_isSymmetric_9_0= 'symmetric'
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
            	    // InternalOML.g:2286:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2286:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2287:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2287:116: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2288:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2291:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2291:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2291:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2291:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2291:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2292:10: lv_isAsymmetric_10_0= 'asymmetric'
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
            	    // InternalOML.g:2309:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2309:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2310:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2310:116: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2311:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2314:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2314:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2314:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2314:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2314:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2315:10: lv_isReflexive_11_0= 'reflexive'
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
            	    // InternalOML.g:2332:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2332:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2333:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2333:116: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2334:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2337:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2337:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2337:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2337:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2337:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2338:10: lv_isIrreflexive_12_0= 'irreflexive'
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
            	    // InternalOML.g:2355:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2355:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2356:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2356:116: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2357:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2360:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2360:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2360:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2360:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2360:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2361:10: lv_isTransitive_13_0= 'transitive'
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
            		
            // InternalOML.g:2393:3: ( (lv_forwardProperty_16_0= ruleForwardProperty ) )
            // InternalOML.g:2394:4: (lv_forwardProperty_16_0= ruleForwardProperty )
            {
            // InternalOML.g:2394:4: (lv_forwardProperty_16_0= ruleForwardProperty )
            // InternalOML.g:2395:5: lv_forwardProperty_16_0= ruleForwardProperty
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

            // InternalOML.g:2412:3: (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==98) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalOML.g:2413:4: otherlv_17= 'inverse' otherlv_18= '=' ( (lv_inverseProperty_19_0= ruleInverseProperty ) )
                    {
                    otherlv_17=(Token)match(input,98,FOLLOW_5); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0());
                    			
                    otherlv_18=(Token)match(input,70,FOLLOW_28); 

                    				newLeafNode(otherlv_18, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalOML.g:2421:4: ( (lv_inverseProperty_19_0= ruleInverseProperty ) )
                    // InternalOML.g:2422:5: (lv_inverseProperty_19_0= ruleInverseProperty )
                    {
                    // InternalOML.g:2422:5: (lv_inverseProperty_19_0= ruleInverseProperty )
                    // InternalOML.g:2423:6: lv_inverseProperty_19_0= ruleInverseProperty
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
            		
            // InternalOML.g:2449:3: ( ( ruleReference ) )
            // InternalOML.g:2450:4: ( ruleReference )
            {
            // InternalOML.g:2450:4: ( ruleReference )
            // InternalOML.g:2451:5: ruleReference
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
            		
            // InternalOML.g:2473:3: ( ( ruleReference ) )
            // InternalOML.g:2474:4: ( ruleReference )
            {
            // InternalOML.g:2474:4: ( ruleReference )
            // InternalOML.g:2475:5: ruleReference
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
    // InternalOML.g:2497:1: entryRuleForwardProperty returns [EObject current=null] : iv_ruleForwardProperty= ruleForwardProperty EOF ;
    public final EObject entryRuleForwardProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForwardProperty = null;


        try {
            // InternalOML.g:2497:56: (iv_ruleForwardProperty= ruleForwardProperty EOF )
            // InternalOML.g:2498:2: iv_ruleForwardProperty= ruleForwardProperty EOF
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
    // InternalOML.g:2504:1: ruleForwardProperty returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleForwardProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOML.g:2510:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalOML.g:2511:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalOML.g:2511:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalOML.g:2512:3: (lv_name_0_0= RULE_ID )
            {
            // InternalOML.g:2512:3: (lv_name_0_0= RULE_ID )
            // InternalOML.g:2513:4: lv_name_0_0= RULE_ID
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
    // InternalOML.g:2532:1: entryRuleInverseProperty returns [EObject current=null] : iv_ruleInverseProperty= ruleInverseProperty EOF ;
    public final EObject entryRuleInverseProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInverseProperty = null;


        try {
            // InternalOML.g:2532:56: (iv_ruleInverseProperty= ruleInverseProperty EOF )
            // InternalOML.g:2533:2: iv_ruleInverseProperty= ruleInverseProperty EOF
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
    // InternalOML.g:2539:1: ruleInverseProperty returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleInverseProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalOML.g:2545:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalOML.g:2546:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalOML.g:2546:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalOML.g:2547:3: (lv_name_0_0= RULE_ID )
            {
            // InternalOML.g:2547:3: (lv_name_0_0= RULE_ID )
            // InternalOML.g:2548:4: lv_name_0_0= RULE_ID
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


    // $ANTLR start "entryRuleUnreifiedRelationship"
    // InternalOML.g:2567:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:2567:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2568:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
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
    // InternalOML.g:2574:1: ruleUnreifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) ;
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
            // InternalOML.g:2580:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) )
            // InternalOML.g:2581:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            {
            // InternalOML.g:2581:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            // InternalOML.g:2582:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}'
            {
            // InternalOML.g:2582:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==71) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:2583:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2583:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2584:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_35);
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
            	    break loop36;
                }
            } while (true);

            otherlv_1=(Token)match(input,101,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1());
            		
            // InternalOML.g:2605:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2606:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2606:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2607:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:2627:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2628:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2628:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2629:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2632:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2633:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2633:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop37:
            do {
                int alt37=10;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // InternalOML.g:2634:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2634:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2635:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2635:118: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2636:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2639:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2639:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2639:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2639:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2639:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2640:10: lv_isFunctional_5_0= 'functional'
            	    {
            	    lv_isFunctional_5_0=(Token)match(input,88,FOLLOW_36); 

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
            	    // InternalOML.g:2657:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2657:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2658:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2658:118: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2659:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2662:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2662:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2662:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2662:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2662:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2663:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_6_0=(Token)match(input,89,FOLLOW_36); 

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
            	    // InternalOML.g:2680:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2680:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2681:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2681:118: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2682:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2685:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2685:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2685:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2685:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2685:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2686:10: lv_isEssential_7_0= 'essential'
            	    {
            	    lv_isEssential_7_0=(Token)match(input,90,FOLLOW_36); 

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
            	    // InternalOML.g:2703:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2703:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2704:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2704:118: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2705:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2708:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2708:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2708:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2708:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2708:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2709:10: lv_isInverseEssential_8_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_8_0=(Token)match(input,91,FOLLOW_36); 

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
            	    // InternalOML.g:2726:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2726:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2727:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2727:118: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2728:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2731:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2731:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2731:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2731:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2731:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2732:10: lv_isSymmetric_9_0= 'symmetric'
            	    {
            	    lv_isSymmetric_9_0=(Token)match(input,92,FOLLOW_36); 

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
            	    // InternalOML.g:2749:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2749:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2750:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2750:118: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2751:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2754:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2754:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2754:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2754:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2754:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2755:10: lv_isAsymmetric_10_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_10_0=(Token)match(input,93,FOLLOW_36); 

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
            	    // InternalOML.g:2772:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2772:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2773:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2773:118: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2774:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2777:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2777:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2777:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2777:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2777:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2778:10: lv_isReflexive_11_0= 'reflexive'
            	    {
            	    lv_isReflexive_11_0=(Token)match(input,94,FOLLOW_36); 

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
            	    // InternalOML.g:2795:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2795:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2796:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2796:118: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2797:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2800:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2800:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2800:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2800:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2800:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2801:10: lv_isIrreflexive_12_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_12_0=(Token)match(input,95,FOLLOW_36); 

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
            	    // InternalOML.g:2818:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2818:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2819:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2819:118: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2820:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2823:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2823:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2823:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2823:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2823:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2824:10: lv_isTransitive_13_0= 'transitive'
            	    {
            	    lv_isTransitive_13_0=(Token)match(input,96,FOLLOW_36); 

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
            	    break loop37;
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
            		
            // InternalOML.g:2856:3: ( ( ruleReference ) )
            // InternalOML.g:2857:4: ( ruleReference )
            {
            // InternalOML.g:2857:4: ( ruleReference )
            // InternalOML.g:2858:5: ruleReference
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
            		
            // InternalOML.g:2880:3: ( ( ruleReference ) )
            // InternalOML.g:2881:4: ( ruleReference )
            {
            // InternalOML.g:2881:4: ( ruleReference )
            // InternalOML.g:2882:5: ruleReference
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
    // InternalOML.g:2904:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:2904:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:2905:2: iv_ruleScalar= ruleScalar EOF
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
    // InternalOML.g:2911:1: ruleScalar returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2917:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2918:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2918:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2919:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2919:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==71) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOML.g:2920:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2920:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2921:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_37);
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
            	    break loop38;
                }
            } while (true);

            otherlv_1=(Token)match(input,102,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarAccess().getScalarKeyword_1());
            		
            // InternalOML.g:2942:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2943:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2943:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2944:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2964:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:2964:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:2965:2: iv_ruleStructure= ruleStructure EOF
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
    // InternalOML.g:2971:1: ruleStructure returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2977:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2978:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2978:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2979:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2979:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==71) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOML.g:2980:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2980:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2981:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStructureAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_38);
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
            	    break loop39;
                }
            } while (true);

            otherlv_1=(Token)match(input,103,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructureAccess().getStructureKeyword_1());
            		
            // InternalOML.g:3002:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3003:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3003:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3004:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:3024:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:3024:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:3025:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
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
    // InternalOML.g:3031:1: ruleEntityStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:3037:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:3038:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:3038:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:3039:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:3039:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==71) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalOML.g:3040:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3040:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3041:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_39);
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
            	    break loop40;
                }
            } while (true);

            otherlv_1=(Token)match(input,104,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:3062:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==105) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalOML.g:3063:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:3063:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:3064:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,105,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:3076:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3077:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3077:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3078:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,73,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,106,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:3102:3: ( ( ruleReference ) )
            // InternalOML.g:3103:4: ( ruleReference )
            {
            // InternalOML.g:3103:4: ( ruleReference )
            // InternalOML.g:3104:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:3122:3: ( ( ruleReference ) )
            // InternalOML.g:3123:4: ( ruleReference )
            {
            // InternalOML.g:3123:4: ( ruleReference )
            // InternalOML.g:3124:5: ruleReference
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
    // InternalOML.g:3146:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:3146:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:3147:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
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
    // InternalOML.g:3153:1: ruleEntityScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:3159:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:3160:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:3160:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:3161:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:3161:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==71) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalOML.g:3162:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3162:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3163:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_43);
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
            	    break loop42;
                }
            } while (true);

            otherlv_1=(Token)match(input,108,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3184:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==105) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalOML.g:3185:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:3185:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:3186:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,105,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:3198:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3199:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3199:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3200:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,73,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,106,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:3224:3: ( ( ruleReference ) )
            // InternalOML.g:3225:4: ( ruleReference )
            {
            // InternalOML.g:3225:4: ( ruleReference )
            // InternalOML.g:3226:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:3244:3: ( ( ruleReference ) )
            // InternalOML.g:3245:4: ( ruleReference )
            {
            // InternalOML.g:3245:4: ( ruleReference )
            // InternalOML.g:3246:5: ruleReference
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
    // InternalOML.g:3268:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:3268:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:3269:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
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
    // InternalOML.g:3275:1: ruleStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:3281:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3282:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3282:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3283:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3283:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==71) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalOML.g:3284:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3284:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3285:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_44);
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
            	    break loop44;
                }
            } while (true);

            otherlv_1=(Token)match(input,109,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:3306:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3307:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3307:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3308:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,106,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3332:3: ( ( ruleReference ) )
            // InternalOML.g:3333:4: ( ruleReference )
            {
            // InternalOML.g:3333:4: ( ruleReference )
            // InternalOML.g:3334:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_5_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3352:3: ( ( ruleReference ) )
            // InternalOML.g:3353:4: ( ruleReference )
            {
            // InternalOML.g:3353:4: ( ruleReference )
            // InternalOML.g:3354:5: ruleReference
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
    // InternalOML.g:3376:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:3376:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:3377:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
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
    // InternalOML.g:3383:1: ruleScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:3389:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3390:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3390:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3391:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3391:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==71) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalOML.g:3392:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3392:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3393:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_45);
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
            	    break loop45;
                }
            } while (true);

            otherlv_1=(Token)match(input,110,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3414:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3415:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3415:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3416:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,106,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3440:3: ( ( ruleReference ) )
            // InternalOML.g:3441:4: ( ruleReference )
            {
            // InternalOML.g:3441:4: ( ruleReference )
            // InternalOML.g:3442:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_5_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3460:3: ( ( ruleReference ) )
            // InternalOML.g:3461:4: ( ruleReference )
            {
            // InternalOML.g:3461:4: ( ruleReference )
            // InternalOML.g:3462:5: ruleReference
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
    // InternalOML.g:3484:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalOML.g:3484:45: (iv_ruleRule= ruleRule EOF )
            // InternalOML.g:3485:2: iv_ruleRule= ruleRule EOF
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
    // InternalOML.g:3491:1: ruleRule returns [EObject current=null] : this_ChainRule_0= ruleChainRule ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChainRule_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3497:2: (this_ChainRule_0= ruleChainRule )
            // InternalOML.g:3498:2: this_ChainRule_0= ruleChainRule
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
    // InternalOML.g:3509:1: entryRuleChainRule returns [EObject current=null] : iv_ruleChainRule= ruleChainRule EOF ;
    public final EObject entryRuleChainRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChainRule = null;


        try {
            // InternalOML.g:3509:50: (iv_ruleChainRule= ruleChainRule EOF )
            // InternalOML.g:3510:2: iv_ruleChainRule= ruleChainRule EOF
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
    // InternalOML.g:3516:1: ruleChainRule returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) ) ;
    public final EObject ruleChainRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_firstSegment_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3522:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) ) )
            // InternalOML.g:3523:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) )
            {
            // InternalOML.g:3523:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) ) )
            // InternalOML.g:3524:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'infers' ( ( ruleReference ) ) otherlv_4= 'if' ( (lv_firstSegment_5_0= ruleRuleBodySegment ) )
            {
            otherlv_0=(Token)match(input,111,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getChainRuleAccess().getRuleKeyword_0());
            		
            // InternalOML.g:3528:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3529:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3529:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3530:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_46); 

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

            otherlv_2=(Token)match(input,112,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getChainRuleAccess().getInfersKeyword_2());
            		
            // InternalOML.g:3550:3: ( ( ruleReference ) )
            // InternalOML.g:3551:4: ( ruleReference )
            {
            // InternalOML.g:3551:4: ( ruleReference )
            // InternalOML.g:3552:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChainRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getChainRuleAccess().getHeadUnreifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_47);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,113,FOLLOW_48); 

            			newLeafNode(otherlv_4, grammarAccess.getChainRuleAccess().getIfKeyword_4());
            		
            // InternalOML.g:3570:3: ( (lv_firstSegment_5_0= ruleRuleBodySegment ) )
            // InternalOML.g:3571:4: (lv_firstSegment_5_0= ruleRuleBodySegment )
            {
            // InternalOML.g:3571:4: (lv_firstSegment_5_0= ruleRuleBodySegment )
            // InternalOML.g:3572:5: lv_firstSegment_5_0= ruleRuleBodySegment
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
    // InternalOML.g:3593:1: entryRuleRuleBodySegment returns [EObject current=null] : iv_ruleRuleBodySegment= ruleRuleBodySegment EOF ;
    public final EObject entryRuleRuleBodySegment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleBodySegment = null;


        try {
            // InternalOML.g:3593:56: (iv_ruleRuleBodySegment= ruleRuleBodySegment EOF )
            // InternalOML.g:3594:2: iv_ruleRuleBodySegment= ruleRuleBodySegment EOF
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
    // InternalOML.g:3600:1: ruleRuleBodySegment returns [EObject current=null] : ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? ) ;
    public final EObject ruleRuleBodySegment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_predicate_0_0 = null;

        EObject lv_nextSegment_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3606:2: ( ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? ) )
            // InternalOML.g:3607:2: ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? )
            {
            // InternalOML.g:3607:2: ( ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )? )
            // InternalOML.g:3608:3: ( (lv_predicate_0_0= ruleSegmentPredicate ) ) (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )?
            {
            // InternalOML.g:3608:3: ( (lv_predicate_0_0= ruleSegmentPredicate ) )
            // InternalOML.g:3609:4: (lv_predicate_0_0= ruleSegmentPredicate )
            {
            // InternalOML.g:3609:4: (lv_predicate_0_0= ruleSegmentPredicate )
            // InternalOML.g:3610:5: lv_predicate_0_0= ruleSegmentPredicate
            {

            					newCompositeNode(grammarAccess.getRuleBodySegmentAccess().getPredicateSegmentPredicateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_49);
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

            // InternalOML.g:3627:3: (otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==114) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalOML.g:3628:4: otherlv_1= '&&' ( (lv_nextSegment_2_0= ruleRuleBodySegment ) )
                    {
                    otherlv_1=(Token)match(input,114,FOLLOW_48); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleBodySegmentAccess().getAmpersandAmpersandKeyword_1_0());
                    			
                    // InternalOML.g:3632:4: ( (lv_nextSegment_2_0= ruleRuleBodySegment ) )
                    // InternalOML.g:3633:5: (lv_nextSegment_2_0= ruleRuleBodySegment )
                    {
                    // InternalOML.g:3633:5: (lv_nextSegment_2_0= ruleRuleBodySegment )
                    // InternalOML.g:3634:6: lv_nextSegment_2_0= ruleRuleBodySegment
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
    // InternalOML.g:3656:1: entryRuleSegmentPredicate returns [EObject current=null] : iv_ruleSegmentPredicate= ruleSegmentPredicate EOF ;
    public final EObject entryRuleSegmentPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSegmentPredicate = null;


        try {
            // InternalOML.g:3656:57: (iv_ruleSegmentPredicate= ruleSegmentPredicate EOF )
            // InternalOML.g:3657:2: iv_ruleSegmentPredicate= ruleSegmentPredicate EOF
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
    // InternalOML.g:3663:1: ruleSegmentPredicate returns [EObject current=null] : ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) ) ;
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
            // InternalOML.g:3669:2: ( ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) ) )
            // InternalOML.g:3670:2: ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) )
            {
            // InternalOML.g:3670:2: ( ( ( ruleQNAME ) ) | (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) | (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' ) | (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' ) | (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' ) | (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' ) )
            int alt47=6;
            switch ( input.LA(1) ) {
            case RULE_ABBREV_IRI:
            case RULE_ID:
                {
                alt47=1;
                }
                break;
            case 99:
                {
                alt47=2;
                }
                break;
            case 117:
                {
                alt47=3;
                }
                break;
            case 100:
                {
                alt47=4;
                }
                break;
            case 118:
                {
                alt47=5;
                }
                break;
            case 119:
                {
                alt47=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalOML.g:3671:3: ( ( ruleQNAME ) )
                    {
                    // InternalOML.g:3671:3: ( ( ruleQNAME ) )
                    // InternalOML.g:3672:4: ( ruleQNAME )
                    {
                    // InternalOML.g:3672:4: ( ruleQNAME )
                    // InternalOML.g:3673:5: ruleQNAME
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
                    // InternalOML.g:3688:3: (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
                    {
                    // InternalOML.g:3688:3: (otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
                    // InternalOML.g:3689:4: otherlv_1= 'source' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,99,FOLLOW_50); 

                    				newLeafNode(otherlv_1, grammarAccess.getSegmentPredicateAccess().getSourceKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,115,FOLLOW_21); 

                    				newLeafNode(otherlv_2, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOML.g:3697:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3698:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3698:5: ( ruleQNAME )
                    // InternalOML.g:3699:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipSourceReifiedRelationshipCrossReference_1_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,116,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOML.g:3719:3: (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' )
                    {
                    // InternalOML.g:3719:3: (otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')' )
                    // InternalOML.g:3720:4: otherlv_5= 'invSource' otherlv_6= '(' ( ( ruleQNAME ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,117,FOLLOW_50); 

                    				newLeafNode(otherlv_5, grammarAccess.getSegmentPredicateAccess().getInvSourceKeyword_2_0());
                    			
                    otherlv_6=(Token)match(input,115,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalOML.g:3728:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3729:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3729:5: ( ruleQNAME )
                    // InternalOML.g:3730:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseSourceReifiedRelationshipCrossReference_2_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,116,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_2_3());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalOML.g:3750:3: (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' )
                    {
                    // InternalOML.g:3750:3: (otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')' )
                    // InternalOML.g:3751:4: otherlv_9= 'target' otherlv_10= '(' ( ( ruleQNAME ) ) otherlv_12= ')'
                    {
                    otherlv_9=(Token)match(input,100,FOLLOW_50); 

                    				newLeafNode(otherlv_9, grammarAccess.getSegmentPredicateAccess().getTargetKeyword_3_0());
                    			
                    otherlv_10=(Token)match(input,115,FOLLOW_21); 

                    				newLeafNode(otherlv_10, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_3_1());
                    			
                    // InternalOML.g:3759:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3760:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3760:5: ( ruleQNAME )
                    // InternalOML.g:3761:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipTargetReifiedRelationshipCrossReference_3_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,116,FOLLOW_2); 

                    				newLeafNode(otherlv_12, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_3_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalOML.g:3781:3: (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' )
                    {
                    // InternalOML.g:3781:3: (otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')' )
                    // InternalOML.g:3782:4: otherlv_13= 'invTarget' otherlv_14= '(' ( ( ruleQNAME ) ) otherlv_16= ')'
                    {
                    otherlv_13=(Token)match(input,118,FOLLOW_50); 

                    				newLeafNode(otherlv_13, grammarAccess.getSegmentPredicateAccess().getInvTargetKeyword_4_0());
                    			
                    otherlv_14=(Token)match(input,115,FOLLOW_21); 

                    				newLeafNode(otherlv_14, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalOML.g:3790:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3791:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3791:5: ( ruleQNAME )
                    // InternalOML.g:3792:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getReifiedRelationshipInverseTargetReifiedRelationshipCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,116,FOLLOW_2); 

                    				newLeafNode(otherlv_16, grammarAccess.getSegmentPredicateAccess().getRightParenthesisKeyword_4_3());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalOML.g:3812:3: (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' )
                    {
                    // InternalOML.g:3812:3: (otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')' )
                    // InternalOML.g:3813:4: otherlv_17= 'inv' otherlv_18= '(' ( ( ruleQNAME ) ) otherlv_20= ')'
                    {
                    otherlv_17=(Token)match(input,119,FOLLOW_50); 

                    				newLeafNode(otherlv_17, grammarAccess.getSegmentPredicateAccess().getInvKeyword_5_0());
                    			
                    otherlv_18=(Token)match(input,115,FOLLOW_21); 

                    				newLeafNode(otherlv_18, grammarAccess.getSegmentPredicateAccess().getLeftParenthesisKeyword_5_1());
                    			
                    // InternalOML.g:3821:4: ( ( ruleQNAME ) )
                    // InternalOML.g:3822:5: ( ruleQNAME )
                    {
                    // InternalOML.g:3822:5: ( ruleQNAME )
                    // InternalOML.g:3823:6: ruleQNAME
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSegmentPredicateRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getSegmentPredicateAccess().getUnreifiedRelationshipInverseUnreifiedRelationshipCrossReference_5_2_0());
                    					
                    pushFollow(FOLLOW_51);
                    ruleQNAME();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,116,FOLLOW_2); 

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
    // InternalOML.g:3846:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:3846:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:3847:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
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
    // InternalOML.g:3853:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:3859:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:3860:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:3860:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:3861:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:3861:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==71) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalOML.g:3862:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3862:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3863:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_52);
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
            	    break loop48;
                }
            } while (true);

            otherlv_1=(Token)match(input,120,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:3888:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3889:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3889:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3890:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_51); 

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

            otherlv_4=(Token)match(input,116,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,73,FOLLOW_53); 

            			newLeafNode(otherlv_5, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:3914:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==71||LA49_0==120||LA49_0==122) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalOML.g:3915:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3915:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3916:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
            	    break loop49;
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
    // InternalOML.g:3941:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:3941:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:3942:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
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
    // InternalOML.g:3948:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:3954:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:3955:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:3955:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:3956:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:3956:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==71) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalOML.g:3957:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3957:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3958:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_54);
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
            	    break loop50;
                }
            } while (true);

            otherlv_1=(Token)match(input,121,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:3983:3: ( ( ruleReference ) )
            // InternalOML.g:3984:4: ( ruleReference )
            {
            // InternalOML.g:3984:4: ( ruleReference )
            // InternalOML.g:3985:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,116,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,73,FOLLOW_53); 

            			newLeafNode(otherlv_5, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:4007:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==71||LA51_0==120||LA51_0==122) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalOML.g:4008:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:4008:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:4009:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
            	    break loop51;
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
    // InternalOML.g:4034:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:4034:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:4035:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
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
    // InternalOML.g:4041:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4047:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' ) )
            // InternalOML.g:4048:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
            {
            // InternalOML.g:4048:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')' )
            // InternalOML.g:4049:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleQNAME ) ) otherlv_4= ')'
            {
            // InternalOML.g:4049:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==71) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalOML.g:4050:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4050:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4051:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_55);
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
            	    break loop52;
                }
            } while (true);

            otherlv_1=(Token)match(input,122,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:4076:3: ( ( ruleQNAME ) )
            // InternalOML.g:4077:4: ( ruleQNAME )
            {
            // InternalOML.g:4077:4: ( ruleQNAME )
            // InternalOML.g:4078:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,116,FOLLOW_2); 

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
    // InternalOML.g:4100:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:4100:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:4101:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
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
    // InternalOML.g:4107:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4113:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) )
            // InternalOML.g:4114:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            {
            // InternalOML.g:4114:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            // InternalOML.g:4115:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) )
            {
            // InternalOML.g:4115:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==71) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalOML.g:4116:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4116:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4117:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_56);
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
            	    break loop53;
                }
            } while (true);

            otherlv_1=(Token)match(input,123,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1());
            		
            // InternalOML.g:4138:3: ( ( ruleQNAME ) )
            // InternalOML.g:4139:4: ( ruleQNAME )
            {
            // InternalOML.g:4139:4: ( ruleQNAME )
            // InternalOML.g:4140:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4158:3: ( ( ruleQNAME ) )
            // InternalOML.g:4159:4: ( ruleQNAME )
            {
            // InternalOML.g:4159:4: ( ruleQNAME )
            // InternalOML.g:4160:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_58);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4178:3: ( ( ruleQNAME ) )
            // InternalOML.g:4179:4: ( ruleQNAME )
            {
            // InternalOML.g:4179:4: ( ruleQNAME )
            // InternalOML.g:4180:5: ruleQNAME
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
    // InternalOML.g:4198:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:4198:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:4199:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
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
    // InternalOML.g:4205:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4211:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) ) )
            // InternalOML.g:4212:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            {
            // InternalOML.g:4212:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) ) )
            // InternalOML.g:4213:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleQNAME ) ) otherlv_3= '.' ( ( ruleQNAME ) ) otherlv_5= 'in' ( ( ruleQNAME ) )
            {
            // InternalOML.g:4213:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==71) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalOML.g:4214:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4214:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4215:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_59);
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
            	    break loop54;
                }
            } while (true);

            otherlv_1=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1());
            		
            // InternalOML.g:4236:3: ( ( ruleQNAME ) )
            // InternalOML.g:4237:4: ( ruleQNAME )
            {
            // InternalOML.g:4237:4: ( ruleQNAME )
            // InternalOML.g:4238:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4256:3: ( ( ruleQNAME ) )
            // InternalOML.g:4257:4: ( ruleQNAME )
            {
            // InternalOML.g:4257:4: ( ruleQNAME )
            // InternalOML.g:4258:5: ruleQNAME
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationshipRestrictableRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_58);
            ruleQNAME();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4276:3: ( ( ruleQNAME ) )
            // InternalOML.g:4277:4: ( ruleQNAME )
            {
            // InternalOML.g:4277:4: ( ruleQNAME )
            // InternalOML.g:4278:5: ruleQNAME
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
    // InternalOML.g:4296:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:4296:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:4297:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
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
    // InternalOML.g:4303:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4309:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:4310:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4310:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:4311:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:4311:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==71) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalOML.g:4312:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4312:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4313:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop55;
                }
            } while (true);

            // InternalOML.g:4330:3: ( ( ruleReference ) )
            // InternalOML.g:4331:4: ( ruleReference )
            {
            // InternalOML.g:4331:4: ( ruleReference )
            // InternalOML.g:4332:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_60);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,127,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2());
            		
            // InternalOML.g:4350:3: ( ( ruleReference ) )
            // InternalOML.g:4351:4: ( ruleReference )
            {
            // InternalOML.g:4351:4: ( ruleReference )
            // InternalOML.g:4352:5: ruleReference
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
    // InternalOML.g:4370:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:4370:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:4371:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
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
    // InternalOML.g:4377:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4383:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:4384:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4384:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:4385:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:4385:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==71) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalOML.g:4386:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4386:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4387:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop56;
                }
            } while (true);

            // InternalOML.g:4404:3: ( ( ruleReference ) )
            // InternalOML.g:4405:4: ( ruleReference )
            {
            // InternalOML.g:4405:4: ( ruleReference )
            // InternalOML.g:4406:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0());
            				
            pushFollow(FOLLOW_61);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,128,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2());
            		
            // InternalOML.g:4424:3: ( ( ruleReference ) )
            // InternalOML.g:4425:4: ( ruleReference )
            {
            // InternalOML.g:4425:4: ( ruleReference )
            // InternalOML.g:4426:5: ruleReference
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
    // InternalOML.g:4444:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:4444:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:4445:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
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
    // InternalOML.g:4451:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4457:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:4458:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4458:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:4459:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:4459:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==71) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalOML.g:4460:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4460:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4461:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop57;
                }
            } while (true);

            // InternalOML.g:4478:3: ( ( ruleReference ) )
            // InternalOML.g:4479:4: ( ruleReference )
            {
            // InternalOML.g:4479:4: ( ruleReference )
            // InternalOML.g:4480:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_1_0());
            				
            pushFollow(FOLLOW_62);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,129,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2());
            		
            // InternalOML.g:4498:3: ( ( ruleReference ) )
            // InternalOML.g:4499:4: ( ruleReference )
            {
            // InternalOML.g:4499:4: ( ruleReference )
            // InternalOML.g:4500:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_3_0());
            				
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
    // InternalOML.g:4518:1: entryRuleSubObjectPropertyOfAxiom returns [EObject current=null] : iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF ;
    public final EObject entryRuleSubObjectPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubObjectPropertyOfAxiom = null;


        try {
            // InternalOML.g:4518:65: (iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF )
            // InternalOML.g:4519:2: iv_ruleSubObjectPropertyOfAxiom= ruleSubObjectPropertyOfAxiom EOF
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
    // InternalOML.g:4525:1: ruleSubObjectPropertyOfAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) ) ;
    public final EObject ruleSubObjectPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4531:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) ) )
            // InternalOML.g:4532:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4532:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) ) )
            // InternalOML.g:4533:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subObjectPropertyOf' ( ( ruleReference ) )
            {
            // InternalOML.g:4533:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==71) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalOML.g:4534:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4534:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4535:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop58;
                }
            } while (true);

            // InternalOML.g:4552:3: ( ( ruleReference ) )
            // InternalOML.g:4553:4: ( ruleReference )
            {
            // InternalOML.g:4553:4: ( ruleReference )
            // InternalOML.g:4554:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubObjectPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubPropertyUnreifiedRelationshipCrossReference_1_0());
            				
            pushFollow(FOLLOW_63);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,130,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSubObjectPropertyOfAxiomAccess().getSubObjectPropertyOfKeyword_2());
            		
            // InternalOML.g:4572:3: ( ( ruleReference ) )
            // InternalOML.g:4573:4: ( ruleReference )
            {
            // InternalOML.g:4573:4: ( ruleReference )
            // InternalOML.g:4574:5: ruleReference
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
    // InternalOML.g:4592:1: entryRuleSubDataPropertyOfAxiom returns [EObject current=null] : iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF ;
    public final EObject entryRuleSubDataPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubDataPropertyOfAxiom = null;


        try {
            // InternalOML.g:4592:63: (iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF )
            // InternalOML.g:4593:2: iv_ruleSubDataPropertyOfAxiom= ruleSubDataPropertyOfAxiom EOF
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
    // InternalOML.g:4599:1: ruleSubDataPropertyOfAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) ) ;
    public final EObject ruleSubDataPropertyOfAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4605:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) ) )
            // InternalOML.g:4606:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4606:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) ) )
            // InternalOML.g:4607:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'subDataPropertyOf' ( ( ruleReference ) )
            {
            // InternalOML.g:4607:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==71) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalOML.g:4608:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4608:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4609:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop59;
                }
            } while (true);

            // InternalOML.g:4626:3: ( ( ruleReference ) )
            // InternalOML.g:4627:4: ( ruleReference )
            {
            // InternalOML.g:4627:4: ( ruleReference )
            // InternalOML.g:4628:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubDataPropertyOfAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubDataPropertyOfAxiomAccess().getSubPropertyEntityScalarDataPropertyCrossReference_1_0());
            				
            pushFollow(FOLLOW_64);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,131,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSubDataPropertyOfAxiomAccess().getSubDataPropertyOfKeyword_2());
            		
            // InternalOML.g:4646:3: ( ( ruleReference ) )
            // InternalOML.g:4647:4: ( ruleReference )
            {
            // InternalOML.g:4647:4: ( ruleReference )
            // InternalOML.g:4648:5: ruleReference
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
    // InternalOML.g:4666:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:4666:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:4667:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
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
    // InternalOML.g:4673:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4679:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:4680:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4680:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:4681:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:4681:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==71) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalOML.g:4682:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4682:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4683:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_65);
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
            	    break loop60;
                }
            } while (true);

            otherlv_1=(Token)match(input,132,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1());
            		
            // InternalOML.g:4704:3: ( ( ruleReference ) )
            // InternalOML.g:4705:4: ( ruleReference )
            {
            // InternalOML.g:4705:4: ( ruleReference )
            // InternalOML.g:4706:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4724:3: ( ( ruleReference ) )
            // InternalOML.g:4725:4: ( ruleReference )
            {
            // InternalOML.g:4725:4: ( ruleReference )
            // InternalOML.g:4726:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4744:3: ( ( ruleReference ) )
            // InternalOML.g:4745:4: ( ruleReference )
            {
            // InternalOML.g:4745:4: ( ruleReference )
            // InternalOML.g:4746:5: ruleReference
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
    // InternalOML.g:4764:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:4764:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:4765:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:4771:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? ) ;
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
            // InternalOML.g:4777:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:4778:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:4778:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:4779:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) (otherlv_7= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:4779:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==71) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalOML.g:4780:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4780:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4781:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    break loop61;
                }
            } while (true);

            otherlv_1=(Token)match(input,133,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:4802:3: ( ( ruleReference ) )
            // InternalOML.g:4803:4: ( ruleReference )
            {
            // InternalOML.g:4803:4: ( ruleReference )
            // InternalOML.g:4804:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4822:3: ( ( ruleReference ) )
            // InternalOML.g:4823:4: ( ruleReference )
            {
            // InternalOML.g:4823:4: ( ruleReference )
            // InternalOML.g:4824:5: ruleReference
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

            otherlv_5=(Token)match(input,70,FOLLOW_67); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:4842:3: ( (lv_literalValue_6_0= ruleLiteralValue ) )
            // InternalOML.g:4843:4: (lv_literalValue_6_0= ruleLiteralValue )
            {
            // InternalOML.g:4843:4: (lv_literalValue_6_0= ruleLiteralValue )
            // InternalOML.g:4844:5: lv_literalValue_6_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalOML.g:4861:3: (otherlv_7= '^^' ( ( ruleReference ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==134) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalOML.g:4862:4: otherlv_7= '^^' ( ( ruleReference ) )
                    {
                    otherlv_7=(Token)match(input,134,FOLLOW_21); 

                    				newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_7_0());
                    			
                    // InternalOML.g:4866:4: ( ( ruleReference ) )
                    // InternalOML.g:4867:5: ( ruleReference )
                    {
                    // InternalOML.g:4867:5: ( ruleReference )
                    // InternalOML.g:4868:6: ruleReference
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
    // InternalOML.g:4887:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:4887:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:4888:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
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
    // InternalOML.g:4894:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4900:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:4901:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4901:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:4902:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:4902:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==71) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalOML.g:4903:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4903:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4904:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_69);
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
            	    break loop63;
                }
            } while (true);

            otherlv_1=(Token)match(input,135,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1());
            		
            // InternalOML.g:4925:3: ( ( ruleReference ) )
            // InternalOML.g:4926:4: ( ruleReference )
            {
            // InternalOML.g:4926:4: ( ruleReference )
            // InternalOML.g:4927:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4945:3: ( ( ruleReference ) )
            // InternalOML.g:4946:4: ( ruleReference )
            {
            // InternalOML.g:4946:4: ( ruleReference )
            // InternalOML.g:4947:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,125,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4965:3: ( ( ruleReference ) )
            // InternalOML.g:4966:4: ( ruleReference )
            {
            // InternalOML.g:4966:4: ( ruleReference )
            // InternalOML.g:4967:5: ruleReference
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
    // InternalOML.g:4985:1: entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:4985:95: (iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:4986:2: iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:4992:1: ruleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) ;
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
            // InternalOML.g:4998:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) )
            // InternalOML.g:4999:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            {
            // InternalOML.g:4999:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            // InternalOML.g:5000:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}'
            {
            // InternalOML.g:5000:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==71) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalOML.g:5001:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5001:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5002:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    break loop64;
                }
            } while (true);

            otherlv_1=(Token)match(input,133,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:5023:3: ( ( ruleReference ) )
            // InternalOML.g:5024:4: ( ruleReference )
            {
            // InternalOML.g:5024:4: ( ruleReference )
            // InternalOML.g:5025:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:5043:3: ( ( ruleReference ) )
            // InternalOML.g:5044:4: ( ruleReference )
            {
            // InternalOML.g:5044:4: ( ruleReference )
            // InternalOML.g:5045:5: ruleReference
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
            		
            otherlv_6=(Token)match(input,73,FOLLOW_70); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalOML.g:5067:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop65:
            do {
                int alt65=3;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // InternalOML.g:5068:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5068:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5069:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5069:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:5070:6: lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:5088:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5088:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:5089:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5089:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:5090:6: lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    break loop65;
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
    // InternalOML.g:5116:1: entryRuleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:5116:79: (iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF )
            // InternalOML.g:5117:2: iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF
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
    // InternalOML.g:5123:1: ruleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:5129:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:5130:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:5130:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:5131:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:5131:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==71) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalOML.g:5132:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5132:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5133:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop66;
                }
            } while (true);

            // InternalOML.g:5150:3: ( ( ruleReference ) )
            // InternalOML.g:5151:4: ( ruleReference )
            {
            // InternalOML.g:5151:4: ( ruleReference )
            // InternalOML.g:5152:5: ruleReference
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
            		
            otherlv_3=(Token)match(input,73,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5174:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop67:
            do {
                int alt67=3;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // InternalOML.g:5175:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5175:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5176:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5176:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:5177:6: lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:5195:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5195:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:5196:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5196:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:5197:6: lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    break loop67;
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
    // InternalOML.g:5223:1: entryRuleRestrictionScalarDataPropertyValue returns [EObject current=null] : iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF ;
    public final EObject entryRuleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5223:75: (iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF )
            // InternalOML.g:5224:2: iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF
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
    // InternalOML.g:5230:1: ruleRestrictionScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5236:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:5237:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:5237:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:5238:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:5238:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==71) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalOML.g:5239:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5239:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5240:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop68;
                }
            } while (true);

            // InternalOML.g:5257:3: ( ( ruleReference ) )
            // InternalOML.g:5258:4: ( ruleReference )
            {
            // InternalOML.g:5258:4: ( ruleReference )
            // InternalOML.g:5259:5: ruleReference
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

            otherlv_2=(Token)match(input,70,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:5277:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:5278:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:5278:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:5279:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalOML.g:5296:3: (otherlv_4= '^^' ( ( ruleReference ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==134) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalOML.g:5297:4: otherlv_4= '^^' ( ( ruleReference ) )
                    {
                    otherlv_4=(Token)match(input,134,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
                    			
                    // InternalOML.g:5301:4: ( ( ruleReference ) )
                    // InternalOML.g:5302:5: ( ruleReference )
                    {
                    // InternalOML.g:5302:5: ( ruleReference )
                    // InternalOML.g:5303:6: ruleReference
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
    // InternalOML.g:5322:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:5322:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:5323:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
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
    // InternalOML.g:5329:1: ruleBinaryScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) ;
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
            // InternalOML.g:5335:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) )
            // InternalOML.g:5336:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            {
            // InternalOML.g:5336:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            // InternalOML.g:5337:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}'
            {
            // InternalOML.g:5337:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==71) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalOML.g:5338:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5338:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5339:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_71);
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
            	    break loop70;
                }
            } while (true);

            otherlv_1=(Token)match(input,136,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5360:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5361:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5361:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5362:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_72); 

            			newLeafNode(otherlv_3, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5382:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5383:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5383:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* ) )
            // InternalOML.g:5384:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5387:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )* )
            // InternalOML.g:5388:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )*
            {
            // InternalOML.g:5388:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) )*
            loop71:
            do {
                int alt71=4;
                int LA71_0 = input.LA(1);

                if ( LA71_0 == 137 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt71=1;
                }
                else if ( LA71_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt71=2;
                }
                else if ( LA71_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt71=3;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalOML.g:5389:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5389:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5390:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5390:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5391:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5394:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5394:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5394:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5394:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,137,FOLLOW_73); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5398:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5399:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5399:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5400:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_72);
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
            	    // InternalOML.g:5423:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5423:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5424:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5424:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5425:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5428:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5428:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5428:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5428:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,138,FOLLOW_73); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5432:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5433:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5433:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5434:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_72);
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
            	    // InternalOML.g:5457:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5457:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5458:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5458:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5459:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5462:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5462:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5462:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5462:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,139,FOLLOW_73); 

            	    									newLeafNode(otherlv_9, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5466:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5467:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5467:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5468:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_72);
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
            	    break loop71;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_11=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_11, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5502:3: ( ( ruleReference ) )
            // InternalOML.g:5503:4: ( ruleReference )
            {
            // InternalOML.g:5503:4: ( ruleReference )
            // InternalOML.g:5504:5: ruleReference
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
    // InternalOML.g:5526:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:5526:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:5527:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
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
    // InternalOML.g:5533:1: ruleIRIScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:5539:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5540:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5540:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5541:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5541:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==71) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalOML.g:5542:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5542:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5543:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_74);
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
            	    break loop72;
                }
            } while (true);

            otherlv_1=(Token)match(input,141,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5564:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5565:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5565:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5566:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_75); 

            			newLeafNode(otherlv_3, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5586:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5587:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5587:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            // InternalOML.g:5588:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5591:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            // InternalOML.g:5592:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            {
            // InternalOML.g:5592:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            loop73:
            do {
                int alt73=5;
                int LA73_0 = input.LA(1);

                if ( LA73_0 == 137 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt73=1;
                }
                else if ( LA73_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt73=2;
                }
                else if ( LA73_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt73=3;
                }
                else if ( LA73_0 == 142 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt73=4;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalOML.g:5593:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5593:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5594:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5594:117: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5595:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5598:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5598:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5598:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5598:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,137,FOLLOW_73); 

            	    									newLeafNode(otherlv_5, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5602:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5603:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5603:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5604:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:5627:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5627:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5628:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5628:117: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5629:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5632:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5632:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5632:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5632:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,138,FOLLOW_73); 

            	    									newLeafNode(otherlv_7, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5636:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5637:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5637:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5638:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:5661:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5661:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:5662:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5662:117: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:5663:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5666:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:5666:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5666:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:5666:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,139,FOLLOW_73); 

            	    									newLeafNode(otherlv_9, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5670:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:5671:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:5671:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:5672:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:5695:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5695:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:5696:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5696:117: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:5697:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5700:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:5700:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5700:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:5700:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,142,FOLLOW_76); 

            	    									newLeafNode(otherlv_11, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5704:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:5705:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:5705:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:5706:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_75); 

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
            	    break loop73;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5739:3: ( ( ruleReference ) )
            // InternalOML.g:5740:4: ( ruleReference )
            {
            // InternalOML.g:5740:4: ( ruleReference )
            // InternalOML.g:5741:5: ruleReference
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
    // InternalOML.g:5763:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:5763:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:5764:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
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
    // InternalOML.g:5770:1: ruleNumericScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:5776:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5777:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5777:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5778:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5778:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==71) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalOML.g:5779:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5779:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5780:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_77);
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
            	    break loop74;
                }
            } while (true);

            otherlv_1=(Token)match(input,143,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5801:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5802:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5802:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5803:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_78); 

            			newLeafNode(otherlv_3, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5823:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5824:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5824:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            // InternalOML.g:5825:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5828:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            // InternalOML.g:5829:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            {
            // InternalOML.g:5829:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            loop75:
            do {
                int alt75=5;
                int LA75_0 = input.LA(1);

                if ( LA75_0 == 144 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt75=1;
                }
                else if ( LA75_0 == 145 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt75=2;
                }
                else if ( LA75_0 == 146 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt75=3;
                }
                else if ( LA75_0 == 147 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt75=4;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalOML.g:5830:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5830:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5831:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5831:121: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5832:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5835:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5835:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5835:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5835:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_5=(Token)match(input,144,FOLLOW_67); 

            	    									newLeafNode(otherlv_5, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5839:9: ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5840:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5840:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    // InternalOML.g:5841:11: lv_minInclusive_6_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:5864:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5864:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5865:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5865:121: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5866:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5869:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5869:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5869:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5869:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_7=(Token)match(input,145,FOLLOW_67); 

            	    									newLeafNode(otherlv_7, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5873:9: ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5874:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5874:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    // InternalOML.g:5875:11: lv_maxInclusive_8_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:5898:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5898:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5899:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5899:121: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5900:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5903:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5903:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5903:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5903:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_9=(Token)match(input,146,FOLLOW_67); 

            	    									newLeafNode(otherlv_9, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5907:9: ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5908:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5908:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    // InternalOML.g:5909:11: lv_minExclusive_10_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:5932:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5932:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5933:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5933:121: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5934:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5937:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5937:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5937:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5937:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_11=(Token)match(input,147,FOLLOW_67); 

            	    									newLeafNode(otherlv_11, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5941:9: ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5942:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5942:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    // InternalOML.g:5943:11: lv_maxExclusive_12_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    break loop75;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5977:3: ( ( ruleReference ) )
            // InternalOML.g:5978:4: ( ruleReference )
            {
            // InternalOML.g:5978:4: ( ruleReference )
            // InternalOML.g:5979:5: ruleReference
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
    // InternalOML.g:6001:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:6001:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:6002:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
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
    // InternalOML.g:6008:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) ;
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
            // InternalOML.g:6014:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) )
            // InternalOML.g:6015:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            {
            // InternalOML.g:6015:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            // InternalOML.g:6016:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}'
            {
            // InternalOML.g:6016:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==71) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalOML.g:6017:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6017:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6018:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_79);
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
            	    break loop76;
                }
            } while (true);

            otherlv_1=(Token)match(input,148,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6039:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6040:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6040:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6041:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_80); 

            			newLeafNode(otherlv_3, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6061:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6062:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6062:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* ) )
            // InternalOML.g:6063:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6066:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )* )
            // InternalOML.g:6067:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )*
            {
            // InternalOML.g:6067:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) ) )*
            loop77:
            do {
                int alt77=6;
                int LA77_0 = input.LA(1);

                if ( LA77_0 == 137 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt77=1;
                }
                else if ( LA77_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt77=2;
                }
                else if ( LA77_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt77=3;
                }
                else if ( LA77_0 == 142 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt77=4;
                }
                else if ( LA77_0 == 149 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
                    alt77=5;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOML.g:6068:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6068:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6069:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6069:126: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6070:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6073:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6073:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6073:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6073:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,137,FOLLOW_73); 

            	    									newLeafNode(otherlv_5, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6077:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6078:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6078:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6079:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_80);
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
            	    // InternalOML.g:6102:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6102:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6103:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6103:126: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6104:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6107:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6107:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6107:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6107:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,138,FOLLOW_73); 

            	    									newLeafNode(otherlv_7, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6111:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6112:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6112:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6113:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_80);
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
            	    // InternalOML.g:6136:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6136:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6137:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6137:126: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6138:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6141:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6141:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6141:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6141:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,139,FOLLOW_73); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6145:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6146:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6146:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6147:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_80);
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
            	    // InternalOML.g:6170:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6170:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:6171:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6171:126: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:6172:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6175:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:6175:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6175:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:6175:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,142,FOLLOW_76); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6179:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:6180:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:6180:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:6181:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_80); 

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
            	    // InternalOML.g:6203:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6203:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) ) )
            	    // InternalOML.g:6204:5: {...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:6204:126: ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) ) )
            	    // InternalOML.g:6205:6: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:6208:9: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) ) )
            	    // InternalOML.g:6208:10: {...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6208:19: (otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) ) )
            	    // InternalOML.g:6208:20: otherlv_13= 'langRange' ( (lv_langRange_14_0= RULE_LANG_TAG ) )
            	    {
            	    otherlv_13=(Token)match(input,149,FOLLOW_81); 

            	    									newLeafNode(otherlv_13, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0());
            	    								
            	    // InternalOML.g:6212:9: ( (lv_langRange_14_0= RULE_LANG_TAG ) )
            	    // InternalOML.g:6213:10: (lv_langRange_14_0= RULE_LANG_TAG )
            	    {
            	    // InternalOML.g:6213:10: (lv_langRange_14_0= RULE_LANG_TAG )
            	    // InternalOML.g:6214:11: lv_langRange_14_0= RULE_LANG_TAG
            	    {
            	    lv_langRange_14_0=(Token)match(input,RULE_LANG_TAG,FOLLOW_80); 

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
            	    break loop77;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_15=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6247:3: ( ( ruleReference ) )
            // InternalOML.g:6248:4: ( ruleReference )
            {
            // InternalOML.g:6248:4: ( ruleReference )
            // InternalOML.g:6249:5: ruleReference
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
    // InternalOML.g:6271:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:6271:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:6272:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
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
    // InternalOML.g:6278:1: ruleScalarOneOfRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
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
            // InternalOML.g:6284:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:6285:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:6285:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:6286:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:6286:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==71) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalOML.g:6287:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6287:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6288:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_82);
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
            	    break loop78;
                }
            } while (true);

            otherlv_1=(Token)match(input,150,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1());
            		
            // InternalOML.g:6309:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6310:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6310:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6311:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_83); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:6335:3: ( ( ruleReference ) )
            // InternalOML.g:6336:4: ( ruleReference )
            {
            // InternalOML.g:6336:4: ( ruleReference )
            // InternalOML.g:6337:5: ruleReference
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
    // InternalOML.g:6359:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:6359:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:6360:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
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
    // InternalOML.g:6366:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6372:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:6373:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:6373:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:6374:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) (otherlv_5= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:6374:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==71) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalOML.g:6375:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6375:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6376:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_84);
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
            	    break loop79;
                }
            } while (true);

            otherlv_1=(Token)match(input,151,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1());
            		
            // InternalOML.g:6397:3: ( ( ruleReference ) )
            // InternalOML.g:6398:4: ( ruleReference )
            {
            // InternalOML.g:6398:4: ( ruleReference )
            // InternalOML.g:6399:5: ruleReference
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

            otherlv_3=(Token)match(input,70,FOLLOW_67); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:6417:3: ( (lv_value_4_0= ruleLiteralValue ) )
            // InternalOML.g:6418:4: (lv_value_4_0= ruleLiteralValue )
            {
            // InternalOML.g:6418:4: (lv_value_4_0= ruleLiteralValue )
            // InternalOML.g:6419:5: lv_value_4_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalOML.g:6436:3: (otherlv_5= '^^' ( ( ruleReference ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==134) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalOML.g:6437:4: otherlv_5= '^^' ( ( ruleReference ) )
                    {
                    otherlv_5=(Token)match(input,134,FOLLOW_21); 

                    				newLeafNode(otherlv_5, grammarAccess.getScalarOneOfLiteralAxiomAccess().getCircumflexAccentCircumflexAccentKeyword_5_0());
                    			
                    // InternalOML.g:6441:4: ( ( ruleReference ) )
                    // InternalOML.g:6442:5: ( ruleReference )
                    {
                    // InternalOML.g:6442:5: ( ruleReference )
                    // InternalOML.g:6443:6: ruleReference
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
    // InternalOML.g:6462:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:6462:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:6463:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
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
    // InternalOML.g:6469:1: ruleStringScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:6475:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:6476:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:6476:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:6477:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:6477:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==71) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalOML.g:6478:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6478:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6479:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_85);
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
            	    break loop81;
                }
            } while (true);

            otherlv_1=(Token)match(input,152,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6500:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6501:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6501:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6502:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_75); 

            			newLeafNode(otherlv_3, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6522:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6523:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6523:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* ) )
            // InternalOML.g:6524:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6527:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )* )
            // InternalOML.g:6528:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            {
            // InternalOML.g:6528:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) ) )*
            loop82:
            do {
                int alt82=5;
                int LA82_0 = input.LA(1);

                if ( LA82_0 == 137 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt82=1;
                }
                else if ( LA82_0 == 138 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt82=2;
                }
                else if ( LA82_0 == 139 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt82=3;
                }
                else if ( LA82_0 == 142 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt82=4;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalOML.g:6529:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6529:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6530:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6530:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6531:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6534:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6534:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6534:19: (otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6534:20: otherlv_5= 'length' ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,137,FOLLOW_73); 

            	    									newLeafNode(otherlv_5, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6538:9: ( (lv_length_6_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6539:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6539:10: (lv_length_6_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6540:11: lv_length_6_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getLengthPositiveIntegerLiteralParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:6563:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6563:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6564:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6564:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6565:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6568:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6568:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6568:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6568:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_7=(Token)match(input,138,FOLLOW_73); 

            	    									newLeafNode(otherlv_7, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6572:9: ( (lv_minLength_8_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6573:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6573:10: (lv_minLength_8_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6574:11: lv_minLength_8_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMinLengthPositiveIntegerLiteralParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:6597:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6597:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) ) )
            	    // InternalOML.g:6598:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6598:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) ) )
            	    // InternalOML.g:6599:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6602:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) ) )
            	    // InternalOML.g:6602:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6602:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) ) )
            	    // InternalOML.g:6602:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    {
            	    otherlv_9=(Token)match(input,139,FOLLOW_73); 

            	    									newLeafNode(otherlv_9, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6606:9: ( (lv_maxLength_10_0= rulePositiveIntegerLiteral ) )
            	    // InternalOML.g:6607:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    {
            	    // InternalOML.g:6607:10: (lv_maxLength_10_0= rulePositiveIntegerLiteral )
            	    // InternalOML.g:6608:11: lv_maxLength_10_0= rulePositiveIntegerLiteral
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getMaxLengthPositiveIntegerLiteralParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_75);
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
            	    // InternalOML.g:6631:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6631:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) ) )
            	    // InternalOML.g:6632:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6632:120: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) ) )
            	    // InternalOML.g:6633:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6636:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) ) )
            	    // InternalOML.g:6636:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6636:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) ) )
            	    // InternalOML.g:6636:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    {
            	    otherlv_11=(Token)match(input,142,FOLLOW_76); 

            	    									newLeafNode(otherlv_11, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6640:9: ( (lv_pattern_12_0= RULE_PATTERN ) )
            	    // InternalOML.g:6641:10: (lv_pattern_12_0= RULE_PATTERN )
            	    {
            	    // InternalOML.g:6641:10: (lv_pattern_12_0= RULE_PATTERN )
            	    // InternalOML.g:6642:11: lv_pattern_12_0= RULE_PATTERN
            	    {
            	    lv_pattern_12_0=(Token)match(input,RULE_PATTERN,FOLLOW_75); 

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
            	    break loop82;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6675:3: ( ( ruleReference ) )
            // InternalOML.g:6676:4: ( ruleReference )
            {
            // InternalOML.g:6676:4: ( ruleReference )
            // InternalOML.g:6677:5: ruleReference
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
    // InternalOML.g:6699:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:6699:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:6700:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
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
    // InternalOML.g:6706:1: ruleSynonymScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
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
            // InternalOML.g:6712:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:6713:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:6713:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:6714:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:6714:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==71) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalOML.g:6715:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6715:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6716:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_86);
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
            	    break loop83;
                }
            } while (true);

            otherlv_1=(Token)match(input,153,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6737:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6738:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6738:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6739:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_83); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:6763:3: ( ( ruleReference ) )
            // InternalOML.g:6764:4: ( ruleReference )
            {
            // InternalOML.g:6764:4: ( ruleReference )
            // InternalOML.g:6765:5: ruleReference
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
    // InternalOML.g:6787:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:6787:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:6788:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
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
    // InternalOML.g:6794:1: ruleTimeScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:6800:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:6801:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:6801:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:6802:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:6802:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==71) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalOML.g:6803:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6803:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6804:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_87);
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
            	    break loop84;
                }
            } while (true);

            otherlv_1=(Token)match(input,154,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6825:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6826:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6826:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6827:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,73,FOLLOW_78); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6847:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6848:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6848:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            // InternalOML.g:6849:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6852:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            // InternalOML.g:6853:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            {
            // InternalOML.g:6853:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            loop85:
            do {
                int alt85=5;
                int LA85_0 = input.LA(1);

                if ( LA85_0 == 144 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt85=1;
                }
                else if ( LA85_0 == 145 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt85=2;
                }
                else if ( LA85_0 == 146 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt85=3;
                }
                else if ( LA85_0 == 147 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt85=4;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalOML.g:6854:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6854:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6855:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6855:118: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6856:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6859:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6859:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6859:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6859:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_5=(Token)match(input,144,FOLLOW_88); 

            	    									newLeafNode(otherlv_5, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6863:9: ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6864:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6864:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    // InternalOML.g:6865:11: lv_minInclusive_6_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:6888:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6888:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6889:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6889:118: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6890:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6893:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6893:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6893:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6893:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_7=(Token)match(input,145,FOLLOW_88); 

            	    									newLeafNode(otherlv_7, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6897:9: ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6898:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6898:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    // InternalOML.g:6899:11: lv_maxInclusive_8_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:6922:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6922:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6923:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6923:118: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6924:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6927:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6927:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6927:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6927:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_9=(Token)match(input,146,FOLLOW_88); 

            	    									newLeafNode(otherlv_9, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6931:9: ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6932:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6932:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    // InternalOML.g:6933:11: lv_minExclusive_10_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    // InternalOML.g:6956:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6956:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6957:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6957:118: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6958:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6961:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6961:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6961:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6961:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_11=(Token)match(input,147,FOLLOW_88); 

            	    									newLeafNode(otherlv_11, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6965:9: ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6966:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6966:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    // InternalOML.g:6967:11: lv_maxExclusive_12_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_78);
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
            	    break loop85;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,140,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:7001:3: ( ( ruleReference ) )
            // InternalOML.g:7002:4: ( ruleReference )
            {
            // InternalOML.g:7002:4: ( ruleReference )
            // InternalOML.g:7003:5: ruleReference
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
    // InternalOML.g:7025:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:7025:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:7026:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
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
    // InternalOML.g:7032:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:7038:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:7039:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:7039:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt86=2;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalOML.g:7040:3: this_ConceptInstance_0= ruleConceptInstance
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
                    // InternalOML.g:7049:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
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
    // InternalOML.g:7061:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:7061:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:7062:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
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
    // InternalOML.g:7068:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7074:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:7075:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:7075:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:7076:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:7076:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==71) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalOML.g:7077:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7077:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7078:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop87;
                }
            } while (true);

            otherlv_1=(Token)match(input,81,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1());
            		
            // InternalOML.g:7099:3: ( ( ruleExternalReference ) )
            // InternalOML.g:7100:4: ( ruleExternalReference )
            {
            // InternalOML.g:7100:4: ( ruleExternalReference )
            // InternalOML.g:7101:5: ruleExternalReference
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
    // InternalOML.g:7119:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:7119:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:7120:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
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
    // InternalOML.g:7126:1: ruleDescriptionBoxRefinement returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7132:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:7133:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:7133:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:7134:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:7134:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==71) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalOML.g:7135:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7135:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7136:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_89);
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
            	    break loop88;
                }
            } while (true);

            otherlv_1=(Token)match(input,155,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1());
            		
            // InternalOML.g:7157:3: ( ( ruleExternalReference ) )
            // InternalOML.g:7158:4: ( ruleExternalReference )
            {
            // InternalOML.g:7158:4: ( ruleExternalReference )
            // InternalOML.g:7159:5: ruleExternalReference
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
    // InternalOML.g:7177:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:7177:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:7178:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
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
    // InternalOML.g:7184:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7190:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:7191:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:7191:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:7192:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) (otherlv_6= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:7192:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==71) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalOML.g:7193:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7193:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7194:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop89;
                }
            } while (true);

            // InternalOML.g:7211:3: ( ( ruleReference ) )
            // InternalOML.g:7212:4: ( ruleReference )
            {
            // InternalOML.g:7212:4: ( ruleReference )
            // InternalOML.g:7213:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:7231:3: ( ( ruleReference ) )
            // InternalOML.g:7232:4: ( ruleReference )
            {
            // InternalOML.g:7232:4: ( ruleReference )
            // InternalOML.g:7233:5: ruleReference
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

            otherlv_4=(Token)match(input,70,FOLLOW_67); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:7251:3: ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) )
            // InternalOML.g:7252:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            {
            // InternalOML.g:7252:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            // InternalOML.g:7253:5: lv_scalarPropertyValue_5_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalOML.g:7270:3: (otherlv_6= '^^' ( ( ruleReference ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==134) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalOML.g:7271:4: otherlv_6= '^^' ( ( ruleReference ) )
                    {
                    otherlv_6=(Token)match(input,134,FOLLOW_21); 

                    				newLeafNode(otherlv_6, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_6_0());
                    			
                    // InternalOML.g:7275:4: ( ( ruleReference ) )
                    // InternalOML.g:7276:5: ( ruleReference )
                    {
                    // InternalOML.g:7276:5: ( ruleReference )
                    // InternalOML.g:7277:6: ruleReference
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
    // InternalOML.g:7296:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:7296:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:7297:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
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
    // InternalOML.g:7303:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) ;
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
            // InternalOML.g:7309:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:7310:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:7310:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            // InternalOML.g:7311:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}'
            {
            // InternalOML.g:7311:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==71) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalOML.g:7312:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7312:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7313:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop91;
                }
            } while (true);

            // InternalOML.g:7330:3: ( ( ruleReference ) )
            // InternalOML.g:7331:4: ( ruleReference )
            {
            // InternalOML.g:7331:4: ( ruleReference )
            // InternalOML.g:7332:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,124,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:7350:3: ( ( ruleReference ) )
            // InternalOML.g:7351:4: ( ruleReference )
            {
            // InternalOML.g:7351:4: ( ruleReference )
            // InternalOML.g:7352:5: ruleReference
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
            		
            otherlv_5=(Token)match(input,73,FOLLOW_70); 

            			newLeafNode(otherlv_5, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:7374:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*
            loop92:
            do {
                int alt92=3;
                alt92 = dfa92.predict(input);
                switch (alt92) {
            	case 1 :
            	    // InternalOML.g:7375:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:7375:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:7376:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:7376:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:7377:6: lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:7395:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:7395:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:7396:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:7396:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:7397:6: lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    break loop92;
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
    // InternalOML.g:7423:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:7423:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:7424:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
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
    // InternalOML.g:7430:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:7436:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:7437:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:7437:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:7438:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:7438:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==71) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalOML.g:7439:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7439:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7440:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop93;
                }
            } while (true);

            // InternalOML.g:7457:3: ( ( ruleReference ) )
            // InternalOML.g:7458:4: ( ruleReference )
            {
            // InternalOML.g:7458:4: ( ruleReference )
            // InternalOML.g:7459:5: ruleReference
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
            		
            otherlv_3=(Token)match(input,73,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:7481:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*
            loop94:
            do {
                int alt94=3;
                alt94 = dfa94.predict(input);
                switch (alt94) {
            	case 1 :
            	    // InternalOML.g:7482:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:7482:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:7483:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:7483:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:7484:6: lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:7502:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:7502:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:7503:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:7503:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:7504:6: lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_70);
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
            	    break loop94;
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
    // InternalOML.g:7530:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:7530:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:7531:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
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
    // InternalOML.g:7537:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7543:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? ) )
            // InternalOML.g:7544:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            {
            // InternalOML.g:7544:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )? )
            // InternalOML.g:7545:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) (otherlv_4= '^^' ( ( ruleReference ) ) )?
            {
            // InternalOML.g:7545:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==71) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalOML.g:7546:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7546:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7547:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop95;
                }
            } while (true);

            // InternalOML.g:7564:3: ( ( ruleReference ) )
            // InternalOML.g:7565:4: ( ruleReference )
            {
            // InternalOML.g:7565:4: ( ruleReference )
            // InternalOML.g:7566:5: ruleReference
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

            otherlv_2=(Token)match(input,70,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:7584:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:7585:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:7585:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:7586:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_68);
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

            // InternalOML.g:7603:3: (otherlv_4= '^^' ( ( ruleReference ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==134) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalOML.g:7604:4: otherlv_4= '^^' ( ( ruleReference ) )
                    {
                    otherlv_4=(Token)match(input,134,FOLLOW_21); 

                    				newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyValueAccess().getCircumflexAccentCircumflexAccentKeyword_4_0());
                    			
                    // InternalOML.g:7608:4: ( ( ruleReference ) )
                    // InternalOML.g:7609:5: ( ruleReference )
                    {
                    // InternalOML.g:7609:5: ( ruleReference )
                    // InternalOML.g:7610:6: ruleReference
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
    // InternalOML.g:7629:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:7629:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:7630:2: iv_ruleConceptInstance= ruleConceptInstance EOF
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
    // InternalOML.g:7636:1: ruleConceptInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
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
            // InternalOML.g:7642:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:7643:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:7643:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:7644:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:7644:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==71) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalOML.g:7645:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7645:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7646:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_90);
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
            	    break loop97;
                }
            } while (true);

            otherlv_1=(Token)match(input,156,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7671:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:7672:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:7672:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:7673:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_91); 

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

            otherlv_4=(Token)match(input,157,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:7693:3: ( ( ruleReference ) )
            // InternalOML.g:7694:4: ( ruleReference )
            {
            // InternalOML.g:7694:4: ( ruleReference )
            // InternalOML.g:7695:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,116,FOLLOW_2); 

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
    // InternalOML.g:7717:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:7717:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:7718:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
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
    // InternalOML.g:7724:1: ruleReifiedRelationshipInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
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
            // InternalOML.g:7730:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:7731:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:7731:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:7732:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:7732:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==71) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalOML.g:7733:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7733:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7734:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_92);
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
            	    break loop98;
                }
            } while (true);

            otherlv_1=(Token)match(input,158,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7759:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:7760:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:7760:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:7761:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_91); 

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

            otherlv_4=(Token)match(input,157,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:7781:3: ( ( ruleReference ) )
            // InternalOML.g:7782:4: ( ruleReference )
            {
            // InternalOML.g:7782:4: ( ruleReference )
            // InternalOML.g:7783:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,116,FOLLOW_2); 

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
    // InternalOML.g:7805:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:7805:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:7806:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
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
    // InternalOML.g:7812:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7818:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:7819:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:7819:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:7820:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:7820:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==71) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalOML.g:7821:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7821:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7822:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_93);
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
            	    break loop99;
                }
            } while (true);

            otherlv_1=(Token)match(input,106,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7847:3: ( ( ruleReference ) )
            // InternalOML.g:7848:4: ( ruleReference )
            {
            // InternalOML.g:7848:4: ( ruleReference )
            // InternalOML.g:7849:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,116,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:7871:3: ( ( ruleReference ) )
            // InternalOML.g:7872:4: ( ruleReference )
            {
            // InternalOML.g:7872:4: ( ruleReference )
            // InternalOML.g:7873:5: ruleReference
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
    // InternalOML.g:7891:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:7891:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:7892:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
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
    // InternalOML.g:7898:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7904:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:7905:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:7905:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:7906:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:7906:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==71) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalOML.g:7907:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7907:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7908:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_94);
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
            	    break loop100;
                }
            } while (true);

            otherlv_1=(Token)match(input,107,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1());
            		
            otherlv_2=(Token)match(input,115,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7933:3: ( ( ruleReference ) )
            // InternalOML.g:7934:4: ( ruleReference )
            {
            // InternalOML.g:7934:4: ( ruleReference )
            // InternalOML.g:7935:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_51);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,116,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,70,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:7957:3: ( ( ruleReference ) )
            // InternalOML.g:7958:4: ( ruleReference )
            {
            // InternalOML.g:7958:4: ( ruleReference )
            // InternalOML.g:7959:5: ruleReference
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
    // InternalOML.g:7977:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:7977:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:7978:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
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
    // InternalOML.g:7984:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:7990:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:7991:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:7991:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:7992:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:7992:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==71) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // InternalOML.g:7993:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7993:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7994:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_95);
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
            	    break loop101;
                }
            } while (true);

            otherlv_1=(Token)match(input,159,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1());
            		
            otherlv_2=(Token)match(input,73,FOLLOW_96); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,101,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3());
            		
            // InternalOML.g:8023:3: ( ( ruleReference ) )
            // InternalOML.g:8024:4: ( ruleReference )
            {
            // InternalOML.g:8024:4: ( ruleReference )
            // InternalOML.g:8025:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,106,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5());
            		
            // InternalOML.g:8043:3: ( ( ruleReference ) )
            // InternalOML.g:8044:4: ( ruleReference )
            {
            // InternalOML.g:8044:4: ( ruleReference )
            // InternalOML.g:8045:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_6_0());
            				
            pushFollow(FOLLOW_42);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,107,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7());
            		
            // InternalOML.g:8063:3: ( ( ruleReference ) )
            // InternalOML.g:8064:4: ( ruleReference )
            {
            // InternalOML.g:8064:4: ( ruleReference )
            // InternalOML.g:8065:5: ruleReference
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
    // InternalOML.g:8087:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:8087:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:8088:2: iv_ruleReference= ruleReference EOF
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
    // InternalOML.g:8094:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8100:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:8101:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:8101:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==RULE_IRI) ) {
                alt102=1;
            }
            else if ( (LA102_0==RULE_ABBREV_IRI||LA102_0==RULE_ID) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalOML.g:8102:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8110:3: this_QNAME_1= ruleQNAME
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
    // InternalOML.g:8124:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:8124:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:8125:2: iv_ruleExternalReference= ruleExternalReference EOF
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
    // InternalOML.g:8131:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:8137:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:8138:2: this_IRI_0= RULE_IRI
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
    // InternalOML.g:8148:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:8148:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:8149:2: iv_ruleQNAME= ruleQNAME EOF
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
    // InternalOML.g:8155:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8161:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:8162:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:8162:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ABBREV_IRI) ) {
                alt103=1;
            }
            else if ( (LA103_0==RULE_ID) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalOML.g:8163:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:8171:3: this_ValidID_1= ruleValidID
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
    // InternalOML.g:8185:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:8185:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:8186:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOML.g:8192:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:8198:2: (this_ID_0= RULE_ID )
            // InternalOML.g:8199:2: this_ID_0= RULE_ID
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
    // InternalOML.g:8209:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // InternalOML.g:8209:53: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalOML.g:8210:2: iv_ruleLiteralValue= ruleLiteralValue EOF
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
    // InternalOML.g:8216:1: ruleLiteralValue returns [EObject current=null] : (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) ;
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
            // InternalOML.g:8222:2: ( (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) )
            // InternalOML.g:8223:2: (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            {
            // InternalOML.g:8223:2: (this_LiteralBoolean_0= ruleLiteralBoolean | this_LiteralDateTime_1= ruleLiteralDateTime | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            int alt104=6;
            switch ( input.LA(1) ) {
            case RULE_TRUE:
            case RULE_FALSE:
                {
                alt104=1;
                }
                break;
            case RULE_DATE_TIME:
                {
                alt104=2;
                }
                break;
            case RULE_QUOTED_STRING_VALUE:
            case RULE_RAW_STRING_VALUE:
                {
                alt104=3;
                }
                break;
            case RULE_UUID:
                {
                alt104=4;
                }
                break;
            case RULE_URI:
                {
                alt104=5;
                }
                break;
            case RULE_REAL:
            case RULE_RATIONAL:
            case RULE_FLOAT:
            case RULE_DIGITS:
            case RULE_DECIMAL:
                {
                alt104=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // InternalOML.g:8224:3: this_LiteralBoolean_0= ruleLiteralBoolean
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
                    // InternalOML.g:8233:3: this_LiteralDateTime_1= ruleLiteralDateTime
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
                    // InternalOML.g:8242:3: this_LiteralString_2= ruleLiteralString
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
                    // InternalOML.g:8251:3: this_LiteralUUID_3= ruleLiteralUUID
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
                    // InternalOML.g:8260:3: this_LiteralURI_4= ruleLiteralURI
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
                    // InternalOML.g:8269:3: this_LiteralNumber_5= ruleLiteralNumber
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
    // InternalOML.g:8281:1: entryRuleLiteralBoolean returns [EObject current=null] : iv_ruleLiteralBoolean= ruleLiteralBoolean EOF ;
    public final EObject entryRuleLiteralBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralBoolean = null;


        try {
            // InternalOML.g:8281:55: (iv_ruleLiteralBoolean= ruleLiteralBoolean EOF )
            // InternalOML.g:8282:2: iv_ruleLiteralBoolean= ruleLiteralBoolean EOF
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
    // InternalOML.g:8288:1: ruleLiteralBoolean returns [EObject current=null] : ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) ) ;
    public final EObject ruleLiteralBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool_1_1=null;
        Token lv_bool_1_2=null;


        	enterRule();

        try {
            // InternalOML.g:8294:2: ( ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) ) )
            // InternalOML.g:8295:2: ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) )
            {
            // InternalOML.g:8295:2: ( () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) ) )
            // InternalOML.g:8296:3: () ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) )
            {
            // InternalOML.g:8296:3: ()
            // InternalOML.g:8297:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralBooleanAccess().getLiteralBooleanAction_0(),
            					current);
            			

            }

            // InternalOML.g:8303:3: ( ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) ) )
            // InternalOML.g:8304:4: ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) )
            {
            // InternalOML.g:8304:4: ( (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE ) )
            // InternalOML.g:8305:5: (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE )
            {
            // InternalOML.g:8305:5: (lv_bool_1_1= RULE_TRUE | lv_bool_1_2= RULE_FALSE )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_TRUE) ) {
                alt105=1;
            }
            else if ( (LA105_0==RULE_FALSE) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalOML.g:8306:6: lv_bool_1_1= RULE_TRUE
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
                    // InternalOML.g:8321:6: lv_bool_1_2= RULE_FALSE
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
    // InternalOML.g:8342:1: entryRuleLiteralDateTime returns [EObject current=null] : iv_ruleLiteralDateTime= ruleLiteralDateTime EOF ;
    public final EObject entryRuleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralDateTime = null;


        try {
            // InternalOML.g:8342:56: (iv_ruleLiteralDateTime= ruleLiteralDateTime EOF )
            // InternalOML.g:8343:2: iv_ruleLiteralDateTime= ruleLiteralDateTime EOF
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
    // InternalOML.g:8349:1: ruleLiteralDateTime returns [EObject current=null] : ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) ) ;
    public final EObject ruleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        Token lv_dateTime_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8355:2: ( ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) ) )
            // InternalOML.g:8356:2: ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) )
            {
            // InternalOML.g:8356:2: ( () ( (lv_dateTime_1_0= RULE_DATE_TIME ) ) )
            // InternalOML.g:8357:3: () ( (lv_dateTime_1_0= RULE_DATE_TIME ) )
            {
            // InternalOML.g:8357:3: ()
            // InternalOML.g:8358:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0(),
            					current);
            			

            }

            // InternalOML.g:8364:3: ( (lv_dateTime_1_0= RULE_DATE_TIME ) )
            // InternalOML.g:8365:4: (lv_dateTime_1_0= RULE_DATE_TIME )
            {
            // InternalOML.g:8365:4: (lv_dateTime_1_0= RULE_DATE_TIME )
            // InternalOML.g:8366:5: lv_dateTime_1_0= RULE_DATE_TIME
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
    // InternalOML.g:8386:1: entryRuleLiteralString returns [EObject current=null] : iv_ruleLiteralString= ruleLiteralString EOF ;
    public final EObject entryRuleLiteralString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralString = null;


        try {
            // InternalOML.g:8386:54: (iv_ruleLiteralString= ruleLiteralString EOF )
            // InternalOML.g:8387:2: iv_ruleLiteralString= ruleLiteralString EOF
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
    // InternalOML.g:8393:1: ruleLiteralString returns [EObject current=null] : (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString ) ;
    public final EObject ruleLiteralString() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralQuotedString_0 = null;

        EObject this_LiteralRawString_1 = null;



        	enterRule();

        try {
            // InternalOML.g:8399:2: ( (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString ) )
            // InternalOML.g:8400:2: (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString )
            {
            // InternalOML.g:8400:2: (this_LiteralQuotedString_0= ruleLiteralQuotedString | this_LiteralRawString_1= ruleLiteralRawString )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==RULE_QUOTED_STRING_VALUE) ) {
                alt106=1;
            }
            else if ( (LA106_0==RULE_RAW_STRING_VALUE) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalOML.g:8401:3: this_LiteralQuotedString_0= ruleLiteralQuotedString
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
                    // InternalOML.g:8410:3: this_LiteralRawString_1= ruleLiteralRawString
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
    // InternalOML.g:8422:1: entryRuleLiteralQuotedString returns [EObject current=null] : iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF ;
    public final EObject entryRuleLiteralQuotedString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralQuotedString = null;


        try {
            // InternalOML.g:8422:60: (iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF )
            // InternalOML.g:8423:2: iv_ruleLiteralQuotedString= ruleLiteralQuotedString EOF
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
    // InternalOML.g:8429:1: ruleLiteralQuotedString returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) ) ;
    public final EObject ruleLiteralQuotedString() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8435:2: ( ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) ) )
            // InternalOML.g:8436:2: ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) )
            {
            // InternalOML.g:8436:2: ( () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) ) )
            // InternalOML.g:8437:3: () ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) )
            {
            // InternalOML.g:8437:3: ()
            // InternalOML.g:8438:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralQuotedStringAccess().getLiteralQuotedStringAction_0(),
            					current);
            			

            }

            // InternalOML.g:8444:3: ( (lv_string_1_0= RULE_QUOTED_STRING_VALUE ) )
            // InternalOML.g:8445:4: (lv_string_1_0= RULE_QUOTED_STRING_VALUE )
            {
            // InternalOML.g:8445:4: (lv_string_1_0= RULE_QUOTED_STRING_VALUE )
            // InternalOML.g:8446:5: lv_string_1_0= RULE_QUOTED_STRING_VALUE
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
    // InternalOML.g:8466:1: entryRuleLiteralRawString returns [EObject current=null] : iv_ruleLiteralRawString= ruleLiteralRawString EOF ;
    public final EObject entryRuleLiteralRawString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRawString = null;


        try {
            // InternalOML.g:8466:57: (iv_ruleLiteralRawString= ruleLiteralRawString EOF )
            // InternalOML.g:8467:2: iv_ruleLiteralRawString= ruleLiteralRawString EOF
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
    // InternalOML.g:8473:1: ruleLiteralRawString returns [EObject current=null] : ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) ) ;
    public final EObject ruleLiteralRawString() throws RecognitionException {
        EObject current = null;

        Token lv_string_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8479:2: ( ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) ) )
            // InternalOML.g:8480:2: ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) )
            {
            // InternalOML.g:8480:2: ( () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) ) )
            // InternalOML.g:8481:3: () ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) )
            {
            // InternalOML.g:8481:3: ()
            // InternalOML.g:8482:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRawStringAccess().getLiteralRawStringAction_0(),
            					current);
            			

            }

            // InternalOML.g:8488:3: ( (lv_string_1_0= RULE_RAW_STRING_VALUE ) )
            // InternalOML.g:8489:4: (lv_string_1_0= RULE_RAW_STRING_VALUE )
            {
            // InternalOML.g:8489:4: (lv_string_1_0= RULE_RAW_STRING_VALUE )
            // InternalOML.g:8490:5: lv_string_1_0= RULE_RAW_STRING_VALUE
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
    // InternalOML.g:8510:1: entryRuleUUIDDataType returns [String current=null] : iv_ruleUUIDDataType= ruleUUIDDataType EOF ;
    public final String entryRuleUUIDDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUUIDDataType = null;


        try {
            // InternalOML.g:8510:52: (iv_ruleUUIDDataType= ruleUUIDDataType EOF )
            // InternalOML.g:8511:2: iv_ruleUUIDDataType= ruleUUIDDataType EOF
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
    // InternalOML.g:8517:1: ruleUUIDDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_UUID_0= RULE_UUID ;
    public final AntlrDatatypeRuleToken ruleUUIDDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_UUID_0=null;


        	enterRule();

        try {
            // InternalOML.g:8523:2: (this_UUID_0= RULE_UUID )
            // InternalOML.g:8524:2: this_UUID_0= RULE_UUID
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
    // InternalOML.g:8534:1: entryRuleLiteralUUID returns [EObject current=null] : iv_ruleLiteralUUID= ruleLiteralUUID EOF ;
    public final EObject entryRuleLiteralUUID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralUUID = null;


        try {
            // InternalOML.g:8534:52: (iv_ruleLiteralUUID= ruleLiteralUUID EOF )
            // InternalOML.g:8535:2: iv_ruleLiteralUUID= ruleLiteralUUID EOF
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
    // InternalOML.g:8541:1: ruleLiteralUUID returns [EObject current=null] : ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) ) ;
    public final EObject ruleLiteralUUID() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_uuid_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8547:2: ( ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) ) )
            // InternalOML.g:8548:2: ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) )
            {
            // InternalOML.g:8548:2: ( () ( (lv_uuid_1_0= ruleUUIDDataType ) ) )
            // InternalOML.g:8549:3: () ( (lv_uuid_1_0= ruleUUIDDataType ) )
            {
            // InternalOML.g:8549:3: ()
            // InternalOML.g:8550:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0(),
            					current);
            			

            }

            // InternalOML.g:8556:3: ( (lv_uuid_1_0= ruleUUIDDataType ) )
            // InternalOML.g:8557:4: (lv_uuid_1_0= ruleUUIDDataType )
            {
            // InternalOML.g:8557:4: (lv_uuid_1_0= ruleUUIDDataType )
            // InternalOML.g:8558:5: lv_uuid_1_0= ruleUUIDDataType
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
    // InternalOML.g:8579:1: entryRuleURIDataType returns [String current=null] : iv_ruleURIDataType= ruleURIDataType EOF ;
    public final String entryRuleURIDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIDataType = null;


        try {
            // InternalOML.g:8579:51: (iv_ruleURIDataType= ruleURIDataType EOF )
            // InternalOML.g:8580:2: iv_ruleURIDataType= ruleURIDataType EOF
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
    // InternalOML.g:8586:1: ruleURIDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_URI_0= RULE_URI ;
    public final AntlrDatatypeRuleToken ruleURIDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_URI_0=null;


        	enterRule();

        try {
            // InternalOML.g:8592:2: (this_URI_0= RULE_URI )
            // InternalOML.g:8593:2: this_URI_0= RULE_URI
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
    // InternalOML.g:8603:1: entryRuleLiteralURI returns [EObject current=null] : iv_ruleLiteralURI= ruleLiteralURI EOF ;
    public final EObject entryRuleLiteralURI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralURI = null;


        try {
            // InternalOML.g:8603:51: (iv_ruleLiteralURI= ruleLiteralURI EOF )
            // InternalOML.g:8604:2: iv_ruleLiteralURI= ruleLiteralURI EOF
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
    // InternalOML.g:8610:1: ruleLiteralURI returns [EObject current=null] : ( () ( (lv_uri_1_0= ruleURIDataType ) ) ) ;
    public final EObject ruleLiteralURI() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_uri_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8616:2: ( ( () ( (lv_uri_1_0= ruleURIDataType ) ) ) )
            // InternalOML.g:8617:2: ( () ( (lv_uri_1_0= ruleURIDataType ) ) )
            {
            // InternalOML.g:8617:2: ( () ( (lv_uri_1_0= ruleURIDataType ) ) )
            // InternalOML.g:8618:3: () ( (lv_uri_1_0= ruleURIDataType ) )
            {
            // InternalOML.g:8618:3: ()
            // InternalOML.g:8619:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralURIAccess().getLiteralURIAction_0(),
            					current);
            			

            }

            // InternalOML.g:8625:3: ( (lv_uri_1_0= ruleURIDataType ) )
            // InternalOML.g:8626:4: (lv_uri_1_0= ruleURIDataType )
            {
            // InternalOML.g:8626:4: (lv_uri_1_0= ruleURIDataType )
            // InternalOML.g:8627:5: lv_uri_1_0= ruleURIDataType
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
    // InternalOML.g:8648:1: entryRuleLiteralNumber returns [EObject current=null] : iv_ruleLiteralNumber= ruleLiteralNumber EOF ;
    public final EObject entryRuleLiteralNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNumber = null;


        try {
            // InternalOML.g:8648:54: (iv_ruleLiteralNumber= ruleLiteralNumber EOF )
            // InternalOML.g:8649:2: iv_ruleLiteralNumber= ruleLiteralNumber EOF
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
    // InternalOML.g:8655:1: ruleLiteralNumber returns [EObject current=null] : (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal ) ;
    public final EObject ruleLiteralNumber() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralReal_0 = null;

        EObject this_LiteralRational_1 = null;

        EObject this_LiteralFloat_2 = null;

        EObject this_LiteralDecimal_3 = null;



        	enterRule();

        try {
            // InternalOML.g:8661:2: ( (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal ) )
            // InternalOML.g:8662:2: (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal )
            {
            // InternalOML.g:8662:2: (this_LiteralReal_0= ruleLiteralReal | this_LiteralRational_1= ruleLiteralRational | this_LiteralFloat_2= ruleLiteralFloat | this_LiteralDecimal_3= ruleLiteralDecimal )
            int alt107=4;
            switch ( input.LA(1) ) {
            case RULE_REAL:
                {
                alt107=1;
                }
                break;
            case RULE_RATIONAL:
                {
                alt107=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt107=3;
                }
                break;
            case RULE_DIGITS:
            case RULE_DECIMAL:
                {
                alt107=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalOML.g:8663:3: this_LiteralReal_0= ruleLiteralReal
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
                    // InternalOML.g:8672:3: this_LiteralRational_1= ruleLiteralRational
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
                    // InternalOML.g:8681:3: this_LiteralFloat_2= ruleLiteralFloat
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
                    // InternalOML.g:8690:3: this_LiteralDecimal_3= ruleLiteralDecimal
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
    // InternalOML.g:8702:1: entryRuleLiteralReal returns [EObject current=null] : iv_ruleLiteralReal= ruleLiteralReal EOF ;
    public final EObject entryRuleLiteralReal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralReal = null;


        try {
            // InternalOML.g:8702:52: (iv_ruleLiteralReal= ruleLiteralReal EOF )
            // InternalOML.g:8703:2: iv_ruleLiteralReal= ruleLiteralReal EOF
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
    // InternalOML.g:8709:1: ruleLiteralReal returns [EObject current=null] : ( () ( (lv_real_1_0= RULE_REAL ) ) ) ;
    public final EObject ruleLiteralReal() throws RecognitionException {
        EObject current = null;

        Token lv_real_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8715:2: ( ( () ( (lv_real_1_0= RULE_REAL ) ) ) )
            // InternalOML.g:8716:2: ( () ( (lv_real_1_0= RULE_REAL ) ) )
            {
            // InternalOML.g:8716:2: ( () ( (lv_real_1_0= RULE_REAL ) ) )
            // InternalOML.g:8717:3: () ( (lv_real_1_0= RULE_REAL ) )
            {
            // InternalOML.g:8717:3: ()
            // InternalOML.g:8718:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRealAccess().getLiteralRealAction_0(),
            					current);
            			

            }

            // InternalOML.g:8724:3: ( (lv_real_1_0= RULE_REAL ) )
            // InternalOML.g:8725:4: (lv_real_1_0= RULE_REAL )
            {
            // InternalOML.g:8725:4: (lv_real_1_0= RULE_REAL )
            // InternalOML.g:8726:5: lv_real_1_0= RULE_REAL
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
    // InternalOML.g:8746:1: entryRuleLiteralRational returns [EObject current=null] : iv_ruleLiteralRational= ruleLiteralRational EOF ;
    public final EObject entryRuleLiteralRational() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralRational = null;


        try {
            // InternalOML.g:8746:56: (iv_ruleLiteralRational= ruleLiteralRational EOF )
            // InternalOML.g:8747:2: iv_ruleLiteralRational= ruleLiteralRational EOF
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
    // InternalOML.g:8753:1: ruleLiteralRational returns [EObject current=null] : ( () ( (lv_rational_1_0= ruleRationalDataType ) ) ) ;
    public final EObject ruleLiteralRational() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_rational_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:8759:2: ( ( () ( (lv_rational_1_0= ruleRationalDataType ) ) ) )
            // InternalOML.g:8760:2: ( () ( (lv_rational_1_0= ruleRationalDataType ) ) )
            {
            // InternalOML.g:8760:2: ( () ( (lv_rational_1_0= ruleRationalDataType ) ) )
            // InternalOML.g:8761:3: () ( (lv_rational_1_0= ruleRationalDataType ) )
            {
            // InternalOML.g:8761:3: ()
            // InternalOML.g:8762:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralRationalAccess().getLiteralRationalAction_0(),
            					current);
            			

            }

            // InternalOML.g:8768:3: ( (lv_rational_1_0= ruleRationalDataType ) )
            // InternalOML.g:8769:4: (lv_rational_1_0= ruleRationalDataType )
            {
            // InternalOML.g:8769:4: (lv_rational_1_0= ruleRationalDataType )
            // InternalOML.g:8770:5: lv_rational_1_0= ruleRationalDataType
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
    // InternalOML.g:8791:1: entryRuleRationalDataType returns [String current=null] : iv_ruleRationalDataType= ruleRationalDataType EOF ;
    public final String entryRuleRationalDataType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRationalDataType = null;


        try {
            // InternalOML.g:8791:56: (iv_ruleRationalDataType= ruleRationalDataType EOF )
            // InternalOML.g:8792:2: iv_ruleRationalDataType= ruleRationalDataType EOF
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
    // InternalOML.g:8798:1: ruleRationalDataType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RATIONAL_0= RULE_RATIONAL ;
    public final AntlrDatatypeRuleToken ruleRationalDataType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RATIONAL_0=null;


        	enterRule();

        try {
            // InternalOML.g:8804:2: (this_RATIONAL_0= RULE_RATIONAL )
            // InternalOML.g:8805:2: this_RATIONAL_0= RULE_RATIONAL
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
    // InternalOML.g:8815:1: entryRuleLiteralFloat returns [EObject current=null] : iv_ruleLiteralFloat= ruleLiteralFloat EOF ;
    public final EObject entryRuleLiteralFloat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFloat = null;


        try {
            // InternalOML.g:8815:53: (iv_ruleLiteralFloat= ruleLiteralFloat EOF )
            // InternalOML.g:8816:2: iv_ruleLiteralFloat= ruleLiteralFloat EOF
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
    // InternalOML.g:8822:1: ruleLiteralFloat returns [EObject current=null] : ( () ( (lv_float_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleLiteralFloat() throws RecognitionException {
        EObject current = null;

        Token lv_float_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:8828:2: ( ( () ( (lv_float_1_0= RULE_FLOAT ) ) ) )
            // InternalOML.g:8829:2: ( () ( (lv_float_1_0= RULE_FLOAT ) ) )
            {
            // InternalOML.g:8829:2: ( () ( (lv_float_1_0= RULE_FLOAT ) ) )
            // InternalOML.g:8830:3: () ( (lv_float_1_0= RULE_FLOAT ) )
            {
            // InternalOML.g:8830:3: ()
            // InternalOML.g:8831:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralFloatAccess().getLiteralFloatAction_0(),
            					current);
            			

            }

            // InternalOML.g:8837:3: ( (lv_float_1_0= RULE_FLOAT ) )
            // InternalOML.g:8838:4: (lv_float_1_0= RULE_FLOAT )
            {
            // InternalOML.g:8838:4: (lv_float_1_0= RULE_FLOAT )
            // InternalOML.g:8839:5: lv_float_1_0= RULE_FLOAT
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
    // InternalOML.g:8859:1: entryRuleLiteralDecimal returns [EObject current=null] : iv_ruleLiteralDecimal= ruleLiteralDecimal EOF ;
    public final EObject entryRuleLiteralDecimal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralDecimal = null;


        try {
            // InternalOML.g:8859:55: (iv_ruleLiteralDecimal= ruleLiteralDecimal EOF )
            // InternalOML.g:8860:2: iv_ruleLiteralDecimal= ruleLiteralDecimal EOF
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
    // InternalOML.g:8866:1: ruleLiteralDecimal returns [EObject current=null] : ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) ) ;
    public final EObject ruleLiteralDecimal() throws RecognitionException {
        EObject current = null;

        Token lv_decimal_1_0=null;
        Token lv_decimal_2_0=null;


        	enterRule();

        try {
            // InternalOML.g:8872:2: ( ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) ) )
            // InternalOML.g:8873:2: ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) )
            {
            // InternalOML.g:8873:2: ( ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) ) | ( (lv_decimal_2_0= RULE_DECIMAL ) ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==RULE_DIGITS) ) {
                alt108=1;
            }
            else if ( (LA108_0==RULE_DECIMAL) ) {
                alt108=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // InternalOML.g:8874:3: ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) )
                    {
                    // InternalOML.g:8874:3: ( () ( (lv_decimal_1_0= RULE_DIGITS ) ) )
                    // InternalOML.g:8875:4: () ( (lv_decimal_1_0= RULE_DIGITS ) )
                    {
                    // InternalOML.g:8875:4: ()
                    // InternalOML.g:8876:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getLiteralDecimalAccess().getLiteralDecimalAction_0_0(),
                    						current);
                    				

                    }

                    // InternalOML.g:8882:4: ( (lv_decimal_1_0= RULE_DIGITS ) )
                    // InternalOML.g:8883:5: (lv_decimal_1_0= RULE_DIGITS )
                    {
                    // InternalOML.g:8883:5: (lv_decimal_1_0= RULE_DIGITS )
                    // InternalOML.g:8884:6: lv_decimal_1_0= RULE_DIGITS
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
                    // InternalOML.g:8902:3: ( (lv_decimal_2_0= RULE_DECIMAL ) )
                    {
                    // InternalOML.g:8902:3: ( (lv_decimal_2_0= RULE_DECIMAL ) )
                    // InternalOML.g:8903:4: (lv_decimal_2_0= RULE_DECIMAL )
                    {
                    // InternalOML.g:8903:4: (lv_decimal_2_0= RULE_DECIMAL )
                    // InternalOML.g:8904:5: lv_decimal_2_0= RULE_DECIMAL
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
    // InternalOML.g:8924:1: entryRulePositiveIntegerLiteral returns [String current=null] : iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF ;
    public final String entryRulePositiveIntegerLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveIntegerLiteral = null;


        try {
            // InternalOML.g:8924:62: (iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF )
            // InternalOML.g:8925:2: iv_rulePositiveIntegerLiteral= rulePositiveIntegerLiteral EOF
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
    // InternalOML.g:8931:1: rulePositiveIntegerLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DIGITS_0= RULE_DIGITS ;
    public final AntlrDatatypeRuleToken rulePositiveIntegerLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DIGITS_0=null;


        	enterRule();

        try {
            // InternalOML.g:8937:2: (this_DIGITS_0= RULE_DIGITS )
            // InternalOML.g:8938:2: this_DIGITS_0= RULE_DIGITS
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
    // InternalOML.g:8948:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:8954:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:8955:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:8955:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==160) ) {
                alt109=1;
            }
            else if ( (LA109_0==161) ) {
                alt109=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // InternalOML.g:8956:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:8956:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:8957:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,160,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:8964:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:8964:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:8965:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,161,FOLLOW_2); 

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
    // InternalOML.g:8975:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:8981:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:8982:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:8982:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==162) ) {
                alt110=1;
            }
            else if ( (LA110_0==163) ) {
                alt110=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // InternalOML.g:8983:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:8983:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:8984:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,162,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:8991:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:8991:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:8992:4: enumLiteral_1= 'partial'
                    {
                    enumLiteral_1=(Token)match(input,163,FOLLOW_2); 

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
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA92 dfa92 = new DFA92(this);
    protected DFA94 dfa94 = new DFA94(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\105\2\4\2\uffff\2\106\1\5\1\14\1\105\2\107";
    static final String dfa_3s = "\1\u00a3\2\4\2\uffff\2\106\1\5\1\15\3\u00a3";
    static final String dfa_4s = "\3\uffff\1\1\1\2\7\uffff";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\uffff\1\2\130\uffff\2\3\2\4",
            "\1\5",
            "\1\6",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12\1\13",
            "\1\1\1\uffff\1\2\130\uffff\2\3\2\4",
            "\1\2\130\uffff\2\3\2\4",
            "\1\2\130\uffff\2\3\2\4"
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
    static final String dfa_9s = "\1\u00a1\2\4\2\113\2\106\2\uffff\1\5\1\15\3\u00a1";
    static final String dfa_10s = "\7\uffff\1\1\1\2\5\uffff";
    static final String dfa_11s = "\16\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\1\uffff\1\2\130\uffff\1\3\1\4",
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
            "\1\1\1\uffff\1\2\130\uffff\1\3\1\4",
            "\1\2\130\uffff\1\3\1\4",
            "\1\2\130\uffff\1\3\1\4"
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
    static final String dfa_15s = "\1\u009a\1\uffff\1\4\2\uffff\1\106\1\15\2\u009a";
    static final String dfa_16s = "\1\uffff\1\3\1\uffff\1\1\1\2\4\uffff";
    static final String dfa_17s = "\11\uffff}>";
    static final String[] dfa_18s = {
            "\3\4\100\uffff\1\2\2\uffff\1\1\3\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\4\4\13\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\3\4\100\uffff\1\2\6\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\14\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "\3\4\100\uffff\1\2\6\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\14\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
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
    static final String dfa_21s = "\1\u009a\1\uffff\1\4\4\uffff\1\106\1\15\2\u009a";
    static final String dfa_22s = "\1\uffff\1\5\1\uffff\1\1\1\2\1\3\1\4\4\uffff";
    static final String dfa_23s = "\13\uffff}>";
    static final String[] dfa_24s = {
            "\3\4\100\uffff\1\2\2\uffff\1\1\2\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\4\4\11\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11\1\12",
            "\3\4\100\uffff\1\2\5\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\12\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "\3\4\100\uffff\1\2\5\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\12\uffff\1\5\1\uffff\1\4\2\uffff\1\4\5\uffff\2\4\1\uffff\2\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
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
    static final String dfa_26s = "\1\4\1\uffff\1\4\7\uffff\3\174\1\106\1\4\1\14\3\106\2\4\1\11\2\uffff";
    static final String dfa_27s = "\1\u009f\1\uffff\1\4\7\uffff\3\174\1\106\1\6\1\15\3\106\2\u009f\1\111\2\uffff";
    static final String dfa_28s = "\1\uffff\1\12\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\14\uffff\1\11\1\10";
    static final String dfa_29s = "\30\uffff}>";
    static final String[] dfa_30s = {
            "\1\13\1\12\1\14\100\uffff\1\2\2\uffff\1\1\6\uffff\1\3\30\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
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
            "\1\13\1\12\1\14\100\uffff\1\2\11\uffff\1\3\30\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "\1\13\1\12\1\14\100\uffff\1\2\11\uffff\1\3\30\uffff\1\7\1\10\57\uffff\1\4\1\5\1\uffff\1\6\1\11",
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
    static final String dfa_37s = "\1\u009a\1\4\2\uffff\1\106\1\15\2\u009a";
    static final String dfa_38s = "\2\uffff\1\1\1\2\4\uffff";
    static final String dfa_39s = "\10\uffff}>";
    static final String[] dfa_40s = {
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\4\3\3\uffff\4\3\13\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\4\3\3\uffff\3\3\14\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3",
            "\3\2\100\uffff\1\1\15\uffff\3\3\15\uffff\4\3\3\uffff\3\3\14\uffff\1\2\2\uffff\1\2\5\uffff\2\2\1\uffff\1\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3"
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
    static final String dfa_42s = "\1\u009a\1\4\5\uffff\1\106\1\15\2\u009a";
    static final String dfa_43s = "\2\uffff\1\1\1\2\1\3\1\4\1\5\4\uffff";
    static final String[] dfa_44s = {
            "\1\1\15\uffff\2\2\1\3\15\uffff\1\3\2\4\1\5\3\uffff\3\5\1\6\30\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4",
            "\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11\1\12",
            "\1\1\15\uffff\2\2\1\3\15\uffff\1\3\2\4\1\5\3\uffff\3\5\31\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4",
            "\1\1\15\uffff\2\2\1\3\15\uffff\1\3\2\4\1\5\3\uffff\3\5\31\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4"
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
    static final String dfa_48s = "\1\145\1\4\2\uffff\1\106\1\15\2\145";
    static final String[] dfa_49s = {
            "\1\1\17\uffff\1\2\15\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\17\uffff\1\2\15\uffff\1\3",
            "\1\1\17\uffff\1\2\15\uffff\1\3"
    };
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_48;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "1428:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )";
        }
    }
    static final String[] dfa_50s = {
            "\1\1\36\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\36\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2",
            "\1\1\36\uffff\1\2\1\3\40\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2"
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
            return "1464:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )";
        }
    }
    static final String[] dfa_51s = {
            "\1\1\36\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\36\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3",
            "\1\1\36\uffff\1\2\41\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3"
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
            return "1500:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )";
        }
    }
    static final String dfa_52s = "\1\107\1\4\10\uffff\1\106\1\14\2\107";
    static final String dfa_53s = "\1\u009a\1\4\10\uffff\1\106\1\15\2\u009a";
    static final String dfa_54s = "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff";
    static final String[] dfa_55s = {
            "\1\1\100\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11",
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
            "\1\1\100\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11",
            "\1\1\100\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11"
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
            return "1536:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )";
        }
    }
    static final String dfa_56s = "\12\uffff";
    static final String dfa_57s = "\1\107\1\4\4\uffff\1\106\1\14\2\107";
    static final String dfa_58s = "\1\156\1\4\4\uffff\1\106\1\15\2\156";
    static final String dfa_59s = "\2\uffff\1\1\1\2\1\3\1\4\4\uffff";
    static final String dfa_60s = "\12\uffff}>";
    static final String[] dfa_61s = {
            "\1\1\40\uffff\1\2\3\uffff\1\3\1\4\1\5",
            "\1\6",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10\1\11",
            "\1\1\40\uffff\1\2\3\uffff\1\3\1\4\1\5",
            "\1\1\40\uffff\1\2\3\uffff\1\3\1\4\1\5"
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
            return "1626:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )";
        }
    }
    static final String dfa_62s = "\31\uffff";
    static final String dfa_63s = "\2\4\2\uffff\1\4\1\uffff\3\177\1\106\3\174\3\uffff\1\14\3\4\3\106\1\11\1\uffff";
    static final String dfa_64s = "\1\u0097\1\4\2\uffff\1\6\1\uffff\3\u0083\1\106\3\174\3\uffff\1\15\1\6\2\u0097\3\106\1\111\1\uffff";
    static final String dfa_65s = "\2\uffff\1\1\1\2\1\uffff\1\4\7\uffff\1\5\1\6\1\7\10\uffff\1\3";
    static final String dfa_66s = "\31\uffff}>";
    static final String[] dfa_67s = {
            "\1\7\1\6\1\10\100\uffff\1\1\63\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
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
            "\1\7\1\6\1\10\100\uffff\1\1\63\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
            "\1\7\1\6\1\10\100\uffff\1\1\63\uffff\1\2\2\uffff\1\2\5\uffff\1\3\1\4\1\uffff\1\3\17\uffff\1\5",
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
            return "1680:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom | this_SubObjectPropertyOfAxiom_5= ruleSubObjectPropertyOfAxiom | this_SubDataPropertyOfAxiom_6= ruleSubDataPropertyOfAxiom )";
        }
    }
    static final String dfa_68s = "\1\176\1\4\2\uffff\1\106\1\15\2\176";
    static final String[] dfa_69s = {
            "\1\1\63\uffff\1\2\2\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\63\uffff\1\2\2\uffff\1\3",
            "\1\1\63\uffff\1\2\2\uffff\1\3"
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
            return "1761:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_70s = "\1\u0087\1\4\3\uffff\1\106\1\15\2\u0087";
    static final String[] dfa_71s = {
            "\1\1\74\uffff\1\2\1\3\1\uffff\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7\1\10",
            "\1\1\74\uffff\1\2\1\3\1\uffff\1\4",
            "\1\1\74\uffff\1\2\1\3\1\uffff\1\4"
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
            return "1797:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_72s = "\2\4\3\177\1\106\3\uffff\1\14\2\4";
    static final String dfa_73s = "\1\107\1\4\3\u0081\1\106\3\uffff\1\15\2\107";
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
            return "1867:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )";
        }
    }
    static final String dfa_76s = "\1\172\1\4\2\uffff\1\106\1\15\2\172";
    static final String[] dfa_77s = {
            "\1\1\60\uffff\1\2\1\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\60\uffff\1\2\1\uffff\1\3",
            "\1\1\60\uffff\1\2\1\uffff\1\3"
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
            return "1962:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )";
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
            return "()* loopback of 2170:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
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

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_78;
            this.max = dfa_83;
            this.accept = dfa_80;
            this.special = dfa_81;
            this.transition = dfa_84;
        }
        public String getDescription() {
            return "()* loopback of 2633:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_0 = input.LA(1);

                         
                        int index37_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA37_0==99) ) {s = 1;}

                        else if ( LA37_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA37_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA37_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA37_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA37_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA37_0 == 93 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA37_0 == 94 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA37_0 == 95 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA37_0 == 96 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                         
                        input.seek(index37_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
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

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 5067:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 5174:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_91s = "\1\u009e\1\4\2\uffff\1\106\1\15\2\u009e";
    static final String[] dfa_92s = {
            "\1\1\124\uffff\1\2\1\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6\1\7",
            "\1\1\124\uffff\1\2\1\uffff\1\3",
            "\1\1\124\uffff\1\2\1\uffff\1\3"
    };
    static final char[] dfa_91 = DFA.unpackEncodedStringToUnsignedChars(dfa_91s);
    static final short[][] dfa_92 = unpackEncodedStringArray(dfa_92s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_45;
            this.max = dfa_91;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_92;
        }
        public String getDescription() {
            return "7039:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )";
        }
    }

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 7374:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA94 extends DFA {

        public DFA94(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 94;
            this.eot = dfa_85;
            this.eof = dfa_85;
            this.min = dfa_86;
            this.max = dfa_87;
            this.accept = dfa_88;
            this.special = dfa_89;
            this.transition = dfa_90;
        }
        public String getDescription() {
            return "()* loopback of 7481:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000A0L,0x0000000F00000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000A0L,0x0000000300000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000070L,0x4800F1E000E64480L,0x0000000007D0A1B0L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000070L,0x4A00F1E000E66480L,0x0000000007D0A1B0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x00000000000010A0L,0x0000000F00000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000070L,0x00000C0000020480L,0x00000000D8000000L});
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
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x00000009FF000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000080L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000080L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000080L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000040L,0x0000020000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000080L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000070L,0x00E0001800000080L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0004000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000080L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0500000000000480L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000080L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000080L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000080L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000080L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000020L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x00000000001FFE00L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000080L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000070L,0x0000000000000480L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000000100L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001E00L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000005E00L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000008000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000F1000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000100000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000205E00L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000400000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000000800000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000001000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000002000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000004000000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000008000000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000010000000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000040000000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000080L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000080L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000080000000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});

}
