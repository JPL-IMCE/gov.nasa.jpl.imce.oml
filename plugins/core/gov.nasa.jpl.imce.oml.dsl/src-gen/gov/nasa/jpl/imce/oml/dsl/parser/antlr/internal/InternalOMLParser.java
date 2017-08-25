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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_STRING", "RULE_ID", "RULE_DIGITS", "RULE_UUID", "RULE_REAL_VALUE", "RULE_RATIONAL", "RULE_FLOAT", "RULE_DECIMAL", "RULE_URI_VALUE", "RULE_LANGUAGE_TAG", "RULE_DATETIME", "RULE_DIGIT", "RULE_DIGIT19", "RULE_DIGIT02", "RULE_DIGIT03", "RULE_DIGIT05", "RULE_YEAR_FRAG", "RULE_MONTH_FRAG", "RULE_DAY_FRAG", "RULE_HOUR_FRAG", "RULE_MINUTE_FRAG", "RULE_SECOND_FRAG", "RULE_END_OF_DAY_FRAG", "RULE_TIMEZONE_FRAG", "RULE_ALPHA", "RULE_SCHEME", "RULE_HEX_DIGIT", "RULE_PCT_ENCODED", "RULE_UNRESERVED", "RULE_DIGIT04", "RULE_DEC_OCTET", "RULE_IPV4_ADDRESS", "RULE_IUSER_PART", "RULE_IUSER_INFO", "RULE_IUNRESERVED_PART", "RULE_IUNRESERVED", "RULE_IHOST", "RULE_PORT", "RULE_IAUTHORITY", "RULE_IPCHAR", "RULE_ISEGMENT", "RULE_IPATH", "RULE_IHIER_PART", "RULE_IFRAGMENT", "RULE_CONSTANT_NAME", "RULE_LETTER", "RULE_LETTER_DIGIT", "RULE_LETTER_DIGIT_PREFIX", "RULE_LETTER_DIGIT_SUFFIX", "RULE_ID_PREFIX", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_LETTER", "RULE_HEX", "RULE_DEC", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'descriptionBox'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'anonymousConceptUnion'", "'('", "')'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'someData'", "'every'", "'allData'", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
    };
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int RULE_HEX=60;
    public static final int T__145=145;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int T__141=141;
    public static final int RULE_IHOST=42;
    public static final int RULE_ABBREV_IRI=4;
    public static final int RULE_IUSER_INFO=39;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int RULE_ISEGMENT=46;
    public static final int T__134=134;
    public static final int RULE_ID=7;
    public static final int RULE_DEC=61;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_DIGIT=17;
    public static final int RULE_HEX_LETTER=59;
    public static final int RULE_RATIONAL=11;
    public static final int RULE_DAY_FRAG=24;
    public static final int RULE_UUID=9;
    public static final int RULE_LETTER_DIGIT_SUFFIX=54;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=62;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int RULE_IRI=5;
    public static final int RULE_IHIER_PART=48;
    public static final int RULE_HOUR_FRAG=25;
    public static final int RULE_YEAR_FRAG=22;
    public static final int RULE_DEC_OCTET=36;
    public static final int RULE_LETTER=51;
    public static final int RULE_UNRESERVED=34;
    public static final int RULE_FLOAT=12;
    public static final int RULE_HEX_DIGIT=32;
    public static final int RULE_IUSER_PART=38;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int RULE_HEX_8DIGITS=56;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_IPATH=47;
    public static final int RULE_IPCHAR=45;
    public static final int RULE_HEX_12DIGITS=58;
    public static final int RULE_SECOND_FRAG=27;
    public static final int RULE_IAUTHORITY=44;
    public static final int RULE_LANGUAGE_TAG=15;
    public static final int RULE_REAL_VALUE=10;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int RULE_TIMEZONE_FRAG=29;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_LETTER_DIGIT=52;
    public static final int RULE_ID_PREFIX=55;
    public static final int RULE_IUNRESERVED_PART=40;
    public static final int RULE_DECIMAL=13;
    public static final int RULE_MONTH_FRAG=23;
    public static final int RULE_CONSTANT_NAME=50;
    public static final int RULE_URI_VALUE=14;
    public static final int RULE_LETTER_DIGIT_PREFIX=53;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int RULE_ALPHA=30;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int RULE_SCHEME=31;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int RULE_PORT=43;
    public static final int T__120=120;
    public static final int RULE_DATETIME=16;
    public static final int RULE_STRING=6;
    public static final int RULE_DIGITS=8;
    public static final int RULE_SL_COMMENT=63;
    public static final int RULE_END_OF_DAY_FRAG=28;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int RULE_IUNRESERVED=41;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int RULE_DIGIT19=18;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int RULE_MINUTE_FRAG=26;
    public static final int RULE_HEX_4DIGITS=57;
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
    public static final int RULE_DIGIT03=20;
    public static final int RULE_DIGIT02=19;
    public static final int RULE_WS=64;
    public static final int RULE_DIGIT05=21;
    public static final int RULE_DIGIT04=35;
    public static final int RULE_IFRAGMENT=49;
    public static final int RULE_PCT_ENCODED=33;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_IPV4_ADDRESS=37;
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
    // InternalOML.g:85:1: ruleExtent returns [EObject current=null] : ( () ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )* ) ;
    public final EObject ruleExtent() throws RecognitionException {
        EObject current = null;

        EObject lv_annotationProperties_1_0 = null;

        EObject lv_modules_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:91:2: ( ( () ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )* ) )
            // InternalOML.g:92:2: ( () ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )* )
            {
            // InternalOML.g:92:2: ( () ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )* )
            // InternalOML.g:93:3: () ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )*
            {
            // InternalOML.g:93:3: ()
            // InternalOML.g:94:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtentAccess().getExtentAction_0(),
            					current);
            			

            }

            // InternalOML.g:100:3: ( ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) ) | ( (lv_modules_2_0= ruleModule ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==65) ) {
                    alt1=1;
                }
                else if ( (LA1_0==67||(LA1_0>=146 && LA1_0<=149)) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOML.g:101:4: ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )
            	    {
            	    // InternalOML.g:101:4: ( (lv_annotationProperties_1_0= ruleAnnotationProperty ) )
            	    // InternalOML.g:102:5: (lv_annotationProperties_1_0= ruleAnnotationProperty )
            	    {
            	    // InternalOML.g:102:5: (lv_annotationProperties_1_0= ruleAnnotationProperty )
            	    // InternalOML.g:103:6: lv_annotationProperties_1_0= ruleAnnotationProperty
            	    {

            	    						newCompositeNode(grammarAccess.getExtentAccess().getAnnotationPropertiesAnnotationPropertyParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_3);
            	    lv_annotationProperties_1_0=ruleAnnotationProperty();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExtentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotationProperties",
            	    							lv_annotationProperties_1_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.AnnotationProperty");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:121:4: ( (lv_modules_2_0= ruleModule ) )
            	    {
            	    // InternalOML.g:121:4: ( (lv_modules_2_0= ruleModule ) )
            	    // InternalOML.g:122:5: (lv_modules_2_0= ruleModule )
            	    {
            	    // InternalOML.g:122:5: (lv_modules_2_0= ruleModule )
            	    // InternalOML.g:123:6: lv_modules_2_0= ruleModule
            	    {

            	    						newCompositeNode(grammarAccess.getExtentAccess().getModulesModuleParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_3);
            	    lv_modules_2_0=ruleModule();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExtentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"modules",
            	    							lv_modules_2_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Module");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


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
    // InternalOML.g:145:1: entryRuleAnnotationProperty returns [EObject current=null] : iv_ruleAnnotationProperty= ruleAnnotationProperty EOF ;
    public final EObject entryRuleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationProperty = null;


        try {
            // InternalOML.g:145:59: (iv_ruleAnnotationProperty= ruleAnnotationProperty EOF )
            // InternalOML.g:146:2: iv_ruleAnnotationProperty= ruleAnnotationProperty EOF
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
    // InternalOML.g:152:1: ruleAnnotationProperty returns [EObject current=null] : (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) ) ;
    public final EObject ruleAnnotationProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_abbrevIRI_1_0=null;
        Token otherlv_2=null;
        Token lv_iri_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:158:2: ( (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) ) )
            // InternalOML.g:159:2: (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) )
            {
            // InternalOML.g:159:2: (otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) ) )
            // InternalOML.g:160:3: otherlv_0= 'annotationProperty' ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_iri_3_0= RULE_IRI ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyAccess().getAnnotationPropertyKeyword_0());
            		
            // InternalOML.g:164:3: ( (lv_abbrevIRI_1_0= RULE_ABBREV_IRI ) )
            // InternalOML.g:165:4: (lv_abbrevIRI_1_0= RULE_ABBREV_IRI )
            {
            // InternalOML.g:165:4: (lv_abbrevIRI_1_0= RULE_ABBREV_IRI )
            // InternalOML.g:166:5: lv_abbrevIRI_1_0= RULE_ABBREV_IRI
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

            otherlv_2=(Token)match(input,66,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:186:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:187:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:187:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:188:5: lv_iri_3_0= RULE_IRI
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
    // InternalOML.g:208:1: entryRuleAnnotationPropertyValue returns [EObject current=null] : iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF ;
    public final EObject entryRuleAnnotationPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationPropertyValue = null;


        try {
            // InternalOML.g:208:64: (iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF )
            // InternalOML.g:209:2: iv_ruleAnnotationPropertyValue= ruleAnnotationPropertyValue EOF
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
    // InternalOML.g:215:1: ruleAnnotationPropertyValue returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAnnotationPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:221:2: ( (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOML.g:222:2: (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOML.g:222:2: (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOML.g:223:3: otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationPropertyValueAccess().getCommercialAtKeyword_0());
            		
            // InternalOML.g:227:3: ( (otherlv_1= RULE_ABBREV_IRI ) )
            // InternalOML.g:228:4: (otherlv_1= RULE_ABBREV_IRI )
            {
            // InternalOML.g:228:4: (otherlv_1= RULE_ABBREV_IRI )
            // InternalOML.g:229:5: otherlv_1= RULE_ABBREV_IRI
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyValueRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getAnnotationPropertyValueAccess().getPropertyAnnotationPropertyCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,66,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:244:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOML.g:245:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOML.g:245:4: (lv_value_3_0= RULE_STRING )
            // InternalOML.g:246:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getAnnotationPropertyValueAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationPropertyValueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            				

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
    // InternalOML.g:266:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalOML.g:266:47: (iv_ruleModule= ruleModule EOF )
            // InternalOML.g:267:2: iv_ruleModule= ruleModule EOF
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
    // InternalOML.g:273:1: ruleModule returns [EObject current=null] : (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminologyBox_0 = null;

        EObject this_DescriptionBox_1 = null;



        	enterRule();

        try {
            // InternalOML.g:279:2: ( (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox ) )
            // InternalOML.g:280:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )
            {
            // InternalOML.g:280:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalOML.g:281:3: this_TerminologyBox_0= ruleTerminologyBox
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
                    // InternalOML.g:290:3: this_DescriptionBox_1= ruleDescriptionBox
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
    // InternalOML.g:302:1: entryRuleTerminologyBox returns [EObject current=null] : iv_ruleTerminologyBox= ruleTerminologyBox EOF ;
    public final EObject entryRuleTerminologyBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBox = null;


        try {
            // InternalOML.g:302:55: (iv_ruleTerminologyBox= ruleTerminologyBox EOF )
            // InternalOML.g:303:2: iv_ruleTerminologyBox= ruleTerminologyBox EOF
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
    // InternalOML.g:309:1: ruleTerminologyBox returns [EObject current=null] : (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph ) ;
    public final EObject ruleTerminologyBox() throws RecognitionException {
        EObject current = null;

        EObject this_Bundle_0 = null;

        EObject this_TerminologyGraph_1 = null;



        	enterRule();

        try {
            // InternalOML.g:315:2: ( (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph ) )
            // InternalOML.g:316:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )
            {
            // InternalOML.g:316:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalOML.g:317:3: this_Bundle_0= ruleBundle
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
                    // InternalOML.g:326:3: this_TerminologyGraph_1= ruleTerminologyGraph
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
    // InternalOML.g:338:1: entryRuleTerminologyGraph returns [EObject current=null] : iv_ruleTerminologyGraph= ruleTerminologyGraph EOF ;
    public final EObject entryRuleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyGraph = null;


        try {
            // InternalOML.g:338:57: (iv_ruleTerminologyGraph= ruleTerminologyGraph EOF )
            // InternalOML.g:339:2: iv_ruleTerminologyGraph= ruleTerminologyGraph EOF
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
    // InternalOML.g:345:1: ruleTerminologyGraph returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_boxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:351:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' ) )
            // InternalOML.g:352:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' )
            {
            // InternalOML.g:352:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' )
            // InternalOML.g:353:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}'
            {
            // InternalOML.g:353:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==67) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOML.g:354:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:354:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:355:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
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
            	    break loop4;
                }
            } while (true);

            // InternalOML.g:372:3: ( (lv_kind_1_0= ruleTerminologyKind ) )
            // InternalOML.g:373:4: (lv_kind_1_0= ruleTerminologyKind )
            {
            // InternalOML.g:373:4: (lv_kind_1_0= ruleTerminologyKind )
            // InternalOML.g:374:5: lv_kind_1_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_kind_1_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_2());
            		
            // InternalOML.g:395:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:396:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:396:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:397:5: lv_iri_3_0= RULE_IRI
            {
            lv_iri_3_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_3_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyGraphRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:417:3: ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )*
            loop5:
            do {
                int alt5=3;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalOML.g:418:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:418:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:419:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:419:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:420:6: lv_boxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_boxAxioms_5_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxAxioms",
            	    							lv_boxAxioms_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:438:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:438:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:439:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:439:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:440:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_boxStatements_6_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_7=(Token)match(input,70,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalOML.g:466:1: entryRuleBundle returns [EObject current=null] : iv_ruleBundle= ruleBundle EOF ;
    public final EObject entryRuleBundle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundle = null;


        try {
            // InternalOML.g:466:47: (iv_ruleBundle= ruleBundle EOF )
            // InternalOML.g:467:2: iv_ruleBundle= ruleBundle EOF
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
    // InternalOML.g:473:1: ruleBundle returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleBundle() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_boxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;

        EObject lv_bundleStatements_7_0 = null;

        EObject lv_bundleAxioms_8_0 = null;



        	enterRule();

        try {
            // InternalOML.g:479:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' ) )
            // InternalOML.g:480:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' )
            {
            // InternalOML.g:480:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' )
            // InternalOML.g:481:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}'
            {
            // InternalOML.g:481:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==67) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOML.g:482:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:482:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:483:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBundleRule());
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
            	    break loop6;
                }
            } while (true);

            // InternalOML.g:500:3: ( (lv_kind_1_0= ruleTerminologyKind ) )
            // InternalOML.g:501:4: (lv_kind_1_0= ruleTerminologyKind )
            {
            // InternalOML.g:501:4: (lv_kind_1_0= ruleTerminologyKind )
            // InternalOML.g:502:5: lv_kind_1_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_kind_1_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBundleRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,71,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getBundleAccess().getBundleKeyword_2());
            		
            // InternalOML.g:523:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:524:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:524:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:525:5: lv_iri_3_0= RULE_IRI
            {
            lv_iri_3_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_3_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:545:3: ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )*
            loop7:
            do {
                int alt7=5;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalOML.g:546:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:546:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:547:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:547:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:548:6: lv_boxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_boxAxioms_5_0=ruleTerminologyBoxAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxAxioms",
            	    							lv_boxAxioms_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:566:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:566:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:567:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:567:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:568:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_boxStatements_6_0=ruleTerminologyBoxStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"boxStatements",
            	    							lv_boxStatements_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBoxStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:586:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    {
            	    // InternalOML.g:586:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    // InternalOML.g:587:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    {
            	    // InternalOML.g:587:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    // InternalOML.g:588:6: lv_bundleStatements_7_0= ruleTerminologyBundleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_5_2_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_bundleStatements_7_0=ruleTerminologyBundleStatement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"bundleStatements",
            	    							lv_bundleStatements_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleStatement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:606:4: ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    {
            	    // InternalOML.g:606:4: ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    // InternalOML.g:607:5: (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    {
            	    // InternalOML.g:607:5: (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    // InternalOML.g:608:6: lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_3_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_bundleAxioms_8_0=ruleTerminologyBundleAxiom();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"bundleAxioms",
            	    							lv_bundleAxioms_8_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyBundleAxiom");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,70,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalOML.g:634:1: entryRuleDescriptionBox returns [EObject current=null] : iv_ruleDescriptionBox= ruleDescriptionBox EOF ;
    public final EObject entryRuleDescriptionBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBox = null;


        try {
            // InternalOML.g:634:55: (iv_ruleDescriptionBox= ruleDescriptionBox EOF )
            // InternalOML.g:635:2: iv_ruleDescriptionBox= ruleDescriptionBox EOF
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
    // InternalOML.g:641:1: ruleDescriptionBox returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' ) ;
    public final EObject ruleDescriptionBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_14=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_closedWorldDefinitions_5_0 = null;

        EObject lv_descriptionBoxRefinements_6_0 = null;

        EObject lv_conceptInstances_7_0 = null;

        EObject lv_reifiedRelationshipInstances_8_0 = null;

        EObject lv_reifiedRelationshipInstanceDomains_9_0 = null;

        EObject lv_reifiedRelationshipInstanceRanges_10_0 = null;

        EObject lv_unreifiedRelationshipInstanceTuples_11_0 = null;

        EObject lv_singletonScalarDataPropertyValues_12_0 = null;

        EObject lv_singletonStructuredDataPropertyValues_13_0 = null;



        	enterRule();

        try {
            // InternalOML.g:647:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' ) )
            // InternalOML.g:648:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' )
            {
            // InternalOML.g:648:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' )
            // InternalOML.g:649:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}'
            {
            // InternalOML.g:649:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==67) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalOML.g:650:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:650:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:651:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_annotations_0_0=ruleAnnotationPropertyValue();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
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
            	    break loop8;
                }
            } while (true);

            // InternalOML.g:668:3: ( (lv_kind_1_0= ruleDescriptionKind ) )
            // InternalOML.g:669:4: (lv_kind_1_0= ruleDescriptionKind )
            {
            // InternalOML.g:669:4: (lv_kind_1_0= ruleDescriptionKind )
            // InternalOML.g:670:5: lv_kind_1_0= ruleDescriptionKind
            {

            					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_15);
            lv_kind_1_0=ruleDescriptionKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_2());
            		
            // InternalOML.g:691:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:692:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:692:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:693:5: lv_iri_3_0= RULE_IRI
            {
            lv_iri_3_0=(Token)match(input,RULE_IRI,FOLLOW_10); 

            					newLeafNode(lv_iri_3_0, grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_3_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:713:3: ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*
            loop9:
            do {
                int alt9=10;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalOML.g:714:4: ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    {
            	    // InternalOML.g:714:4: ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    // InternalOML.g:715:5: (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    {
            	    // InternalOML.g:715:5: (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    // InternalOML.g:716:6: lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_closedWorldDefinitions_5_0=ruleDescriptionBoxExtendsClosedWorldDefinitions();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"closedWorldDefinitions",
            	    							lv_closedWorldDefinitions_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxExtendsClosedWorldDefinitions");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:734:4: ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) )
            	    {
            	    // InternalOML.g:734:4: ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) )
            	    // InternalOML.g:735:5: (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement )
            	    {
            	    // InternalOML.g:735:5: (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement )
            	    // InternalOML.g:736:6: lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_descriptionBoxRefinements_6_0=ruleDescriptionBoxRefinement();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"descriptionBoxRefinements",
            	    							lv_descriptionBoxRefinements_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionBoxRefinement");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:754:4: ( (lv_conceptInstances_7_0= ruleConceptInstance ) )
            	    {
            	    // InternalOML.g:754:4: ( (lv_conceptInstances_7_0= ruleConceptInstance ) )
            	    // InternalOML.g:755:5: (lv_conceptInstances_7_0= ruleConceptInstance )
            	    {
            	    // InternalOML.g:755:5: (lv_conceptInstances_7_0= ruleConceptInstance )
            	    // InternalOML.g:756:6: lv_conceptInstances_7_0= ruleConceptInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_5_2_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_conceptInstances_7_0=ruleConceptInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conceptInstances",
            	    							lv_conceptInstances_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ConceptInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:774:4: ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) )
            	    {
            	    // InternalOML.g:774:4: ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) )
            	    // InternalOML.g:775:5: (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance )
            	    {
            	    // InternalOML.g:775:5: (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance )
            	    // InternalOML.g:776:6: lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_3_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstances_8_0=ruleReifiedRelationshipInstance();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstances",
            	    							lv_reifiedRelationshipInstances_8_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstance");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:794:4: ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) )
            	    {
            	    // InternalOML.g:794:4: ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) )
            	    // InternalOML.g:795:5: (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain )
            	    {
            	    // InternalOML.g:795:5: (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain )
            	    // InternalOML.g:796:6: lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_4_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstanceDomains_9_0=ruleReifiedRelationshipInstanceDomain();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstanceDomains",
            	    							lv_reifiedRelationshipInstanceDomains_9_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceDomain");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:814:4: ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) )
            	    {
            	    // InternalOML.g:814:4: ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) )
            	    // InternalOML.g:815:5: (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange )
            	    {
            	    // InternalOML.g:815:5: (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange )
            	    // InternalOML.g:816:6: lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_5_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_reifiedRelationshipInstanceRanges_10_0=ruleReifiedRelationshipInstanceRange();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"reifiedRelationshipInstanceRanges",
            	    							lv_reifiedRelationshipInstanceRanges_10_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ReifiedRelationshipInstanceRange");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:834:4: ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    {
            	    // InternalOML.g:834:4: ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    // InternalOML.g:835:5: (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple )
            	    {
            	    // InternalOML.g:835:5: (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple )
            	    // InternalOML.g:836:6: lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_6_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_unreifiedRelationshipInstanceTuples_11_0=ruleUnreifiedRelationshipInstanceTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"unreifiedRelationshipInstanceTuples",
            	    							lv_unreifiedRelationshipInstanceTuples_11_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.UnreifiedRelationshipInstanceTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:854:4: ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:854:4: ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    // InternalOML.g:855:5: (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:855:5: (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    // InternalOML.g:856:6: lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_7_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_singletonScalarDataPropertyValues_12_0=ruleSingletonInstanceScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"singletonScalarDataPropertyValues",
            	    							lv_singletonScalarDataPropertyValues_12_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:874:4: ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    {
            	    // InternalOML.g:874:4: ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    // InternalOML.g:875:5: (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    {
            	    // InternalOML.g:875:5: (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    // InternalOML.g:876:6: lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_8_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_singletonStructuredDataPropertyValues_13_0=ruleSingletonInstanceStructuredDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"singletonStructuredDataPropertyValues",
            	    							lv_singletonStructuredDataPropertyValues_13_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.SingletonInstanceStructuredDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_14=(Token)match(input,70,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalOML.g:902:1: entryRuleTerminologyBoxAxiom returns [EObject current=null] : iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF ;
    public final EObject entryRuleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxAxiom = null;


        try {
            // InternalOML.g:902:60: (iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF )
            // InternalOML.g:903:2: iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF
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
    // InternalOML.g:909:1: ruleTerminologyBoxAxiom returns [EObject current=null] : (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) ;
    public final EObject ruleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptDesignationTerminologyAxiom_0 = null;

        EObject this_TerminologyExtensionAxiom_1 = null;

        EObject this_TerminologyNestingAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:915:2: ( (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) )
            // InternalOML.g:916:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            {
            // InternalOML.g:916:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            int alt10=3;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // InternalOML.g:917:3: this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom
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
                    // InternalOML.g:926:3: this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom
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
                    // InternalOML.g:935:3: this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom
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
    // InternalOML.g:947:1: entryRuleBundledTerminologyAxiom returns [EObject current=null] : iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF ;
    public final EObject entryRuleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundledTerminologyAxiom = null;


        try {
            // InternalOML.g:947:64: (iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF )
            // InternalOML.g:948:2: iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF
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
    // InternalOML.g:954:1: ruleBundledTerminologyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:960:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:961:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:961:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) ) )
            // InternalOML.g:962:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'bundles' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:962:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==67) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalOML.g:963:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:963:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:964:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop11;
                }
            } while (true);

            otherlv_1=(Token)match(input,73,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_1());
            		
            // InternalOML.g:985:3: ( ( ruleExternalReference ) )
            // InternalOML.g:986:4: ( ruleExternalReference )
            {
            // InternalOML.g:986:4: ( ruleExternalReference )
            // InternalOML.g:987:5: ruleExternalReference
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
    // InternalOML.g:1005:1: entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null] : iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF ;
    public final EObject entryRuleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptDesignationTerminologyAxiom = null;


        try {
            // InternalOML.g:1005:75: (iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF )
            // InternalOML.g:1006:2: iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF
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
    // InternalOML.g:1012:1: ruleConceptDesignationTerminologyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:1018:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:1019:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:1019:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:1020:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptDesignationTerminologyAxiom' otherlv_2= '{' otherlv_3= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'designatedConcept' ( ( ruleReference ) ) otherlv_7= '}'
            {
            // InternalOML.g:1020:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==67) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalOML.g:1021:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1021:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1022:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop12;
                }
            } while (true);

            otherlv_1=(Token)match(input,74,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_1());
            		
            otherlv_2=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,75,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_3());
            		
            // InternalOML.g:1051:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1052:4: ( ruleExternalReference )
            {
            // InternalOML.g:1052:4: ( ruleExternalReference )
            // InternalOML.g:1053:5: ruleExternalReference
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

            otherlv_5=(Token)match(input,76,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_5());
            		
            // InternalOML.g:1071:3: ( ( ruleReference ) )
            // InternalOML.g:1072:4: ( ruleReference )
            {
            // InternalOML.g:1072:4: ( ruleReference )
            // InternalOML.g:1073:5: ruleReference
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

            otherlv_7=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:1095:1: entryRuleTerminologyExtensionAxiom returns [EObject current=null] : iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF ;
    public final EObject entryRuleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtensionAxiom = null;


        try {
            // InternalOML.g:1095:66: (iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF )
            // InternalOML.g:1096:2: iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF
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
    // InternalOML.g:1102:1: ruleTerminologyExtensionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1108:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:1109:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:1109:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:1110:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:1110:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==67) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalOML.g:1111:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1111:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1112:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop13;
                }
            } while (true);

            otherlv_1=(Token)match(input,77,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_1());
            		
            // InternalOML.g:1133:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1134:4: ( ruleExternalReference )
            {
            // InternalOML.g:1134:4: ( ruleExternalReference )
            // InternalOML.g:1135:5: ruleExternalReference
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
    // InternalOML.g:1153:1: entryRuleTerminologyNestingAxiom returns [EObject current=null] : iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF ;
    public final EObject entryRuleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyNestingAxiom = null;


        try {
            // InternalOML.g:1153:64: (iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF )
            // InternalOML.g:1154:2: iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF
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
    // InternalOML.g:1160:1: ruleTerminologyNestingAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:1166:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:1167:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:1167:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:1168:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'terminologyNestingAxiom' otherlv_2= '{' otherlv_3= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_5= 'nestingContext' ( ( ruleReference ) ) otherlv_7= '}'
            {
            // InternalOML.g:1168:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==67) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalOML.g:1169:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1169:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1170:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop14;
                }
            } while (true);

            otherlv_1=(Token)match(input,78,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_1());
            		
            otherlv_2=(Token)match(input,69,FOLLOW_25); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,79,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_3());
            		
            // InternalOML.g:1199:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1200:4: ( ruleExternalReference )
            {
            // InternalOML.g:1200:4: ( ruleExternalReference )
            // InternalOML.g:1201:5: ruleExternalReference
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

            otherlv_5=(Token)match(input,80,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_5());
            		
            // InternalOML.g:1219:3: ( ( ruleReference ) )
            // InternalOML.g:1220:4: ( ruleReference )
            {
            // InternalOML.g:1220:4: ( ruleReference )
            // InternalOML.g:1221:5: ruleReference
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

            otherlv_7=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:1243:1: entryRuleTerminologyBoxStatement returns [EObject current=null] : iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF ;
    public final EObject entryRuleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxStatement = null;


        try {
            // InternalOML.g:1243:64: (iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF )
            // InternalOML.g:1244:2: iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF
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
    // InternalOML.g:1250:1: ruleTerminologyBoxStatement returns [EObject current=null] : (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) ;
    public final EObject ruleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TermAxiom_0 = null;

        EObject this_Term_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1256:2: ( (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) )
            // InternalOML.g:1257:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            {
            // InternalOML.g:1257:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalOML.g:1258:3: this_TermAxiom_0= ruleTermAxiom
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
                    // InternalOML.g:1267:3: this_Term_1= ruleTerm
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
    // InternalOML.g:1279:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalOML.g:1279:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalOML.g:1280:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalOML.g:1286:1: ruleTerm returns [EObject current=null] : (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEntity_0 = null;

        EObject this_EntityRelationship_1 = null;

        EObject this_Datatype_2 = null;

        EObject this_DataRelationship_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1292:2: ( (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) )
            // InternalOML.g:1293:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            {
            // InternalOML.g:1293:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            int alt16=4;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalOML.g:1294:3: this_AtomicEntity_0= ruleAtomicEntity
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
                    // InternalOML.g:1303:3: this_EntityRelationship_1= ruleEntityRelationship
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
                    // InternalOML.g:1312:3: this_Datatype_2= ruleDatatype
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
                    // InternalOML.g:1321:3: this_DataRelationship_3= ruleDataRelationship
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getDataRelationshipParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DataRelationship_3=ruleDataRelationship();

                    state._fsp--;


                    			current = this_DataRelationship_3;
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
    // InternalOML.g:1333:1: entryRuleAtomicEntity returns [EObject current=null] : iv_ruleAtomicEntity= ruleAtomicEntity EOF ;
    public final EObject entryRuleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEntity = null;


        try {
            // InternalOML.g:1333:53: (iv_ruleAtomicEntity= ruleAtomicEntity EOF )
            // InternalOML.g:1334:2: iv_ruleAtomicEntity= ruleAtomicEntity EOF
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
    // InternalOML.g:1340:1: ruleAtomicEntity returns [EObject current=null] : (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) ;
    public final EObject ruleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Aspect_0 = null;

        EObject this_Concept_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1346:2: ( (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) )
            // InternalOML.g:1347:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            {
            // InternalOML.g:1347:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            int alt17=2;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // InternalOML.g:1348:3: this_Aspect_0= ruleAspect
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
                    // InternalOML.g:1357:3: this_Concept_1= ruleConcept
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
    // InternalOML.g:1369:1: entryRuleEntityRelationship returns [EObject current=null] : iv_ruleEntityRelationship= ruleEntityRelationship EOF ;
    public final EObject entryRuleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRelationship = null;


        try {
            // InternalOML.g:1369:59: (iv_ruleEntityRelationship= ruleEntityRelationship EOF )
            // InternalOML.g:1370:2: iv_ruleEntityRelationship= ruleEntityRelationship EOF
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
    // InternalOML.g:1376:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_UnreifiedRelationship_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1382:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) )
            // InternalOML.g:1383:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            {
            // InternalOML.g:1383:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            int alt18=2;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalOML.g:1384:3: this_ReifiedRelationship_0= ruleReifiedRelationship
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
                    // InternalOML.g:1393:3: this_UnreifiedRelationship_1= ruleUnreifiedRelationship
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
    // InternalOML.g:1405:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOML.g:1405:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOML.g:1406:2: iv_ruleDatatype= ruleDatatype EOF
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
    // InternalOML.g:1412:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1418:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOML.g:1419:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOML.g:1419:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalOML.g:1420:3: this_ScalarDataRange_0= ruleScalarDataRange
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
                    // InternalOML.g:1429:3: this_Structure_1= ruleStructure
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
    // InternalOML.g:1441:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOML.g:1441:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOML.g:1442:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
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
    // InternalOML.g:1448:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1454:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOML.g:1455:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOML.g:1455:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalOML.g:1456:3: this_Scalar_0= ruleScalar
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
                    // InternalOML.g:1465:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
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
    // InternalOML.g:1477:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOML.g:1477:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOML.g:1478:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
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
    // InternalOML.g:1484:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
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
            // InternalOML.g:1490:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOML.g:1491:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOML.g:1491:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt21=8;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalOML.g:1492:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
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
                    // InternalOML.g:1501:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
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
                    // InternalOML.g:1510:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
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
                    // InternalOML.g:1519:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
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
                    // InternalOML.g:1528:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
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
                    // InternalOML.g:1537:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
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
                    // InternalOML.g:1546:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
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
                    // InternalOML.g:1555:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
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
    // InternalOML.g:1567:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOML.g:1567:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOML.g:1568:2: iv_ruleDataRelationship= ruleDataRelationship EOF
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
    // InternalOML.g:1574:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1580:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOML.g:1581:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOML.g:1581:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt22=4;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalOML.g:1582:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
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
                    // InternalOML.g:1591:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
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
                    // InternalOML.g:1600:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
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
                    // InternalOML.g:1609:3: this_ScalarDataProperty_3= ruleScalarDataProperty
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
    // InternalOML.g:1621:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOML.g:1621:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOML.g:1622:2: iv_ruleTermAxiom= ruleTermAxiom EOF
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
    // InternalOML.g:1628:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_EntityStructuredDataPropertyRestrictionAxiom_2 = null;

        EObject this_ScalarOneOfLiteralAxiom_3 = null;

        EObject this_SpecializationAxiom_4 = null;



        	enterRule();

        try {
            // InternalOML.g:1634:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom ) )
            // InternalOML.g:1635:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )
            {
            // InternalOML.g:1635:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )
            int alt23=5;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalOML.g:1636:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
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
                    // InternalOML.g:1645:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1654:3: this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1663:3: this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom
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
                    // InternalOML.g:1672:3: this_SpecializationAxiom_4= ruleSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecializationAxiom_4=ruleSpecializationAxiom();

                    state._fsp--;


                    			current = this_SpecializationAxiom_4;
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
    // InternalOML.g:1684:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1684:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1685:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
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
    // InternalOML.g:1691:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1697:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1698:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1698:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalOML.g:1699:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
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
                    // InternalOML.g:1708:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
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
    // InternalOML.g:1720:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1720:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1721:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1727:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1733:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1734:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1734:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt25=3;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalOML.g:1735:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
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
                    // InternalOML.g:1744:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
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
                    // InternalOML.g:1753:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
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
    // InternalOML.g:1765:1: entryRuleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1765:85: (iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1766:2: iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1772:1: ruleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom ;
    public final EObject ruleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataPropertyParticularRestrictionAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1778:2: (this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom )
            // InternalOML.g:1779:2: this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom
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
    // InternalOML.g:1790:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1790:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1791:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
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
    // InternalOML.g:1797:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1803:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1804:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1804:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt26=3;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalOML.g:1805:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
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
                    // InternalOML.g:1814:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
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
                    // InternalOML.g:1823:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
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
    // InternalOML.g:1835:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1835:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1836:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
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
    // InternalOML.g:1842:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1848:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1849:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
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
    // InternalOML.g:1860:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1860:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1861:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
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
    // InternalOML.g:1867:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1873:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1874:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
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
    // InternalOML.g:1885:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1885:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1886:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
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
    // InternalOML.g:1892:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1898:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1899:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1899:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalOML.g:1900:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
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
                    // InternalOML.g:1909:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
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
    // InternalOML.g:1921:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1921:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1922:2: iv_ruleAspect= ruleAspect EOF
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
    // InternalOML.g:1928:1: ruleAspect returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1934:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:1935:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:1935:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:1936:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'aspect' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:1936:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==67) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOML.g:1937:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1937:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1938:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop28;
                }
            } while (true);

            otherlv_1=(Token)match(input,81,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getAspectAccess().getAspectKeyword_1());
            		
            // InternalOML.g:1959:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:1960:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:1960:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:1961:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:1981:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:1981:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:1982:2: iv_ruleConcept= ruleConcept EOF
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
    // InternalOML.g:1988:1: ruleConcept returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1994:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:1995:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:1995:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:1996:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'concept' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:1996:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==67) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOML.g:1997:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:1997:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:1998:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop29;
                }
            } while (true);

            otherlv_1=(Token)match(input,82,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptAccess().getConceptKeyword_1());
            		
            // InternalOML.g:2019:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2020:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2020:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2021:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2041:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:2041:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:2042:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
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
    // InternalOML.g:2048:1: ruleReifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_unreifiedPropertyName_16_0= RULE_ID ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) ;
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
        Token lv_unreifiedPropertyName_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_unreifiedInversePropertyName_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2054:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_unreifiedPropertyName_16_0= RULE_ID ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' ) )
            // InternalOML.g:2055:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_unreifiedPropertyName_16_0= RULE_ID ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            {
            // InternalOML.g:2055:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_unreifiedPropertyName_16_0= RULE_ID ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}' )
            // InternalOML.g:2056:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'unreified' otherlv_15= '=' ( (lv_unreifiedPropertyName_16_0= RULE_ID ) ) (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )? otherlv_20= 'source' otherlv_21= '=' ( ( ruleReference ) ) otherlv_23= 'target' otherlv_24= '=' ( ( ruleReference ) ) otherlv_26= '}'
            {
            // InternalOML.g:2056:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==67) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOML.g:2057:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2057:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2058:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop30;
                }
            } while (true);

            otherlv_1=(Token)match(input,83,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_1());
            		
            // InternalOML.g:2079:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2080:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2080:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2081:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:2101:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2102:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2102:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2103:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2106:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2107:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2107:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop31:
            do {
                int alt31=10;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:2108:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2108:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2109:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2109:116: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2110:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2113:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2113:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2113:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2113:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2113:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2114:10: lv_isFunctional_5_0= 'functional'
            	    {
            	    lv_isFunctional_5_0=(Token)match(input,84,FOLLOW_31); 

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
            	    // InternalOML.g:2131:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2131:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2132:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2132:116: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2133:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2136:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2136:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2136:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2136:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2136:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2137:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_6_0=(Token)match(input,85,FOLLOW_31); 

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
            	    // InternalOML.g:2154:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2154:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2155:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2155:116: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2156:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2159:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2159:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2159:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2159:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2159:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2160:10: lv_isEssential_7_0= 'essential'
            	    {
            	    lv_isEssential_7_0=(Token)match(input,86,FOLLOW_31); 

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
            	    // InternalOML.g:2177:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2177:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2178:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2178:116: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2179:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2182:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2182:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2182:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2182:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2182:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2183:10: lv_isInverseEssential_8_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_8_0=(Token)match(input,87,FOLLOW_31); 

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
            	    // InternalOML.g:2200:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2200:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2201:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2201:116: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2202:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2205:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2205:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2205:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2205:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2205:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2206:10: lv_isSymmetric_9_0= 'symmetric'
            	    {
            	    lv_isSymmetric_9_0=(Token)match(input,88,FOLLOW_31); 

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
            	    // InternalOML.g:2223:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2223:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2224:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2224:116: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2225:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2228:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2228:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2228:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2228:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2228:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2229:10: lv_isAsymmetric_10_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_10_0=(Token)match(input,89,FOLLOW_31); 

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
            	    // InternalOML.g:2246:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2246:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2247:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2247:116: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2248:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2251:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2251:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2251:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2251:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2251:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2252:10: lv_isReflexive_11_0= 'reflexive'
            	    {
            	    lv_isReflexive_11_0=(Token)match(input,90,FOLLOW_31); 

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
            	    // InternalOML.g:2269:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2269:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2270:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2270:116: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2271:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2274:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2274:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2274:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2274:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2274:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2275:10: lv_isIrreflexive_12_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_12_0=(Token)match(input,91,FOLLOW_31); 

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
            	    // InternalOML.g:2292:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2292:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2293:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2293:116: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2294:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2297:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2297:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2297:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2297:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2297:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2298:10: lv_isTransitive_13_0= 'transitive'
            	    {
            	    lv_isTransitive_13_0=(Token)match(input,92,FOLLOW_31); 

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
            	    break loop31;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4());
            				

            }

            otherlv_14=(Token)match(input,93,FOLLOW_5); 

            			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_5());
            		
            otherlv_15=(Token)match(input,66,FOLLOW_28); 

            			newLeafNode(otherlv_15, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_6());
            		
            // InternalOML.g:2330:3: ( (lv_unreifiedPropertyName_16_0= RULE_ID ) )
            // InternalOML.g:2331:4: (lv_unreifiedPropertyName_16_0= RULE_ID )
            {
            // InternalOML.g:2331:4: (lv_unreifiedPropertyName_16_0= RULE_ID )
            // InternalOML.g:2332:5: lv_unreifiedPropertyName_16_0= RULE_ID
            {
            lv_unreifiedPropertyName_16_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_unreifiedPropertyName_16_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unreifiedPropertyName",
            						lv_unreifiedPropertyName_16_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            // InternalOML.g:2348:3: (otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==94) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalOML.g:2349:4: otherlv_17= 'inverse' otherlv_18= '=' ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) )
                    {
                    otherlv_17=(Token)match(input,94,FOLLOW_5); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_8_0());
                    			
                    otherlv_18=(Token)match(input,66,FOLLOW_28); 

                    				newLeafNode(otherlv_18, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_8_1());
                    			
                    // InternalOML.g:2357:4: ( (lv_unreifiedInversePropertyName_19_0= RULE_ID ) )
                    // InternalOML.g:2358:5: (lv_unreifiedInversePropertyName_19_0= RULE_ID )
                    {
                    // InternalOML.g:2358:5: (lv_unreifiedInversePropertyName_19_0= RULE_ID )
                    // InternalOML.g:2359:6: lv_unreifiedInversePropertyName_19_0= RULE_ID
                    {
                    lv_unreifiedInversePropertyName_19_0=(Token)match(input,RULE_ID,FOLLOW_33); 

                    						newLeafNode(lv_unreifiedInversePropertyName_19_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_8_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unreifiedInversePropertyName",
                    							lv_unreifiedInversePropertyName_19_0,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_20=(Token)match(input,95,FOLLOW_5); 

            			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_9());
            		
            otherlv_21=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_21, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_10());
            		
            // InternalOML.g:2384:3: ( ( ruleReference ) )
            // InternalOML.g:2385:4: ( ruleReference )
            {
            // InternalOML.g:2385:4: ( ruleReference )
            // InternalOML.g:2386:5: ruleReference
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

            otherlv_23=(Token)match(input,96,FOLLOW_5); 

            			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_12());
            		
            otherlv_24=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_24, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_13());
            		
            // InternalOML.g:2408:3: ( ( ruleReference ) )
            // InternalOML.g:2409:4: ( ruleReference )
            {
            // InternalOML.g:2409:4: ( ruleReference )
            // InternalOML.g:2410:5: ruleReference
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

            otherlv_26=(Token)match(input,70,FOLLOW_2); 

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


    // $ANTLR start "entryRuleUnreifiedRelationship"
    // InternalOML.g:2432:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:2432:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2433:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
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
    // InternalOML.g:2439:1: ruleUnreifiedRelationship returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) ;
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
            // InternalOML.g:2445:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' ) )
            // InternalOML.g:2446:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            {
            // InternalOML.g:2446:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}' )
            // InternalOML.g:2447:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'unreifiedRelationship' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_14= 'source' otherlv_15= '=' ( ( ruleReference ) ) otherlv_17= 'target' otherlv_18= '=' ( ( ruleReference ) ) otherlv_20= '}'
            {
            // InternalOML.g:2447:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==67) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:2448:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2448:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2449:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop33;
                }
            } while (true);

            otherlv_1=(Token)match(input,97,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_1());
            		
            // InternalOML.g:2470:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2471:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2471:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2472:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:2492:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2493:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2493:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2494:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:2497:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2498:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2498:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*
            loop34:
            do {
                int alt34=10;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // InternalOML.g:2499:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2499:4: ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2500:5: {...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:2500:118: ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) )
            	    // InternalOML.g:2501:6: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:2504:9: ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) )
            	    // InternalOML.g:2504:10: {...}? => ( (lv_isFunctional_5_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2504:19: ( (lv_isFunctional_5_0= 'functional' ) )
            	    // InternalOML.g:2504:20: (lv_isFunctional_5_0= 'functional' )
            	    {
            	    // InternalOML.g:2504:20: (lv_isFunctional_5_0= 'functional' )
            	    // InternalOML.g:2505:10: lv_isFunctional_5_0= 'functional'
            	    {
            	    lv_isFunctional_5_0=(Token)match(input,84,FOLLOW_36); 

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
            	    // InternalOML.g:2522:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2522:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2523:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:2523:118: ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2524:6: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:2527:9: ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2527:10: {...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2527:19: ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2527:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2527:20: (lv_isInverseFunctional_6_0= 'inverseFunctional' )
            	    // InternalOML.g:2528:10: lv_isInverseFunctional_6_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_6_0=(Token)match(input,85,FOLLOW_36); 

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
            	    // InternalOML.g:2545:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2545:4: ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2546:5: {...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:2546:118: ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) )
            	    // InternalOML.g:2547:6: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:2550:9: ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) )
            	    // InternalOML.g:2550:10: {...}? => ( (lv_isEssential_7_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2550:19: ( (lv_isEssential_7_0= 'essential' ) )
            	    // InternalOML.g:2550:20: (lv_isEssential_7_0= 'essential' )
            	    {
            	    // InternalOML.g:2550:20: (lv_isEssential_7_0= 'essential' )
            	    // InternalOML.g:2551:10: lv_isEssential_7_0= 'essential'
            	    {
            	    lv_isEssential_7_0=(Token)match(input,86,FOLLOW_36); 

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
            	    // InternalOML.g:2568:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2568:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2569:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:2569:118: ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2570:6: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:2573:9: ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2573:10: {...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2573:19: ( (lv_isInverseEssential_8_0= 'inverseEssential' ) )
            	    // InternalOML.g:2573:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2573:20: (lv_isInverseEssential_8_0= 'inverseEssential' )
            	    // InternalOML.g:2574:10: lv_isInverseEssential_8_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_8_0=(Token)match(input,87,FOLLOW_36); 

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
            	    // InternalOML.g:2591:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2591:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2592:5: {...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:2592:118: ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2593:6: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:2596:9: ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) )
            	    // InternalOML.g:2596:10: {...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2596:19: ( (lv_isSymmetric_9_0= 'symmetric' ) )
            	    // InternalOML.g:2596:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2596:20: (lv_isSymmetric_9_0= 'symmetric' )
            	    // InternalOML.g:2597:10: lv_isSymmetric_9_0= 'symmetric'
            	    {
            	    lv_isSymmetric_9_0=(Token)match(input,88,FOLLOW_36); 

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
            	    // InternalOML.g:2614:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2614:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2615:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalOML.g:2615:118: ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2616:6: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalOML.g:2619:9: ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2619:10: {...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2619:19: ( (lv_isAsymmetric_10_0= 'asymmetric' ) )
            	    // InternalOML.g:2619:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2619:20: (lv_isAsymmetric_10_0= 'asymmetric' )
            	    // InternalOML.g:2620:10: lv_isAsymmetric_10_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_10_0=(Token)match(input,89,FOLLOW_36); 

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
            	    // InternalOML.g:2637:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2637:4: ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2638:5: {...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalOML.g:2638:118: ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2639:6: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalOML.g:2642:9: ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) )
            	    // InternalOML.g:2642:10: {...}? => ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2642:19: ( (lv_isReflexive_11_0= 'reflexive' ) )
            	    // InternalOML.g:2642:20: (lv_isReflexive_11_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2642:20: (lv_isReflexive_11_0= 'reflexive' )
            	    // InternalOML.g:2643:10: lv_isReflexive_11_0= 'reflexive'
            	    {
            	    lv_isReflexive_11_0=(Token)match(input,90,FOLLOW_36); 

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
            	    // InternalOML.g:2660:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2660:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2661:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // InternalOML.g:2661:118: ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2662:6: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7);
            	    					
            	    // InternalOML.g:2665:9: ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2665:10: {...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2665:19: ( (lv_isIrreflexive_12_0= 'irreflexive' ) )
            	    // InternalOML.g:2665:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2665:20: (lv_isIrreflexive_12_0= 'irreflexive' )
            	    // InternalOML.g:2666:10: lv_isIrreflexive_12_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_12_0=(Token)match(input,91,FOLLOW_36); 

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
            	    // InternalOML.g:2683:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2683:4: ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2684:5: {...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // InternalOML.g:2684:118: ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2685:6: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8);
            	    					
            	    // InternalOML.g:2688:9: ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) )
            	    // InternalOML.g:2688:10: {...}? => ( (lv_isTransitive_13_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2688:19: ( (lv_isTransitive_13_0= 'transitive' ) )
            	    // InternalOML.g:2688:20: (lv_isTransitive_13_0= 'transitive' )
            	    {
            	    // InternalOML.g:2688:20: (lv_isTransitive_13_0= 'transitive' )
            	    // InternalOML.g:2689:10: lv_isTransitive_13_0= 'transitive'
            	    {
            	    lv_isTransitive_13_0=(Token)match(input,92,FOLLOW_36); 

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
            	    break loop34;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4());
            				

            }

            otherlv_14=(Token)match(input,95,FOLLOW_5); 

            			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_5());
            		
            otherlv_15=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_6());
            		
            // InternalOML.g:2721:3: ( ( ruleReference ) )
            // InternalOML.g:2722:4: ( ruleReference )
            {
            // InternalOML.g:2722:4: ( ruleReference )
            // InternalOML.g:2723:5: ruleReference
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

            otherlv_17=(Token)match(input,96,FOLLOW_5); 

            			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_8());
            		
            otherlv_18=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_18, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_9());
            		
            // InternalOML.g:2745:3: ( ( ruleReference ) )
            // InternalOML.g:2746:4: ( ruleReference )
            {
            // InternalOML.g:2746:4: ( ruleReference )
            // InternalOML.g:2747:5: ruleReference
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

            otherlv_20=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:2769:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:2769:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:2770:2: iv_ruleScalar= ruleScalar EOF
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
    // InternalOML.g:2776:1: ruleScalar returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2782:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2783:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2783:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2784:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalar' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2784:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==67) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOML.g:2785:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2785:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2786:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop35;
                }
            } while (true);

            otherlv_1=(Token)match(input,98,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarAccess().getScalarKeyword_1());
            		
            // InternalOML.g:2807:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2808:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2808:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2809:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2829:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:2829:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:2830:2: iv_ruleStructure= ruleStructure EOF
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
    // InternalOML.g:2836:1: ruleStructure returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:2842:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalOML.g:2843:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalOML.g:2843:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalOML.g:2844:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structure' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalOML.g:2844:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==67) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:2845:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2845:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2846:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop36;
                }
            } while (true);

            otherlv_1=(Token)match(input,99,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructureAccess().getStructureKeyword_1());
            		
            // InternalOML.g:2867:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2868:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2868:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2869:5: lv_name_2_0= RULE_ID
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
    // InternalOML.g:2889:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:2889:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:2890:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
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
    // InternalOML.g:2896:1: ruleEntityStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:2902:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:2903:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:2903:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:2904:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:2904:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==67) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOML.g:2905:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:2905:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:2906:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop37;
                }
            } while (true);

            otherlv_1=(Token)match(input,100,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:2927:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==101) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalOML.g:2928:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:2928:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:2929:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,101,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2941:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:2942:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:2942:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:2943:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,69,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:2967:3: ( ( ruleReference ) )
            // InternalOML.g:2968:4: ( ruleReference )
            {
            // InternalOML.g:2968:4: ( ruleReference )
            // InternalOML.g:2969:5: ruleReference
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

            otherlv_7=(Token)match(input,103,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:2987:3: ( ( ruleReference ) )
            // InternalOML.g:2988:4: ( ruleReference )
            {
            // InternalOML.g:2988:4: ( ruleReference )
            // InternalOML.g:2989:5: ruleReference
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

            otherlv_9=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:3011:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:3011:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:3012:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
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
    // InternalOML.g:3018:1: ruleEntityScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:3024:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:3025:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:3025:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:3026:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_2_0= '+' ) )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '{' otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:3026:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==67) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalOML.g:3027:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3027:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3028:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop39;
                }
            } while (true);

            otherlv_1=(Token)match(input,104,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3049:3: ( (lv_isIdentityCriteria_2_0= '+' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==101) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalOML.g:3050:4: (lv_isIdentityCriteria_2_0= '+' )
                    {
                    // InternalOML.g:3050:4: (lv_isIdentityCriteria_2_0= '+' )
                    // InternalOML.g:3051:5: lv_isIdentityCriteria_2_0= '+'
                    {
                    lv_isIdentityCriteria_2_0=(Token)match(input,101,FOLLOW_28); 

                    					newLeafNode(lv_isIdentityCriteria_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:3063:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3064:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3064:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3065:5: lv_name_3_0= RULE_ID
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

            otherlv_4=(Token)match(input,69,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_4());
            		
            otherlv_5=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_5());
            		
            // InternalOML.g:3089:3: ( ( ruleReference ) )
            // InternalOML.g:3090:4: ( ruleReference )
            {
            // InternalOML.g:3090:4: ( ruleReference )
            // InternalOML.g:3091:5: ruleReference
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

            otherlv_7=(Token)match(input,103,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_7());
            		
            // InternalOML.g:3109:3: ( ( ruleReference ) )
            // InternalOML.g:3110:4: ( ruleReference )
            {
            // InternalOML.g:3110:4: ( ruleReference )
            // InternalOML.g:3111:5: ruleReference
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

            otherlv_9=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:3133:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:3133:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:3134:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
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
    // InternalOML.g:3140:1: ruleStructuredDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:3146:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3147:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3147:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3148:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'structuredDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3148:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==67) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalOML.g:3149:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3149:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3150:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop41;
                }
            } while (true);

            otherlv_1=(Token)match(input,105,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_1());
            		
            // InternalOML.g:3171:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3172:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3172:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3173:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3197:3: ( ( ruleReference ) )
            // InternalOML.g:3198:4: ( ruleReference )
            {
            // InternalOML.g:3198:4: ( ruleReference )
            // InternalOML.g:3199:5: ruleReference
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

            otherlv_6=(Token)match(input,103,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3217:3: ( ( ruleReference ) )
            // InternalOML.g:3218:4: ( ruleReference )
            {
            // InternalOML.g:3218:4: ( ruleReference )
            // InternalOML.g:3219:5: ruleReference
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

            otherlv_8=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:3241:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:3241:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:3242:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
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
    // InternalOML.g:3248:1: ruleScalarDataProperty returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:3254:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:3255:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:3255:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:3256:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarDataProperty' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            // InternalOML.g:3256:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==67) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalOML.g:3257:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3257:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3258:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop42;
                }
            } while (true);

            otherlv_1=(Token)match(input,106,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_1());
            		
            // InternalOML.g:3279:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3280:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3280:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3281:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_41); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:3305:3: ( ( ruleReference ) )
            // InternalOML.g:3306:4: ( ruleReference )
            {
            // InternalOML.g:3306:4: ( ruleReference )
            // InternalOML.g:3307:5: ruleReference
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

            otherlv_6=(Token)match(input,103,FOLLOW_21); 

            			newLeafNode(otherlv_6, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:3325:3: ( ( ruleReference ) )
            // InternalOML.g:3326:4: ( ruleReference )
            {
            // InternalOML.g:3326:4: ( ruleReference )
            // InternalOML.g:3327:5: ruleReference
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

            otherlv_8=(Token)match(input,70,FOLLOW_2); 

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


    // $ANTLR start "entryRuleAnonymousConceptUnionAxiom"
    // InternalOML.g:3349:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:3349:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:3350:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
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
    // InternalOML.g:3356:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:3362:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:3363:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:3363:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:3364:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'anonymousConceptUnion' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:3364:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==67) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalOML.g:3365:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3365:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3366:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_46);
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
            	    break loop43;
                }
            } while (true);

            otherlv_1=(Token)match(input,107,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:3391:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:3392:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:3392:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:3393:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_48); 

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

            otherlv_4=(Token)match(input,109,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,69,FOLLOW_49); 

            			newLeafNode(otherlv_5, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:3417:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==67||LA44_0==107||LA44_0==111) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalOML.g:3418:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3418:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3419:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_49);
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
            	    break loop44;
                }
            } while (true);

            otherlv_7=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:3444:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:3444:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:3445:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
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
    // InternalOML.g:3451:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:3457:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' ) )
            // InternalOML.g:3458:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            {
            // InternalOML.g:3458:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}' )
            // InternalOML.g:3459:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'rootConceptTaxonomy' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '{' ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_7= '}'
            {
            // InternalOML.g:3459:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==67) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalOML.g:3460:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3460:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3461:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_50);
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
            	    break loop45;
                }
            } while (true);

            otherlv_1=(Token)match(input,110,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:3486:3: ( ( ruleReference ) )
            // InternalOML.g:3487:4: ( ruleReference )
            {
            // InternalOML.g:3487:4: ( ruleReference )
            // InternalOML.g:3488:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,109,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,69,FOLLOW_49); 

            			newLeafNode(otherlv_5, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:3510:3: ( (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==67||LA46_0==107||LA46_0==111) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalOML.g:3511:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3511:4: (lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3512:5: lv_disjunctions_6_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_49);
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
            	    break loop46;
                }
            } while (true);

            otherlv_7=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:3537:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:3537:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:3538:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
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
    // InternalOML.g:3544:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3550:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' ) )
            // InternalOML.g:3551:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' )
            {
            // InternalOML.g:3551:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' )
            // InternalOML.g:3552:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'disjointLeaf' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')'
            {
            // InternalOML.g:3552:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==67) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalOML.g:3553:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3553:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3554:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_51);
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
            	    break loop47;
                }
            } while (true);

            otherlv_1=(Token)match(input,111,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:3579:3: ( ( ruleReference ) )
            // InternalOML.g:3580:4: ( ruleReference )
            {
            // InternalOML.g:3580:4: ( ruleReference )
            // InternalOML.g:3581:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_3_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,109,FOLLOW_2); 

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
    // InternalOML.g:3603:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3603:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:3604:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3610:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3616:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3617:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3617:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3618:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:3618:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==67) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalOML.g:3619:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3619:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3620:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_52);
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
            	    break loop48;
                }
            } while (true);

            otherlv_1=(Token)match(input,112,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_1());
            		
            // InternalOML.g:3641:3: ( ( ruleReference ) )
            // InternalOML.g:3642:4: ( ruleReference )
            {
            // InternalOML.g:3642:4: ( ruleReference )
            // InternalOML.g:3643:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:3661:3: ( ( ruleReference ) )
            // InternalOML.g:3662:4: ( ruleReference )
            {
            // InternalOML.g:3662:4: ( ruleReference )
            // InternalOML.g:3663:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,114,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:3681:3: ( ( ruleReference ) )
            // InternalOML.g:3682:4: ( ruleReference )
            {
            // InternalOML.g:3682:4: ( ruleReference )
            // InternalOML.g:3683:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
            				
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
    // $ANTLR end "ruleEntityExistentialRestrictionAxiom"


    // $ANTLR start "entryRuleEntityUniversalRestrictionAxiom"
    // InternalOML.g:3701:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3701:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:3702:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3708:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3714:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3715:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3715:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3716:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allEntities' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:3716:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==67) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalOML.g:3717:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3717:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3718:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_55);
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
            	    break loop49;
                }
            } while (true);

            otherlv_1=(Token)match(input,115,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_1());
            		
            // InternalOML.g:3739:3: ( ( ruleReference ) )
            // InternalOML.g:3740:4: ( ruleReference )
            {
            // InternalOML.g:3740:4: ( ruleReference )
            // InternalOML.g:3741:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:3759:3: ( ( ruleReference ) )
            // InternalOML.g:3760:4: ( ruleReference )
            {
            // InternalOML.g:3760:4: ( ruleReference )
            // InternalOML.g:3761:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,114,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:3779:3: ( ( ruleReference ) )
            // InternalOML.g:3780:4: ( ruleReference )
            {
            // InternalOML.g:3780:4: ( ruleReference )
            // InternalOML.g:3781:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_6_0());
            				
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
    // $ANTLR end "ruleEntityUniversalRestrictionAxiom"


    // $ANTLR start "entryRuleAspectSpecializationAxiom"
    // InternalOML.g:3799:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:3799:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:3800:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
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
    // InternalOML.g:3806:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3812:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:3813:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3813:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:3814:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:3814:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==67) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalOML.g:3815:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3815:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3816:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop50;
                }
            } while (true);

            // InternalOML.g:3833:3: ( ( ruleReference ) )
            // InternalOML.g:3834:4: ( ruleReference )
            {
            // InternalOML.g:3834:4: ( ruleReference )
            // InternalOML.g:3835:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_56);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,116,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_2());
            		
            // InternalOML.g:3853:3: ( ( ruleReference ) )
            // InternalOML.g:3854:4: ( ruleReference )
            {
            // InternalOML.g:3854:4: ( ruleReference )
            // InternalOML.g:3855:5: ruleReference
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
    // InternalOML.g:3873:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:3873:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:3874:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
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
    // InternalOML.g:3880:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3886:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:3887:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3887:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:3888:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:3888:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==67) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalOML.g:3889:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3889:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3890:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop51;
                }
            } while (true);

            // InternalOML.g:3907:3: ( ( ruleReference ) )
            // InternalOML.g:3908:4: ( ruleReference )
            {
            // InternalOML.g:3908:4: ( ruleReference )
            // InternalOML.g:3909:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_1_0());
            				
            pushFollow(FOLLOW_57);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,117,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_2());
            		
            // InternalOML.g:3927:3: ( ( ruleReference ) )
            // InternalOML.g:3928:4: ( ruleReference )
            {
            // InternalOML.g:3928:4: ( ruleReference )
            // InternalOML.g:3929:5: ruleReference
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
    // InternalOML.g:3947:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:3947:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:3948:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
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
    // InternalOML.g:3954:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3960:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:3961:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3961:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:3962:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:3962:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==67) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalOML.g:3963:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:3963:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:3964:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop52;
                }
            } while (true);

            // InternalOML.g:3981:3: ( ( ruleReference ) )
            // InternalOML.g:3982:4: ( ruleReference )
            {
            // InternalOML.g:3982:4: ( ruleReference )
            // InternalOML.g:3983:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_1_0());
            				
            pushFollow(FOLLOW_58);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,118,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_2());
            		
            // InternalOML.g:4001:3: ( ( ruleReference ) )
            // InternalOML.g:4002:4: ( ruleReference )
            {
            // InternalOML.g:4002:4: ( ruleReference )
            // InternalOML.g:4003:5: ruleReference
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


    // $ANTLR start "entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom"
    // InternalOML.g:4021:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:4021:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:4022:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
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
    // InternalOML.g:4028:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4034:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:4035:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4035:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:4036:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'someData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:4036:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==67) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalOML.g:4037:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4037:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4038:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_59);
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
            	    break loop53;
                }
            } while (true);

            otherlv_1=(Token)match(input,119,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_1());
            		
            // InternalOML.g:4059:3: ( ( ruleReference ) )
            // InternalOML.g:4060:4: ( ruleReference )
            {
            // InternalOML.g:4060:4: ( ruleReference )
            // InternalOML.g:4061:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4079:3: ( ( ruleReference ) )
            // InternalOML.g:4080:4: ( ruleReference )
            {
            // InternalOML.g:4080:4: ( ruleReference )
            // InternalOML.g:4081:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,114,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4099:3: ( ( ruleReference ) )
            // InternalOML.g:4100:4: ( ruleReference )
            {
            // InternalOML.g:4100:4: ( ruleReference )
            // InternalOML.g:4101:5: ruleReference
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
    // InternalOML.g:4119:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:4119:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:4120:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:4126:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_literalValue_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4132:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) ) )
            // InternalOML.g:4133:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) )
            {
            // InternalOML.g:4133:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) ) )
            // InternalOML.g:4134:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' ( (lv_literalValue_6_0= ruleLiteralValue ) )
            {
            // InternalOML.g:4134:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==67) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalOML.g:4135:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4135:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4136:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    break loop54;
                }
            } while (true);

            otherlv_1=(Token)match(input,120,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:4157:3: ( ( ruleReference ) )
            // InternalOML.g:4158:4: ( ruleReference )
            {
            // InternalOML.g:4158:4: ( ruleReference )
            // InternalOML.g:4159:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4177:3: ( ( ruleReference ) )
            // InternalOML.g:4178:4: ( ruleReference )
            {
            // InternalOML.g:4178:4: ( ruleReference )
            // InternalOML.g:4179:5: ruleReference
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

            otherlv_5=(Token)match(input,66,FOLLOW_61); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:4197:3: ( (lv_literalValue_6_0= ruleLiteralValue ) )
            // InternalOML.g:4198:4: (lv_literalValue_6_0= ruleLiteralValue )
            {
            // InternalOML.g:4198:4: (lv_literalValue_6_0= ruleLiteralValue )
            // InternalOML.g:4199:5: lv_literalValue_6_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueLiteralValueParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalOML.g:4220:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:4220:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:4221:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
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
    // InternalOML.g:4227:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4233:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:4234:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:4234:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:4235:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'allData' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= 'in' ( ( ruleReference ) )
            {
            // InternalOML.g:4235:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==67) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalOML.g:4236:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4236:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4237:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_62);
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
            	    break loop55;
                }
            } while (true);

            otherlv_1=(Token)match(input,121,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_1());
            		
            // InternalOML.g:4258:3: ( ( ruleReference ) )
            // InternalOML.g:4259:4: ( ruleReference )
            {
            // InternalOML.g:4259:4: ( ruleReference )
            // InternalOML.g:4260:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4278:3: ( ( ruleReference ) )
            // InternalOML.g:4279:4: ( ruleReference )
            {
            // InternalOML.g:4279:4: ( ruleReference )
            // InternalOML.g:4280:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,114,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_5());
            		
            // InternalOML.g:4298:3: ( ( ruleReference ) )
            // InternalOML.g:4299:4: ( ruleReference )
            {
            // InternalOML.g:4299:4: ( ruleReference )
            // InternalOML.g:4300:5: ruleReference
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
    // InternalOML.g:4318:1: entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:4318:95: (iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:4319:2: iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:4325:1: ruleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) ;
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
            // InternalOML.g:4331:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' ) )
            // InternalOML.g:4332:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            {
            // InternalOML.g:4332:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}' )
            // InternalOML.g:4333:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'every' ( ( ruleReference ) ) otherlv_3= '.' ( ( ruleReference ) ) otherlv_5= '=' otherlv_6= '{' ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_9= '}'
            {
            // InternalOML.g:4333:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==67) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalOML.g:4334:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4334:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4335:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    break loop56;
                }
            } while (true);

            otherlv_1=(Token)match(input,120,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_1());
            		
            // InternalOML.g:4356:3: ( ( ruleReference ) )
            // InternalOML.g:4357:4: ( ruleReference )
            {
            // InternalOML.g:4357:4: ( ruleReference )
            // InternalOML.g:4358:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_2_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_3());
            		
            // InternalOML.g:4376:3: ( ( ruleReference ) )
            // InternalOML.g:4377:4: ( ruleReference )
            {
            // InternalOML.g:4377:4: ( ruleReference )
            // InternalOML.g:4378:5: ruleReference
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

            otherlv_5=(Token)match(input,66,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_5());
            		
            otherlv_6=(Token)match(input,69,FOLLOW_63); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalOML.g:4400:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop57:
            do {
                int alt57=3;
                alt57 = dfa57.predict(input);
                switch (alt57) {
            	case 1 :
            	    // InternalOML.g:4401:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:4401:4: ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:4402:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:4402:5: (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:4403:6: lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    // InternalOML.g:4421:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:4421:4: ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:4422:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:4422:5: (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:4423:6: lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    break loop57;
                }
            } while (true);

            otherlv_9=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:4449:1: entryRuleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:4449:79: (iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF )
            // InternalOML.g:4450:2: iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF
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
    // InternalOML.g:4456:1: ruleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:4462:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:4463:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:4463:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:4464:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:4464:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==67) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalOML.g:4465:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4465:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4466:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop58;
                }
            } while (true);

            // InternalOML.g:4483:3: ( ( ruleReference ) )
            // InternalOML.g:4484:4: ( ruleReference )
            {
            // InternalOML.g:4484:4: ( ruleReference )
            // InternalOML.g:4485:5: ruleReference
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

            otherlv_2=(Token)match(input,66,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,69,FOLLOW_63); 

            			newLeafNode(otherlv_3, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:4507:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop59:
            do {
                int alt59=3;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // InternalOML.g:4508:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:4508:4: ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:4509:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:4509:5: (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:4510:6: lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyRestrictionsRestrictionStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    // InternalOML.g:4528:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:4528:4: ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:4529:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:4529:5: (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:4530:6: lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyRestrictionsRestrictionScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    break loop59;
                }
            } while (true);

            otherlv_6=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:4556:1: entryRuleRestrictionScalarDataPropertyValue returns [EObject current=null] : iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF ;
    public final EObject entryRuleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionScalarDataPropertyValue = null;


        try {
            // InternalOML.g:4556:75: (iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF )
            // InternalOML.g:4557:2: iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF
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
    // InternalOML.g:4563:1: ruleRestrictionScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) ) ;
    public final EObject ruleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4569:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) ) )
            // InternalOML.g:4570:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) )
            {
            // InternalOML.g:4570:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) )
            // InternalOML.g:4571:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            {
            // InternalOML.g:4571:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==67) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalOML.g:4572:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4572:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4573:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop60;
                }
            } while (true);

            // InternalOML.g:4590:3: ( ( ruleReference ) )
            // InternalOML.g:4591:4: ( ruleReference )
            {
            // InternalOML.g:4591:4: ( ruleReference )
            // InternalOML.g:4592:5: ruleReference
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

            otherlv_2=(Token)match(input,66,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:4610:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:4611:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:4611:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:4612:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalOML.g:4633:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:4633:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:4634:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
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
    // InternalOML.g:4640:1: ruleBinaryScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) ;
    public final EObject ruleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_length_6_0=null;
        Token otherlv_7=null;
        Token lv_minLength_8_0=null;
        Token otherlv_9=null;
        Token lv_maxLength_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4646:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' ) )
            // InternalOML.g:4647:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            {
            // InternalOML.g:4647:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}' )
            // InternalOML.g:4648:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'binaryScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) ) otherlv_11= 'restrictedRange' ( ( ruleReference ) ) otherlv_13= '}'
            {
            // InternalOML.g:4648:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==67) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalOML.g:4649:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4649:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4650:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_64);
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
            	    break loop61;
                }
            } while (true);

            otherlv_1=(Token)match(input,122,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_1());
            		
            // InternalOML.g:4671:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:4672:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:4672:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:4673:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_65); 

            			newLeafNode(otherlv_3, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:4693:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4694:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4694:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* ) )
            // InternalOML.g:4695:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:4698:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )* )
            // InternalOML.g:4699:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )*
            {
            // InternalOML.g:4699:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) )*
            loop62:
            do {
                int alt62=4;
                int LA62_0 = input.LA(1);

                if ( LA62_0 == 123 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt62=1;
                }
                else if ( LA62_0 == 124 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt62=2;
                }
                else if ( LA62_0 == 125 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt62=3;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalOML.g:4700:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4700:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4701:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:4701:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4702:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:4705:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4705:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4705:19: (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4705:20: otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) )
            	    {
            	    otherlv_5=(Token)match(input,123,FOLLOW_66); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:4709:9: ( (lv_length_6_0= RULE_DIGITS ) )
            	    // InternalOML.g:4710:10: (lv_length_6_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4710:10: (lv_length_6_0= RULE_DIGITS )
            	    // InternalOML.g:4711:11: lv_length_6_0= RULE_DIGITS
            	    {
            	    lv_length_6_0=(Token)match(input,RULE_DIGITS,FOLLOW_65); 

            	    											newLeafNode(lv_length_6_0, grammarAccess.getBinaryScalarRestrictionAccess().getLengthDIGITSTerminalRuleCall_4_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:4733:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4733:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4734:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:4734:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4735:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:4738:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4738:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4738:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4738:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    {
            	    otherlv_7=(Token)match(input,124,FOLLOW_66); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:4742:9: ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    // InternalOML.g:4743:10: (lv_minLength_8_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4743:10: (lv_minLength_8_0= RULE_DIGITS )
            	    // InternalOML.g:4744:11: lv_minLength_8_0= RULE_DIGITS
            	    {
            	    lv_minLength_8_0=(Token)match(input,RULE_DIGITS,FOLLOW_65); 

            	    											newLeafNode(lv_minLength_8_0, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthDIGITSTerminalRuleCall_4_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:4766:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4766:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4767:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:4767:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4768:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:4771:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4771:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4771:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4771:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    {
            	    otherlv_9=(Token)match(input,125,FOLLOW_66); 

            	    									newLeafNode(otherlv_9, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:4775:9: ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    // InternalOML.g:4776:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4776:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    // InternalOML.g:4777:11: lv_maxLength_10_0= RULE_DIGITS
            	    {
            	    lv_maxLength_10_0=(Token)match(input,RULE_DIGITS,FOLLOW_65); 

            	    											newLeafNode(lv_maxLength_10_0, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthDIGITSTerminalRuleCall_4_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    break loop62;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_11=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_11, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:4810:3: ( ( ruleReference ) )
            // InternalOML.g:4811:4: ( ruleReference )
            {
            // InternalOML.g:4811:4: ( ruleReference )
            // InternalOML.g:4812:5: ruleReference
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

            otherlv_13=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:4834:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:4834:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:4835:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
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
    // InternalOML.g:4841:1: ruleIRIScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_length_6_0=null;
        Token otherlv_7=null;
        Token lv_minLength_8_0=null;
        Token otherlv_9=null;
        Token lv_maxLength_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_pattern_12_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4847:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:4848:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:4848:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:4849:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'iriScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:4849:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==67) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalOML.g:4850:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:4850:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:4851:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_67);
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
            	    break loop63;
                }
            } while (true);

            otherlv_1=(Token)match(input,127,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_1());
            		
            // InternalOML.g:4872:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:4873:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:4873:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:4874:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_68); 

            			newLeafNode(otherlv_3, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:4894:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4895:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4895:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) )
            // InternalOML.g:4896:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:4899:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* )
            // InternalOML.g:4900:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )*
            {
            // InternalOML.g:4900:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )*
            loop64:
            do {
                int alt64=5;
                int LA64_0 = input.LA(1);

                if ( LA64_0 == 123 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt64=1;
                }
                else if ( LA64_0 == 124 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt64=2;
                }
                else if ( LA64_0 == 125 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt64=3;
                }
                else if ( LA64_0 == 128 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt64=4;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalOML.g:4901:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4901:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4902:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:4902:117: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4903:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:4906:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4906:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4906:19: (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4906:20: otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) )
            	    {
            	    otherlv_5=(Token)match(input,123,FOLLOW_66); 

            	    									newLeafNode(otherlv_5, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:4910:9: ( (lv_length_6_0= RULE_DIGITS ) )
            	    // InternalOML.g:4911:10: (lv_length_6_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4911:10: (lv_length_6_0= RULE_DIGITS )
            	    // InternalOML.g:4912:11: lv_length_6_0= RULE_DIGITS
            	    {
            	    lv_length_6_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_length_6_0, grammarAccess.getIRIScalarRestrictionAccess().getLengthDIGITSTerminalRuleCall_4_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:4934:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4934:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4935:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:4935:117: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4936:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:4939:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4939:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4939:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4939:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    {
            	    otherlv_7=(Token)match(input,124,FOLLOW_66); 

            	    									newLeafNode(otherlv_7, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:4943:9: ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    // InternalOML.g:4944:10: (lv_minLength_8_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4944:10: (lv_minLength_8_0= RULE_DIGITS )
            	    // InternalOML.g:4945:11: lv_minLength_8_0= RULE_DIGITS
            	    {
            	    lv_minLength_8_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_minLength_8_0, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthDIGITSTerminalRuleCall_4_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:4967:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4967:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:4968:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:4968:117: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:4969:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:4972:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:4972:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4972:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:4972:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    {
            	    otherlv_9=(Token)match(input,125,FOLLOW_66); 

            	    									newLeafNode(otherlv_9, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:4976:9: ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    // InternalOML.g:4977:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:4977:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    // InternalOML.g:4978:11: lv_maxLength_10_0= RULE_DIGITS
            	    {
            	    lv_maxLength_10_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_maxLength_10_0, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthDIGITSTerminalRuleCall_4_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5000:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5000:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    // InternalOML.g:5001:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5001:117: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    // InternalOML.g:5002:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5005:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    // InternalOML.g:5005:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5005:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    // InternalOML.g:5005:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    {
            	    otherlv_11=(Token)match(input,128,FOLLOW_7); 

            	    									newLeafNode(otherlv_11, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5009:9: ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    // InternalOML.g:5010:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    {
            	    // InternalOML.g:5010:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    // InternalOML.g:5011:11: lv_pattern_12_0= ruleLiteralPattern
            	    {

            	    											newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getPatternLiteralPatternParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_68);
            	    lv_pattern_12_0=ruleLiteralPattern();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralPattern");
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

            	default :
            	    break loop64;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5045:3: ( ( ruleReference ) )
            // InternalOML.g:5046:4: ( ruleReference )
            {
            // InternalOML.g:5046:4: ( ruleReference )
            // InternalOML.g:5047:5: ruleReference
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

            otherlv_15=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:5069:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:5069:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:5070:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
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
    // InternalOML.g:5076:1: ruleNumericScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:5082:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5083:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5083:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5084:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'numericScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5084:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==67) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalOML.g:5085:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5085:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5086:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_69);
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
            	    break loop65;
                }
            } while (true);

            otherlv_1=(Token)match(input,129,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5107:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5108:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5108:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5109:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5129:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5130:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5130:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* ) )
            // InternalOML.g:5131:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5134:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )* )
            // InternalOML.g:5135:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            {
            // InternalOML.g:5135:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) ) )*
            loop66:
            do {
                int alt66=5;
                int LA66_0 = input.LA(1);

                if ( LA66_0 == 130 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt66=1;
                }
                else if ( LA66_0 == 131 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt66=2;
                }
                else if ( LA66_0 == 132 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt66=3;
                }
                else if ( LA66_0 == 133 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt66=4;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalOML.g:5136:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5136:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5137:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5137:121: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5138:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5141:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5141:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5141:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5141:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_5=(Token)match(input,130,FOLLOW_61); 

            	    									newLeafNode(otherlv_5, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5145:9: ( (lv_minInclusive_6_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5146:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5146:10: (lv_minInclusive_6_0= ruleLiteralNumber )
            	    // InternalOML.g:5147:11: lv_minInclusive_6_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveLiteralNumberParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:5170:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5170:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5171:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5171:121: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5172:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5175:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5175:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5175:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5175:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_7=(Token)match(input,131,FOLLOW_61); 

            	    									newLeafNode(otherlv_7, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5179:9: ( (lv_maxInclusive_8_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5180:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5180:10: (lv_maxInclusive_8_0= ruleLiteralNumber )
            	    // InternalOML.g:5181:11: lv_maxInclusive_8_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveLiteralNumberParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:5204:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5204:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5205:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5205:121: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5206:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5209:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5209:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5209:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5209:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_9=(Token)match(input,132,FOLLOW_61); 

            	    									newLeafNode(otherlv_9, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5213:9: ( (lv_minExclusive_10_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5214:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5214:10: (lv_minExclusive_10_0= ruleLiteralNumber )
            	    // InternalOML.g:5215:11: lv_minExclusive_10_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveLiteralNumberParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:5238:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5238:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) ) )
            	    // InternalOML.g:5239:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5239:121: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) ) )
            	    // InternalOML.g:5240:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5243:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) ) )
            	    // InternalOML.g:5243:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5243:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) ) )
            	    // InternalOML.g:5243:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    {
            	    otherlv_11=(Token)match(input,133,FOLLOW_61); 

            	    									newLeafNode(otherlv_11, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5247:9: ( (lv_maxExclusive_12_0= ruleLiteralNumber ) )
            	    // InternalOML.g:5248:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    {
            	    // InternalOML.g:5248:10: (lv_maxExclusive_12_0= ruleLiteralNumber )
            	    // InternalOML.g:5249:11: lv_maxExclusive_12_0= ruleLiteralNumber
            	    {

            	    											newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveLiteralNumberParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    break loop66;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5283:3: ( ( ruleReference ) )
            // InternalOML.g:5284:4: ( ruleReference )
            {
            // InternalOML.g:5284:4: ( ruleReference )
            // InternalOML.g:5285:5: ruleReference
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

            otherlv_15=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:5307:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:5307:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:5308:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
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
    // InternalOML.g:5314:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) ;
    public final EObject rulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_length_6_0=null;
        Token otherlv_7=null;
        Token lv_minLength_8_0=null;
        Token otherlv_9=null;
        Token lv_maxLength_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_pattern_12_0 = null;

        EObject lv_langRange_14_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5320:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' ) )
            // InternalOML.g:5321:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            {
            // InternalOML.g:5321:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}' )
            // InternalOML.g:5322:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'plainLiteralScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) ) otherlv_15= 'restrictedRange' ( ( ruleReference ) ) otherlv_17= '}'
            {
            // InternalOML.g:5322:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==67) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalOML.g:5323:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5323:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5324:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_71);
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
            	    break loop67;
                }
            } while (true);

            otherlv_1=(Token)match(input,134,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5345:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5346:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5346:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5347:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_72); 

            			newLeafNode(otherlv_3, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5367:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5368:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5368:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* ) )
            // InternalOML.g:5369:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5372:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )* )
            // InternalOML.g:5373:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )*
            {
            // InternalOML.g:5373:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) ) )*
            loop68:
            do {
                int alt68=6;
                int LA68_0 = input.LA(1);

                if ( LA68_0 == 123 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt68=1;
                }
                else if ( LA68_0 == 124 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt68=2;
                }
                else if ( LA68_0 == 125 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt68=3;
                }
                else if ( LA68_0 == 128 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt68=4;
                }
                else if ( LA68_0 == 135 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
                    alt68=5;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalOML.g:5374:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5374:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5375:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5375:126: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5376:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5379:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5379:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5379:19: (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5379:20: otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) )
            	    {
            	    otherlv_5=(Token)match(input,123,FOLLOW_66); 

            	    									newLeafNode(otherlv_5, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5383:9: ( (lv_length_6_0= RULE_DIGITS ) )
            	    // InternalOML.g:5384:10: (lv_length_6_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5384:10: (lv_length_6_0= RULE_DIGITS )
            	    // InternalOML.g:5385:11: lv_length_6_0= RULE_DIGITS
            	    {
            	    lv_length_6_0=(Token)match(input,RULE_DIGITS,FOLLOW_72); 

            	    											newLeafNode(lv_length_6_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthDIGITSTerminalRuleCall_4_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5407:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5407:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5408:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5408:126: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5409:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5412:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5412:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5412:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5412:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    {
            	    otherlv_7=(Token)match(input,124,FOLLOW_66); 

            	    									newLeafNode(otherlv_7, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5416:9: ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    // InternalOML.g:5417:10: (lv_minLength_8_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5417:10: (lv_minLength_8_0= RULE_DIGITS )
            	    // InternalOML.g:5418:11: lv_minLength_8_0= RULE_DIGITS
            	    {
            	    lv_minLength_8_0=(Token)match(input,RULE_DIGITS,FOLLOW_72); 

            	    											newLeafNode(lv_minLength_8_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthDIGITSTerminalRuleCall_4_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5440:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5440:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5441:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5441:126: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5442:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5445:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5445:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5445:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5445:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    {
            	    otherlv_9=(Token)match(input,125,FOLLOW_66); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5449:9: ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    // InternalOML.g:5450:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5450:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    // InternalOML.g:5451:11: lv_maxLength_10_0= RULE_DIGITS
            	    {
            	    lv_maxLength_10_0=(Token)match(input,RULE_DIGITS,FOLLOW_72); 

            	    											newLeafNode(lv_maxLength_10_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthDIGITSTerminalRuleCall_4_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5473:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5473:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    // InternalOML.g:5474:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5474:126: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    // InternalOML.g:5475:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5478:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    // InternalOML.g:5478:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5478:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    // InternalOML.g:5478:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    {
            	    otherlv_11=(Token)match(input,128,FOLLOW_7); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5482:9: ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    // InternalOML.g:5483:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    {
            	    // InternalOML.g:5483:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    // InternalOML.g:5484:11: lv_pattern_12_0= ruleLiteralPattern
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternLiteralPatternParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_72);
            	    lv_pattern_12_0=ruleLiteralPattern();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralPattern");
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
            	case 5 :
            	    // InternalOML.g:5507:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5507:4: ({...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) ) )
            	    // InternalOML.g:5508:5: {...}? => ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalOML.g:5508:126: ( ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) ) )
            	    // InternalOML.g:5509:6: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalOML.g:5512:9: ({...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) ) )
            	    // InternalOML.g:5512:10: {...}? => (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5512:19: (otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) ) )
            	    // InternalOML.g:5512:20: otherlv_13= 'langRange' ( (lv_langRange_14_0= ruleLiteralLanguageTag ) )
            	    {
            	    otherlv_13=(Token)match(input,135,FOLLOW_73); 

            	    									newLeafNode(otherlv_13, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_4_4_0());
            	    								
            	    // InternalOML.g:5516:9: ( (lv_langRange_14_0= ruleLiteralLanguageTag ) )
            	    // InternalOML.g:5517:10: (lv_langRange_14_0= ruleLiteralLanguageTag )
            	    {
            	    // InternalOML.g:5517:10: (lv_langRange_14_0= ruleLiteralLanguageTag )
            	    // InternalOML.g:5518:11: lv_langRange_14_0= ruleLiteralLanguageTag
            	    {

            	    											newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeLiteralLanguageTagParserRuleCall_4_4_1_0());
            	    										
            	    pushFollow(FOLLOW_72);
            	    lv_langRange_14_0=ruleLiteralLanguageTag();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"langRange",
            	    												lv_langRange_14_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralLanguageTag");
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

            	default :
            	    break loop68;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_15=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_15, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5552:3: ( ( ruleReference ) )
            // InternalOML.g:5553:4: ( ruleReference )
            {
            // InternalOML.g:5553:4: ( ruleReference )
            // InternalOML.g:5554:5: ruleReference
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

            otherlv_17=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:5576:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:5576:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:5577:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
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
    // InternalOML.g:5583:1: ruleScalarOneOfRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
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
            // InternalOML.g:5589:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:5590:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:5590:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:5591:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'scalarOneOfRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:5591:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==67) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalOML.g:5592:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5592:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5593:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_74);
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
            	    break loop69;
                }
            } while (true);

            otherlv_1=(Token)match(input,136,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_1());
            		
            // InternalOML.g:5614:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5615:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5615:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5616:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_75); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5640:3: ( ( ruleReference ) )
            // InternalOML.g:5641:4: ( ruleReference )
            {
            // InternalOML.g:5641:4: ( ruleReference )
            // InternalOML.g:5642:5: ruleReference
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

            otherlv_6=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:5664:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:5664:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:5665:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
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
    // InternalOML.g:5671:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5677:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) ) )
            // InternalOML.g:5678:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) )
            {
            // InternalOML.g:5678:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) ) )
            // InternalOML.g:5679:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'oneOf' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_value_4_0= ruleLiteralValue ) )
            {
            // InternalOML.g:5679:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalOML.g:5680:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5680:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5681:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_76);
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
            	    break loop70;
                }
            } while (true);

            otherlv_1=(Token)match(input,137,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_1());
            		
            // InternalOML.g:5702:3: ( ( ruleReference ) )
            // InternalOML.g:5703:4: ( ruleReference )
            {
            // InternalOML.g:5703:4: ( ruleReference )
            // InternalOML.g:5704:5: ruleReference
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

            otherlv_3=(Token)match(input,66,FOLLOW_61); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:5722:3: ( (lv_value_4_0= ruleLiteralValue ) )
            // InternalOML.g:5723:4: (lv_value_4_0= ruleLiteralValue )
            {
            // InternalOML.g:5723:4: (lv_value_4_0= ruleLiteralValue )
            // InternalOML.g:5724:5: lv_value_4_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueLiteralValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalOML.g:5745:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:5745:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:5746:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
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
    // InternalOML.g:5752:1: ruleStringScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
    public final EObject ruleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_length_6_0=null;
        Token otherlv_7=null;
        Token lv_minLength_8_0=null;
        Token otherlv_9=null;
        Token lv_maxLength_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_pattern_12_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5758:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:5759:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:5759:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:5760:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'stringScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:5760:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==67) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalOML.g:5761:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5761:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5762:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_77);
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
            	    break loop71;
                }
            } while (true);

            otherlv_1=(Token)match(input,138,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_1());
            		
            // InternalOML.g:5783:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5784:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5784:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5785:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_68); 

            			newLeafNode(otherlv_3, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5805:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5806:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5806:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* ) )
            // InternalOML.g:5807:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:5810:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )* )
            // InternalOML.g:5811:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )*
            {
            // InternalOML.g:5811:6: ( ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) ) )*
            loop72:
            do {
                int alt72=5;
                int LA72_0 = input.LA(1);

                if ( LA72_0 == 123 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt72=1;
                }
                else if ( LA72_0 == 124 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt72=2;
                }
                else if ( LA72_0 == 125 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt72=3;
                }
                else if ( LA72_0 == 128 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt72=4;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalOML.g:5812:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5812:4: ({...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5813:5: {...}? => ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:5813:120: ( ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5814:6: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:5817:9: ({...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5817:10: {...}? => (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5817:19: (otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5817:20: otherlv_5= 'length' ( (lv_length_6_0= RULE_DIGITS ) )
            	    {
            	    otherlv_5=(Token)match(input,123,FOLLOW_66); 

            	    									newLeafNode(otherlv_5, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_4_0_0());
            	    								
            	    // InternalOML.g:5821:9: ( (lv_length_6_0= RULE_DIGITS ) )
            	    // InternalOML.g:5822:10: (lv_length_6_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5822:10: (lv_length_6_0= RULE_DIGITS )
            	    // InternalOML.g:5823:11: lv_length_6_0= RULE_DIGITS
            	    {
            	    lv_length_6_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_length_6_0, grammarAccess.getStringScalarRestrictionAccess().getLengthDIGITSTerminalRuleCall_4_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_6_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5845:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5845:4: ({...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5846:5: {...}? => ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:5846:120: ( ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5847:6: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:5850:9: ({...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5850:10: {...}? => (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5850:19: (otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5850:20: otherlv_7= 'minLength' ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    {
            	    otherlv_7=(Token)match(input,124,FOLLOW_66); 

            	    									newLeafNode(otherlv_7, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_4_1_0());
            	    								
            	    // InternalOML.g:5854:9: ( (lv_minLength_8_0= RULE_DIGITS ) )
            	    // InternalOML.g:5855:10: (lv_minLength_8_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5855:10: (lv_minLength_8_0= RULE_DIGITS )
            	    // InternalOML.g:5856:11: lv_minLength_8_0= RULE_DIGITS
            	    {
            	    lv_minLength_8_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_minLength_8_0, grammarAccess.getStringScalarRestrictionAccess().getMinLengthDIGITSTerminalRuleCall_4_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_8_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5878:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5878:4: ({...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) ) )
            	    // InternalOML.g:5879:5: {...}? => ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:5879:120: ( ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) ) )
            	    // InternalOML.g:5880:6: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:5883:9: ({...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) ) )
            	    // InternalOML.g:5883:10: {...}? => (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5883:19: (otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) ) )
            	    // InternalOML.g:5883:20: otherlv_9= 'maxLength' ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    {
            	    otherlv_9=(Token)match(input,125,FOLLOW_66); 

            	    									newLeafNode(otherlv_9, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_4_2_0());
            	    								
            	    // InternalOML.g:5887:9: ( (lv_maxLength_10_0= RULE_DIGITS ) )
            	    // InternalOML.g:5888:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    {
            	    // InternalOML.g:5888:10: (lv_maxLength_10_0= RULE_DIGITS )
            	    // InternalOML.g:5889:11: lv_maxLength_10_0= RULE_DIGITS
            	    {
            	    lv_maxLength_10_0=(Token)match(input,RULE_DIGITS,FOLLOW_68); 

            	    											newLeafNode(lv_maxLength_10_0, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthDIGITSTerminalRuleCall_4_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_10_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.DIGITS");
            	    										

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
            	    // InternalOML.g:5911:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5911:4: ({...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) ) )
            	    // InternalOML.g:5912:5: {...}? => ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:5912:120: ( ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) ) )
            	    // InternalOML.g:5913:6: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:5916:9: ({...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) ) )
            	    // InternalOML.g:5916:10: {...}? => (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5916:19: (otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) ) )
            	    // InternalOML.g:5916:20: otherlv_11= 'pattern' ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    {
            	    otherlv_11=(Token)match(input,128,FOLLOW_7); 

            	    									newLeafNode(otherlv_11, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_4_3_0());
            	    								
            	    // InternalOML.g:5920:9: ( (lv_pattern_12_0= ruleLiteralPattern ) )
            	    // InternalOML.g:5921:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    {
            	    // InternalOML.g:5921:10: (lv_pattern_12_0= ruleLiteralPattern )
            	    // InternalOML.g:5922:11: lv_pattern_12_0= ruleLiteralPattern
            	    {

            	    											newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getPatternLiteralPatternParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_68);
            	    lv_pattern_12_0=ruleLiteralPattern();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											set(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_12_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.LiteralPattern");
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

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:5956:3: ( ( ruleReference ) )
            // InternalOML.g:5957:4: ( ruleReference )
            {
            // InternalOML.g:5957:4: ( ruleReference )
            // InternalOML.g:5958:5: ruleReference
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

            otherlv_15=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:5980:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:5980:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:5981:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
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
    // InternalOML.g:5987:1: ruleSynonymScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) ;
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
            // InternalOML.g:5993:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:5994:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:5994:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:5995:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'synonymScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'restrictedRange' ( ( ruleReference ) ) otherlv_6= '}'
            {
            // InternalOML.g:5995:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==67) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalOML.g:5996:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:5996:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:5997:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_78);
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
            	    break loop73;
                }
            } while (true);

            otherlv_1=(Token)match(input,139,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6018:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6019:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6019:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6020:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_75); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:6044:3: ( ( ruleReference ) )
            // InternalOML.g:6045:4: ( ruleReference )
            {
            // InternalOML.g:6045:4: ( ruleReference )
            // InternalOML.g:6046:5: ruleReference
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

            otherlv_6=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:6068:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:6068:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:6069:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
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
    // InternalOML.g:6075:1: ruleTimeScalarRestriction returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) ;
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
            // InternalOML.g:6081:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' ) )
            // InternalOML.g:6082:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            {
            // InternalOML.g:6082:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}' )
            // InternalOML.g:6083:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'timeScalarRestriction' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) ) otherlv_13= 'restrictedRange' ( ( ruleReference ) ) otherlv_15= '}'
            {
            // InternalOML.g:6083:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==67) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalOML.g:6084:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6084:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6085:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_79);
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
            	    break loop74;
                }
            } while (true);

            otherlv_1=(Token)match(input,140,FOLLOW_28); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_1());
            		
            // InternalOML.g:6106:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6107:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6107:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6108:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,69,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6128:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:6129:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:6129:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* ) )
            // InternalOML.g:6130:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				
            // InternalOML.g:6133:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )* )
            // InternalOML.g:6134:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            {
            // InternalOML.g:6134:6: ( ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) ) )*
            loop75:
            do {
                int alt75=5;
                int LA75_0 = input.LA(1);

                if ( LA75_0 == 130 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
                    alt75=1;
                }
                else if ( LA75_0 == 131 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
                    alt75=2;
                }
                else if ( LA75_0 == 132 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
                    alt75=3;
                }
                else if ( LA75_0 == 133 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
                    alt75=4;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalOML.g:6135:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6135:4: ({...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6136:5: {...}? => ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalOML.g:6136:118: ( ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6137:6: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalOML.g:6140:9: ({...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6140:10: {...}? => (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6140:19: (otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6140:20: otherlv_5= 'minInclusive' ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_5=(Token)match(input,130,FOLLOW_80); 

            	    									newLeafNode(otherlv_5, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_4_0_0());
            	    								
            	    // InternalOML.g:6144:9: ( (lv_minInclusive_6_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6145:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6145:10: (lv_minInclusive_6_0= ruleLiteralDateTime )
            	    // InternalOML.g:6146:11: lv_minInclusive_6_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveLiteralDateTimeParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:6169:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6169:4: ({...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6170:5: {...}? => ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalOML.g:6170:118: ( ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6171:6: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalOML.g:6174:9: ({...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6174:10: {...}? => (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6174:19: (otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6174:20: otherlv_7= 'maxInclusive' ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_7=(Token)match(input,131,FOLLOW_80); 

            	    									newLeafNode(otherlv_7, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_4_1_0());
            	    								
            	    // InternalOML.g:6178:9: ( (lv_maxInclusive_8_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6179:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6179:10: (lv_maxInclusive_8_0= ruleLiteralDateTime )
            	    // InternalOML.g:6180:11: lv_maxInclusive_8_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveLiteralDateTimeParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:6203:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6203:4: ({...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6204:5: {...}? => ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalOML.g:6204:118: ( ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6205:6: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalOML.g:6208:9: ({...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6208:10: {...}? => (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6208:19: (otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6208:20: otherlv_9= 'minExclusive' ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_9=(Token)match(input,132,FOLLOW_80); 

            	    									newLeafNode(otherlv_9, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_4_2_0());
            	    								
            	    // InternalOML.g:6212:9: ( (lv_minExclusive_10_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6213:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6213:10: (lv_minExclusive_10_0= ruleLiteralDateTime )
            	    // InternalOML.g:6214:11: lv_minExclusive_10_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveLiteralDateTimeParserRuleCall_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    // InternalOML.g:6237:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    {
            	    // InternalOML.g:6237:4: ({...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) ) )
            	    // InternalOML.g:6238:5: {...}? => ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalOML.g:6238:118: ( ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) ) )
            	    // InternalOML.g:6239:6: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalOML.g:6242:9: ({...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) ) )
            	    // InternalOML.g:6242:10: {...}? => (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:6242:19: (otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) ) )
            	    // InternalOML.g:6242:20: otherlv_11= 'maxExclusive' ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    {
            	    otherlv_11=(Token)match(input,133,FOLLOW_80); 

            	    									newLeafNode(otherlv_11, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_4_3_0());
            	    								
            	    // InternalOML.g:6246:9: ( (lv_maxExclusive_12_0= ruleLiteralDateTime ) )
            	    // InternalOML.g:6247:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    {
            	    // InternalOML.g:6247:10: (lv_maxExclusive_12_0= ruleLiteralDateTime )
            	    // InternalOML.g:6248:11: lv_maxExclusive_12_0= ruleLiteralDateTime
            	    {

            	    											newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveLiteralDateTimeParserRuleCall_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_70);
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
            	    break loop75;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_4());
            				

            }

            otherlv_13=(Token)match(input,126,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_5());
            		
            // InternalOML.g:6282:3: ( ( ruleReference ) )
            // InternalOML.g:6283:4: ( ruleReference )
            {
            // InternalOML.g:6283:4: ( ruleReference )
            // InternalOML.g:6284:5: ruleReference
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

            otherlv_15=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:6306:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:6306:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:6307:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
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
    // InternalOML.g:6313:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6319:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:6320:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:6320:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt76=2;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalOML.g:6321:3: this_ConceptInstance_0= ruleConceptInstance
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
                    // InternalOML.g:6330:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
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
    // InternalOML.g:6342:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:6342:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:6343:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
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
    // InternalOML.g:6349:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6355:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:6356:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:6356:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:6357:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'extends' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:6357:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==67) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalOML.g:6358:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6358:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6359:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop77;
                }
            } while (true);

            otherlv_1=(Token)match(input,77,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_1());
            		
            // InternalOML.g:6380:3: ( ( ruleExternalReference ) )
            // InternalOML.g:6381:4: ( ruleExternalReference )
            {
            // InternalOML.g:6381:4: ( ruleExternalReference )
            // InternalOML.g:6382:5: ruleExternalReference
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
    // InternalOML.g:6400:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:6400:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:6401:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
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
    // InternalOML.g:6407:1: ruleDescriptionBoxRefinement returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6413:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:6414:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:6414:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:6415:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'refines' ( ( ruleExternalReference ) )
            {
            // InternalOML.g:6415:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==67) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalOML.g:6416:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6416:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6417:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_81);
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
            	    break loop78;
                }
            } while (true);

            otherlv_1=(Token)match(input,141,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_1());
            		
            // InternalOML.g:6438:3: ( ( ruleExternalReference ) )
            // InternalOML.g:6439:4: ( ruleExternalReference )
            {
            // InternalOML.g:6439:4: ( ruleExternalReference )
            // InternalOML.g:6440:5: ruleExternalReference
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
    // InternalOML.g:6458:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:6458:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:6459:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
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
    // InternalOML.g:6465:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6471:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) ) )
            // InternalOML.g:6472:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) )
            {
            // InternalOML.g:6472:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) ) )
            // InternalOML.g:6473:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) )
            {
            // InternalOML.g:6473:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==67) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalOML.g:6474:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6474:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6475:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop79;
                }
            } while (true);

            // InternalOML.g:6492:3: ( ( ruleReference ) )
            // InternalOML.g:6493:4: ( ruleReference )
            {
            // InternalOML.g:6493:4: ( ruleReference )
            // InternalOML.g:6494:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:6512:3: ( ( ruleReference ) )
            // InternalOML.g:6513:4: ( ruleReference )
            {
            // InternalOML.g:6513:4: ( ruleReference )
            // InternalOML.g:6514:5: ruleReference
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

            otherlv_4=(Token)match(input,66,FOLLOW_61); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:6532:3: ( (lv_scalarPropertyValue_5_0= ruleLiteralValue ) )
            // InternalOML.g:6533:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            {
            // InternalOML.g:6533:4: (lv_scalarPropertyValue_5_0= ruleLiteralValue )
            // InternalOML.g:6534:5: lv_scalarPropertyValue_5_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalOML.g:6555:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:6555:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:6556:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
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
    // InternalOML.g:6562:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) ;
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
            // InternalOML.g:6568:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:6569:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:6569:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            // InternalOML.g:6570:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )* otherlv_8= '}'
            {
            // InternalOML.g:6570:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==67) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalOML.g:6571:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6571:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6572:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop80;
                }
            } while (true);

            // InternalOML.g:6589:3: ( ( ruleReference ) )
            // InternalOML.g:6590:4: ( ruleReference )
            {
            // InternalOML.g:6590:4: ( ruleReference )
            // InternalOML.g:6591:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_1_0());
            				
            pushFollow(FOLLOW_53);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,113,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:6609:3: ( ( ruleReference ) )
            // InternalOML.g:6610:4: ( ruleReference )
            {
            // InternalOML.g:6610:4: ( ruleReference )
            // InternalOML.g:6611:5: ruleReference
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

            otherlv_4=(Token)match(input,66,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_4());
            		
            otherlv_5=(Token)match(input,69,FOLLOW_63); 

            			newLeafNode(otherlv_5, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:6633:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*
            loop81:
            do {
                int alt81=3;
                alt81 = dfa81.predict(input);
                switch (alt81) {
            	case 1 :
            	    // InternalOML.g:6634:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:6634:4: ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:6635:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:6635:5: (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:6636:6: lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    // InternalOML.g:6654:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:6654:4: ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:6655:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:6655:5: (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:6656:6: lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    break loop81;
                }
            } while (true);

            otherlv_8=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:6682:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:6682:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:6683:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
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
    // InternalOML.g:6689:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:6695:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' ) )
            // InternalOML.g:6696:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            {
            // InternalOML.g:6696:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}' )
            // InternalOML.g:6697:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' otherlv_3= '{' ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )* otherlv_6= '}'
            {
            // InternalOML.g:6697:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==67) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalOML.g:6698:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6698:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6699:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop82;
                }
            } while (true);

            // InternalOML.g:6716:3: ( ( ruleReference ) )
            // InternalOML.g:6717:4: ( ruleReference )
            {
            // InternalOML.g:6717:4: ( ruleReference )
            // InternalOML.g:6718:5: ruleReference
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

            otherlv_2=(Token)match(input,66,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,69,FOLLOW_63); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:6740:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*
            loop83:
            do {
                int alt83=3;
                alt83 = dfa83.predict(input);
                switch (alt83) {
            	case 1 :
            	    // InternalOML.g:6741:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:6741:4: ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:6742:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:6742:5: (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:6743:6: lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    // InternalOML.g:6761:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:6761:4: ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:6762:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:6762:5: (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:6763:6: lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_63);
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
            	    break loop83;
                }
            } while (true);

            otherlv_6=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:6789:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:6789:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:6790:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
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
    // InternalOML.g:6796:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_scalarPropertyValue_3_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6802:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) ) )
            // InternalOML.g:6803:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) )
            {
            // InternalOML.g:6803:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) ) )
            // InternalOML.g:6804:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* ( ( ruleReference ) ) otherlv_2= '=' ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            {
            // InternalOML.g:6804:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==67) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalOML.g:6805:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6805:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6806:5: lv_annotations_0_0= ruleAnnotationPropertyValue
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
            	    break loop84;
                }
            } while (true);

            // InternalOML.g:6823:3: ( ( ruleReference ) )
            // InternalOML.g:6824:4: ( ruleReference )
            {
            // InternalOML.g:6824:4: ( ruleReference )
            // InternalOML.g:6825:5: ruleReference
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

            otherlv_2=(Token)match(input,66,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:6843:3: ( (lv_scalarPropertyValue_3_0= ruleLiteralValue ) )
            // InternalOML.g:6844:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            {
            // InternalOML.g:6844:4: (lv_scalarPropertyValue_3_0= ruleLiteralValue )
            // InternalOML.g:6845:5: lv_scalarPropertyValue_3_0= ruleLiteralValue
            {

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueLiteralValueParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalOML.g:6866:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:6866:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:6867:2: iv_ruleConceptInstance= ruleConceptInstance EOF
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
    // InternalOML.g:6873:1: ruleConceptInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
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
            // InternalOML.g:6879:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:6880:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:6880:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:6881:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'conceptInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:6881:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==67) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalOML.g:6882:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6882:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6883:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getConceptInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_82);
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
            	    break loop85;
                }
            } while (true);

            otherlv_1=(Token)match(input,142,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:6908:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:6909:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:6909:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:6910:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_83); 

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

            otherlv_4=(Token)match(input,143,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:6930:3: ( ( ruleReference ) )
            // InternalOML.g:6931:4: ( ruleReference )
            {
            // InternalOML.g:6931:4: ( ruleReference )
            // InternalOML.g:6932:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,109,FOLLOW_2); 

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
    // InternalOML.g:6954:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:6954:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:6955:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
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
    // InternalOML.g:6961:1: ruleReifiedRelationshipInstance returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) ;
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
            // InternalOML.g:6967:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' ) )
            // InternalOML.g:6968:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            {
            // InternalOML.g:6968:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')' )
            // InternalOML.g:6969:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'reifiedRelationshipInstance' otherlv_2= '(' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'is-a' ( ( ruleReference ) ) otherlv_6= ')'
            {
            // InternalOML.g:6969:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==67) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalOML.g:6970:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:6970:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:6971:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_84);
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
            	    break loop86;
                }
            } while (true);

            otherlv_1=(Token)match(input,144,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:6996:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalOML.g:6997:4: (lv_name_3_0= RULE_ID )
            {
            // InternalOML.g:6997:4: (lv_name_3_0= RULE_ID )
            // InternalOML.g:6998:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_83); 

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

            otherlv_4=(Token)match(input,143,FOLLOW_21); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_4());
            		
            // InternalOML.g:7018:3: ( ( ruleReference ) )
            // InternalOML.g:7019:4: ( ruleReference )
            {
            // InternalOML.g:7019:4: ( ruleReference )
            // InternalOML.g:7020:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_5_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,109,FOLLOW_2); 

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
    // InternalOML.g:7042:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:7042:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:7043:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
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
    // InternalOML.g:7049:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7055:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:7056:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:7056:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:7057:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'domain' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:7057:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==67) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalOML.g:7058:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7058:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7059:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_85);
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
            	    break loop87;
                }
            } while (true);

            otherlv_1=(Token)match(input,102,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7084:3: ( ( ruleReference ) )
            // InternalOML.g:7085:4: ( ruleReference )
            {
            // InternalOML.g:7085:4: ( ruleReference )
            // InternalOML.g:7086:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,109,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:7108:3: ( ( ruleReference ) )
            // InternalOML.g:7109:4: ( ruleReference )
            {
            // InternalOML.g:7109:4: ( ruleReference )
            // InternalOML.g:7110:5: ruleReference
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
    // InternalOML.g:7128:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:7128:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:7129:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
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
    // InternalOML.g:7135:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_annotations_0_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7141:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:7142:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:7142:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) ) )
            // InternalOML.g:7143:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'range' otherlv_2= '(' ( ( ruleReference ) ) otherlv_4= ')' otherlv_5= '=' ( ( ruleReference ) )
            {
            // InternalOML.g:7143:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==67) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalOML.g:7144:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7144:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7145:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_86);
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
            	    break loop88;
                }
            } while (true);

            otherlv_1=(Token)match(input,103,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_1());
            		
            otherlv_2=(Token)match(input,108,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_2());
            		
            // InternalOML.g:7170:3: ( ( ruleReference ) )
            // InternalOML.g:7171:4: ( ruleReference )
            {
            // InternalOML.g:7171:4: ( ruleReference )
            // InternalOML.g:7172:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_3_0());
            				
            pushFollow(FOLLOW_48);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,109,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_4());
            		
            otherlv_5=(Token)match(input,66,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:7194:3: ( ( ruleReference ) )
            // InternalOML.g:7195:4: ( ruleReference )
            {
            // InternalOML.g:7195:4: ( ruleReference )
            // InternalOML.g:7196:5: ruleReference
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
    // InternalOML.g:7214:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:7214:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:7215:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
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
    // InternalOML.g:7221:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) ;
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
            // InternalOML.g:7227:2: ( ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' ) )
            // InternalOML.g:7228:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            {
            // InternalOML.g:7228:2: ( ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}' )
            // InternalOML.g:7229:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )* otherlv_1= 'tuple' otherlv_2= '{' otherlv_3= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_5= 'domain' ( ( ruleReference ) ) otherlv_7= 'range' ( ( ruleReference ) ) otherlv_9= '}'
            {
            // InternalOML.g:7229:3: ( (lv_annotations_0_0= ruleAnnotationPropertyValue ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==67) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalOML.g:7230:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    {
            	    // InternalOML.g:7230:4: (lv_annotations_0_0= ruleAnnotationPropertyValue )
            	    // InternalOML.g:7231:5: lv_annotations_0_0= ruleAnnotationPropertyValue
            	    {

            	    					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getAnnotationsAnnotationPropertyValueParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_87);
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
            	    break loop89;
                }
            } while (true);

            otherlv_1=(Token)match(input,145,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_1());
            		
            otherlv_2=(Token)match(input,69,FOLLOW_88); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,97,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_3());
            		
            // InternalOML.g:7260:3: ( ( ruleReference ) )
            // InternalOML.g:7261:4: ( ruleReference )
            {
            // InternalOML.g:7261:4: ( ruleReference )
            // InternalOML.g:7262:5: ruleReference
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

            otherlv_5=(Token)match(input,102,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_5());
            		
            // InternalOML.g:7280:3: ( ( ruleReference ) )
            // InternalOML.g:7281:4: ( ruleReference )
            {
            // InternalOML.g:7281:4: ( ruleReference )
            // InternalOML.g:7282:5: ruleReference
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

            otherlv_7=(Token)match(input,103,FOLLOW_21); 

            			newLeafNode(otherlv_7, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_7());
            		
            // InternalOML.g:7300:3: ( ( ruleReference ) )
            // InternalOML.g:7301:4: ( ruleReference )
            {
            // InternalOML.g:7301:4: ( ruleReference )
            // InternalOML.g:7302:5: ruleReference
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

            otherlv_9=(Token)match(input,70,FOLLOW_2); 

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
    // InternalOML.g:7324:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:7324:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:7325:2: iv_ruleReference= ruleReference EOF
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
    // InternalOML.g:7331:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:7337:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:7338:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:7338:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_IRI) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_ABBREV_IRI||LA90_0==RULE_ID) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalOML.g:7339:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:7347:3: this_QNAME_1= ruleQNAME
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
    // InternalOML.g:7361:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:7361:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:7362:2: iv_ruleExternalReference= ruleExternalReference EOF
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
    // InternalOML.g:7368:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:7374:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:7375:2: this_IRI_0= RULE_IRI
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
    // InternalOML.g:7385:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:7385:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:7386:2: iv_ruleQNAME= ruleQNAME EOF
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
    // InternalOML.g:7392:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:7398:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:7399:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:7399:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ABBREV_IRI) ) {
                alt91=1;
            }
            else if ( (LA91_0==RULE_ID) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalOML.g:7400:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:7408:3: this_ValidID_1= ruleValidID
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
    // InternalOML.g:7422:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:7422:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:7423:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOML.g:7429:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:7435:2: (this_ID_0= RULE_ID )
            // InternalOML.g:7436:2: this_ID_0= RULE_ID
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


    // $ANTLR start "entryRuleLiteralPattern"
    // InternalOML.g:7446:1: entryRuleLiteralPattern returns [EObject current=null] : iv_ruleLiteralPattern= ruleLiteralPattern EOF ;
    public final EObject entryRuleLiteralPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralPattern = null;


        try {
            // InternalOML.g:7446:55: (iv_ruleLiteralPattern= ruleLiteralPattern EOF )
            // InternalOML.g:7447:2: iv_ruleLiteralPattern= ruleLiteralPattern EOF
            {
             newCompositeNode(grammarAccess.getLiteralPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralPattern=ruleLiteralPattern();

            state._fsp--;

             current =iv_ruleLiteralPattern; 
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
    // $ANTLR end "entryRuleLiteralPattern"


    // $ANTLR start "ruleLiteralPattern"
    // InternalOML.g:7453:1: ruleLiteralPattern returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLiteralPattern() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:7459:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalOML.g:7460:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalOML.g:7460:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalOML.g:7461:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalOML.g:7461:3: ()
            // InternalOML.g:7462:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralPatternAccess().getLiteralPatternAction_0(),
            					current);
            			

            }

            // InternalOML.g:7468:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalOML.g:7469:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalOML.g:7469:4: (lv_value_1_0= RULE_STRING )
            // InternalOML.g:7470:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getLiteralPatternAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralPatternRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            				

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
    // $ANTLR end "ruleLiteralPattern"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalOML.g:7490:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // InternalOML.g:7490:53: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalOML.g:7491:2: iv_ruleLiteralValue= ruleLiteralValue EOF
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
    // InternalOML.g:7497:1: ruleLiteralValue returns [EObject current=null] : (this_LiteralDateTime_0= ruleLiteralDateTime | this_LiteralLanguageTag_1= ruleLiteralLanguageTag | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) ;
    public final EObject ruleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralDateTime_0 = null;

        EObject this_LiteralLanguageTag_1 = null;

        EObject this_LiteralString_2 = null;

        EObject this_LiteralUUID_3 = null;

        EObject this_LiteralURI_4 = null;

        EObject this_LiteralNumber_5 = null;



        	enterRule();

        try {
            // InternalOML.g:7503:2: ( (this_LiteralDateTime_0= ruleLiteralDateTime | this_LiteralLanguageTag_1= ruleLiteralLanguageTag | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber ) )
            // InternalOML.g:7504:2: (this_LiteralDateTime_0= ruleLiteralDateTime | this_LiteralLanguageTag_1= ruleLiteralLanguageTag | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            {
            // InternalOML.g:7504:2: (this_LiteralDateTime_0= ruleLiteralDateTime | this_LiteralLanguageTag_1= ruleLiteralLanguageTag | this_LiteralString_2= ruleLiteralString | this_LiteralUUID_3= ruleLiteralUUID | this_LiteralURI_4= ruleLiteralURI | this_LiteralNumber_5= ruleLiteralNumber )
            int alt92=6;
            switch ( input.LA(1) ) {
            case RULE_DATETIME:
                {
                alt92=1;
                }
                break;
            case RULE_LANGUAGE_TAG:
                {
                alt92=2;
                }
                break;
            case RULE_STRING:
                {
                alt92=3;
                }
                break;
            case RULE_UUID:
                {
                alt92=4;
                }
                break;
            case RULE_URI_VALUE:
                {
                alt92=5;
                }
                break;
            case RULE_REAL_VALUE:
            case RULE_RATIONAL:
            case RULE_FLOAT:
            case RULE_DECIMAL:
                {
                alt92=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalOML.g:7505:3: this_LiteralDateTime_0= ruleLiteralDateTime
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralDateTimeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralDateTime_0=ruleLiteralDateTime();

                    state._fsp--;


                    			current = this_LiteralDateTime_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:7514:3: this_LiteralLanguageTag_1= ruleLiteralLanguageTag
                    {

                    			newCompositeNode(grammarAccess.getLiteralValueAccess().getLiteralLanguageTagParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralLanguageTag_1=ruleLiteralLanguageTag();

                    state._fsp--;


                    			current = this_LiteralLanguageTag_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:7523:3: this_LiteralString_2= ruleLiteralString
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
                    // InternalOML.g:7532:3: this_LiteralUUID_3= ruleLiteralUUID
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
                    // InternalOML.g:7541:3: this_LiteralURI_4= ruleLiteralURI
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
                    // InternalOML.g:7550:3: this_LiteralNumber_5= ruleLiteralNumber
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


    // $ANTLR start "entryRuleLiteralDateTime"
    // InternalOML.g:7562:1: entryRuleLiteralDateTime returns [EObject current=null] : iv_ruleLiteralDateTime= ruleLiteralDateTime EOF ;
    public final EObject entryRuleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralDateTime = null;


        try {
            // InternalOML.g:7562:56: (iv_ruleLiteralDateTime= ruleLiteralDateTime EOF )
            // InternalOML.g:7563:2: iv_ruleLiteralDateTime= ruleLiteralDateTime EOF
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
    // InternalOML.g:7569:1: ruleLiteralDateTime returns [EObject current=null] : ( () ( (lv_value_1_0= ruleDATE_TIME ) ) ) ;
    public final EObject ruleLiteralDateTime() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7575:2: ( ( () ( (lv_value_1_0= ruleDATE_TIME ) ) ) )
            // InternalOML.g:7576:2: ( () ( (lv_value_1_0= ruleDATE_TIME ) ) )
            {
            // InternalOML.g:7576:2: ( () ( (lv_value_1_0= ruleDATE_TIME ) ) )
            // InternalOML.g:7577:3: () ( (lv_value_1_0= ruleDATE_TIME ) )
            {
            // InternalOML.g:7577:3: ()
            // InternalOML.g:7578:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralDateTimeAccess().getLiteralDateTimeAction_0(),
            					current);
            			

            }

            // InternalOML.g:7584:3: ( (lv_value_1_0= ruleDATE_TIME ) )
            // InternalOML.g:7585:4: (lv_value_1_0= ruleDATE_TIME )
            {
            // InternalOML.g:7585:4: (lv_value_1_0= ruleDATE_TIME )
            // InternalOML.g:7586:5: lv_value_1_0= ruleDATE_TIME
            {

            					newCompositeNode(grammarAccess.getLiteralDateTimeAccess().getValueDATE_TIMEParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleDATE_TIME();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralDateTimeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.DATE_TIME");
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
    // $ANTLR end "ruleLiteralDateTime"


    // $ANTLR start "entryRuleLiteralLanguageTag"
    // InternalOML.g:7607:1: entryRuleLiteralLanguageTag returns [EObject current=null] : iv_ruleLiteralLanguageTag= ruleLiteralLanguageTag EOF ;
    public final EObject entryRuleLiteralLanguageTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralLanguageTag = null;


        try {
            // InternalOML.g:7607:59: (iv_ruleLiteralLanguageTag= ruleLiteralLanguageTag EOF )
            // InternalOML.g:7608:2: iv_ruleLiteralLanguageTag= ruleLiteralLanguageTag EOF
            {
             newCompositeNode(grammarAccess.getLiteralLanguageTagRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralLanguageTag=ruleLiteralLanguageTag();

            state._fsp--;

             current =iv_ruleLiteralLanguageTag; 
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
    // $ANTLR end "entryRuleLiteralLanguageTag"


    // $ANTLR start "ruleLiteralLanguageTag"
    // InternalOML.g:7614:1: ruleLiteralLanguageTag returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLANG_TAG ) ) ) ;
    public final EObject ruleLiteralLanguageTag() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7620:2: ( ( () ( (lv_value_1_0= ruleLANG_TAG ) ) ) )
            // InternalOML.g:7621:2: ( () ( (lv_value_1_0= ruleLANG_TAG ) ) )
            {
            // InternalOML.g:7621:2: ( () ( (lv_value_1_0= ruleLANG_TAG ) ) )
            // InternalOML.g:7622:3: () ( (lv_value_1_0= ruleLANG_TAG ) )
            {
            // InternalOML.g:7622:3: ()
            // InternalOML.g:7623:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralLanguageTagAccess().getLiteralLanguageTagAction_0(),
            					current);
            			

            }

            // InternalOML.g:7629:3: ( (lv_value_1_0= ruleLANG_TAG ) )
            // InternalOML.g:7630:4: (lv_value_1_0= ruleLANG_TAG )
            {
            // InternalOML.g:7630:4: (lv_value_1_0= ruleLANG_TAG )
            // InternalOML.g:7631:5: lv_value_1_0= ruleLANG_TAG
            {

            					newCompositeNode(grammarAccess.getLiteralLanguageTagAccess().getValueLANG_TAGParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleLANG_TAG();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralLanguageTagRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.LANG_TAG");
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
    // $ANTLR end "ruleLiteralLanguageTag"


    // $ANTLR start "entryRuleLiteralString"
    // InternalOML.g:7652:1: entryRuleLiteralString returns [EObject current=null] : iv_ruleLiteralString= ruleLiteralString EOF ;
    public final EObject entryRuleLiteralString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralString = null;


        try {
            // InternalOML.g:7652:54: (iv_ruleLiteralString= ruleLiteralString EOF )
            // InternalOML.g:7653:2: iv_ruleLiteralString= ruleLiteralString EOF
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
    // InternalOML.g:7659:1: ruleLiteralString returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleLiteralString() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:7665:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalOML.g:7666:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalOML.g:7666:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalOML.g:7667:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalOML.g:7667:3: ()
            // InternalOML.g:7668:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralStringAccess().getLiteralStringAction_0(),
            					current);
            			

            }

            // InternalOML.g:7674:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalOML.g:7675:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalOML.g:7675:4: (lv_value_1_0= RULE_STRING )
            // InternalOML.g:7676:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getLiteralStringAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralStringRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            				

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
    // $ANTLR end "ruleLiteralString"


    // $ANTLR start "entryRuleLiteralUUID"
    // InternalOML.g:7696:1: entryRuleLiteralUUID returns [EObject current=null] : iv_ruleLiteralUUID= ruleLiteralUUID EOF ;
    public final EObject entryRuleLiteralUUID() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralUUID = null;


        try {
            // InternalOML.g:7696:52: (iv_ruleLiteralUUID= ruleLiteralUUID EOF )
            // InternalOML.g:7697:2: iv_ruleLiteralUUID= ruleLiteralUUID EOF
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
    // InternalOML.g:7703:1: ruleLiteralUUID returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_UUID ) ) ) ;
    public final EObject ruleLiteralUUID() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:7709:2: ( ( () ( (lv_value_1_0= RULE_UUID ) ) ) )
            // InternalOML.g:7710:2: ( () ( (lv_value_1_0= RULE_UUID ) ) )
            {
            // InternalOML.g:7710:2: ( () ( (lv_value_1_0= RULE_UUID ) ) )
            // InternalOML.g:7711:3: () ( (lv_value_1_0= RULE_UUID ) )
            {
            // InternalOML.g:7711:3: ()
            // InternalOML.g:7712:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralUUIDAccess().getLiteralUUIDAction_0(),
            					current);
            			

            }

            // InternalOML.g:7718:3: ( (lv_value_1_0= RULE_UUID ) )
            // InternalOML.g:7719:4: (lv_value_1_0= RULE_UUID )
            {
            // InternalOML.g:7719:4: (lv_value_1_0= RULE_UUID )
            // InternalOML.g:7720:5: lv_value_1_0= RULE_UUID
            {
            lv_value_1_0=(Token)match(input,RULE_UUID,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getLiteralUUIDAccess().getValueUUIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLiteralUUIDRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.UUID");
            				

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


    // $ANTLR start "entryRuleLiteralURI"
    // InternalOML.g:7740:1: entryRuleLiteralURI returns [EObject current=null] : iv_ruleLiteralURI= ruleLiteralURI EOF ;
    public final EObject entryRuleLiteralURI() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralURI = null;


        try {
            // InternalOML.g:7740:51: (iv_ruleLiteralURI= ruleLiteralURI EOF )
            // InternalOML.g:7741:2: iv_ruleLiteralURI= ruleLiteralURI EOF
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
    // InternalOML.g:7747:1: ruleLiteralURI returns [EObject current=null] : ( () ( (lv_value_1_0= ruleURI ) ) ) ;
    public final EObject ruleLiteralURI() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalOML.g:7753:2: ( ( () ( (lv_value_1_0= ruleURI ) ) ) )
            // InternalOML.g:7754:2: ( () ( (lv_value_1_0= ruleURI ) ) )
            {
            // InternalOML.g:7754:2: ( () ( (lv_value_1_0= ruleURI ) ) )
            // InternalOML.g:7755:3: () ( (lv_value_1_0= ruleURI ) )
            {
            // InternalOML.g:7755:3: ()
            // InternalOML.g:7756:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralURIAccess().getLiteralURIAction_0(),
            					current);
            			

            }

            // InternalOML.g:7762:3: ( (lv_value_1_0= ruleURI ) )
            // InternalOML.g:7763:4: (lv_value_1_0= ruleURI )
            {
            // InternalOML.g:7763:4: (lv_value_1_0= ruleURI )
            // InternalOML.g:7764:5: lv_value_1_0= ruleURI
            {

            					newCompositeNode(grammarAccess.getLiteralURIAccess().getValueURIParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleURI();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLiteralURIRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.URI");
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
    // InternalOML.g:7785:1: entryRuleLiteralNumber returns [EObject current=null] : iv_ruleLiteralNumber= ruleLiteralNumber EOF ;
    public final EObject entryRuleLiteralNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralNumber = null;


        try {
            // InternalOML.g:7785:54: (iv_ruleLiteralNumber= ruleLiteralNumber EOF )
            // InternalOML.g:7786:2: iv_ruleLiteralNumber= ruleLiteralNumber EOF
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
    // InternalOML.g:7792:1: ruleLiteralNumber returns [EObject current=null] : ( () ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) ) ) ;
    public final EObject ruleLiteralNumber() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;


        	enterRule();

        try {
            // InternalOML.g:7798:2: ( ( () ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) ) ) )
            // InternalOML.g:7799:2: ( () ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) ) )
            {
            // InternalOML.g:7799:2: ( () ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) ) )
            // InternalOML.g:7800:3: () ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) )
            {
            // InternalOML.g:7800:3: ()
            // InternalOML.g:7801:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLiteralNumberAccess().getLiteralNumberAction_0(),
            					current);
            			

            }

            // InternalOML.g:7807:3: ( ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) ) )
            // InternalOML.g:7808:4: ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) )
            {
            // InternalOML.g:7808:4: ( (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL ) )
            // InternalOML.g:7809:5: (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL )
            {
            // InternalOML.g:7809:5: (lv_value_1_1= RULE_REAL_VALUE | lv_value_1_2= RULE_RATIONAL | lv_value_1_3= RULE_FLOAT | lv_value_1_4= RULE_DECIMAL )
            int alt93=4;
            switch ( input.LA(1) ) {
            case RULE_REAL_VALUE:
                {
                alt93=1;
                }
                break;
            case RULE_RATIONAL:
                {
                alt93=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt93=3;
                }
                break;
            case RULE_DECIMAL:
                {
                alt93=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalOML.g:7810:6: lv_value_1_1= RULE_REAL_VALUE
                    {
                    lv_value_1_1=(Token)match(input,RULE_REAL_VALUE,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getLiteralNumberAccess().getValueREAL_VALUETerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralNumberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_1,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.REAL_VALUE");
                    					

                    }
                    break;
                case 2 :
                    // InternalOML.g:7825:6: lv_value_1_2= RULE_RATIONAL
                    {
                    lv_value_1_2=(Token)match(input,RULE_RATIONAL,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getLiteralNumberAccess().getValueRATIONALTerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralNumberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_2,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.RATIONAL");
                    					

                    }
                    break;
                case 3 :
                    // InternalOML.g:7840:6: lv_value_1_3= RULE_FLOAT
                    {
                    lv_value_1_3=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_3, grammarAccess.getLiteralNumberAccess().getValueFLOATTerminalRuleCall_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralNumberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_3,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.FLOAT");
                    					

                    }
                    break;
                case 4 :
                    // InternalOML.g:7855:6: lv_value_1_4= RULE_DECIMAL
                    {
                    lv_value_1_4=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    						newLeafNode(lv_value_1_4, grammarAccess.getLiteralNumberAccess().getValueDECIMALTerminalRuleCall_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLiteralNumberRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_4,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.DECIMAL");
                    					

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
    // $ANTLR end "ruleLiteralNumber"


    // $ANTLR start "entryRuleURI"
    // InternalOML.g:7876:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // InternalOML.g:7876:43: (iv_ruleURI= ruleURI EOF )
            // InternalOML.g:7877:2: iv_ruleURI= ruleURI EOF
            {
             newCompositeNode(grammarAccess.getURIRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURI=ruleURI();

            state._fsp--;

             current =iv_ruleURI.getText(); 
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
    // $ANTLR end "entryRuleURI"


    // $ANTLR start "ruleURI"
    // InternalOML.g:7883:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_URI_VALUE_0= RULE_URI_VALUE ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_URI_VALUE_0=null;


        	enterRule();

        try {
            // InternalOML.g:7889:2: (this_URI_VALUE_0= RULE_URI_VALUE )
            // InternalOML.g:7890:2: this_URI_VALUE_0= RULE_URI_VALUE
            {
            this_URI_VALUE_0=(Token)match(input,RULE_URI_VALUE,FOLLOW_2); 

            		current.merge(this_URI_VALUE_0);
            	

            		newLeafNode(this_URI_VALUE_0, grammarAccess.getURIAccess().getURI_VALUETerminalRuleCall());
            	

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
    // $ANTLR end "ruleURI"


    // $ANTLR start "entryRuleLANG_TAG"
    // InternalOML.g:7900:1: entryRuleLANG_TAG returns [String current=null] : iv_ruleLANG_TAG= ruleLANG_TAG EOF ;
    public final String entryRuleLANG_TAG() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLANG_TAG = null;


        try {
            // InternalOML.g:7900:48: (iv_ruleLANG_TAG= ruleLANG_TAG EOF )
            // InternalOML.g:7901:2: iv_ruleLANG_TAG= ruleLANG_TAG EOF
            {
             newCompositeNode(grammarAccess.getLANG_TAGRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLANG_TAG=ruleLANG_TAG();

            state._fsp--;

             current =iv_ruleLANG_TAG.getText(); 
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
    // $ANTLR end "entryRuleLANG_TAG"


    // $ANTLR start "ruleLANG_TAG"
    // InternalOML.g:7907:1: ruleLANG_TAG returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_LANGUAGE_TAG_0= RULE_LANGUAGE_TAG ;
    public final AntlrDatatypeRuleToken ruleLANG_TAG() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LANGUAGE_TAG_0=null;


        	enterRule();

        try {
            // InternalOML.g:7913:2: (this_LANGUAGE_TAG_0= RULE_LANGUAGE_TAG )
            // InternalOML.g:7914:2: this_LANGUAGE_TAG_0= RULE_LANGUAGE_TAG
            {
            this_LANGUAGE_TAG_0=(Token)match(input,RULE_LANGUAGE_TAG,FOLLOW_2); 

            		current.merge(this_LANGUAGE_TAG_0);
            	

            		newLeafNode(this_LANGUAGE_TAG_0, grammarAccess.getLANG_TAGAccess().getLANGUAGE_TAGTerminalRuleCall());
            	

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
    // $ANTLR end "ruleLANG_TAG"


    // $ANTLR start "entryRuleDATE_TIME"
    // InternalOML.g:7924:1: entryRuleDATE_TIME returns [String current=null] : iv_ruleDATE_TIME= ruleDATE_TIME EOF ;
    public final String entryRuleDATE_TIME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDATE_TIME = null;


        try {
            // InternalOML.g:7924:49: (iv_ruleDATE_TIME= ruleDATE_TIME EOF )
            // InternalOML.g:7925:2: iv_ruleDATE_TIME= ruleDATE_TIME EOF
            {
             newCompositeNode(grammarAccess.getDATE_TIMERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDATE_TIME=ruleDATE_TIME();

            state._fsp--;

             current =iv_ruleDATE_TIME.getText(); 
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
    // $ANTLR end "entryRuleDATE_TIME"


    // $ANTLR start "ruleDATE_TIME"
    // InternalOML.g:7931:1: ruleDATE_TIME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATETIME_0= RULE_DATETIME ;
    public final AntlrDatatypeRuleToken ruleDATE_TIME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATETIME_0=null;


        	enterRule();

        try {
            // InternalOML.g:7937:2: (this_DATETIME_0= RULE_DATETIME )
            // InternalOML.g:7938:2: this_DATETIME_0= RULE_DATETIME
            {
            this_DATETIME_0=(Token)match(input,RULE_DATETIME,FOLLOW_2); 

            		current.merge(this_DATETIME_0);
            	

            		newLeafNode(this_DATETIME_0, grammarAccess.getDATE_TIMEAccess().getDATETIMETerminalRuleCall());
            	

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
    // $ANTLR end "ruleDATE_TIME"


    // $ANTLR start "ruleTerminologyKind"
    // InternalOML.g:7948:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:7954:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:7955:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:7955:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==146) ) {
                alt94=1;
            }
            else if ( (LA94_0==147) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalOML.g:7956:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:7956:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:7957:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,146,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:7964:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:7964:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:7965:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,147,FOLLOW_2); 

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
    // InternalOML.g:7975:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:7981:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:7982:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:7982:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==148) ) {
                alt95=1;
            }
            else if ( (LA95_0==149) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalOML.g:7983:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:7983:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:7984:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,148,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:7991:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:7991:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:7992:4: enumLiteral_1= 'partial'
                    {
                    enumLiteral_1=(Token)match(input,149,FOLLOW_2); 

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
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
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
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA83 dfa83 = new DFA83(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\103\1\4\2\uffff\1\102\1\6\1\103";
    static final String dfa_3s = "\1\u0095\1\4\2\uffff\1\102\1\6\1\u0095";
    static final String dfa_4s = "\2\uffff\1\1\1\2\3\uffff";
    static final String dfa_5s = "\7\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\116\uffff\2\2\2\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\116\uffff\2\2\2\3"
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
            return "280:2: (this_TerminologyBox_0= ruleTerminologyBox | this_DescriptionBox_1= ruleDescriptionBox )";
        }
    }
    static final String dfa_7s = "\11\uffff";
    static final String dfa_8s = "\1\103\1\4\2\104\1\102\2\uffff\1\6\1\103";
    static final String dfa_9s = "\1\u0093\1\4\2\107\1\102\2\uffff\1\6\1\u0093";
    static final String dfa_10s = "\5\uffff\1\2\1\1\2\uffff";
    static final String dfa_11s = "\11\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\116\uffff\1\2\1\3",
            "\1\4",
            "\1\5\2\uffff\1\6",
            "\1\5\2\uffff\1\6",
            "\1\7",
            "",
            "",
            "\1\10",
            "\1\1\116\uffff\1\2\1\3"
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
            return "316:2: (this_Bundle_0= ruleBundle | this_TerminologyGraph_1= ruleTerminologyGraph )";
        }
    }
    static final String dfa_13s = "\10\uffff";
    static final String dfa_14s = "\1\4\1\uffff\1\4\2\uffff\1\102\1\6\1\4";
    static final String dfa_15s = "\1\u008c\1\uffff\1\4\2\uffff\1\102\1\6\1\u008c";
    static final String dfa_16s = "\1\uffff\1\3\1\uffff\1\1\1\2\3\uffff";
    static final String dfa_17s = "\10\uffff}>";
    static final String[] dfa_18s = {
            "\2\4\1\uffff\1\4\73\uffff\1\2\2\uffff\1\1\3\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\5\uffff\1\4\2\uffff\1\4\3\uffff\4\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\7",
            "\2\4\1\uffff\1\4\73\uffff\1\2\6\uffff\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\5\uffff\1\4\2\uffff\1\4\3\uffff\4\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 417:3: ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )*";
        }
    }
    static final String dfa_19s = "\12\uffff";
    static final String dfa_20s = "\1\4\1\uffff\1\4\4\uffff\1\102\1\6\1\4";
    static final String dfa_21s = "\1\u008c\1\uffff\1\4\4\uffff\1\102\1\6\1\u008c";
    static final String dfa_22s = "\1\uffff\1\5\1\uffff\1\1\1\2\1\3\1\4\3\uffff";
    static final String dfa_23s = "\12\uffff}>";
    static final String[] dfa_24s = {
            "\2\4\1\uffff\1\4\73\uffff\1\2\2\uffff\1\1\2\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\3\uffff\1\5\1\uffff\1\4\2\uffff\1\4\3\uffff\4\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4",
            "",
            "\1\7",
            "",
            "",
            "",
            "",
            "\1\10",
            "\1\11",
            "\2\4\1\uffff\1\4\73\uffff\1\2\5\uffff\1\6\1\3\2\uffff\2\3\2\uffff\3\4\15\uffff\4\4\3\uffff\3\4\3\uffff\1\5\1\uffff\1\4\2\uffff\1\4\3\uffff\4\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\5\4"
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "()* loopback of 545:3: ( ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )*";
        }
    }
    static final String dfa_25s = "\27\uffff";
    static final String dfa_26s = "\1\4\1\uffff\1\4\7\uffff\3\161\1\102\1\4\1\6\3\102\1\4\1\6\2\uffff";
    static final String dfa_27s = "\1\u0091\1\uffff\1\4\7\uffff\3\161\1\102\1\7\1\6\3\102\1\u0091\1\105\2\uffff";
    static final String dfa_28s = "\1\uffff\1\12\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\13\uffff\1\11\1\10";
    static final String dfa_29s = "\27\uffff}>";
    static final String[] dfa_30s = {
            "\1\13\1\12\1\uffff\1\14\73\uffff\1\2\2\uffff\1\1\6\uffff\1\3\30\uffff\1\7\1\10\45\uffff\1\4\1\5\1\uffff\1\6\1\11",
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
            "\1\21\1\20\1\uffff\1\22",
            "\1\23",
            "\1\24",
            "\1\24",
            "\1\24",
            "\1\13\1\12\1\uffff\1\14\73\uffff\1\2\11\uffff\1\3\30\uffff\1\7\1\10\45\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "\1\26\2\uffff\10\26\64\uffff\1\25",
            "",
            ""
    };

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "()* loopback of 713:3: ( ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_31s = "\1\103\1\4\3\uffff\1\102\1\6\1\103";
    static final String dfa_32s = "\1\116\1\4\3\uffff\1\102\1\6\1\116";
    static final String dfa_33s = "\2\uffff\1\1\1\2\1\3\3\uffff";
    static final String[] dfa_34s = {
            "\1\1\6\uffff\1\2\2\uffff\1\3\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7",
            "\1\1\6\uffff\1\2\2\uffff\1\3\1\4"
    };
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_17;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "916:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )";
        }
    }
    static final String dfa_35s = "\2\4\2\uffff\1\102\1\6\1\4";
    static final String dfa_36s = "\1\u008c\1\4\2\uffff\1\102\1\6\1\u008c";
    static final String[] dfa_37s = {
            "\2\2\1\uffff\1\2\73\uffff\1\1\15\uffff\3\3\15\uffff\4\3\3\uffff\3\3\5\uffff\1\2\2\uffff\1\2\3\uffff\3\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\2\2\1\uffff\1\2\73\uffff\1\1\15\uffff\3\3\15\uffff\4\3\3\uffff\3\3\5\uffff\1\2\2\uffff\1\2\3\uffff\3\2\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\2\3\3"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "1257:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )";
        }
    }
    static final String dfa_38s = "\1\103\1\4\4\uffff\1\102\1\6\1\103";
    static final String dfa_39s = "\1\u008c\1\4\4\uffff\1\102\1\6\1\u008c";
    static final String dfa_40s = "\2\uffff\1\1\1\2\1\3\1\4\3\uffff";
    static final String[] dfa_41s = {
            "\1\1\15\uffff\2\2\1\3\15\uffff\1\3\2\4\1\5\3\uffff\3\5\17\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4",
            "\1\6",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\1\15\uffff\2\2\1\3\15\uffff\1\3\2\4\1\5\3\uffff\3\5\17\uffff\1\4\4\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1\uffff\3\4"
    };
    static final char[] dfa_38 = DFA.unpackEncodedStringToUnsignedChars(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[][] dfa_41 = unpackEncodedStringArray(dfa_41s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_38;
            this.max = dfa_39;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_41;
        }
        public String getDescription() {
            return "1293:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )";
        }
    }
    static final String dfa_42s = "\1\122\1\4\2\uffff\1\102\1\6\1\122";
    static final String[] dfa_43s = {
            "\1\1\15\uffff\1\2\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\15\uffff\1\2\1\3"
    };
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[][] dfa_43 = unpackEncodedStringArray(dfa_43s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_42;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_43;
        }
        public String getDescription() {
            return "1347:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )";
        }
    }
    static final String dfa_44s = "\1\141\1\4\2\uffff\1\102\1\6\1\141";
    static final String[] dfa_45s = {
            "\1\1\17\uffff\1\2\15\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\17\uffff\1\2\15\uffff\1\3"
    };
    static final char[] dfa_44 = DFA.unpackEncodedStringToUnsignedChars(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_44;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "1383:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )";
        }
    }
    static final String[] dfa_46s = {
            "\1\1\36\uffff\1\2\1\3\26\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\36\uffff\1\2\1\3\26\uffff\1\2\4\uffff\1\2\1\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\3\2"
    };
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_36;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "1419:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )";
        }
    }
    static final String[] dfa_47s = {
            "\1\1\36\uffff\1\2\27\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\36\uffff\1\2\27\uffff\1\3\4\uffff\1\3\1\uffff\1\3\4\uffff\1\3\1\uffff\1\3\1\uffff\3\3"
    };
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_36;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "1455:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )";
        }
    }
    static final String dfa_48s = "\15\uffff";
    static final String dfa_49s = "\1\103\1\4\10\uffff\1\102\1\6\1\103";
    static final String dfa_50s = "\1\u008c\1\4\10\uffff\1\102\1\6\1\u008c";
    static final String dfa_51s = "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff";
    static final String dfa_52s = "\15\uffff}>";
    static final String[] dfa_53s = {
            "\1\1\66\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11",
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
            "\1\14",
            "\1\1\66\uffff\1\2\4\uffff\1\3\1\uffff\1\4\4\uffff\1\5\1\uffff\1\6\1\uffff\1\7\1\10\1\11"
    };

    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final char[] dfa_50 = DFA.unpackEncodedStringToUnsignedChars(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final short[][] dfa_53 = unpackEncodedStringArray(dfa_53s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_48;
            this.eof = dfa_48;
            this.min = dfa_49;
            this.max = dfa_50;
            this.accept = dfa_51;
            this.special = dfa_52;
            this.transition = dfa_53;
        }
        public String getDescription() {
            return "1491:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )";
        }
    }
    static final String dfa_54s = "\1\152\1\4\4\uffff\1\102\1\6\1\152";
    static final String[] dfa_55s = {
            "\1\1\40\uffff\1\2\3\uffff\1\3\1\4\1\5",
            "\1\6",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\10",
            "\1\1\40\uffff\1\2\3\uffff\1\3\1\4\1\5"
    };
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[][] dfa_55 = unpackEncodedStringArray(dfa_55s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_38;
            this.max = dfa_54;
            this.accept = dfa_40;
            this.special = dfa_11;
            this.transition = dfa_55;
        }
        public String getDescription() {
            return "1581:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )";
        }
    }
    static final String dfa_56s = "\23\uffff";
    static final String dfa_57s = "\2\4\2\uffff\1\4\2\uffff\1\102\3\161\1\6\2\4\3\102\1\6\1\uffff";
    static final String dfa_58s = "\1\u0089\1\4\2\uffff\1\7\2\uffff\1\102\3\161\1\6\1\7\1\u0089\3\102\1\105\1\uffff";
    static final String dfa_59s = "\2\uffff\1\1\1\2\1\uffff\1\4\1\5\13\uffff\1\3";
    static final String dfa_60s = "\23\uffff}>";
    static final String[] dfa_61s = {
            "\2\6\1\uffff\1\6\73\uffff\1\1\54\uffff\1\2\2\uffff\1\2\3\uffff\1\3\1\4\1\3\17\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\11\1\10\1\uffff\1\12",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\14",
            "\1\14",
            "\1\15",
            "\1\17\1\16\1\uffff\1\20",
            "\2\6\1\uffff\1\6\73\uffff\1\1\54\uffff\1\2\2\uffff\1\2\3\uffff\1\3\1\4\1\3\17\uffff\1\5",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\3\2\uffff\10\3\64\uffff\1\22",
            ""
    };

    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final char[] dfa_57 = DFA.unpackEncodedStringToUnsignedChars(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[][] dfa_61 = unpackEncodedStringArray(dfa_61s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_56;
            this.eof = dfa_56;
            this.min = dfa_57;
            this.max = dfa_58;
            this.accept = dfa_59;
            this.special = dfa_60;
            this.transition = dfa_61;
        }
        public String getDescription() {
            return "1635:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )";
        }
    }
    static final String dfa_62s = "\1\163\1\4\2\uffff\1\102\1\6\1\163";
    static final String[] dfa_63s = {
            "\1\1\54\uffff\1\2\2\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\54\uffff\1\2\2\uffff\1\3"
    };
    static final char[] dfa_62 = DFA.unpackEncodedStringToUnsignedChars(dfa_62s);
    static final short[][] dfa_63 = unpackEncodedStringArray(dfa_63s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_62;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_63;
        }
        public String getDescription() {
            return "1698:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_64s = "\1\171\1\4\3\uffff\1\102\1\6\1\171";
    static final String[] dfa_65s = {
            "\1\1\63\uffff\1\2\1\3\1\4",
            "\1\5",
            "",
            "",
            "",
            "\1\6",
            "\1\7",
            "\1\1\63\uffff\1\2\1\3\1\4"
    };
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[][] dfa_65 = unpackEncodedStringArray(dfa_65s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_31;
            this.max = dfa_64;
            this.accept = dfa_33;
            this.special = dfa_17;
            this.transition = dfa_65;
        }
        public String getDescription() {
            return "1734:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )";
        }
    }
    static final String dfa_66s = "\13\uffff";
    static final String dfa_67s = "\2\4\3\164\1\102\3\uffff\1\6\1\4";
    static final String dfa_68s = "\1\103\1\4\3\166\1\102\3\uffff\1\6\1\103";
    static final String dfa_69s = "\6\uffff\1\1\1\3\1\2\2\uffff";
    static final String dfa_70s = "\13\uffff}>";
    static final String[] dfa_71s = {
            "\1\3\1\2\1\uffff\1\4\73\uffff\1\1",
            "\1\5",
            "\1\10\1\6\1\7",
            "\1\10\1\6\1\7",
            "\1\10\1\6\1\7",
            "\1\11",
            "",
            "",
            "",
            "\1\12",
            "\1\3\1\2\1\uffff\1\4\73\uffff\1\1"
    };

    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "1804:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )";
        }
    }
    static final String dfa_72s = "\1\157\1\4\2\uffff\1\102\1\6\1\157";
    static final String[] dfa_73s = {
            "\1\1\47\uffff\1\2\3\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\47\uffff\1\2\3\uffff\1\3"
    };
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final short[][] dfa_73 = unpackEncodedStringArray(dfa_73s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_72;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_73;
        }
        public String getDescription() {
            return "1899:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )";
        }
    }
    static final String dfa_74s = "\1\124\12\uffff";
    static final String dfa_75s = "\1\135\12\uffff";
    static final String dfa_76s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_77s = "\1\0\12\uffff}>";
    static final String[] dfa_78s = {
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
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final char[] dfa_75 = DFA.unpackEncodedStringToUnsignedChars(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final short[][] dfa_78 = unpackEncodedStringArray(dfa_78s);

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_74;
            this.max = dfa_75;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_78;
        }
        public String getDescription() {
            return "()* loopback of 2107:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_0 = input.LA(1);

                         
                        int index31_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA31_0==93) ) {s = 1;}

                        else if ( LA31_0 == 84 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA31_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA31_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA31_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA31_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA31_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA31_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA31_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA31_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                         
                        input.seek(index31_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_79s = "\1\137\12\uffff";
    static final String[] dfa_80s = {
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
    static final char[] dfa_79 = DFA.unpackEncodedStringToUnsignedChars(dfa_79s);
    static final short[][] dfa_80 = unpackEncodedStringArray(dfa_80s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_66;
            this.eof = dfa_66;
            this.min = dfa_74;
            this.max = dfa_79;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_80;
        }
        public String getDescription() {
            return "()* loopback of 2498:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_5_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_6_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_7_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_8_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_9_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_10_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_11_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_12_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_13_0= 'transitive' ) ) ) ) ) )*";
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
                        if ( (LA34_0==95) ) {s = 1;}

                        else if ( LA34_0 == 84 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA34_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA34_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA34_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA34_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA34_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA34_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA34_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA34_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                         
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
    static final String dfa_81s = "\14\uffff";
    static final String dfa_82s = "\1\4\1\uffff\1\4\4\102\2\6\2\uffff\1\4";
    static final String dfa_83s = "\1\106\1\uffff\1\4\4\102\1\105\1\6\2\uffff\1\103";
    static final String dfa_84s = "\1\uffff\1\3\7\uffff\1\1\1\2\1\uffff";
    static final String dfa_85s = "\14\uffff}>";
    static final String[] dfa_86s = {
            "\1\4\1\3\1\uffff\1\5\73\uffff\1\2\2\uffff\1\1",
            "",
            "\1\6",
            "\1\7",
            "\1\7",
            "\1\7",
            "\1\10",
            "\1\12\2\uffff\10\12\64\uffff\1\11",
            "\1\13",
            "",
            "",
            "\1\4\1\3\1\uffff\1\5\73\uffff\1\2"
    };

    static final short[] dfa_81 = DFA.unpackEncodedString(dfa_81s);
    static final char[] dfa_82 = DFA.unpackEncodedStringToUnsignedChars(dfa_82s);
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final short[] dfa_84 = DFA.unpackEncodedString(dfa_84s);
    static final short[] dfa_85 = DFA.unpackEncodedString(dfa_85s);
    static final short[][] dfa_86 = unpackEncodedStringArray(dfa_86s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_81;
            this.eof = dfa_81;
            this.min = dfa_82;
            this.max = dfa_83;
            this.accept = dfa_84;
            this.special = dfa_85;
            this.transition = dfa_86;
        }
        public String getDescription() {
            return "()* loopback of 4400:3: ( ( (lv_structuredDataPropertyRestrictions_7_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_8_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_81;
            this.eof = dfa_81;
            this.min = dfa_82;
            this.max = dfa_83;
            this.accept = dfa_84;
            this.special = dfa_85;
            this.transition = dfa_86;
        }
        public String getDescription() {
            return "()* loopback of 4507:3: ( ( (lv_structuredDataPropertyRestrictions_4_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyRestrictions_5_0= ruleRestrictionScalarDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_87s = "\1\u0090\1\4\2\uffff\1\102\1\6\1\u0090";
    static final String[] dfa_88s = {
            "\1\1\112\uffff\1\2\1\uffff\1\3",
            "\1\4",
            "",
            "",
            "\1\5",
            "\1\6",
            "\1\1\112\uffff\1\2\1\uffff\1\3"
    };
    static final char[] dfa_87 = DFA.unpackEncodedStringToUnsignedChars(dfa_87s);
    static final short[][] dfa_88 = unpackEncodedStringArray(dfa_88s);

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_87;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_88;
        }
        public String getDescription() {
            return "6320:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )";
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_81;
            this.eof = dfa_81;
            this.min = dfa_82;
            this.max = dfa_83;
            this.accept = dfa_84;
            this.special = dfa_85;
            this.transition = dfa_86;
        }
        public String getDescription() {
            return "()* loopback of 6633:3: ( ( (lv_structuredPropertyTuples_6_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_81;
            this.eof = dfa_81;
            this.min = dfa_82;
            this.max = dfa_83;
            this.accept = dfa_84;
            this.special = dfa_85;
            this.transition = dfa_86;
        }
        public String getDescription() {
            return "()* loopback of 6740:3: ( ( (lv_structuredPropertyTuples_4_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_5_0= ruleScalarDataPropertyValue ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000AL,0x00000000003C0000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x00000000000C0000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000000B0L,0x8789071E000E6448L,0x0000000000001F42L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000000B0L,0x8789471E000E6648L,0x0000000000001F42L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x000000000000010AL,0x00000000003C0000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000000B0L,0x000000C000002048L,0x0000000000036000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000208L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000408L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000000000000B0L,0x0000000000000008L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002008L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004008L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020008L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040008L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080008L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x000000003FF00000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000008L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x000000009FF00000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000008L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000008L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000008L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000080L,0x0000002000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000008L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000008L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000008L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000880000000048L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000008L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000008L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000008L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000008L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000008L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000008L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x000000000001FE40L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000008L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x00000000000000B0L,0x0000000000000048L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000008L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x7800000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000008L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x7800000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L,0x000000000000003CL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x7800000000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000100L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000200L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000400L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000000800L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000001000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000002000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000004000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000008L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000008L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});

}
