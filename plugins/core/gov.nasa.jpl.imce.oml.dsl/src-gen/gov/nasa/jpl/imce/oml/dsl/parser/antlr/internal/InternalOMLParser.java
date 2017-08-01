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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DECIMAL", "RULE_UUID", "RULE_HEX", "RULE_FLOAT", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'descriptionBox'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'anonymousConceptUnion'", "'('", "')'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'someData'", "'every'", "'allData'", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
    };
    public static final int RULE_HEX=11;
    public static final int T__50=50;
    public static final int RULE_ABBREV_IRI=4;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=7;
    public static final int RULE_UUID=10;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=17;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_IRI=5;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=12;
    public static final int RULE_HEX_DIGIT=16;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_HEX_8DIGITS=13;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_HEX_12DIGITS=15;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=18;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int RULE_HEX_4DIGITS=14;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=19;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;

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

                if ( (LA1_0==20) ) {
                    alt1=1;
                }
                else if ( (LA1_0==22||(LA1_0>=101 && LA1_0<=104)) ) {
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
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,21,FOLLOW_6); 

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


    // $ANTLR start "entryRuleAnnotation"
    // InternalOML.g:208:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalOML.g:208:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalOML.g:209:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalOML.g:215:1: ruleAnnotation returns [EObject current=null] : (otherlv_0= '@' ( (otherlv_1= RULE_ABBREV_IRI ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
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
            otherlv_0=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAnnotationAccess().getCommercialAtKeyword_0());
            		
            // InternalOML.g:227:3: ( (otherlv_1= RULE_ABBREV_IRI ) )
            // InternalOML.g:228:4: (otherlv_1= RULE_ABBREV_IRI )
            {
            // InternalOML.g:228:4: (otherlv_1= RULE_ABBREV_IRI )
            // InternalOML.g:229:5: otherlv_1= RULE_ABBREV_IRI
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_5); 

            					newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getPropertyAnnotationPropertyCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getAnnotationAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:244:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOML.g:245:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOML.g:245:4: (lv_value_3_0= RULE_STRING )
            // InternalOML.g:246:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnnotationRule());
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
    // $ANTLR end "ruleAnnotation"


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
    // InternalOML.g:345:1: ruleTerminologyGraph returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_annotations_5_0 = null;

        EObject lv_boxAxioms_6_0 = null;

        EObject lv_boxStatements_7_0 = null;



        	enterRule();

        try {
            // InternalOML.g:351:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:352:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:352:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}' )
            // InternalOML.g:353:3: ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'terminology' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )* otherlv_8= '}'
            {
            // InternalOML.g:353:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOML.g:354:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:354:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalOML.g:355:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
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

            otherlv_2=(Token)match(input,23,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,24,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:417:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )*
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    alt5=1;
                    }
                    break;
                case 29:
                case 32:
                case 33:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_ABBREV_IRI:
                case RULE_IRI:
                case RULE_ID:
                case 36:
                case 37:
                case 38:
                case 52:
                case 53:
                case 54:
                case 55:
                case 59:
                case 60:
                case 61:
                case 67:
                case 70:
                case 74:
                case 75:
                case 76:
                case 77:
                case 82:
                case 84:
                case 89:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    {
                    alt5=3;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalOML.g:418:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:418:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    // InternalOML.g:419:5: (lv_annotations_5_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:419:5: (lv_annotations_5_0= ruleAnnotation )
            	    // InternalOML.g:420:6: lv_annotations_5_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_annotations_5_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:438:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:438:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:439:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:439:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:440:6: lv_boxAxioms_6_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0());
            	    					
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
            	case 3 :
            	    // InternalOML.g:458:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:458:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:459:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:459:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:460:6: lv_boxStatements_7_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0());
            	    					
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
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:486:1: entryRuleBundle returns [EObject current=null] : iv_ruleBundle= ruleBundle EOF ;
    public final EObject entryRuleBundle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundle = null;


        try {
            // InternalOML.g:486:47: (iv_ruleBundle= ruleBundle EOF )
            // InternalOML.g:487:2: iv_ruleBundle= ruleBundle EOF
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
    // InternalOML.g:493:1: ruleBundle returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleBundle() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_10=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_annotations_5_0 = null;

        EObject lv_boxAxioms_6_0 = null;

        EObject lv_boxStatements_7_0 = null;

        EObject lv_bundleStatements_8_0 = null;

        EObject lv_bundleAxioms_9_0 = null;



        	enterRule();

        try {
            // InternalOML.g:499:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' ) )
            // InternalOML.g:500:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' )
            {
            // InternalOML.g:500:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}' )
            // InternalOML.g:501:3: ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleTerminologyKind ) ) otherlv_2= 'bundle' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )* otherlv_10= '}'
            {
            // InternalOML.g:501:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalOML.g:502:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:502:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalOML.g:503:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBundleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalOML.g:520:3: ( (lv_kind_1_0= ruleTerminologyKind ) )
            // InternalOML.g:521:4: (lv_kind_1_0= ruleTerminologyKind )
            {
            // InternalOML.g:521:4: (lv_kind_1_0= ruleTerminologyKind )
            // InternalOML.g:522:5: lv_kind_1_0= ruleTerminologyKind
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

            otherlv_2=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getBundleAccess().getBundleKeyword_2());
            		
            // InternalOML.g:543:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:544:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:544:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:545:5: lv_iri_3_0= RULE_IRI
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

            otherlv_4=(Token)match(input,24,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:565:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )*
            loop7:
            do {
                int alt7=6;
                switch ( input.LA(1) ) {
                case 22:
                    {
                    alt7=1;
                    }
                    break;
                case 29:
                case 32:
                case 33:
                    {
                    alt7=2;
                    }
                    break;
                case RULE_ABBREV_IRI:
                case RULE_IRI:
                case RULE_ID:
                case 36:
                case 37:
                case 38:
                case 52:
                case 53:
                case 54:
                case 55:
                case 59:
                case 60:
                case 61:
                case 67:
                case 70:
                case 74:
                case 75:
                case 76:
                case 77:
                case 82:
                case 84:
                case 89:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    {
                    alt7=3;
                    }
                    break;
                case 65:
                    {
                    alt7=4;
                    }
                    break;
                case 28:
                    {
                    alt7=5;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // InternalOML.g:566:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:566:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    // InternalOML.g:567:5: (lv_annotations_5_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:567:5: (lv_annotations_5_0= ruleAnnotation )
            	    // InternalOML.g:568:6: lv_annotations_5_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_annotations_5_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:586:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:586:4: ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:587:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:587:5: (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:588:6: lv_boxAxioms_6_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_5_1_0());
            	    					
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
            	case 3 :
            	    // InternalOML.g:606:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:606:4: ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:607:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:607:5: (lv_boxStatements_7_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:608:6: lv_boxStatements_7_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_5_2_0());
            	    					
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
            	case 4 :
            	    // InternalOML.g:626:4: ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) )
            	    {
            	    // InternalOML.g:626:4: ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) )
            	    // InternalOML.g:627:5: (lv_bundleStatements_8_0= ruleTerminologyBundleStatement )
            	    {
            	    // InternalOML.g:627:5: (lv_bundleStatements_8_0= ruleTerminologyBundleStatement )
            	    // InternalOML.g:628:6: lv_bundleStatements_8_0= ruleTerminologyBundleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_5_3_0());
            	    					
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
            	case 5 :
            	    // InternalOML.g:646:4: ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) )
            	    {
            	    // InternalOML.g:646:4: ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) )
            	    // InternalOML.g:647:5: (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom )
            	    {
            	    // InternalOML.g:647:5: (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom )
            	    // InternalOML.g:648:6: lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_5_4_0());
            	    					
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
            	    break loop7;
                }
            } while (true);

            otherlv_10=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:674:1: entryRuleDescriptionBox returns [EObject current=null] : iv_ruleDescriptionBox= ruleDescriptionBox EOF ;
    public final EObject entryRuleDescriptionBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBox = null;


        try {
            // InternalOML.g:674:55: (iv_ruleDescriptionBox= ruleDescriptionBox EOF )
            // InternalOML.g:675:2: iv_ruleDescriptionBox= ruleDescriptionBox EOF
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
    // InternalOML.g:681:1: ruleDescriptionBox returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' ) ;
    public final EObject ruleDescriptionBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_iri_3_0=null;
        Token otherlv_4=null;
        Token otherlv_15=null;
        EObject lv_annotations_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_annotations_5_0 = null;

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
            // InternalOML.g:687:2: ( ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' ) )
            // InternalOML.g:688:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' )
            {
            // InternalOML.g:688:2: ( ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}' )
            // InternalOML.g:689:3: ( (lv_annotations_0_0= ruleAnnotation ) )* ( (lv_kind_1_0= ruleDescriptionKind ) ) otherlv_2= 'descriptionBox' ( (lv_iri_3_0= RULE_IRI ) ) otherlv_4= '{' ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_15= '}'
            {
            // InternalOML.g:689:3: ( (lv_annotations_0_0= ruleAnnotation ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalOML.g:690:4: (lv_annotations_0_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:690:4: (lv_annotations_0_0= ruleAnnotation )
            	    // InternalOML.g:691:5: lv_annotations_0_0= ruleAnnotation
            	    {

            	    					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_14);
            	    lv_annotations_0_0=ruleAnnotation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    					}
            	    					add(
            	    						current,
            	    						"annotations",
            	    						lv_annotations_0_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalOML.g:708:3: ( (lv_kind_1_0= ruleDescriptionKind ) )
            // InternalOML.g:709:4: (lv_kind_1_0= ruleDescriptionKind )
            {
            // InternalOML.g:709:4: (lv_kind_1_0= ruleDescriptionKind )
            // InternalOML.g:710:5: lv_kind_1_0= ruleDescriptionKind
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

            otherlv_2=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_2());
            		
            // InternalOML.g:731:3: ( (lv_iri_3_0= RULE_IRI ) )
            // InternalOML.g:732:4: (lv_iri_3_0= RULE_IRI )
            {
            // InternalOML.g:732:4: (lv_iri_3_0= RULE_IRI )
            // InternalOML.g:733:5: lv_iri_3_0= RULE_IRI
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

            otherlv_4=(Token)match(input,24,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:753:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*
            loop9:
            do {
                int alt9=11;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalOML.g:754:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:754:4: ( (lv_annotations_5_0= ruleAnnotation ) )
            	    // InternalOML.g:755:5: (lv_annotations_5_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:755:5: (lv_annotations_5_0= ruleAnnotation )
            	    // InternalOML.g:756:6: lv_annotations_5_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_annotations_5_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:774:4: ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    {
            	    // InternalOML.g:774:4: ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    // InternalOML.g:775:5: (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    {
            	    // InternalOML.g:775:5: (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    // InternalOML.g:776:6: lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_5_1_0());
            	    					
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
            	case 3 :
            	    // InternalOML.g:794:4: ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) )
            	    {
            	    // InternalOML.g:794:4: ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) )
            	    // InternalOML.g:795:5: (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement )
            	    {
            	    // InternalOML.g:795:5: (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement )
            	    // InternalOML.g:796:6: lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_5_2_0());
            	    					
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
            	case 4 :
            	    // InternalOML.g:814:4: ( (lv_conceptInstances_8_0= ruleConceptInstance ) )
            	    {
            	    // InternalOML.g:814:4: ( (lv_conceptInstances_8_0= ruleConceptInstance ) )
            	    // InternalOML.g:815:5: (lv_conceptInstances_8_0= ruleConceptInstance )
            	    {
            	    // InternalOML.g:815:5: (lv_conceptInstances_8_0= ruleConceptInstance )
            	    // InternalOML.g:816:6: lv_conceptInstances_8_0= ruleConceptInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_5_3_0());
            	    					
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
            	case 5 :
            	    // InternalOML.g:834:4: ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) )
            	    {
            	    // InternalOML.g:834:4: ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) )
            	    // InternalOML.g:835:5: (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance )
            	    {
            	    // InternalOML.g:835:5: (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance )
            	    // InternalOML.g:836:6: lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_5_4_0());
            	    					
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
            	case 6 :
            	    // InternalOML.g:854:4: ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) )
            	    {
            	    // InternalOML.g:854:4: ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) )
            	    // InternalOML.g:855:5: (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain )
            	    {
            	    // InternalOML.g:855:5: (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain )
            	    // InternalOML.g:856:6: lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_5_5_0());
            	    					
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
            	case 7 :
            	    // InternalOML.g:874:4: ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) )
            	    {
            	    // InternalOML.g:874:4: ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) )
            	    // InternalOML.g:875:5: (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange )
            	    {
            	    // InternalOML.g:875:5: (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange )
            	    // InternalOML.g:876:6: lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_5_6_0());
            	    					
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
            	case 8 :
            	    // InternalOML.g:894:4: ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    {
            	    // InternalOML.g:894:4: ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    // InternalOML.g:895:5: (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple )
            	    {
            	    // InternalOML.g:895:5: (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple )
            	    // InternalOML.g:896:6: lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_5_7_0());
            	    					
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
            	case 9 :
            	    // InternalOML.g:914:4: ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:914:4: ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    // InternalOML.g:915:5: (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:915:5: (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    // InternalOML.g:916:6: lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_5_8_0());
            	    					
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
            	case 10 :
            	    // InternalOML.g:934:4: ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    {
            	    // InternalOML.g:934:4: ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    // InternalOML.g:935:5: (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    {
            	    // InternalOML.g:935:5: (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    // InternalOML.g:936:6: lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_5_9_0());
            	    					
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
            	    break loop9;
                }
            } while (true);

            otherlv_15=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:962:1: entryRuleTerminologyBoxAxiom returns [EObject current=null] : iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF ;
    public final EObject entryRuleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxAxiom = null;


        try {
            // InternalOML.g:962:60: (iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF )
            // InternalOML.g:963:2: iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF
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
    // InternalOML.g:969:1: ruleTerminologyBoxAxiom returns [EObject current=null] : (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) ;
    public final EObject ruleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptDesignationTerminologyAxiom_0 = null;

        EObject this_TerminologyExtensionAxiom_1 = null;

        EObject this_TerminologyNestingAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:975:2: ( (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) )
            // InternalOML.g:976:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            {
            // InternalOML.g:976:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt10=1;
                }
                break;
            case 32:
                {
                alt10=2;
                }
                break;
            case 33:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalOML.g:977:3: this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom
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
                    // InternalOML.g:986:3: this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom
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
                    // InternalOML.g:995:3: this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom
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
    // InternalOML.g:1007:1: entryRuleBundledTerminologyAxiom returns [EObject current=null] : iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF ;
    public final EObject entryRuleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundledTerminologyAxiom = null;


        try {
            // InternalOML.g:1007:64: (iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF )
            // InternalOML.g:1008:2: iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF
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
    // InternalOML.g:1014:1: ruleBundledTerminologyAxiom returns [EObject current=null] : (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:1020:2: ( (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:1021:2: (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:1021:2: (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) )
            // InternalOML.g:1022:3: otherlv_0= 'bundles' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_0());
            		
            // InternalOML.g:1026:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1027:4: ( ruleExternalReference )
            {
            // InternalOML.g:1027:4: ( ruleExternalReference )
            // InternalOML.g:1028:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundledTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBundledTerminologyAxiomAccess().getBundledTerminologyTerminologyBoxCrossReference_1_0());
            				
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
    // InternalOML.g:1046:1: entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null] : iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF ;
    public final EObject entryRuleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptDesignationTerminologyAxiom = null;


        try {
            // InternalOML.g:1046:75: (iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF )
            // InternalOML.g:1047:2: iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF
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
    // InternalOML.g:1053:1: ruleConceptDesignationTerminologyAxiom returns [EObject current=null] : (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalOML.g:1059:2: ( (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:1060:2: (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:1060:2: (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:1061:3: otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2());
            		
            // InternalOML.g:1073:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1074:4: ( ruleExternalReference )
            {
            // InternalOML.g:1074:4: ( ruleExternalReference )
            // InternalOML.g:1075:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_18);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,31,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4());
            		
            // InternalOML.g:1093:3: ( ( ruleReference ) )
            // InternalOML.g:1094:4: ( ruleReference )
            {
            // InternalOML.g:1094:4: ( ruleReference )
            // InternalOML.g:1095:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:1117:1: entryRuleTerminologyExtensionAxiom returns [EObject current=null] : iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF ;
    public final EObject entryRuleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtensionAxiom = null;


        try {
            // InternalOML.g:1117:66: (iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF )
            // InternalOML.g:1118:2: iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF
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
    // InternalOML.g:1124:1: ruleTerminologyExtensionAxiom returns [EObject current=null] : (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:1130:2: ( (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:1131:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:1131:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:1132:3: otherlv_0= 'extends' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_0());
            		
            // InternalOML.g:1136:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1137:4: ( ruleExternalReference )
            {
            // InternalOML.g:1137:4: ( ruleExternalReference )
            // InternalOML.g:1138:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyExtensionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyExtensionAxiomAccess().getExtendedTerminologyTerminologyBoxCrossReference_1_0());
            				
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
    // InternalOML.g:1156:1: entryRuleTerminologyNestingAxiom returns [EObject current=null] : iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF ;
    public final EObject entryRuleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyNestingAxiom = null;


        try {
            // InternalOML.g:1156:64: (iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF )
            // InternalOML.g:1157:2: iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF
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
    // InternalOML.g:1163:1: ruleTerminologyNestingAxiom returns [EObject current=null] : (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalOML.g:1169:2: ( (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:1170:2: (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:1170:2: (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:1171:3: otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2());
            		
            // InternalOML.g:1183:3: ( ( ruleExternalReference ) )
            // InternalOML.g:1184:4: ( ruleExternalReference )
            {
            // InternalOML.g:1184:4: ( ruleExternalReference )
            // InternalOML.g:1185:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_22);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4());
            		
            // InternalOML.g:1203:3: ( ( ruleReference ) )
            // InternalOML.g:1204:4: ( ruleReference )
            {
            // InternalOML.g:1204:4: ( ruleReference )
            // InternalOML.g:1205:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTerminologyNestingAxiomAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:1227:1: entryRuleTerminologyBoxStatement returns [EObject current=null] : iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF ;
    public final EObject entryRuleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxStatement = null;


        try {
            // InternalOML.g:1227:64: (iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF )
            // InternalOML.g:1228:2: iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF
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
    // InternalOML.g:1234:1: ruleTerminologyBoxStatement returns [EObject current=null] : (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) ;
    public final EObject ruleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TermAxiom_0 = null;

        EObject this_Term_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1240:2: ( (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) )
            // InternalOML.g:1241:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            {
            // InternalOML.g:1241:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_ABBREV_IRI && LA11_0<=RULE_IRI)||LA11_0==RULE_ID||LA11_0==67||LA11_0==70||(LA11_0>=74 && LA11_0<=76)||LA11_0==92) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=36 && LA11_0<=38)||(LA11_0>=52 && LA11_0<=55)||(LA11_0>=59 && LA11_0<=61)||LA11_0==77||LA11_0==82||LA11_0==84||LA11_0==89||LA11_0==91||(LA11_0>=93 && LA11_0<=95)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOML.g:1242:3: this_TermAxiom_0= ruleTermAxiom
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
                    // InternalOML.g:1251:3: this_Term_1= ruleTerm
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
    // InternalOML.g:1263:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalOML.g:1263:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalOML.g:1264:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalOML.g:1270:1: ruleTerm returns [EObject current=null] : (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEntity_0 = null;

        EObject this_EntityRelationship_1 = null;

        EObject this_Datatype_2 = null;

        EObject this_DataRelationship_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1276:2: ( (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) )
            // InternalOML.g:1277:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            {
            // InternalOML.g:1277:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 36:
            case 37:
                {
                alt12=1;
                }
                break;
            case 38:
            case 52:
                {
                alt12=2;
                }
                break;
            case 53:
            case 54:
            case 77:
            case 82:
            case 84:
            case 89:
            case 91:
            case 93:
            case 94:
            case 95:
                {
                alt12=3;
                }
                break;
            case 55:
            case 59:
            case 60:
            case 61:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalOML.g:1278:3: this_AtomicEntity_0= ruleAtomicEntity
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
                    // InternalOML.g:1287:3: this_EntityRelationship_1= ruleEntityRelationship
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
                    // InternalOML.g:1296:3: this_Datatype_2= ruleDatatype
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
                    // InternalOML.g:1305:3: this_DataRelationship_3= ruleDataRelationship
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
    // InternalOML.g:1317:1: entryRuleAtomicEntity returns [EObject current=null] : iv_ruleAtomicEntity= ruleAtomicEntity EOF ;
    public final EObject entryRuleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEntity = null;


        try {
            // InternalOML.g:1317:53: (iv_ruleAtomicEntity= ruleAtomicEntity EOF )
            // InternalOML.g:1318:2: iv_ruleAtomicEntity= ruleAtomicEntity EOF
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
    // InternalOML.g:1324:1: ruleAtomicEntity returns [EObject current=null] : (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) ;
    public final EObject ruleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Aspect_0 = null;

        EObject this_Concept_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1330:2: ( (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) )
            // InternalOML.g:1331:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            {
            // InternalOML.g:1331:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==36) ) {
                alt13=1;
            }
            else if ( (LA13_0==37) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalOML.g:1332:3: this_Aspect_0= ruleAspect
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
                    // InternalOML.g:1341:3: this_Concept_1= ruleConcept
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
    // InternalOML.g:1353:1: entryRuleEntityRelationship returns [EObject current=null] : iv_ruleEntityRelationship= ruleEntityRelationship EOF ;
    public final EObject entryRuleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRelationship = null;


        try {
            // InternalOML.g:1353:59: (iv_ruleEntityRelationship= ruleEntityRelationship EOF )
            // InternalOML.g:1354:2: iv_ruleEntityRelationship= ruleEntityRelationship EOF
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
    // InternalOML.g:1360:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_UnreifiedRelationship_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1366:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) )
            // InternalOML.g:1367:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            {
            // InternalOML.g:1367:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            else if ( (LA14_0==52) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalOML.g:1368:3: this_ReifiedRelationship_0= ruleReifiedRelationship
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
                    // InternalOML.g:1377:3: this_UnreifiedRelationship_1= ruleUnreifiedRelationship
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
    // InternalOML.g:1389:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOML.g:1389:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOML.g:1390:2: iv_ruleDatatype= ruleDatatype EOF
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
    // InternalOML.g:1396:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1402:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOML.g:1403:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOML.g:1403:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==53||LA15_0==77||LA15_0==82||LA15_0==84||LA15_0==89||LA15_0==91||(LA15_0>=93 && LA15_0<=95)) ) {
                alt15=1;
            }
            else if ( (LA15_0==54) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalOML.g:1404:3: this_ScalarDataRange_0= ruleScalarDataRange
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
                    // InternalOML.g:1413:3: this_Structure_1= ruleStructure
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
    // InternalOML.g:1425:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOML.g:1425:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOML.g:1426:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
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
    // InternalOML.g:1432:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1438:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOML.g:1439:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOML.g:1439:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==53) ) {
                alt16=1;
            }
            else if ( (LA16_0==77||LA16_0==82||LA16_0==84||LA16_0==89||LA16_0==91||(LA16_0>=93 && LA16_0<=95)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOML.g:1440:3: this_Scalar_0= ruleScalar
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
                    // InternalOML.g:1449:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
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
    // InternalOML.g:1461:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOML.g:1461:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOML.g:1462:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
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
    // InternalOML.g:1468:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
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
            // InternalOML.g:1474:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOML.g:1475:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOML.g:1475:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt17=8;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt17=1;
                }
                break;
            case 82:
                {
                alt17=2;
                }
                break;
            case 84:
                {
                alt17=3;
                }
                break;
            case 89:
                {
                alt17=4;
                }
                break;
            case 91:
                {
                alt17=5;
                }
                break;
            case 93:
                {
                alt17=6;
                }
                break;
            case 94:
                {
                alt17=7;
                }
                break;
            case 95:
                {
                alt17=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalOML.g:1476:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
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
                    // InternalOML.g:1485:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
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
                    // InternalOML.g:1494:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
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
                    // InternalOML.g:1503:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
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
                    // InternalOML.g:1512:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
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
                    // InternalOML.g:1521:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
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
                    // InternalOML.g:1530:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
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
                    // InternalOML.g:1539:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
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
    // InternalOML.g:1551:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOML.g:1551:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOML.g:1552:2: iv_ruleDataRelationship= ruleDataRelationship EOF
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
    // InternalOML.g:1558:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1564:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOML.g:1565:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOML.g:1565:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt18=1;
                }
                break;
            case 59:
                {
                alt18=2;
                }
                break;
            case 60:
                {
                alt18=3;
                }
                break;
            case 61:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOML.g:1566:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
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
                    // InternalOML.g:1575:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
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
                    // InternalOML.g:1584:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
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
                    // InternalOML.g:1593:3: this_ScalarDataProperty_3= ruleScalarDataProperty
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
    // InternalOML.g:1605:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOML.g:1605:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOML.g:1606:2: iv_ruleTermAxiom= ruleTermAxiom EOF
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
    // InternalOML.g:1612:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_EntityStructuredDataPropertyRestrictionAxiom_2 = null;

        EObject this_ScalarOneOfLiteralAxiom_3 = null;

        EObject this_SpecializationAxiom_4 = null;



        	enterRule();

        try {
            // InternalOML.g:1618:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom ) )
            // InternalOML.g:1619:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )
            {
            // InternalOML.g:1619:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )
            int alt19=5;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalOML.g:1620:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
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
                    // InternalOML.g:1629:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1638:3: this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1647:3: this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom
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
                    // InternalOML.g:1656:3: this_SpecializationAxiom_4= ruleSpecializationAxiom
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
    // InternalOML.g:1668:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1668:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1669:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
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
    // InternalOML.g:1675:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1681:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1682:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1682:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==67) ) {
                alt20=1;
            }
            else if ( (LA20_0==70) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalOML.g:1683:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
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
                    // InternalOML.g:1692:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
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
    // InternalOML.g:1704:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1704:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1705:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1711:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1717:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1718:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1718:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt21=1;
                }
                break;
            case 75:
                {
                alt21=2;
                }
                break;
            case 76:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalOML.g:1719:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
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
                    // InternalOML.g:1728:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
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
                    // InternalOML.g:1737:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
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
    // InternalOML.g:1749:1: entryRuleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1749:85: (iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1750:2: iv_ruleEntityStructuredDataPropertyRestrictionAxiom= ruleEntityStructuredDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1756:1: ruleEntityStructuredDataPropertyRestrictionAxiom returns [EObject current=null] : this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom ;
    public final EObject ruleEntityStructuredDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataPropertyParticularRestrictionAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1762:2: (this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom )
            // InternalOML.g:1763:2: this_EntityStructuredDataPropertyParticularRestrictionAxiom_0= ruleEntityStructuredDataPropertyParticularRestrictionAxiom
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
    // InternalOML.g:1774:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1774:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1775:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
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
    // InternalOML.g:1781:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1787:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1788:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1788:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_IRI:
                {
                switch ( input.LA(2) ) {
                case 72:
                    {
                    alt22=1;
                    }
                    break;
                case 71:
                    {
                    alt22=2;
                    }
                    break;
                case 73:
                    {
                    alt22=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ABBREV_IRI:
                {
                switch ( input.LA(2) ) {
                case 72:
                    {
                    alt22=1;
                    }
                    break;
                case 71:
                    {
                    alt22=2;
                    }
                    break;
                case 73:
                    {
                    alt22=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 72:
                    {
                    alt22=1;
                    }
                    break;
                case 71:
                    {
                    alt22=2;
                    }
                    break;
                case 73:
                    {
                    alt22=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalOML.g:1789:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
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
                    // InternalOML.g:1798:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
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
                    // InternalOML.g:1807:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
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
    // InternalOML.g:1819:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1819:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1820:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
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
    // InternalOML.g:1826:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1832:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1833:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
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
    // InternalOML.g:1844:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1844:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1845:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
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
    // InternalOML.g:1851:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1857:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1858:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
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
    // InternalOML.g:1869:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1869:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1870:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
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
    // InternalOML.g:1876:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1882:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1883:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1883:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==62) ) {
                alt23=1;
            }
            else if ( (LA23_0==66) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalOML.g:1884:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
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
                    // InternalOML.g:1893:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
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
    // InternalOML.g:1905:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1905:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1906:2: iv_ruleAspect= ruleAspect EOF
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
    // InternalOML.g:1912:1: ruleAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1918:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1919:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1919:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1920:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
            		
            // InternalOML.g:1924:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1925:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1925:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1926:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAspectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // InternalOML.g:1946:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:1946:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:1947:2: iv_ruleConcept= ruleConcept EOF
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
    // InternalOML.g:1953:1: ruleConcept returns [EObject current=null] : (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1959:2: ( (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1960:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1960:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1961:3: otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptAccess().getConceptKeyword_0());
            		
            // InternalOML.g:1965:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1966:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1966:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1967:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConceptAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // InternalOML.g:1987:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:1987:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:1988:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
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
    // InternalOML.g:1994:1: ruleReifiedRelationship returns [EObject current=null] : (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) ;
    public final EObject ruleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_isFunctional_4_0=null;
        Token lv_isInverseFunctional_5_0=null;
        Token lv_isEssential_6_0=null;
        Token lv_isInverseEssential_7_0=null;
        Token lv_isSymmetric_8_0=null;
        Token lv_isAsymmetric_9_0=null;
        Token lv_isReflexive_10_0=null;
        Token lv_isIrreflexive_11_0=null;
        Token lv_isTransitive_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_unreifiedPropertyName_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_unreifiedInversePropertyName_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;


        	enterRule();

        try {
            // InternalOML.g:2000:2: ( (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) )
            // InternalOML.g:2001:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            {
            // InternalOML.g:2001:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            // InternalOML.g:2002:3: otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0());
            		
            // InternalOML.g:2006:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2007:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2007:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2008:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getReifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:2028:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2029:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2029:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2030:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:2033:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2034:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2034:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop24:
            do {
                int alt24=10;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // InternalOML.g:2035:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2035:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2036:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:2036:116: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:2037:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:2040:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:2040:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2040:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:2040:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:2040:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:2041:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,39,FOLLOW_24); 

            	    										newLeafNode(lv_isFunctional_4_0, grammarAccess.getReifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isFunctional", true, "functional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:2058:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2058:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2059:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:2059:116: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2060:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:2063:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2063:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2063:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2063:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2063:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:2064:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,40,FOLLOW_24); 

            	    										newLeafNode(lv_isInverseFunctional_5_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseFunctional", true, "inverseFunctional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:2081:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2081:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2082:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:2082:116: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:2083:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:2086:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:2086:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2086:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:2086:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:2086:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:2087:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,41,FOLLOW_24); 

            	    										newLeafNode(lv_isEssential_6_0, grammarAccess.getReifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isEssential", true, "essential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:2104:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2104:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2105:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:2105:116: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2106:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:2109:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2109:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2109:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:2109:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2109:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:2110:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,42,FOLLOW_24); 

            	    										newLeafNode(lv_isInverseEssential_7_0, grammarAccess.getReifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseEssential", true, "inverseEssential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:2127:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2127:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2128:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:2128:116: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2129:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:2132:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:2132:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2132:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:2132:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2132:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:2133:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,43,FOLLOW_24); 

            	    										newLeafNode(lv_isSymmetric_8_0, grammarAccess.getReifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isSymmetric", true, "symmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:2150:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2150:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2151:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:2151:116: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2152:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:2155:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2155:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2155:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:2155:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2155:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:2156:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,44,FOLLOW_24); 

            	    										newLeafNode(lv_isAsymmetric_9_0, grammarAccess.getReifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isAsymmetric", true, "asymmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:2173:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2173:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2174:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:2174:116: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2175:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:2178:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:2178:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2178:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:2178:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2178:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:2179:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,45,FOLLOW_24); 

            	    										newLeafNode(lv_isReflexive_10_0, grammarAccess.getReifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isReflexive", true, "reflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:2196:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2196:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2197:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:2197:116: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2198:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:2201:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2201:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2201:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:2201:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2201:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:2202:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,46,FOLLOW_24); 

            	    										newLeafNode(lv_isIrreflexive_11_0, grammarAccess.getReifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isIrreflexive", true, "irreflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:2219:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2219:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2220:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:2220:116: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2221:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:2224:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:2224:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2224:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:2224:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:2224:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:2225:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,47,FOLLOW_24); 

            	    										newLeafNode(lv_isTransitive_12_0, grammarAccess.getReifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isTransitive", true, "transitive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            				

            }

            otherlv_13=(Token)match(input,48,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4());
            		
            otherlv_14=(Token)match(input,21,FOLLOW_23); 

            			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2257:3: ( (lv_unreifiedPropertyName_15_0= RULE_ID ) )
            // InternalOML.g:2258:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            {
            // InternalOML.g:2258:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            // InternalOML.g:2259:5: lv_unreifiedPropertyName_15_0= RULE_ID
            {
            lv_unreifiedPropertyName_15_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(lv_unreifiedPropertyName_15_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedPropertyNameIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unreifiedPropertyName",
            						lv_unreifiedPropertyName_15_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            // InternalOML.g:2275:3: (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==49) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOML.g:2276:4: otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,49,FOLLOW_5); 

                    				newLeafNode(otherlv_16, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0());
                    			
                    otherlv_17=(Token)match(input,21,FOLLOW_23); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalOML.g:2284:4: ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    // InternalOML.g:2285:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    {
                    // InternalOML.g:2285:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    // InternalOML.g:2286:6: lv_unreifiedInversePropertyName_18_0= RULE_ID
                    {
                    lv_unreifiedInversePropertyName_18_0=(Token)match(input,RULE_ID,FOLLOW_26); 

                    						newLeafNode(lv_unreifiedInversePropertyName_18_0, grammarAccess.getReifiedRelationshipAccess().getUnreifiedInversePropertyNameIDTerminalRuleCall_7_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getReifiedRelationshipRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unreifiedInversePropertyName",
                    							lv_unreifiedInversePropertyName_18_0,
                    							"gov.nasa.jpl.imce.oml.dsl.OML.ID");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,50,FOLLOW_5); 

            			newLeafNode(otherlv_19, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_8());
            		
            otherlv_20=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9());
            		
            // InternalOML.g:2311:3: ( ( ruleReference ) )
            // InternalOML.g:2312:4: ( ruleReference )
            {
            // InternalOML.g:2312:4: ( ruleReference )
            // InternalOML.g:2313:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_10_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_22=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_22, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11());
            		
            otherlv_23=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12());
            		
            // InternalOML.g:2335:3: ( ( ruleReference ) )
            // InternalOML.g:2336:4: ( ruleReference )
            {
            // InternalOML.g:2336:4: ( ruleReference )
            // InternalOML.g:2337:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_13_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_25=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getReifiedRelationshipAccess().getRightCurlyBracketKeyword_14());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:2359:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:2359:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2360:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
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
    // InternalOML.g:2366:1: ruleUnreifiedRelationship returns [EObject current=null] : (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) ;
    public final EObject ruleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_isFunctional_4_0=null;
        Token lv_isInverseFunctional_5_0=null;
        Token lv_isEssential_6_0=null;
        Token lv_isInverseEssential_7_0=null;
        Token lv_isSymmetric_8_0=null;
        Token lv_isAsymmetric_9_0=null;
        Token lv_isReflexive_10_0=null;
        Token lv_isIrreflexive_11_0=null;
        Token lv_isTransitive_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;


        	enterRule();

        try {
            // InternalOML.g:2372:2: ( (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) )
            // InternalOML.g:2373:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            {
            // InternalOML.g:2373:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            // InternalOML.g:2374:3: otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0());
            		
            // InternalOML.g:2378:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2379:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2379:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2380:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUnreifiedRelationshipAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:2400:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2401:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2401:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2402:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:2405:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2406:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2406:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop26:
            do {
                int alt26=10;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalOML.g:2407:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2407:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2408:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:2408:118: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:2409:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:2412:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:2412:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2412:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:2412:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:2412:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:2413:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,39,FOLLOW_28); 

            	    										newLeafNode(lv_isFunctional_4_0, grammarAccess.getUnreifiedRelationshipAccess().getIsFunctionalFunctionalKeyword_3_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isFunctional", true, "functional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:2430:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2430:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2431:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:2431:118: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2432:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:2435:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2435:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2435:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2435:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2435:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:2436:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,40,FOLLOW_28); 

            	    										newLeafNode(lv_isInverseFunctional_5_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseFunctionalInverseFunctionalKeyword_3_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseFunctional", true, "inverseFunctional");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:2453:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2453:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2454:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:2454:118: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:2455:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:2458:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:2458:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2458:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:2458:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:2458:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:2459:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,41,FOLLOW_28); 

            	    										newLeafNode(lv_isEssential_6_0, grammarAccess.getUnreifiedRelationshipAccess().getIsEssentialEssentialKeyword_3_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isEssential", true, "essential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:2476:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2476:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2477:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:2477:118: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2478:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:2481:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2481:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2481:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:2481:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2481:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:2482:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,42,FOLLOW_28); 

            	    										newLeafNode(lv_isInverseEssential_7_0, grammarAccess.getUnreifiedRelationshipAccess().getIsInverseEssentialInverseEssentialKeyword_3_3_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isInverseEssential", true, "inverseEssential");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:2499:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2499:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2500:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:2500:118: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2501:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:2504:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:2504:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2504:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:2504:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2504:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:2505:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,43,FOLLOW_28); 

            	    										newLeafNode(lv_isSymmetric_8_0, grammarAccess.getUnreifiedRelationshipAccess().getIsSymmetricSymmetricKeyword_3_4_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isSymmetric", true, "symmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalOML.g:2522:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2522:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2523:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:2523:118: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2524:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:2527:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2527:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2527:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:2527:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2527:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:2528:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,44,FOLLOW_28); 

            	    										newLeafNode(lv_isAsymmetric_9_0, grammarAccess.getUnreifiedRelationshipAccess().getIsAsymmetricAsymmetricKeyword_3_5_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isAsymmetric", true, "asymmetric");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalOML.g:2545:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2545:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2546:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:2546:118: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2547:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:2550:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:2550:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2550:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:2550:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2550:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:2551:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,45,FOLLOW_28); 

            	    										newLeafNode(lv_isReflexive_10_0, grammarAccess.getUnreifiedRelationshipAccess().getIsReflexiveReflexiveKeyword_3_6_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isReflexive", true, "reflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalOML.g:2568:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2568:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2569:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:2569:118: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2570:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:2573:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2573:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2573:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:2573:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2573:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:2574:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,46,FOLLOW_28); 

            	    										newLeafNode(lv_isIrreflexive_11_0, grammarAccess.getUnreifiedRelationshipAccess().getIsIrreflexiveIrreflexiveKeyword_3_7_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isIrreflexive", true, "irreflexive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalOML.g:2591:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2591:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2592:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:2592:118: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2593:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:2596:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:2596:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2596:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:2596:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:2596:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:2597:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,47,FOLLOW_28); 

            	    										newLeafNode(lv_isTransitive_12_0, grammarAccess.getUnreifiedRelationshipAccess().getIsTransitiveTransitiveKeyword_3_8_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            	    										}
            	    										setWithLastConsumed(current, "isTransitive", true, "transitive");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            				

            }

            otherlv_13=(Token)match(input,50,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4());
            		
            otherlv_14=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2629:3: ( ( ruleReference ) )
            // InternalOML.g:2630:4: ( ruleReference )
            {
            // InternalOML.g:2630:4: ( ruleReference )
            // InternalOML.g:2631:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_16, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7());
            		
            otherlv_17=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8());
            		
            // InternalOML.g:2653:3: ( ( ruleReference ) )
            // InternalOML.g:2654:4: ( ruleReference )
            {
            // InternalOML.g:2654:4: ( ruleReference )
            // InternalOML.g:2655:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_9_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_19, grammarAccess.getUnreifiedRelationshipAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:2677:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:2677:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:2678:2: iv_ruleScalar= ruleScalar EOF
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
    // InternalOML.g:2684:1: ruleScalar returns [EObject current=null] : (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2690:2: ( (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2691:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2691:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2692:3: otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarAccess().getScalarKeyword_0());
            		
            // InternalOML.g:2696:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2697:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2697:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2698:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // InternalOML.g:2718:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:2718:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:2719:2: iv_ruleStructure= ruleStructure EOF
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
    // InternalOML.g:2725:1: ruleStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2731:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2732:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2732:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2733:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStructureAccess().getStructureKeyword_0());
            		
            // InternalOML.g:2737:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2738:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2738:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2739:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStructureAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructureRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
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
    // InternalOML.g:2759:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:2759:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:2760:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
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
    // InternalOML.g:2766:1: ruleEntityStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
    public final EObject ruleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_isIdentityCriteria_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalOML.g:2772:2: ( (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2773:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2773:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2774:3: otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2778:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==56) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOML.g:2779:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2779:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2780:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,56,FOLLOW_23); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2792:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2793:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2793:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2794:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEntityStructuredDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,57,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2818:3: ( ( ruleReference ) )
            // InternalOML.g:2819:4: ( ruleReference )
            {
            // InternalOML.g:2819:4: ( ruleReference )
            // InternalOML.g:2820:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2838:3: ( ( ruleReference ) )
            // InternalOML.g:2839:4: ( ruleReference )
            {
            // InternalOML.g:2839:4: ( ruleReference )
            // InternalOML.g:2840:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEntityStructuredDataPropertyAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:2862:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:2862:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:2863:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
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
    // InternalOML.g:2869:1: ruleEntityScalarDataProperty returns [EObject current=null] : (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
    public final EObject ruleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_isIdentityCriteria_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalOML.g:2875:2: ( (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2876:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2876:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2877:3: otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:2881:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==56) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalOML.g:2882:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2882:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2883:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,56,FOLLOW_23); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2895:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2896:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2896:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2897:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEntityScalarDataPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,57,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2921:3: ( ( ruleReference ) )
            // InternalOML.g:2922:4: ( ruleReference )
            {
            // InternalOML.g:2922:4: ( ruleReference )
            // InternalOML.g:2923:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2941:3: ( ( ruleReference ) )
            // InternalOML.g:2942:4: ( ruleReference )
            {
            // InternalOML.g:2942:4: ( ruleReference )
            // InternalOML.g:2943:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEntityScalarDataPropertyAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:2965:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:2965:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:2966:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
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
    // InternalOML.g:2972:1: ruleStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
    public final EObject ruleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalOML.g:2978:2: ( (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:2979:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:2979:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:2980:3: otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2984:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2985:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2985:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2986:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStructuredDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,57,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:3010:3: ( ( ruleReference ) )
            // InternalOML.g:3011:4: ( ruleReference )
            {
            // InternalOML.g:3011:4: ( ruleReference )
            // InternalOML.g:3012:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:3030:3: ( ( ruleReference ) )
            // InternalOML.g:3031:4: ( ruleReference )
            {
            // InternalOML.g:3031:4: ( ruleReference )
            // InternalOML.g:3032:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getStructuredDataPropertyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:3054:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:3054:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:3055:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
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
    // InternalOML.g:3061:1: ruleScalarDataProperty returns [EObject current=null] : (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
    public final EObject ruleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalOML.g:3067:2: ( (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:3068:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:3068:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:3069:3: otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:3073:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3074:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3074:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3075:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarDataPropertyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,57,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:3099:3: ( ( ruleReference ) )
            // InternalOML.g:3100:4: ( ruleReference )
            {
            // InternalOML.g:3100:4: ( ruleReference )
            // InternalOML.g:3101:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:3119:3: ( ( ruleReference ) )
            // InternalOML.g:3120:4: ( ruleReference )
            {
            // InternalOML.g:3120:4: ( ruleReference )
            // InternalOML.g:3121:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getScalarDataPropertyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:3143:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:3143:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:3144:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
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
    // InternalOML.g:3150:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
    public final EObject ruleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_disjunctions_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3156:2: ( (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:3157:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:3157:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:3158:3: otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3166:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3167:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3167:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3168:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAnonymousConceptUnionAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,24,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:3192:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==62||LA29_0==66) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOML.g:3193:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3193:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3194:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_disjunctions_5_0=ruleDisjointUnionOfConceptsAxiom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAnonymousConceptUnionAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"disjunctions",
            	    						lv_disjunctions_5_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:3219:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:3219:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:3220:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
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
    // InternalOML.g:3226:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
    public final EObject ruleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_disjunctions_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3232:2: ( (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:3233:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:3233:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:3234:3: otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3242:3: ( ( ruleReference ) )
            // InternalOML.g:3243:4: ( ruleReference )
            {
            // InternalOML.g:3243:4: ( ruleReference )
            // InternalOML.g:3244:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_2_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,24,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:3266:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==62||LA30_0==66) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOML.g:3267:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3267:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3268:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_34);
            	    lv_disjunctions_5_0=ruleDisjointUnionOfConceptsAxiom();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRootConceptTaxonomyAxiomRule());
            	    					}
            	    					add(
            	    						current,
            	    						"disjunctions",
            	    						lv_disjunctions_5_0,
            	    						"gov.nasa.jpl.imce.oml.dsl.OML.DisjointUnionOfConceptsAxiom");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:3293:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:3293:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:3294:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
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
    // InternalOML.g:3300:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOML.g:3306:2: ( (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) )
            // InternalOML.g:3307:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            {
            // InternalOML.g:3307:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            // InternalOML.g:3308:3: otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3316:3: ( ( ruleReference ) )
            // InternalOML.g:3317:4: ( ruleReference )
            {
            // InternalOML.g:3317:4: ( ruleReference )
            // InternalOML.g:3318:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_2_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSpecificDisjointConceptAxiomAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:3340:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3340:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:3341:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3347:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3353:2: ( (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3354:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3354:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3355:3: otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0());
            		
            // InternalOML.g:3359:3: ( ( ruleReference ) )
            // InternalOML.g:3360:4: ( ruleReference )
            {
            // InternalOML.g:3360:4: ( ruleReference )
            // InternalOML.g:3361:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3379:3: ( ( ruleReference ) )
            // InternalOML.g:3380:4: ( ruleReference )
            {
            // InternalOML.g:3380:4: ( ruleReference )
            // InternalOML.g:3381:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_36);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3399:3: ( ( ruleReference ) )
            // InternalOML.g:3400:4: ( ruleReference )
            {
            // InternalOML.g:3400:4: ( ruleReference )
            // InternalOML.g:3401:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
            				
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
    // InternalOML.g:3419:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3419:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:3420:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3426:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3432:2: ( (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3433:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3433:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3434:3: otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0());
            		
            // InternalOML.g:3438:3: ( ( ruleReference ) )
            // InternalOML.g:3439:4: ( ruleReference )
            {
            // InternalOML.g:3439:4: ( ruleReference )
            // InternalOML.g:3440:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3458:3: ( ( ruleReference ) )
            // InternalOML.g:3459:4: ( ruleReference )
            {
            // InternalOML.g:3459:4: ( ruleReference )
            // InternalOML.g:3460:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_36);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3478:3: ( ( ruleReference ) )
            // InternalOML.g:3479:4: ( ruleReference )
            {
            // InternalOML.g:3479:4: ( ruleReference )
            // InternalOML.g:3480:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRangeEntityCrossReference_5_0());
            				
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
    // InternalOML.g:3498:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:3498:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:3499:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
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
    // InternalOML.g:3505:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3511:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:3512:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3512:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:3513:3: ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:3513:3: ( ( ruleReference ) )
            // InternalOML.g:3514:4: ( ruleReference )
            {
            // InternalOML.g:3514:4: ( ruleReference )
            // InternalOML.g:3515:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0());
            				
            pushFollow(FOLLOW_37);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,71,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1());
            		
            // InternalOML.g:3533:3: ( ( ruleReference ) )
            // InternalOML.g:3534:4: ( ruleReference )
            {
            // InternalOML.g:3534:4: ( ruleReference )
            // InternalOML.g:3535:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSuperAspectAspectCrossReference_2_0());
            				
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
    // InternalOML.g:3553:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:3553:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:3554:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
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
    // InternalOML.g:3560:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3566:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:3567:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3567:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:3568:3: ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:3568:3: ( ( ruleReference ) )
            // InternalOML.g:3569:4: ( ruleReference )
            {
            // InternalOML.g:3569:4: ( ruleReference )
            // InternalOML.g:3570:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_0_0());
            				
            pushFollow(FOLLOW_38);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1());
            		
            // InternalOML.g:3588:3: ( ( ruleReference ) )
            // InternalOML.g:3589:4: ( ruleReference )
            {
            // InternalOML.g:3589:4: ( ruleReference )
            // InternalOML.g:3590:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSuperConceptConceptCrossReference_2_0());
            				
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
    // InternalOML.g:3608:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:3608:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:3609:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
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
    // InternalOML.g:3615:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3621:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:3622:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3622:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:3623:3: ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:3623:3: ( ( ruleReference ) )
            // InternalOML.g:3624:4: ( ruleReference )
            {
            // InternalOML.g:3624:4: ( ruleReference )
            // InternalOML.g:3625:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_0_0());
            				
            pushFollow(FOLLOW_39);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,73,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1());
            		
            // InternalOML.g:3643:3: ( ( ruleReference ) )
            // InternalOML.g:3644:4: ( ruleReference )
            {
            // InternalOML.g:3644:4: ( ruleReference )
            // InternalOML.g:3645:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSuperRelationshipReifiedRelationshipCrossReference_2_0());
            				
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
    // InternalOML.g:3663:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3663:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:3664:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3670:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3676:2: ( (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3677:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3677:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3678:3: otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0());
            		
            // InternalOML.g:3682:3: ( ( ruleReference ) )
            // InternalOML.g:3683:4: ( ruleReference )
            {
            // InternalOML.g:3683:4: ( ruleReference )
            // InternalOML.g:3684:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3702:3: ( ( ruleReference ) )
            // InternalOML.g:3703:4: ( ruleReference )
            {
            // InternalOML.g:3703:4: ( ruleReference )
            // InternalOML.g:3704:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_36);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3722:3: ( ( ruleReference ) )
            // InternalOML.g:3723:4: ( ruleReference )
            {
            // InternalOML.g:3723:4: ( ruleReference )
            // InternalOML.g:3724:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0());
            				
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
    // InternalOML.g:3742:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:3742:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:3743:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:3749:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= ruleValue ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_literalValue_5_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3755:2: ( (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= ruleValue ) ) ) )
            // InternalOML.g:3756:2: (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= ruleValue ) ) )
            {
            // InternalOML.g:3756:2: (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= ruleValue ) ) )
            // InternalOML.g:3757:3: otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= ruleValue ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0());
            		
            // InternalOML.g:3761:3: ( ( ruleReference ) )
            // InternalOML.g:3762:4: ( ruleReference )
            {
            // InternalOML.g:3762:4: ( ruleReference )
            // InternalOML.g:3763:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3781:3: ( ( ruleReference ) )
            // InternalOML.g:3782:4: ( ruleReference )
            {
            // InternalOML.g:3782:4: ( ruleReference )
            // InternalOML.g:3783:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_40); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:3801:3: ( (lv_literalValue_5_0= ruleValue ) )
            // InternalOML.g:3802:4: (lv_literalValue_5_0= ruleValue )
            {
            // InternalOML.g:3802:4: (lv_literalValue_5_0= ruleValue )
            // InternalOML.g:3803:5: lv_literalValue_5_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueValueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_literalValue_5_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            					set(
            						current,
            						"literalValue",
            						lv_literalValue_5_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
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
    // InternalOML.g:3824:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3824:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:3825:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3831:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3837:2: ( (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3838:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3838:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3839:3: otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0());
            		
            // InternalOML.g:3843:3: ( ( ruleReference ) )
            // InternalOML.g:3844:4: ( ruleReference )
            {
            // InternalOML.g:3844:4: ( ruleReference )
            // InternalOML.g:3845:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3863:3: ( ( ruleReference ) )
            // InternalOML.g:3864:4: ( ruleReference )
            {
            // InternalOML.g:3864:4: ( ruleReference )
            // InternalOML.g:3865:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_36);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3883:3: ( ( ruleReference ) )
            // InternalOML.g:3884:4: ( ruleReference )
            {
            // InternalOML.g:3884:4: ( ruleReference )
            // InternalOML.g:3885:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarRestrictionDataRangeCrossReference_5_0());
            				
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
    // InternalOML.g:3903:1: entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:3903:95: (iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:3904:2: iv_ruleEntityStructuredDataPropertyParticularRestrictionAxiom= ruleEntityStructuredDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:3910:1: ruleEntityStructuredDataPropertyParticularRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleEntityStructuredDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_structuredPropertyTuples_6_0 = null;

        EObject lv_scalarDataPropertyValues_7_0 = null;



        	enterRule();

        try {
            // InternalOML.g:3916:2: ( (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_8= '}' ) )
            // InternalOML.g:3917:2: (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            {
            // InternalOML.g:3917:2: (otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_8= '}' )
            // InternalOML.g:3918:3: otherlv_0= 'every' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= '=' otherlv_5= '{' ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEveryKeyword_0());
            		
            // InternalOML.g:3922:3: ( ( ruleReference ) )
            // InternalOML.g:3923:4: ( ruleReference )
            {
            // InternalOML.g:3923:4: ( ruleReference )
            // InternalOML.g:3924:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3942:3: ( ( ruleReference ) )
            // InternalOML.g:3943:4: ( ruleReference )
            {
            // InternalOML.g:3943:4: ( ruleReference )
            // InternalOML.g:3944:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredDataPropertyEntityStructuredDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4());
            		
            otherlv_5=(Token)match(input,24,FOLLOW_41); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalOML.g:3966:3: ( ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop31:
            do {
                int alt31=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==21) ) {
                        int LA31_5 = input.LA(3);

                        if ( (LA31_5==24) ) {
                            alt31=1;
                        }
                        else if ( (LA31_5==RULE_STRING||(LA31_5>=RULE_INT && LA31_5<=RULE_FLOAT)) ) {
                            alt31=2;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (LA31_3==21) ) {
                        int LA31_5 = input.LA(3);

                        if ( (LA31_5==24) ) {
                            alt31=1;
                        }
                        else if ( (LA31_5==RULE_STRING||(LA31_5>=RULE_INT && LA31_5<=RULE_FLOAT)) ) {
                            alt31=2;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (LA31_4==21) ) {
                        int LA31_5 = input.LA(3);

                        if ( (LA31_5==24) ) {
                            alt31=1;
                        }
                        else if ( (LA31_5==RULE_STRING||(LA31_5>=RULE_INT && LA31_5<=RULE_FLOAT)) ) {
                            alt31=2;
                        }


                    }


                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:3967:4: ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:3967:4: ( (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:3968:5: (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:3968:5: (lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:3969:6: lv_structuredPropertyTuples_6_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_structuredPropertyTuples_6_0=ruleRestrictionStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:3987:4: ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:3987:4: ( (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:3988:5: (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:3988:5: (lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:3989:6: lv_scalarDataPropertyValues_7_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_scalarDataPropertyValues_7_0=ruleRestrictionScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_7_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEntityStructuredDataPropertyParticularRestrictionAxiomAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:4015:1: entryRuleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:4015:79: (iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF )
            // InternalOML.g:4016:2: iv_ruleRestrictionStructuredDataPropertyTuple= ruleRestrictionStructuredDataPropertyTuple EOF
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
    // InternalOML.g:4022:1: ruleRestrictionStructuredDataPropertyTuple returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleRestrictionStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_structuredPropertyTuples_3_0 = null;

        EObject lv_scalarDataPropertyValues_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4028:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_5= '}' ) )
            // InternalOML.g:4029:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            {
            // InternalOML.g:4029:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            // InternalOML.g:4030:3: ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )* otherlv_5= '}'
            {
            // InternalOML.g:4030:3: ( ( ruleReference ) )
            // InternalOML.g:4031:4: ( ruleReference )
            {
            // InternalOML.g:4031:4: ( ruleReference )
            // InternalOML.g:4032:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredDataPropertyStructuredDataPropertyCrossReference_0_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4054:3: ( ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) ) )*
            loop32:
            do {
                int alt32=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==21) ) {
                        int LA32_5 = input.LA(3);

                        if ( (LA32_5==RULE_STRING||(LA32_5>=RULE_INT && LA32_5<=RULE_FLOAT)) ) {
                            alt32=2;
                        }
                        else if ( (LA32_5==24) ) {
                            alt32=1;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (LA32_3==21) ) {
                        int LA32_5 = input.LA(3);

                        if ( (LA32_5==RULE_STRING||(LA32_5>=RULE_INT && LA32_5<=RULE_FLOAT)) ) {
                            alt32=2;
                        }
                        else if ( (LA32_5==24) ) {
                            alt32=1;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (LA32_4==21) ) {
                        int LA32_5 = input.LA(3);

                        if ( (LA32_5==RULE_STRING||(LA32_5>=RULE_INT && LA32_5<=RULE_FLOAT)) ) {
                            alt32=2;
                        }
                        else if ( (LA32_5==24) ) {
                            alt32=1;
                        }


                    }


                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // InternalOML.g:4055:4: ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:4055:4: ( (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple ) )
            	    // InternalOML.g:4056:5: (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:4056:5: (lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple )
            	    // InternalOML.g:4057:6: lv_structuredPropertyTuples_3_0= ruleRestrictionStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesRestrictionStructuredDataPropertyTupleParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_structuredPropertyTuples_3_0=ruleRestrictionStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_3_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionStructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:4075:4: ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:4075:4: ( (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue ) )
            	    // InternalOML.g:4076:5: (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:4076:5: (lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue )
            	    // InternalOML.g:4077:6: lv_scalarDataPropertyValues_4_0= ruleRestrictionScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesRestrictionScalarDataPropertyValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_scalarDataPropertyValues_4_0=ruleRestrictionScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRestrictionStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.RestrictionScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRestrictionStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:4103:1: entryRuleRestrictionScalarDataPropertyValue returns [EObject current=null] : iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF ;
    public final EObject entryRuleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictionScalarDataPropertyValue = null;


        try {
            // InternalOML.g:4103:75: (iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF )
            // InternalOML.g:4104:2: iv_ruleRestrictionScalarDataPropertyValue= ruleRestrictionScalarDataPropertyValue EOF
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
    // InternalOML.g:4110:1: ruleRestrictionScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) ;
    public final EObject ruleRestrictionScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:4116:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) )
            // InternalOML.g:4117:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            {
            // InternalOML.g:4117:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            // InternalOML.g:4118:3: ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            {
            // InternalOML.g:4118:3: ( ( ruleReference ) )
            // InternalOML.g:4119:4: ( ruleReference )
            {
            // InternalOML.g:4119:4: ( ruleReference )
            // InternalOML.g:4120:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRestrictionScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarDataPropertyScalarDataPropertyCrossReference_0_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getRestrictionScalarDataPropertyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalOML.g:4138:3: ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            // InternalOML.g:4139:4: (lv_scalarPropertyValue_2_0= ruleValue )
            {
            // InternalOML.g:4139:4: (lv_scalarPropertyValue_2_0= ruleValue )
            // InternalOML.g:4140:5: lv_scalarPropertyValue_2_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getRestrictionScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_scalarPropertyValue_2_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRestrictionScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
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
    // InternalOML.g:4161:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:4161:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:4162:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
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
    // InternalOML.g:4168:1: ruleBinaryScalarRestriction returns [EObject current=null] : (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) ;
    public final EObject ruleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_length_5_0=null;
        Token otherlv_6=null;
        Token lv_minLength_7_0=null;
        Token otherlv_8=null;
        Token lv_maxLength_9_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;


        	enterRule();

        try {
            // InternalOML.g:4174:2: ( (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) )
            // InternalOML.g:4175:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            {
            // InternalOML.g:4175:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            // InternalOML.g:4176:3: otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4180:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4181:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4181:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4182:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getBinaryScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4202:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4203:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4203:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            // InternalOML.g:4204:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4207:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            // InternalOML.g:4208:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            {
            // InternalOML.g:4208:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            loop33:
            do {
                int alt33=4;
                int LA33_0 = input.LA(1);

                if ( LA33_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt33=1;
                }
                else if ( LA33_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt33=2;
                }
                else if ( LA33_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt33=3;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:4209:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4209:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4210:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4210:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4211:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4214:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4214:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4214:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4214:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_43); 

            	    									newLeafNode(otherlv_4, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4218:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4219:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4219:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4220:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_42); 

            	    											newLeafNode(lv_length_5_0, grammarAccess.getBinaryScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:4242:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4242:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4243:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4243:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4244:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4247:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4247:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4247:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4247:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_43); 

            	    									newLeafNode(otherlv_6, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4251:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4252:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4252:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4253:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_42); 

            	    											newLeafNode(lv_minLength_7_0, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:4275:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4275:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4276:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4276:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4277:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4280:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4280:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4280:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4280:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_43); 

            	    									newLeafNode(otherlv_8, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4284:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4285:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4285:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4286:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_42); 

            	    											newLeafNode(lv_maxLength_9_0, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_10=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_10, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4319:3: ( ( ruleReference ) )
            // InternalOML.g:4320:4: ( ruleReference )
            {
            // InternalOML.g:4320:4: ( ruleReference )
            // InternalOML.g:4321:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getBinaryScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:4343:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:4343:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:4344:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
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
    // InternalOML.g:4350:1: ruleIRIScalarRestriction returns [EObject current=null] : (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
    public final EObject ruleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_length_5_0=null;
        Token otherlv_6=null;
        Token lv_minLength_7_0=null;
        Token otherlv_8=null;
        Token lv_maxLength_9_0=null;
        Token otherlv_10=null;
        Token lv_pattern_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalOML.g:4356:2: ( (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4357:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4357:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4358:3: otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4362:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4363:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4363:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4364:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getIRIScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4384:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4385:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4385:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4386:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4389:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4390:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4390:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop34:
            do {
                int alt34=5;
                int LA34_0 = input.LA(1);

                if ( LA34_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt34=1;
                }
                else if ( LA34_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt34=2;
                }
                else if ( LA34_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt34=3;
                }
                else if ( LA34_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt34=4;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalOML.g:4391:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4391:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4392:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4392:117: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4393:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4396:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4396:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4396:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4396:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_43); 

            	    									newLeafNode(otherlv_4, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4400:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4401:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4401:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4402:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_length_5_0, grammarAccess.getIRIScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:4424:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4424:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4425:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4425:117: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4426:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4429:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4429:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4429:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4429:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_43); 

            	    									newLeafNode(otherlv_6, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4433:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4434:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4434:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4435:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_minLength_7_0, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:4457:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4457:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4458:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4458:117: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4459:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4462:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4462:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4462:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4462:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_43); 

            	    									newLeafNode(otherlv_8, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4466:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4467:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4467:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4468:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_maxLength_9_0, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:4490:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4490:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4491:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4491:117: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4492:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4495:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4495:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4495:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4495:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4499:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4500:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4500:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4501:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            	    											newLeafNode(lv_pattern_11_0, grammarAccess.getIRIScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_11_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

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

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4534:3: ( ( ruleReference ) )
            // InternalOML.g:4535:4: ( ruleReference )
            {
            // InternalOML.g:4535:4: ( ruleReference )
            // InternalOML.g:4536:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getIRIScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:4558:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:4558:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:4559:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
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
    // InternalOML.g:4565:1: ruleNumericScalarRestriction returns [EObject current=null] : (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
    public final EObject ruleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_minInclusive_5_0=null;
        Token otherlv_6=null;
        Token lv_maxInclusive_7_0=null;
        Token otherlv_8=null;
        Token lv_minExclusive_9_0=null;
        Token otherlv_10=null;
        Token lv_maxExclusive_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalOML.g:4571:2: ( (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4572:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4572:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4573:3: otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4577:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4578:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4578:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4579:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getNumericScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4599:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4600:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4600:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4601:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4604:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4605:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4605:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop35:
            do {
                int alt35=5;
                int LA35_0 = input.LA(1);

                if ( LA35_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt35=1;
                }
                else if ( LA35_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt35=2;
                }
                else if ( LA35_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt35=3;
                }
                else if ( LA35_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt35=4;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOML.g:4606:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4606:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4607:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4607:121: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4608:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4611:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4611:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4611:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:4611:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,85,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4615:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:4616:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4616:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:4617:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_minInclusive_5_0, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minInclusive",
            	    												lv_minInclusive_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:4639:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4639:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4640:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4640:121: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4641:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4644:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4644:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4644:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:4644:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4648:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:4649:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4649:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:4650:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_maxInclusive_7_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxInclusive",
            	    												lv_maxInclusive_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:4672:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4672:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4673:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4673:121: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4674:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4677:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4677:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4677:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:4677:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4681:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:4682:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4682:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:4683:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_minExclusive_9_0, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minExclusive",
            	    												lv_minExclusive_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:4705:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4705:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4706:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4706:121: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4707:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4710:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4710:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4710:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4710:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4714:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:4715:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4715:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:4716:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_maxExclusive_11_0, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxExclusive",
            	    												lv_maxExclusive_11_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4749:3: ( ( ruleReference ) )
            // InternalOML.g:4750:4: ( ruleReference )
            {
            // InternalOML.g:4750:4: ( ruleReference )
            // InternalOML.g:4751:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getNumericScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:4773:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:4773:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:4774:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
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
    // InternalOML.g:4780:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) ;
    public final EObject rulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_length_5_0=null;
        Token otherlv_6=null;
        Token lv_minLength_7_0=null;
        Token otherlv_8=null;
        Token lv_maxLength_9_0=null;
        Token otherlv_10=null;
        Token lv_pattern_11_0=null;
        Token otherlv_12=null;
        Token lv_langRange_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;


        	enterRule();

        try {
            // InternalOML.g:4786:2: ( (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) )
            // InternalOML.g:4787:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            {
            // InternalOML.g:4787:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            // InternalOML.g:4788:3: otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4792:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4793:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4793:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4794:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4814:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4815:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4815:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4816:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4819:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4820:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4820:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            loop36:
            do {
                int alt36=6;
                int LA36_0 = input.LA(1);

                if ( LA36_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt36=1;
                }
                else if ( LA36_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt36=2;
                }
                else if ( LA36_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt36=3;
                }
                else if ( LA36_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt36=4;
                }
                else if ( LA36_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
                    alt36=5;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:4821:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4821:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4822:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4822:126: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4823:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4826:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4826:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4826:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4826:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_43); 

            	    									newLeafNode(otherlv_4, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4830:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4831:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4831:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4832:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_46); 

            	    											newLeafNode(lv_length_5_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:4854:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4854:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4855:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4855:126: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4856:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4859:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4859:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4859:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4859:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_43); 

            	    									newLeafNode(otherlv_6, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4863:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4864:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4864:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4865:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_46); 

            	    											newLeafNode(lv_minLength_7_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:4887:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4887:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4888:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4888:126: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4889:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4892:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4892:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4892:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4892:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_43); 

            	    									newLeafNode(otherlv_8, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4896:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4897:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4897:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4898:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_46); 

            	    											newLeafNode(lv_maxLength_9_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:4920:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4920:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4921:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4921:126: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4922:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4925:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4925:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4925:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4925:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4929:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4930:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4930:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4931:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

            	    											newLeafNode(lv_pattern_11_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_11_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalOML.g:4953:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4953:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4954:5: {...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:4954:126: ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4955:6: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:4958:9: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4958:10: {...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4958:19: (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    // InternalOML.g:4958:20: otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) )
            	    {
            	    otherlv_12=(Token)match(input,90,FOLLOW_7); 

            	    									newLeafNode(otherlv_12, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0());
            	    								
            	    // InternalOML.g:4962:9: ( (lv_langRange_13_0= RULE_STRING ) )
            	    // InternalOML.g:4963:10: (lv_langRange_13_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4963:10: (lv_langRange_13_0= RULE_STRING )
            	    // InternalOML.g:4964:11: lv_langRange_13_0= RULE_STRING
            	    {
            	    lv_langRange_13_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

            	    											newLeafNode(lv_langRange_13_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeSTRINGTerminalRuleCall_3_4_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"langRange",
            	    												lv_langRange_13_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_14=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_14, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4997:3: ( ( ruleReference ) )
            // InternalOML.g:4998:4: ( ruleReference )
            {
            // InternalOML.g:4998:4: ( ruleReference )
            // InternalOML.g:4999:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5021:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:5021:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:5022:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
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
    // InternalOML.g:5028:1: ruleScalarOneOfRestriction returns [EObject current=null] : (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5034:2: ( (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:5035:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:5035:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:5036:3: otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0());
            		
            // InternalOML.g:5040:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5041:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5041:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5042:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getScalarOneOfRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:5066:3: ( ( ruleReference ) )
            // InternalOML.g:5067:4: ( ruleReference )
            {
            // InternalOML.g:5067:4: ( ruleReference )
            // InternalOML.g:5068:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getScalarOneOfRestrictionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5090:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:5090:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:5091:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
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
    // InternalOML.g:5097:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:5103:2: ( (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOML.g:5104:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOML.g:5104:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOML.g:5105:3: otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0());
            		
            // InternalOML.g:5109:3: ( ( ruleReference ) )
            // InternalOML.g:5110:4: ( ruleReference )
            {
            // InternalOML.g:5110:4: ( ruleReference )
            // InternalOML.g:5111:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfLiteralAxiomAccess().getAxiomScalarOneOfRestrictionCrossReference_1_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:5129:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOML.g:5130:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOML.g:5130:4: (lv_value_3_0= RULE_STRING )
            // InternalOML.g:5131:5: lv_value_3_0= RULE_STRING
            {
            lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_3_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getValueSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfLiteralAxiomRule());
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
    // $ANTLR end "ruleScalarOneOfLiteralAxiom"


    // $ANTLR start "entryRuleStringScalarRestriction"
    // InternalOML.g:5151:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:5151:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:5152:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
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
    // InternalOML.g:5158:1: ruleStringScalarRestriction returns [EObject current=null] : (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
    public final EObject ruleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_length_5_0=null;
        Token otherlv_6=null;
        Token lv_minLength_7_0=null;
        Token otherlv_8=null;
        Token lv_maxLength_9_0=null;
        Token otherlv_10=null;
        Token lv_pattern_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalOML.g:5164:2: ( (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:5165:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:5165:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:5166:3: otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0());
            		
            // InternalOML.g:5170:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5171:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5171:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5172:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStringScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5192:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5193:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5193:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:5194:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:5197:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:5198:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:5198:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop37:
            do {
                int alt37=5;
                int LA37_0 = input.LA(1);

                if ( LA37_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt37=1;
                }
                else if ( LA37_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt37=2;
                }
                else if ( LA37_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt37=3;
                }
                else if ( LA37_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt37=4;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalOML.g:5199:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5199:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:5200:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:5200:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:5201:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:5204:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:5204:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5204:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:5204:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_43); 

            	    									newLeafNode(otherlv_4, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:5208:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:5209:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:5209:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:5210:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_length_5_0, grammarAccess.getStringScalarRestrictionAccess().getLengthINTTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"length",
            	    												lv_length_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5232:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5232:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:5233:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:5233:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:5234:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:5237:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:5237:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5237:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:5237:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_43); 

            	    									newLeafNode(otherlv_6, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:5241:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:5242:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:5242:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:5243:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_minLength_7_0, grammarAccess.getStringScalarRestrictionAccess().getMinLengthINTTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minLength",
            	    												lv_minLength_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:5265:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5265:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:5266:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:5266:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:5267:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:5270:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:5270:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5270:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:5270:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_43); 

            	    									newLeafNode(otherlv_8, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:5274:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:5275:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:5275:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:5276:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            	    											newLeafNode(lv_maxLength_9_0, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthINTTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxLength",
            	    												lv_maxLength_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.INT");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:5298:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5298:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5299:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:5299:120: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5300:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:5303:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5303:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5303:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:5303:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:5307:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:5308:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5308:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:5309:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

            	    											newLeafNode(lv_pattern_11_0, grammarAccess.getStringScalarRestrictionAccess().getPatternSTRINGTerminalRuleCall_3_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"pattern",
            	    												lv_pattern_11_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

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

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5342:3: ( ( ruleReference ) )
            // InternalOML.g:5343:4: ( ruleReference )
            {
            // InternalOML.g:5343:4: ( ruleReference )
            // InternalOML.g:5344:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getStringScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5366:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:5366:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:5367:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
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
    // InternalOML.g:5373:1: ruleSynonymScalarRestriction returns [EObject current=null] : (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5379:2: ( (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:5380:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:5380:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:5381:3: otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0());
            		
            // InternalOML.g:5385:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5386:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5386:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5387:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSynonymScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:5411:3: ( ( ruleReference ) )
            // InternalOML.g:5412:4: ( ruleReference )
            {
            // InternalOML.g:5412:4: ( ruleReference )
            // InternalOML.g:5413:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSynonymScalarRestrictionAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5435:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:5435:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:5436:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
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
    // InternalOML.g:5442:1: ruleTimeScalarRestriction returns [EObject current=null] : (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
    public final EObject ruleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_minInclusive_5_0=null;
        Token otherlv_6=null;
        Token lv_maxInclusive_7_0=null;
        Token otherlv_8=null;
        Token lv_minExclusive_9_0=null;
        Token otherlv_10=null;
        Token lv_maxExclusive_11_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalOML.g:5448:2: ( (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:5449:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:5449:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:5450:3: otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0());
            		
            // InternalOML.g:5454:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5455:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5455:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5456:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimeScalarRestrictionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5476:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5477:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5477:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:5478:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:5481:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:5482:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:5482:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop38:
            do {
                int alt38=5;
                int LA38_0 = input.LA(1);

                if ( LA38_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt38=1;
                }
                else if ( LA38_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt38=2;
                }
                else if ( LA38_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt38=3;
                }
                else if ( LA38_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt38=4;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalOML.g:5483:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5483:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5484:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:5484:118: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5485:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:5488:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5488:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5488:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:5488:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,85,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:5492:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:5493:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5493:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:5494:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_minInclusive_5_0, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveSTRINGTerminalRuleCall_3_0_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minInclusive",
            	    												lv_minInclusive_5_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5516:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5516:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5517:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:5517:118: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5518:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:5521:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5521:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5521:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:5521:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:5525:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:5526:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5526:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:5527:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_maxInclusive_7_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveSTRINGTerminalRuleCall_3_1_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxInclusive",
            	    												lv_maxInclusive_7_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalOML.g:5549:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5549:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5550:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:5550:118: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5551:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:5554:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5554:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5554:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:5554:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:5558:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:5559:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5559:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:5560:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_minExclusive_9_0, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveSTRINGTerminalRuleCall_3_2_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"minExclusive",
            	    												lv_minExclusive_9_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalOML.g:5582:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5582:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5583:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:5583:118: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5584:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:5587:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5587:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5587:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:5587:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:5591:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:5592:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5592:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:5593:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

            	    											newLeafNode(lv_maxExclusive_11_0, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveSTRINGTerminalRuleCall_3_3_1_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"maxExclusive",
            	    												lv_maxExclusive_11_0,
            	    												"gov.nasa.jpl.imce.oml.dsl.OML.STRING");
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            	    					

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

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5626:3: ( ( ruleReference ) )
            // InternalOML.g:5627:4: ( ruleReference )
            {
            // InternalOML.g:5627:4: ( ruleReference )
            // InternalOML.g:5628:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getTimeScalarRestrictionAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5650:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:5650:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:5651:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
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
    // InternalOML.g:5657:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:5663:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:5664:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:5664:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==97) ) {
                alt39=1;
            }
            else if ( (LA39_0==99) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalOML.g:5665:3: this_ConceptInstance_0= ruleConceptInstance
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
                    // InternalOML.g:5674:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
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
    // InternalOML.g:5686:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:5686:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:5687:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
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
    // InternalOML.g:5693:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5699:2: ( (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5700:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5700:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5701:3: otherlv_0= 'extends' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0());
            		
            // InternalOML.g:5705:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5706:4: ( ruleExternalReference )
            {
            // InternalOML.g:5706:4: ( ruleExternalReference )
            // InternalOML.g:5707:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getClosedWorldDefinitionsTerminologyBoxCrossReference_1_0());
            				
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
    // InternalOML.g:5725:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:5725:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:5726:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
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
    // InternalOML.g:5732:1: ruleDescriptionBoxRefinement returns [EObject current=null] : (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5738:2: ( (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5739:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5739:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5740:3: otherlv_0= 'refines' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,96,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0());
            		
            // InternalOML.g:5744:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5745:4: ( ruleExternalReference )
            {
            // InternalOML.g:5745:4: ( ruleExternalReference )
            // InternalOML.g:5746:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxRefinementRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDescriptionBoxRefinementAccess().getRefinedDescriptionBoxDescriptionBoxCrossReference_1_0());
            				
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
    // InternalOML.g:5764:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5764:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:5765:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
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
    // InternalOML.g:5771:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5777:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) )
            // InternalOML.g:5778:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            {
            // InternalOML.g:5778:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            // InternalOML.g:5779:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            {
            // InternalOML.g:5779:3: ( ( ruleReference ) )
            // InternalOML.g:5780:4: ( ruleReference )
            {
            // InternalOML.g:5780:4: ( ruleReference )
            // InternalOML.g:5781:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5799:3: ( ( ruleReference ) )
            // InternalOML.g:5800:4: ( ruleReference )
            {
            // InternalOML.g:5800:4: ( ruleReference )
            // InternalOML.g:5801:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarDataPropertyEntityScalarDataPropertyCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_40); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:5819:3: ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            // InternalOML.g:5820:4: (lv_scalarPropertyValue_4_0= ruleValue )
            {
            // InternalOML.g:5820:4: (lv_scalarPropertyValue_4_0= ruleValue )
            // InternalOML.g:5821:5: lv_scalarPropertyValue_4_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_scalarPropertyValue_4_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_4_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
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
    // InternalOML.g:5842:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:5842:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:5843:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
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
    // InternalOML.g:5849:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_structuredPropertyTuples_5_0 = null;

        EObject lv_scalarDataPropertyValues_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5855:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) )
            // InternalOML.g:5856:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            {
            // InternalOML.g:5856:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            // InternalOML.g:5857:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}'
            {
            // InternalOML.g:5857:3: ( ( ruleReference ) )
            // InternalOML.g:5858:4: ( ruleReference )
            {
            // InternalOML.g:5858:4: ( ruleReference )
            // InternalOML.g:5859:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5877:3: ( ( ruleReference ) )
            // InternalOML.g:5878:4: ( ruleReference )
            {
            // InternalOML.g:5878:4: ( ruleReference )
            // InternalOML.g:5879:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_2_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            otherlv_4=(Token)match(input,24,FOLLOW_41); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:5901:3: ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )*
            loop40:
            do {
                int alt40=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA40_2 = input.LA(2);

                    if ( (LA40_2==21) ) {
                        int LA40_5 = input.LA(3);

                        if ( (LA40_5==RULE_STRING||(LA40_5>=RULE_INT && LA40_5<=RULE_FLOAT)) ) {
                            alt40=2;
                        }
                        else if ( (LA40_5==24) ) {
                            alt40=1;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA40_3 = input.LA(2);

                    if ( (LA40_3==21) ) {
                        int LA40_5 = input.LA(3);

                        if ( (LA40_5==RULE_STRING||(LA40_5>=RULE_INT && LA40_5<=RULE_FLOAT)) ) {
                            alt40=2;
                        }
                        else if ( (LA40_5==24) ) {
                            alt40=1;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA40_4 = input.LA(2);

                    if ( (LA40_4==21) ) {
                        int LA40_5 = input.LA(3);

                        if ( (LA40_5==RULE_STRING||(LA40_5>=RULE_INT && LA40_5<=RULE_FLOAT)) ) {
                            alt40=2;
                        }
                        else if ( (LA40_5==24) ) {
                            alt40=1;
                        }


                    }


                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // InternalOML.g:5902:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5902:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5903:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5903:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5904:6: lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_structuredPropertyTuples_5_0=ruleStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_5_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5922:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5922:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:5923:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5923:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:5924:6: lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_scalarDataPropertyValues_6_0=ruleScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_6_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:5950:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:5950:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:5951:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
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
    // InternalOML.g:5957:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_structuredPropertyTuples_3_0 = null;

        EObject lv_scalarDataPropertyValues_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5963:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) )
            // InternalOML.g:5964:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            {
            // InternalOML.g:5964:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            // InternalOML.g:5965:3: ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}'
            {
            // InternalOML.g:5965:3: ( ( ruleReference ) )
            // InternalOML.g:5966:4: ( ruleReference )
            {
            // InternalOML.g:5966:4: ( ruleReference )
            // InternalOML.g:5967:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredDataPropertyDataRelationshipToStructureCrossReference_0_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5989:3: ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )*
            loop41:
            do {
                int alt41=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA41_2 = input.LA(2);

                    if ( (LA41_2==21) ) {
                        int LA41_5 = input.LA(3);

                        if ( (LA41_5==24) ) {
                            alt41=1;
                        }
                        else if ( (LA41_5==RULE_STRING||(LA41_5>=RULE_INT && LA41_5<=RULE_FLOAT)) ) {
                            alt41=2;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA41_3 = input.LA(2);

                    if ( (LA41_3==21) ) {
                        int LA41_5 = input.LA(3);

                        if ( (LA41_5==24) ) {
                            alt41=1;
                        }
                        else if ( (LA41_5==RULE_STRING||(LA41_5>=RULE_INT && LA41_5<=RULE_FLOAT)) ) {
                            alt41=2;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA41_4 = input.LA(2);

                    if ( (LA41_4==21) ) {
                        int LA41_5 = input.LA(3);

                        if ( (LA41_5==24) ) {
                            alt41=1;
                        }
                        else if ( (LA41_5==RULE_STRING||(LA41_5>=RULE_INT && LA41_5<=RULE_FLOAT)) ) {
                            alt41=2;
                        }


                    }


                    }
                    break;

                }

                switch (alt41) {
            	case 1 :
            	    // InternalOML.g:5990:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5990:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5991:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5991:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5992:6: lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_structuredPropertyTuples_3_0=ruleStructuredDataPropertyTuple();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"structuredPropertyTuples",
            	    							lv_structuredPropertyTuples_3_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.StructuredDataPropertyTuple");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:6010:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:6010:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:6011:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:6011:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:6012:6: lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_scalarDataPropertyValues_4_0=ruleScalarDataPropertyValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getStructuredDataPropertyTupleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scalarDataPropertyValues",
            	    							lv_scalarDataPropertyValues_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.ScalarDataPropertyValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyTupleAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:6038:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:6038:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:6039:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
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
    // InternalOML.g:6045:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:6051:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) )
            // InternalOML.g:6052:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            {
            // InternalOML.g:6052:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            // InternalOML.g:6053:3: ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            {
            // InternalOML.g:6053:3: ( ( ruleReference ) )
            // InternalOML.g:6054:4: ( ruleReference )
            {
            // InternalOML.g:6054:4: ( ruleReference )
            // InternalOML.g:6055:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarDataPropertyDataRelationshipToScalarCrossReference_0_0());
            				
            pushFollow(FOLLOW_5);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalOML.g:6073:3: ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            // InternalOML.g:6074:4: (lv_scalarPropertyValue_2_0= ruleValue )
            {
            // InternalOML.g:6074:4: (lv_scalarPropertyValue_2_0= ruleValue )
            // InternalOML.g:6075:5: lv_scalarPropertyValue_2_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getScalarDataPropertyValueAccess().getScalarPropertyValueValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_scalarPropertyValue_2_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScalarDataPropertyValueRule());
            					}
            					set(
            						current,
            						"scalarPropertyValue",
            						lv_scalarPropertyValue_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.Value");
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
    // InternalOML.g:6096:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:6096:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:6097:2: iv_ruleConceptInstance= ruleConceptInstance EOF
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
    // InternalOML.g:6103:1: ruleConceptInstance returns [EObject current=null] : (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleConceptInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:6109:2: ( (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:6110:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:6110:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:6111:3: otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:6119:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6120:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6120:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6121:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_2_0, grammarAccess.getConceptInstanceAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,98,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getConceptInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:6141:3: ( ( ruleReference ) )
            // InternalOML.g:6142:4: ( ruleReference )
            {
            // InternalOML.g:6142:4: ( ruleReference )
            // InternalOML.g:6143:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_4_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,64,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getConceptInstanceAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:6165:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:6165:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:6166:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
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
    // InternalOML.g:6172:1: ruleReifiedRelationshipInstance returns [EObject current=null] : (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:6178:2: ( (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:6179:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:6179:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:6180:3: otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,99,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:6188:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:6189:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:6189:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:6190:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_48); 

            					newLeafNode(lv_name_2_0, grammarAccess.getReifiedRelationshipInstanceAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,98,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:6210:3: ( ( ruleReference ) )
            // InternalOML.g:6211:4: ( ruleReference )
            {
            // InternalOML.g:6211:4: ( ruleReference )
            // InternalOML.g:6212:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,64,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getReifiedRelationshipInstanceAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:6234:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:6234:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:6235:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
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
    // InternalOML.g:6241:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:6247:2: ( (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:6248:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:6248:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:6249:3: otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:6257:3: ( ( ruleReference ) )
            // InternalOML.g:6258:4: ( ruleReference )
            {
            // InternalOML.g:6258:4: ( ruleReference )
            // InternalOML.g:6259:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:6281:3: ( ( ruleReference ) )
            // InternalOML.g:6282:4: ( ruleReference )
            {
            // InternalOML.g:6282:4: ( ruleReference )
            // InternalOML.g:6283:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0());
            				
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
    // InternalOML.g:6301:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:6301:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:6302:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
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
    // InternalOML.g:6308:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:6314:2: ( (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:6315:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:6315:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:6316:3: otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:6324:3: ( ( ruleReference ) )
            // InternalOML.g:6325:4: ( ruleReference )
            {
            // InternalOML.g:6325:4: ( ruleReference )
            // InternalOML.g:6326:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:6348:3: ( ( ruleReference ) )
            // InternalOML.g:6349:4: ( ruleReference )
            {
            // InternalOML.g:6349:4: ( ruleReference )
            // InternalOML.g:6350:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeConceptualEntitySingletonInstanceCrossReference_5_0());
            				
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
    // InternalOML.g:6368:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:6368:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:6369:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
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
    // InternalOML.g:6375:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
    public final EObject ruleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalOML.g:6381:2: ( (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:6382:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:6382:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:6383:3: otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,52,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2());
            		
            // InternalOML.g:6395:3: ( ( ruleReference ) )
            // InternalOML.g:6396:4: ( ruleReference )
            {
            // InternalOML.g:6396:4: ( ruleReference )
            // InternalOML.g:6397:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_30);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,57,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4());
            		
            // InternalOML.g:6415:3: ( ( ruleReference ) )
            // InternalOML.g:6416:4: ( ruleReference )
            {
            // InternalOML.g:6416:4: ( ruleReference )
            // InternalOML.g:6417:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6());
            		
            // InternalOML.g:6435:3: ( ( ruleReference ) )
            // InternalOML.g:6436:4: ( ruleReference )
            {
            // InternalOML.g:6436:4: ( ruleReference )
            // InternalOML.g:6437:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_7_0());
            				
            pushFollow(FOLLOW_20);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:6459:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:6459:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:6460:2: iv_ruleReference= ruleReference EOF
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
    // InternalOML.g:6466:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6472:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:6473:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:6473:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_IRI) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_ABBREV_IRI||LA42_0==RULE_ID) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalOML.g:6474:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6482:3: this_QNAME_1= ruleQNAME
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
    // InternalOML.g:6496:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:6496:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:6497:2: iv_ruleExternalReference= ruleExternalReference EOF
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
    // InternalOML.g:6503:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:6509:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:6510:2: this_IRI_0= RULE_IRI
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
    // InternalOML.g:6520:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:6520:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:6521:2: iv_ruleQNAME= ruleQNAME EOF
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
    // InternalOML.g:6527:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6533:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:6534:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:6534:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ABBREV_IRI) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalOML.g:6535:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6543:3: this_ValidID_1= ruleValidID
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
    // InternalOML.g:6557:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:6557:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:6558:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOML.g:6564:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:6570:2: (this_ID_0= RULE_ID )
            // InternalOML.g:6571:2: this_ID_0= RULE_ID
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


    // $ANTLR start "entryRuleValue"
    // InternalOML.g:6581:1: entryRuleValue returns [String current=null] : iv_ruleValue= ruleValue EOF ;
    public final String entryRuleValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValue = null;


        try {
            // InternalOML.g:6581:45: (iv_ruleValue= ruleValue EOF )
            // InternalOML.g:6582:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalOML.g:6588:1: ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DECIMAL_0= RULE_DECIMAL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECIMAL_0=null;
        Token this_INT_1=null;
        Token this_STRING_2=null;
        Token this_UUID_3=null;
        Token this_HEX_4=null;
        Token this_FLOAT_5=null;


        	enterRule();

        try {
            // InternalOML.g:6594:2: ( (this_DECIMAL_0= RULE_DECIMAL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) )
            // InternalOML.g:6595:2: (this_DECIMAL_0= RULE_DECIMAL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            {
            // InternalOML.g:6595:2: (this_DECIMAL_0= RULE_DECIMAL | this_INT_1= RULE_INT | this_STRING_2= RULE_STRING | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            int alt44=6;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL:
                {
                alt44=1;
                }
                break;
            case RULE_INT:
                {
                alt44=2;
                }
                break;
            case RULE_STRING:
                {
                alt44=3;
                }
                break;
            case RULE_UUID:
                {
                alt44=4;
                }
                break;
            case RULE_HEX:
                {
                alt44=5;
                }
                break;
            case RULE_FLOAT:
                {
                alt44=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalOML.g:6596:3: this_DECIMAL_0= RULE_DECIMAL
                    {
                    this_DECIMAL_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    			current.merge(this_DECIMAL_0);
                    		

                    			newLeafNode(this_DECIMAL_0, grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6604:3: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_1);
                    		

                    			newLeafNode(this_INT_1, grammarAccess.getValueAccess().getINTTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:6612:3: this_STRING_2= RULE_STRING
                    {
                    this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_2);
                    		

                    			newLeafNode(this_STRING_2, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:6620:3: this_UUID_3= RULE_UUID
                    {
                    this_UUID_3=(Token)match(input,RULE_UUID,FOLLOW_2); 

                    			current.merge(this_UUID_3);
                    		

                    			newLeafNode(this_UUID_3, grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:6628:3: this_HEX_4= RULE_HEX
                    {
                    this_HEX_4=(Token)match(input,RULE_HEX,FOLLOW_2); 

                    			current.merge(this_HEX_4);
                    		

                    			newLeafNode(this_HEX_4, grammarAccess.getValueAccess().getHEXTerminalRuleCall_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:6636:3: this_FLOAT_5= RULE_FLOAT
                    {
                    this_FLOAT_5=(Token)match(input,RULE_FLOAT,FOLLOW_2); 

                    			current.merge(this_FLOAT_5);
                    		

                    			newLeafNode(this_FLOAT_5, grammarAccess.getValueAccess().getFLOATTerminalRuleCall_5());
                    		

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
    // $ANTLR end "ruleValue"


    // $ANTLR start "ruleTerminologyKind"
    // InternalOML.g:6647:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6653:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:6654:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:6654:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==101) ) {
                alt45=1;
            }
            else if ( (LA45_0==102) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalOML.g:6655:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:6655:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:6656:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6663:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:6663:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:6664:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); 

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
    // InternalOML.g:6674:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6680:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:6681:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:6681:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==103) ) {
                alt46=1;
            }
            else if ( (LA46_0==104) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalOML.g:6682:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:6682:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:6683:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6690:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:6690:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:6691:4: enumLiteral_1= 'partial'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

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
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\26\1\4\2\uffff\1\25\1\6\1\26";
    static final String dfa_3s = "\1\150\1\4\2\uffff\1\25\1\6\1\150";
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
    static final String dfa_8s = "\1\26\1\4\2\27\1\25\2\uffff\1\6\1\26";
    static final String dfa_9s = "\1\146\1\4\2\32\1\25\2\uffff\1\6\1\146";
    static final String dfa_10s = "\5\uffff\1\1\1\2\2\uffff";
    static final String dfa_11s = "\11\uffff}>";
    static final String[] dfa_12s = {
            "\1\1\116\uffff\1\2\1\3",
            "\1\4",
            "\1\6\2\uffff\1\5",
            "\1\6\2\uffff\1\5",
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
    static final String dfa_13s = "\24\uffff";
    static final String dfa_14s = "\1\4\11\uffff\3\104\1\4\3\25\1\6\2\uffff";
    static final String dfa_15s = "\1\144\11\uffff\3\104\1\7\3\25\1\30\2\uffff";
    static final String dfa_16s = "\1\uffff\1\13\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff\1\12\1\11";
    static final String dfa_17s = "\24\uffff}>";
    static final String[] dfa_18s = {
            "\1\13\1\12\1\uffff\1\14\16\uffff\1\2\2\uffff\1\1\6\uffff\1\3\30\uffff\1\7\1\10\45\uffff\1\4\1\5\1\uffff\1\6\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15",
            "\1\15",
            "\1\15",
            "\1\17\1\16\1\uffff\1\20",
            "\1\21",
            "\1\21",
            "\1\21",
            "\1\23\1\uffff\5\23\13\uffff\1\22",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 753:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_6_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_7_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_8_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_9_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_10_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_11_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_12_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_13_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_14_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*";
        }
    }
    static final String dfa_19s = "\17\uffff";
    static final String dfa_20s = "\1\4\2\uffff\1\4\2\uffff\3\104\1\4\3\25\1\6\1\uffff";
    static final String dfa_21s = "\1\134\2\uffff\1\7\2\uffff\3\104\1\7\3\25\1\30\1\uffff";
    static final String dfa_22s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\10\uffff\1\3";
    static final String dfa_23s = "\17\uffff}>";
    static final String[] dfa_24s = {
            "\2\5\1\uffff\1\5\73\uffff\1\1\2\uffff\1\1\3\uffff\1\2\1\3\1\2\17\uffff\1\4",
            "",
            "",
            "\1\7\1\6\1\uffff\1\10",
            "",
            "",
            "\1\11",
            "\1\11",
            "\1\11",
            "\1\13\1\12\1\uffff\1\14",
            "\1\15",
            "\1\15",
            "\1\15",
            "\1\2\1\uffff\5\2\13\uffff\1\16",
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "1619:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_EntityStructuredDataPropertyRestrictionAxiom_2= ruleEntityStructuredDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_3= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_4= ruleSpecializationAxiom )";
        }
    }
    static final String dfa_25s = "\13\uffff";
    static final String dfa_26s = "\1\47\12\uffff";
    static final String dfa_27s = "\1\60\12\uffff";
    static final String dfa_28s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_29s = "\1\0\12\uffff}>";
    static final String[] dfa_30s = {
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

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "()* loopback of 2034:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_0 = input.LA(1);

                         
                        int index24_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA24_0==48) ) {s = 1;}

                        else if ( LA24_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA24_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA24_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA24_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA24_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA24_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA24_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA24_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA24_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index24_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_31s = "\1\62\12\uffff";
    static final String[] dfa_32s = {
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
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_31;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "()* loopback of 2406:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA26_0==50) ) {s = 1;}

                        else if ( LA26_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA26_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA26_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA26_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA26_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA26_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA26_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA26_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA26_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000500002L,0x000001E000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L,0x0000006000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x38F00073224000B0L,0x00000000FA143C48L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x38F00073324000B0L,0x00000000FA143C4AL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008500000L,0x000001E000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x06000001024000B0L,0x0000001B00000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001FF8000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0004FF8000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0100000000000080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000002000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000001F40L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000020000B0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x000000000003C000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x00000000000BC000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000001E20000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x00000000040BC000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0010000000000000L});

}
