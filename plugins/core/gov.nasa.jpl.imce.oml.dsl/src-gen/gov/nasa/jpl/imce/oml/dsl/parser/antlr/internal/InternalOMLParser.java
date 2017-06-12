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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DECIMAL", "RULE_UUID", "RULE_HEX", "RULE_FLOAT", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'descriptionBox'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'anonymousConceptUnion'", "'('", "')'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'someData'", "'allData'", "','", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
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
    public static final int RULE_ANY_OTHER=20;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
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

                if ( (LA1_0==21) ) {
                    alt1=1;
                }
                else if ( (LA1_0==23||(LA1_0>=102 && LA1_0<=105)) ) {
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
            otherlv_0=(Token)match(input,21,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_6); 

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
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_7); 

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

                if ( (LA4_0==23) ) {
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

            otherlv_2=(Token)match(input,24,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:417:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) )*
            loop5:
            do {
                int alt5=4;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt5=1;
                    }
                    break;
                case 30:
                case 33:
                case 34:
                    {
                    alt5=2;
                    }
                    break;
                case RULE_ABBREV_IRI:
                case RULE_IRI:
                case RULE_ID:
                case 37:
                case 38:
                case 39:
                case 53:
                case 54:
                case 55:
                case 56:
                case 60:
                case 61:
                case 62:
                case 68:
                case 71:
                case 75:
                case 76:
                case 78:
                case 83:
                case 85:
                case 90:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
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

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

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

                if ( (LA6_0==23) ) {
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

            otherlv_2=(Token)match(input,27,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:565:3: ( ( (lv_annotations_5_0= ruleAnnotation ) ) | ( (lv_boxAxioms_6_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_7_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_8_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_9_0= ruleTerminologyBundleAxiom ) ) )*
            loop7:
            do {
                int alt7=6;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt7=1;
                    }
                    break;
                case 30:
                case 33:
                case 34:
                    {
                    alt7=2;
                    }
                    break;
                case RULE_ABBREV_IRI:
                case RULE_IRI:
                case RULE_ID:
                case 37:
                case 38:
                case 39:
                case 53:
                case 54:
                case 55:
                case 56:
                case 60:
                case 61:
                case 62:
                case 68:
                case 71:
                case 75:
                case 76:
                case 78:
                case 83:
                case 85:
                case 90:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                    {
                    alt7=3;
                    }
                    break;
                case 66:
                    {
                    alt7=4;
                    }
                    break;
                case 29:
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

            otherlv_10=(Token)match(input,26,FOLLOW_2); 

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

                if ( (LA8_0==23) ) {
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

            otherlv_2=(Token)match(input,28,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,25,FOLLOW_16); 

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

            otherlv_15=(Token)match(input,26,FOLLOW_2); 

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
            case 30:
                {
                alt10=1;
                }
                break;
            case 33:
                {
                alt10=2;
                }
                break;
            case 34:
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
            otherlv_0=(Token)match(input,29,FOLLOW_6); 

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
            otherlv_0=(Token)match(input,30,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,31,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,32,FOLLOW_19); 

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

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
            otherlv_0=(Token)match(input,33,FOLLOW_6); 

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
            otherlv_0=(Token)match(input,34,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,35,FOLLOW_6); 

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

            otherlv_4=(Token)match(input,36,FOLLOW_19); 

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

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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

            if ( ((LA11_0>=RULE_ABBREV_IRI && LA11_0<=RULE_IRI)||LA11_0==RULE_ID||LA11_0==68||LA11_0==71||(LA11_0>=75 && LA11_0<=76)||LA11_0==93) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=37 && LA11_0<=39)||(LA11_0>=53 && LA11_0<=56)||(LA11_0>=60 && LA11_0<=62)||LA11_0==78||LA11_0==83||LA11_0==85||LA11_0==90||LA11_0==92||(LA11_0>=94 && LA11_0<=96)) ) {
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
            case 37:
            case 38:
                {
                alt12=1;
                }
                break;
            case 39:
            case 53:
                {
                alt12=2;
                }
                break;
            case 54:
            case 55:
            case 78:
            case 83:
            case 85:
            case 90:
            case 92:
            case 94:
            case 95:
            case 96:
                {
                alt12=3;
                }
                break;
            case 56:
            case 60:
            case 61:
            case 62:
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

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            else if ( (LA13_0==38) ) {
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

            if ( (LA14_0==39) ) {
                alt14=1;
            }
            else if ( (LA14_0==53) ) {
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

            if ( (LA15_0==54||LA15_0==78||LA15_0==83||LA15_0==85||LA15_0==90||LA15_0==92||(LA15_0>=94 && LA15_0<=96)) ) {
                alt15=1;
            }
            else if ( (LA15_0==55) ) {
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

            if ( (LA16_0==54) ) {
                alt16=1;
            }
            else if ( (LA16_0==78||LA16_0==83||LA16_0==85||LA16_0==90||LA16_0==92||(LA16_0>=94 && LA16_0<=96)) ) {
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
            case 78:
                {
                alt17=1;
                }
                break;
            case 83:
                {
                alt17=2;
                }
                break;
            case 85:
                {
                alt17=3;
                }
                break;
            case 90:
                {
                alt17=4;
                }
                break;
            case 92:
                {
                alt17=5;
                }
                break;
            case 94:
                {
                alt17=6;
                }
                break;
            case 95:
                {
                alt17=7;
                }
                break;
            case 96:
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
            case 56:
                {
                alt18=1;
                }
                break;
            case 60:
                {
                alt18=2;
                }
                break;
            case 61:
                {
                alt18=3;
                }
                break;
            case 62:
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
    // InternalOML.g:1612:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_ScalarOneOfLiteralAxiom_2 = null;

        EObject this_SpecializationAxiom_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1618:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom ) )
            // InternalOML.g:1619:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom )
            {
            // InternalOML.g:1619:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 68:
            case 71:
                {
                alt19=1;
                }
                break;
            case 75:
            case 76:
                {
                alt19=2;
                }
                break;
            case 93:
                {
                alt19=3;
                }
                break;
            case RULE_ABBREV_IRI:
            case RULE_IRI:
            case RULE_ID:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

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
                    // InternalOML.g:1638:3: this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getScalarOneOfLiteralAxiomParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScalarOneOfLiteralAxiom_2=ruleScalarOneOfLiteralAxiom();

                    state._fsp--;


                    			current = this_ScalarOneOfLiteralAxiom_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:1647:3: this_SpecializationAxiom_3= ruleSpecializationAxiom
                    {

                    			newCompositeNode(grammarAccess.getTermAxiomAccess().getSpecializationAxiomParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecializationAxiom_3=ruleSpecializationAxiom();

                    state._fsp--;


                    			current = this_SpecializationAxiom_3;
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
    // InternalOML.g:1659:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1659:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1660:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
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
    // InternalOML.g:1666:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1672:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1673:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1673:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==68) ) {
                alt20=1;
            }
            else if ( (LA20_0==71) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalOML.g:1674:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
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
                    // InternalOML.g:1683:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
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
    // InternalOML.g:1695:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1695:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1696:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1702:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1708:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1709:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1709:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==75) ) {
                alt21=1;
            }
            else if ( (LA21_0==76) ) {
                switch ( input.LA(2) ) {
                case RULE_IRI:
                    {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==77) ) {
                        alt21=2;
                    }
                    else if ( (LA21_3==69) ) {
                        alt21=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA21_4 = input.LA(3);

                    if ( (LA21_4==77) ) {
                        alt21=2;
                    }
                    else if ( (LA21_4==69) ) {
                        alt21=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA21_5 = input.LA(3);

                    if ( (LA21_5==69) ) {
                        alt21=3;
                    }
                    else if ( (LA21_5==77) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalOML.g:1710:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
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
                    // InternalOML.g:1719:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
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
                    // InternalOML.g:1728:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
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


    // $ANTLR start "entryRuleSpecializationAxiom"
    // InternalOML.g:1740:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1740:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1741:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
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
    // InternalOML.g:1747:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1753:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1754:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1754:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_IRI:
                {
                switch ( input.LA(2) ) {
                case 73:
                    {
                    alt22=1;
                    }
                    break;
                case 72:
                    {
                    alt22=2;
                    }
                    break;
                case 74:
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
                case 73:
                    {
                    alt22=1;
                    }
                    break;
                case 72:
                    {
                    alt22=2;
                    }
                    break;
                case 74:
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
                case 74:
                    {
                    alt22=3;
                    }
                    break;
                case 73:
                    {
                    alt22=1;
                    }
                    break;
                case 72:
                    {
                    alt22=2;
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
                    // InternalOML.g:1755:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
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
                    // InternalOML.g:1764:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
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
                    // InternalOML.g:1773:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
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
    // InternalOML.g:1785:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1785:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1786:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
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
    // InternalOML.g:1792:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1798:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1799:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
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
    // InternalOML.g:1810:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1810:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1811:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
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
    // InternalOML.g:1817:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1823:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1824:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
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
    // InternalOML.g:1835:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1835:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1836:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
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
    // InternalOML.g:1842:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1848:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1849:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1849:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==63) ) {
                alt23=1;
            }
            else if ( (LA23_0==67) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalOML.g:1850:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
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
                    // InternalOML.g:1859:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
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
    // InternalOML.g:1871:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1871:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1872:2: iv_ruleAspect= ruleAspect EOF
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
    // InternalOML.g:1878:1: ruleAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1884:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1885:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1885:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1886:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
            		
            // InternalOML.g:1890:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1891:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1891:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1892:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:1912:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:1912:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:1913:2: iv_ruleConcept= ruleConcept EOF
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
    // InternalOML.g:1919:1: ruleConcept returns [EObject current=null] : (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1925:2: ( (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1926:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1926:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1927:3: otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptAccess().getConceptKeyword_0());
            		
            // InternalOML.g:1931:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1932:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1932:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1933:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:1953:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:1953:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:1954:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
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
    // InternalOML.g:1960:1: ruleReifiedRelationship returns [EObject current=null] : (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) ;
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
            // InternalOML.g:1966:2: ( (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) )
            // InternalOML.g:1967:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            {
            // InternalOML.g:1967:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            // InternalOML.g:1968:3: otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0());
            		
            // InternalOML.g:1972:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1973:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1973:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1974:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:1994:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:1995:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:1995:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:1996:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:1999:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2000:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2000:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop24:
            do {
                int alt24=10;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // InternalOML.g:2001:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2001:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2002:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:2002:116: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:2003:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:2006:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:2006:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2006:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:2006:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:2006:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:2007:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,40,FOLLOW_24); 

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
            	    // InternalOML.g:2024:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2024:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2025:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:2025:116: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2026:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:2029:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2029:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2029:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2029:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2029:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:2030:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,41,FOLLOW_24); 

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
            	    // InternalOML.g:2047:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2047:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2048:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:2048:116: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:2049:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:2052:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:2052:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2052:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:2052:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:2052:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:2053:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,42,FOLLOW_24); 

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
            	    // InternalOML.g:2070:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2070:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2071:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:2071:116: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2072:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:2075:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2075:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2075:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:2075:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2075:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:2076:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,43,FOLLOW_24); 

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
            	    // InternalOML.g:2093:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2093:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2094:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:2094:116: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2095:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:2098:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:2098:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2098:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:2098:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2098:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:2099:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,44,FOLLOW_24); 

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
            	    // InternalOML.g:2116:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2116:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2117:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:2117:116: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2118:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:2121:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2121:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2121:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:2121:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2121:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:2122:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,45,FOLLOW_24); 

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
            	    // InternalOML.g:2139:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2139:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2140:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:2140:116: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2141:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:2144:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:2144:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2144:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:2144:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2144:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:2145:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,46,FOLLOW_24); 

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
            	    // InternalOML.g:2162:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2162:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2163:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:2163:116: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2164:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:2167:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2167:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2167:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:2167:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2167:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:2168:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,47,FOLLOW_24); 

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
            	    // InternalOML.g:2185:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2185:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2186:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:2186:116: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2187:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:2190:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:2190:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2190:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:2190:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:2190:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:2191:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,48,FOLLOW_24); 

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

            otherlv_13=(Token)match(input,49,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4());
            		
            otherlv_14=(Token)match(input,22,FOLLOW_23); 

            			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2223:3: ( (lv_unreifiedPropertyName_15_0= RULE_ID ) )
            // InternalOML.g:2224:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            {
            // InternalOML.g:2224:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            // InternalOML.g:2225:5: lv_unreifiedPropertyName_15_0= RULE_ID
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

            // InternalOML.g:2241:3: (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==50) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOML.g:2242:4: otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,50,FOLLOW_5); 

                    				newLeafNode(otherlv_16, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0());
                    			
                    otherlv_17=(Token)match(input,22,FOLLOW_23); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalOML.g:2250:4: ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    // InternalOML.g:2251:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    {
                    // InternalOML.g:2251:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    // InternalOML.g:2252:6: lv_unreifiedInversePropertyName_18_0= RULE_ID
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

            otherlv_19=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_19, grammarAccess.getReifiedRelationshipAccess().getSourceKeyword_8());
            		
            otherlv_20=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9());
            		
            // InternalOML.g:2277:3: ( ( ruleReference ) )
            // InternalOML.g:2278:4: ( ruleReference )
            {
            // InternalOML.g:2278:4: ( ruleReference )
            // InternalOML.g:2279:5: ruleReference
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

            otherlv_22=(Token)match(input,52,FOLLOW_5); 

            			newLeafNode(otherlv_22, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11());
            		
            otherlv_23=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12());
            		
            // InternalOML.g:2301:3: ( ( ruleReference ) )
            // InternalOML.g:2302:4: ( ruleReference )
            {
            // InternalOML.g:2302:4: ( ruleReference )
            // InternalOML.g:2303:5: ruleReference
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

            otherlv_25=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:2325:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:2325:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2326:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
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
    // InternalOML.g:2332:1: ruleUnreifiedRelationship returns [EObject current=null] : (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) ;
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
            // InternalOML.g:2338:2: ( (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) )
            // InternalOML.g:2339:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            {
            // InternalOML.g:2339:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            // InternalOML.g:2340:3: otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0());
            		
            // InternalOML.g:2344:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2345:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2345:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2346:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_28); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:2366:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2367:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2367:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2368:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:2371:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2372:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2372:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop26:
            do {
                int alt26=10;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // InternalOML.g:2373:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2373:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2374:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:2374:118: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:2375:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:2378:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:2378:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2378:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:2378:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:2378:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:2379:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,40,FOLLOW_28); 

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
            	    // InternalOML.g:2396:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2396:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2397:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:2397:118: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2398:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:2401:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2401:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2401:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2401:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2401:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:2402:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,41,FOLLOW_28); 

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
            	    // InternalOML.g:2419:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2419:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2420:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:2420:118: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:2421:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:2424:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:2424:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2424:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:2424:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:2424:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:2425:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,42,FOLLOW_28); 

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
            	    // InternalOML.g:2442:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2442:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2443:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:2443:118: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2444:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:2447:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2447:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2447:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:2447:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2447:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:2448:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,43,FOLLOW_28); 

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
            	    // InternalOML.g:2465:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2465:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2466:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:2466:118: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2467:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:2470:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:2470:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2470:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:2470:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2470:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:2471:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,44,FOLLOW_28); 

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
            	    // InternalOML.g:2488:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2488:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2489:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:2489:118: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2490:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:2493:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2493:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2493:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:2493:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2493:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:2494:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,45,FOLLOW_28); 

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
            	    // InternalOML.g:2511:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2511:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2512:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:2512:118: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2513:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:2516:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:2516:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2516:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:2516:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2516:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:2517:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,46,FOLLOW_28); 

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
            	    // InternalOML.g:2534:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2534:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2535:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:2535:118: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2536:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:2539:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2539:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2539:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:2539:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2539:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:2540:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,47,FOLLOW_28); 

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
            	    // InternalOML.g:2557:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2557:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2558:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:2558:118: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2559:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:2562:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:2562:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2562:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:2562:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:2562:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:2563:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,48,FOLLOW_28); 

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

            otherlv_13=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4());
            		
            otherlv_14=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2595:3: ( ( ruleReference ) )
            // InternalOML.g:2596:4: ( ruleReference )
            {
            // InternalOML.g:2596:4: ( ruleReference )
            // InternalOML.g:2597:5: ruleReference
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

            otherlv_16=(Token)match(input,52,FOLLOW_5); 

            			newLeafNode(otherlv_16, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7());
            		
            otherlv_17=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8());
            		
            // InternalOML.g:2619:3: ( ( ruleReference ) )
            // InternalOML.g:2620:4: ( ruleReference )
            {
            // InternalOML.g:2620:4: ( ruleReference )
            // InternalOML.g:2621:5: ruleReference
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

            otherlv_19=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:2643:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:2643:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:2644:2: iv_ruleScalar= ruleScalar EOF
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
    // InternalOML.g:2650:1: ruleScalar returns [EObject current=null] : (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2656:2: ( (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2657:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2657:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2658:3: otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarAccess().getScalarKeyword_0());
            		
            // InternalOML.g:2662:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2663:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2663:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2664:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:2684:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:2684:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:2685:2: iv_ruleStructure= ruleStructure EOF
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
    // InternalOML.g:2691:1: ruleStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2697:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2698:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2698:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2699:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStructureAccess().getStructureKeyword_0());
            		
            // InternalOML.g:2703:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2704:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2704:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2705:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:2725:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:2725:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:2726:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
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
    // InternalOML.g:2732:1: ruleEntityStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:2738:2: ( (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2739:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2739:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2740:3: otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2744:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==57) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalOML.g:2745:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2745:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2746:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,57,FOLLOW_23); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2758:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2759:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2759:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2760:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2784:3: ( ( ruleReference ) )
            // InternalOML.g:2785:4: ( ruleReference )
            {
            // InternalOML.g:2785:4: ( ruleReference )
            // InternalOML.g:2786:5: ruleReference
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

            otherlv_6=(Token)match(input,59,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2804:3: ( ( ruleReference ) )
            // InternalOML.g:2805:4: ( ruleReference )
            {
            // InternalOML.g:2805:4: ( ruleReference )
            // InternalOML.g:2806:5: ruleReference
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

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:2828:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:2828:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:2829:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
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
    // InternalOML.g:2835:1: ruleEntityScalarDataProperty returns [EObject current=null] : (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:2841:2: ( (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2842:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2842:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2843:3: otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:2847:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==57) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalOML.g:2848:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2848:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2849:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,57,FOLLOW_23); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2861:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2862:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2862:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2863:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2887:3: ( ( ruleReference ) )
            // InternalOML.g:2888:4: ( ruleReference )
            {
            // InternalOML.g:2888:4: ( ruleReference )
            // InternalOML.g:2889:5: ruleReference
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

            otherlv_6=(Token)match(input,59,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2907:3: ( ( ruleReference ) )
            // InternalOML.g:2908:4: ( ruleReference )
            {
            // InternalOML.g:2908:4: ( ruleReference )
            // InternalOML.g:2909:5: ruleReference
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

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:2931:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:2931:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:2932:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
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
    // InternalOML.g:2938:1: ruleStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:2944:2: ( (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:2945:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:2945:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:2946:3: otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2950:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2951:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2951:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2952:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:2976:3: ( ( ruleReference ) )
            // InternalOML.g:2977:4: ( ruleReference )
            {
            // InternalOML.g:2977:4: ( ruleReference )
            // InternalOML.g:2978:5: ruleReference
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

            otherlv_5=(Token)match(input,59,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:2996:3: ( ( ruleReference ) )
            // InternalOML.g:2997:4: ( ruleReference )
            {
            // InternalOML.g:2997:4: ( ruleReference )
            // InternalOML.g:2998:5: ruleReference
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

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:3020:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:3020:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:3021:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
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
    // InternalOML.g:3027:1: ruleScalarDataProperty returns [EObject current=null] : (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:3033:2: ( (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:3034:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:3034:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:3035:3: otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:3039:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3040:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3040:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3041:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:3065:3: ( ( ruleReference ) )
            // InternalOML.g:3066:4: ( ruleReference )
            {
            // InternalOML.g:3066:4: ( ruleReference )
            // InternalOML.g:3067:5: ruleReference
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

            otherlv_5=(Token)match(input,59,FOLLOW_19); 

            			newLeafNode(otherlv_5, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:3085:3: ( ( ruleReference ) )
            // InternalOML.g:3086:4: ( ruleReference )
            {
            // InternalOML.g:3086:4: ( ruleReference )
            // InternalOML.g:3087:5: ruleReference
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

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:3109:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:3109:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:3110:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
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
    // InternalOML.g:3116:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:3122:2: ( (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:3123:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:3123:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:3124:3: otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3132:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:3133:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:3133:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:3134:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,65,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:3158:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==63||LA29_0==67) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOML.g:3159:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3159:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3160:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
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

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:3185:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:3185:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:3186:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
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
    // InternalOML.g:3192:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:3198:2: ( (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:3199:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:3199:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:3200:3: otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3208:3: ( ( ruleReference ) )
            // InternalOML.g:3209:4: ( ruleReference )
            {
            // InternalOML.g:3209:4: ( ruleReference )
            // InternalOML.g:3210:5: ruleReference
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

            otherlv_3=(Token)match(input,65,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_34); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:3232:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==63||LA30_0==67) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOML.g:3233:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:3233:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:3234:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
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

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:3259:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:3259:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:3260:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
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
    // InternalOML.g:3266:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOML.g:3272:2: ( (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) )
            // InternalOML.g:3273:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            {
            // InternalOML.g:3273:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            // InternalOML.g:3274:3: otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:3282:3: ( ( ruleReference ) )
            // InternalOML.g:3283:4: ( ruleReference )
            {
            // InternalOML.g:3283:4: ( ruleReference )
            // InternalOML.g:3284:5: ruleReference
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

            otherlv_3=(Token)match(input,65,FOLLOW_2); 

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
    // InternalOML.g:3306:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3306:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:3307:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3313:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3319:2: ( (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3320:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3320:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3321:3: otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,68,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0());
            		
            // InternalOML.g:3325:3: ( ( ruleReference ) )
            // InternalOML.g:3326:4: ( ruleReference )
            {
            // InternalOML.g:3326:4: ( ruleReference )
            // InternalOML.g:3327:5: ruleReference
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

            otherlv_2=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3345:3: ( ( ruleReference ) )
            // InternalOML.g:3346:4: ( ruleReference )
            {
            // InternalOML.g:3346:4: ( ruleReference )
            // InternalOML.g:3347:5: ruleReference
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

            otherlv_4=(Token)match(input,70,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3365:3: ( ( ruleReference ) )
            // InternalOML.g:3366:4: ( ruleReference )
            {
            // InternalOML.g:3366:4: ( ruleReference )
            // InternalOML.g:3367:5: ruleReference
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
    // InternalOML.g:3385:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3385:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:3386:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3392:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3398:2: ( (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3399:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3399:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3400:3: otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0());
            		
            // InternalOML.g:3404:3: ( ( ruleReference ) )
            // InternalOML.g:3405:4: ( ruleReference )
            {
            // InternalOML.g:3405:4: ( ruleReference )
            // InternalOML.g:3406:5: ruleReference
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

            otherlv_2=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3424:3: ( ( ruleReference ) )
            // InternalOML.g:3425:4: ( ruleReference )
            {
            // InternalOML.g:3425:4: ( ruleReference )
            // InternalOML.g:3426:5: ruleReference
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

            otherlv_4=(Token)match(input,70,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3444:3: ( ( ruleReference ) )
            // InternalOML.g:3445:4: ( ruleReference )
            {
            // InternalOML.g:3445:4: ( ruleReference )
            // InternalOML.g:3446:5: ruleReference
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
    // InternalOML.g:3464:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:3464:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:3465:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
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
    // InternalOML.g:3471:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3477:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:3478:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3478:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:3479:3: ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:3479:3: ( ( ruleReference ) )
            // InternalOML.g:3480:4: ( ruleReference )
            {
            // InternalOML.g:3480:4: ( ruleReference )
            // InternalOML.g:3481:5: ruleReference
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

            otherlv_1=(Token)match(input,72,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1());
            		
            // InternalOML.g:3499:3: ( ( ruleReference ) )
            // InternalOML.g:3500:4: ( ruleReference )
            {
            // InternalOML.g:3500:4: ( ruleReference )
            // InternalOML.g:3501:5: ruleReference
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
    // InternalOML.g:3519:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:3519:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:3520:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
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
    // InternalOML.g:3526:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3532:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:3533:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3533:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:3534:3: ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:3534:3: ( ( ruleReference ) )
            // InternalOML.g:3535:4: ( ruleReference )
            {
            // InternalOML.g:3535:4: ( ruleReference )
            // InternalOML.g:3536:5: ruleReference
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

            otherlv_1=(Token)match(input,73,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1());
            		
            // InternalOML.g:3554:3: ( ( ruleReference ) )
            // InternalOML.g:3555:4: ( ruleReference )
            {
            // InternalOML.g:3555:4: ( ruleReference )
            // InternalOML.g:3556:5: ruleReference
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
    // InternalOML.g:3574:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:3574:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:3575:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
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
    // InternalOML.g:3581:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3587:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:3588:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3588:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:3589:3: ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:3589:3: ( ( ruleReference ) )
            // InternalOML.g:3590:4: ( ruleReference )
            {
            // InternalOML.g:3590:4: ( ruleReference )
            // InternalOML.g:3591:5: ruleReference
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

            otherlv_1=(Token)match(input,74,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1());
            		
            // InternalOML.g:3609:3: ( ( ruleReference ) )
            // InternalOML.g:3610:4: ( ruleReference )
            {
            // InternalOML.g:3610:4: ( ruleReference )
            // InternalOML.g:3611:5: ruleReference
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
    // InternalOML.g:3629:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3629:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:3630:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3636:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3642:2: ( (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3643:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3643:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3644:3: otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0());
            		
            // InternalOML.g:3648:3: ( ( ruleReference ) )
            // InternalOML.g:3649:4: ( ruleReference )
            {
            // InternalOML.g:3649:4: ( ruleReference )
            // InternalOML.g:3650:5: ruleReference
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

            otherlv_2=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3668:3: ( ( ruleReference ) )
            // InternalOML.g:3669:4: ( ruleReference )
            {
            // InternalOML.g:3669:4: ( ruleReference )
            // InternalOML.g:3670:5: ruleReference
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

            otherlv_4=(Token)match(input,70,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3688:3: ( ( ruleReference ) )
            // InternalOML.g:3689:4: ( ruleReference )
            {
            // InternalOML.g:3689:4: ( ruleReference )
            // InternalOML.g:3690:5: ruleReference
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
    // InternalOML.g:3708:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:3708:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:3709:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:3715:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_literalValue_5_0=null;


        	enterRule();

        try {
            // InternalOML.g:3721:2: ( (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) ) )
            // InternalOML.g:3722:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) )
            {
            // InternalOML.g:3722:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) )
            // InternalOML.g:3723:3: otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAllDataKeyword_0());
            		
            // InternalOML.g:3727:3: ( ( ruleReference ) )
            // InternalOML.g:3728:4: ( ruleReference )
            {
            // InternalOML.g:3728:4: ( ruleReference )
            // InternalOML.g:3729:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_40);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,77,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCommaKeyword_2());
            		
            // InternalOML.g:3747:3: ( ( ruleReference ) )
            // InternalOML.g:3748:4: ( ruleReference )
            {
            // InternalOML.g:3748:4: ( ruleReference )
            // InternalOML.g:3749:5: ruleReference
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

            otherlv_4=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:3767:3: ( (lv_literalValue_5_0= RULE_STRING ) )
            // InternalOML.g:3768:4: (lv_literalValue_5_0= RULE_STRING )
            {
            // InternalOML.g:3768:4: (lv_literalValue_5_0= RULE_STRING )
            // InternalOML.g:3769:5: lv_literalValue_5_0= RULE_STRING
            {
            lv_literalValue_5_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_literalValue_5_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getLiteralValueSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            					setWithLastConsumed(
            						current,
            						"literalValue",
            						lv_literalValue_5_0,
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
    // $ANTLR end "ruleEntityScalarDataPropertyParticularRestrictionAxiom"


    // $ANTLR start "entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom"
    // InternalOML.g:3789:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3789:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:3790:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3796:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3802:2: ( (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3803:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3803:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3804:3: otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0());
            		
            // InternalOML.g:3808:3: ( ( ruleReference ) )
            // InternalOML.g:3809:4: ( ruleReference )
            {
            // InternalOML.g:3809:4: ( ruleReference )
            // InternalOML.g:3810:5: ruleReference
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

            otherlv_2=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3828:3: ( ( ruleReference ) )
            // InternalOML.g:3829:4: ( ruleReference )
            {
            // InternalOML.g:3829:4: ( ruleReference )
            // InternalOML.g:3830:5: ruleReference
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

            otherlv_4=(Token)match(input,70,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3848:3: ( ( ruleReference ) )
            // InternalOML.g:3849:4: ( ruleReference )
            {
            // InternalOML.g:3849:4: ( ruleReference )
            // InternalOML.g:3850:5: ruleReference
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


    // $ANTLR start "entryRuleBinaryScalarRestriction"
    // InternalOML.g:3868:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:3868:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:3869:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
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
    // InternalOML.g:3875:1: ruleBinaryScalarRestriction returns [EObject current=null] : (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) ;
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
            // InternalOML.g:3881:2: ( (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) )
            // InternalOML.g:3882:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            {
            // InternalOML.g:3882:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            // InternalOML.g:3883:3: otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0());
            		
            // InternalOML.g:3887:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3888:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3888:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3889:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:3909:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:3910:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:3910:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            // InternalOML.g:3911:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:3914:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            // InternalOML.g:3915:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            {
            // InternalOML.g:3915:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            loop31:
            do {
                int alt31=4;
                int LA31_0 = input.LA(1);

                if ( LA31_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt31=1;
                }
                else if ( LA31_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt31=2;
                }
                else if ( LA31_0 == 81 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt31=3;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:3916:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3916:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3917:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:3917:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3918:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:3921:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3921:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3921:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:3921:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,79,FOLLOW_42); 

            	    									newLeafNode(otherlv_4, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:3925:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:3926:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:3926:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:3927:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    // InternalOML.g:3949:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3949:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3950:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:3950:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3951:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:3954:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3954:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3954:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:3954:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,80,FOLLOW_42); 

            	    									newLeafNode(otherlv_6, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:3958:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:3959:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:3959:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:3960:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    // InternalOML.g:3982:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3982:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3983:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:3983:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3984:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:3987:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3987:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3987:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:3987:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,81,FOLLOW_42); 

            	    									newLeafNode(otherlv_8, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:3991:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:3992:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:3992:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:3993:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    break loop31;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_10=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_10, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4026:3: ( ( ruleReference ) )
            // InternalOML.g:4027:4: ( ruleReference )
            {
            // InternalOML.g:4027:4: ( ruleReference )
            // InternalOML.g:4028:5: ruleReference
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

            otherlv_12=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:4050:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:4050:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:4051:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
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
    // InternalOML.g:4057:1: ruleIRIScalarRestriction returns [EObject current=null] : (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:4063:2: ( (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4064:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4064:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4065:3: otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4069:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4070:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4070:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4071:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4091:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4092:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4092:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4093:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4096:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4097:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4097:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop32:
            do {
                int alt32=5;
                int LA32_0 = input.LA(1);

                if ( LA32_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt32=1;
                }
                else if ( LA32_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt32=2;
                }
                else if ( LA32_0 == 81 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt32=3;
                }
                else if ( LA32_0 == 84 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt32=4;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOML.g:4098:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4098:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4099:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4099:117: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4100:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4103:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4103:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4103:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4103:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,79,FOLLOW_42); 

            	    									newLeafNode(otherlv_4, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4107:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4108:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4108:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4109:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:4131:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4131:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4132:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4132:117: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4133:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4136:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4136:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4136:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4136:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,80,FOLLOW_42); 

            	    									newLeafNode(otherlv_6, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4140:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4141:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4141:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4142:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:4164:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4164:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4165:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4165:117: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4166:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4169:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4169:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4169:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4169:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,81,FOLLOW_42); 

            	    									newLeafNode(otherlv_8, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4173:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4174:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4174:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4175:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:4197:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4197:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4198:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4198:117: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4199:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4202:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4202:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4202:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4202:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,84,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4206:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4207:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4207:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4208:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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
            	    break loop32;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4241:3: ( ( ruleReference ) )
            // InternalOML.g:4242:4: ( ruleReference )
            {
            // InternalOML.g:4242:4: ( ruleReference )
            // InternalOML.g:4243:5: ruleReference
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

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:4265:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:4265:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:4266:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
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
    // InternalOML.g:4272:1: ruleNumericScalarRestriction returns [EObject current=null] : (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:4278:2: ( (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4279:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4279:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4280:3: otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,85,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4284:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4285:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4285:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4286:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4306:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4307:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4307:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4308:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4311:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4312:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4312:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop33:
            do {
                int alt33=5;
                int LA33_0 = input.LA(1);

                if ( LA33_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt33=1;
                }
                else if ( LA33_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt33=2;
                }
                else if ( LA33_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt33=3;
                }
                else if ( LA33_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt33=4;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:4313:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4313:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4314:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4314:121: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4315:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4318:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4318:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4318:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:4318:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4322:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:4323:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4323:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:4324:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:4346:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4346:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4347:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4347:121: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4348:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4351:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4351:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4351:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:4351:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4355:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:4356:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4356:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:4357:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:4379:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4379:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4380:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4380:121: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4381:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4384:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4384:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4384:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:4384:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4388:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:4389:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4389:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:4390:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:4412:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4412:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4413:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4413:121: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4414:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4417:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4417:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4417:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4417:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,89,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4421:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:4422:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4422:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:4423:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    break loop33;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4456:3: ( ( ruleReference ) )
            // InternalOML.g:4457:4: ( ruleReference )
            {
            // InternalOML.g:4457:4: ( ruleReference )
            // InternalOML.g:4458:5: ruleReference
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

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:4480:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:4480:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:4481:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
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
    // InternalOML.g:4487:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) ;
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
            // InternalOML.g:4493:2: ( (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) )
            // InternalOML.g:4494:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            {
            // InternalOML.g:4494:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            // InternalOML.g:4495:3: otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,90,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4499:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4500:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4500:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4501:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_45); 

            			newLeafNode(otherlv_2, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4521:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4522:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4522:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4523:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4526:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4527:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4527:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            loop34:
            do {
                int alt34=6;
                int LA34_0 = input.LA(1);

                if ( LA34_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt34=1;
                }
                else if ( LA34_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt34=2;
                }
                else if ( LA34_0 == 81 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt34=3;
                }
                else if ( LA34_0 == 84 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt34=4;
                }
                else if ( LA34_0 == 91 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
                    alt34=5;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalOML.g:4528:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4528:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4529:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4529:126: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4530:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4533:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4533:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4533:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4533:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,79,FOLLOW_42); 

            	    									newLeafNode(otherlv_4, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4537:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4538:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4538:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4539:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_45); 

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
            	    // InternalOML.g:4561:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4561:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4562:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4562:126: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4563:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4566:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4566:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4566:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4566:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,80,FOLLOW_42); 

            	    									newLeafNode(otherlv_6, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4570:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4571:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4571:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4572:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_45); 

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
            	    // InternalOML.g:4594:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4594:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4595:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4595:126: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4596:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4599:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4599:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4599:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4599:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,81,FOLLOW_42); 

            	    									newLeafNode(otherlv_8, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4603:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4604:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4604:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4605:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_45); 

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
            	    // InternalOML.g:4627:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4627:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4628:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4628:126: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4629:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4632:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4632:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4632:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4632:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,84,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4636:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4637:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4637:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4638:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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
            	    // InternalOML.g:4660:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4660:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4661:5: {...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:4661:126: ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4662:6: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:4665:9: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4665:10: {...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4665:19: (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    // InternalOML.g:4665:20: otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) )
            	    {
            	    otherlv_12=(Token)match(input,91,FOLLOW_7); 

            	    									newLeafNode(otherlv_12, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0());
            	    								
            	    // InternalOML.g:4669:9: ( (lv_langRange_13_0= RULE_STRING ) )
            	    // InternalOML.g:4670:10: (lv_langRange_13_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4670:10: (lv_langRange_13_0= RULE_STRING )
            	    // InternalOML.g:4671:11: lv_langRange_13_0= RULE_STRING
            	    {
            	    lv_langRange_13_0=(Token)match(input,RULE_STRING,FOLLOW_45); 

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
            	    break loop34;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_14=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_14, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4704:3: ( ( ruleReference ) )
            // InternalOML.g:4705:4: ( ruleReference )
            {
            // InternalOML.g:4705:4: ( ruleReference )
            // InternalOML.g:4706:5: ruleReference
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

            otherlv_16=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:4728:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:4728:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:4729:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
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
    // InternalOML.g:4735:1: ruleScalarOneOfRestriction returns [EObject current=null] : (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:4741:2: ( (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:4742:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:4742:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:4743:3: otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0());
            		
            // InternalOML.g:4747:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4748:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4748:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4749:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:4773:3: ( ( ruleReference ) )
            // InternalOML.g:4774:4: ( ruleReference )
            {
            // InternalOML.g:4774:4: ( ruleReference )
            // InternalOML.g:4775:5: ruleReference
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

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:4797:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:4797:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:4798:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
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
    // InternalOML.g:4804:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:4810:2: ( (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOML.g:4811:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOML.g:4811:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOML.g:4812:3: otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,93,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0());
            		
            // InternalOML.g:4816:3: ( ( ruleReference ) )
            // InternalOML.g:4817:4: ( ruleReference )
            {
            // InternalOML.g:4817:4: ( ruleReference )
            // InternalOML.g:4818:5: ruleReference
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

            otherlv_2=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfLiteralAxiomAccess().getEqualsSignKeyword_2());
            		
            // InternalOML.g:4836:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOML.g:4837:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOML.g:4837:4: (lv_value_3_0= RULE_STRING )
            // InternalOML.g:4838:5: lv_value_3_0= RULE_STRING
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
    // InternalOML.g:4858:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:4858:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:4859:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
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
    // InternalOML.g:4865:1: ruleStringScalarRestriction returns [EObject current=null] : (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:4871:2: ( (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4872:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4872:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4873:3: otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4877:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4878:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4878:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4879:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4899:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4900:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4900:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4901:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4904:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4905:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4905:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop35:
            do {
                int alt35=5;
                int LA35_0 = input.LA(1);

                if ( LA35_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt35=1;
                }
                else if ( LA35_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt35=2;
                }
                else if ( LA35_0 == 81 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt35=3;
                }
                else if ( LA35_0 == 84 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt35=4;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalOML.g:4906:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4906:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4907:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4907:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4908:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4911:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4911:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4911:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4911:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,79,FOLLOW_42); 

            	    									newLeafNode(otherlv_4, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4915:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4916:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4916:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4917:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:4939:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4939:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4940:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4940:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4941:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4944:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4944:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4944:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4944:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,80,FOLLOW_42); 

            	    									newLeafNode(otherlv_6, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4948:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4949:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4949:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4950:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:4972:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4972:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4973:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4973:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4974:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4977:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4977:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4977:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4977:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,81,FOLLOW_42); 

            	    									newLeafNode(otherlv_8, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4981:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4982:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4982:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4983:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_43); 

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
            	    // InternalOML.g:5005:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5005:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5006:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:5006:120: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5007:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:5010:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5010:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5010:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:5010:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,84,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:5014:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:5015:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5015:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:5016:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_43); 

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
            	    break loop35;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5049:3: ( ( ruleReference ) )
            // InternalOML.g:5050:4: ( ruleReference )
            {
            // InternalOML.g:5050:4: ( ruleReference )
            // InternalOML.g:5051:5: ruleReference
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

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:5073:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:5073:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:5074:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
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
    // InternalOML.g:5080:1: ruleSynonymScalarRestriction returns [EObject current=null] : (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5086:2: ( (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:5087:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:5087:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:5088:3: otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0());
            		
            // InternalOML.g:5092:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5093:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5093:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5094:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:5118:3: ( ( ruleReference ) )
            // InternalOML.g:5119:4: ( ruleReference )
            {
            // InternalOML.g:5119:4: ( ruleReference )
            // InternalOML.g:5120:5: ruleReference
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

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:5142:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:5142:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:5143:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
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
    // InternalOML.g:5149:1: ruleTimeScalarRestriction returns [EObject current=null] : (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:5155:2: ( (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:5156:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:5156:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:5157:3: otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,96,FOLLOW_23); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0());
            		
            // InternalOML.g:5161:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:5162:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:5162:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:5163:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,25,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5183:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:5184:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:5184:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:5185:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:5188:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:5189:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:5189:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop36:
            do {
                int alt36=5;
                int LA36_0 = input.LA(1);

                if ( LA36_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt36=1;
                }
                else if ( LA36_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt36=2;
                }
                else if ( LA36_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt36=3;
                }
                else if ( LA36_0 == 89 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt36=4;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:5190:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5190:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5191:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:5191:118: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5192:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:5195:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5195:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5195:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:5195:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:5199:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:5200:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5200:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:5201:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:5223:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5223:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5224:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:5224:118: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5225:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:5228:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5228:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5228:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:5228:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:5232:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:5233:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5233:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:5234:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:5256:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5256:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5257:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:5257:118: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5258:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:5261:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5261:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5261:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:5261:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:5265:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:5266:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5266:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:5267:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    // InternalOML.g:5289:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:5289:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:5290:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:5290:118: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:5291:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:5294:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:5294:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:5294:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:5294:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,89,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:5298:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:5299:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:5299:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:5300:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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
            	    break loop36;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_12, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5333:3: ( ( ruleReference ) )
            // InternalOML.g:5334:4: ( ruleReference )
            {
            // InternalOML.g:5334:4: ( ruleReference )
            // InternalOML.g:5335:5: ruleReference
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

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:5357:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:5357:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:5358:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
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
    // InternalOML.g:5364:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:5370:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:5371:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:5371:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==98) ) {
                alt37=1;
            }
            else if ( (LA37_0==100) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalOML.g:5372:3: this_ConceptInstance_0= ruleConceptInstance
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
                    // InternalOML.g:5381:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
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
    // InternalOML.g:5393:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:5393:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:5394:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
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
    // InternalOML.g:5400:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5406:2: ( (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5407:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5407:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5408:3: otherlv_0= 'extends' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0());
            		
            // InternalOML.g:5412:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5413:4: ( ruleExternalReference )
            {
            // InternalOML.g:5413:4: ( ruleExternalReference )
            // InternalOML.g:5414:5: ruleExternalReference
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
    // InternalOML.g:5432:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:5432:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:5433:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
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
    // InternalOML.g:5439:1: ruleDescriptionBoxRefinement returns [EObject current=null] : (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5445:2: ( (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5446:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5446:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5447:3: otherlv_0= 'refines' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0());
            		
            // InternalOML.g:5451:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5452:4: ( ruleExternalReference )
            {
            // InternalOML.g:5452:4: ( ruleExternalReference )
            // InternalOML.g:5453:5: ruleExternalReference
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
    // InternalOML.g:5471:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5471:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:5472:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
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
    // InternalOML.g:5478:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5484:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) )
            // InternalOML.g:5485:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            {
            // InternalOML.g:5485:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            // InternalOML.g:5486:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            {
            // InternalOML.g:5486:3: ( ( ruleReference ) )
            // InternalOML.g:5487:4: ( ruleReference )
            {
            // InternalOML.g:5487:4: ( ruleReference )
            // InternalOML.g:5488:5: ruleReference
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

            otherlv_1=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5506:3: ( ( ruleReference ) )
            // InternalOML.g:5507:4: ( ruleReference )
            {
            // InternalOML.g:5507:4: ( ruleReference )
            // InternalOML.g:5508:5: ruleReference
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

            otherlv_3=(Token)match(input,22,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:5526:3: ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            // InternalOML.g:5527:4: (lv_scalarPropertyValue_4_0= ruleValue )
            {
            // InternalOML.g:5527:4: (lv_scalarPropertyValue_4_0= ruleValue )
            // InternalOML.g:5528:5: lv_scalarPropertyValue_4_0= ruleValue
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
    // InternalOML.g:5549:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:5549:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:5550:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
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
    // InternalOML.g:5556:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:5562:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) )
            // InternalOML.g:5563:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            {
            // InternalOML.g:5563:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            // InternalOML.g:5564:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}'
            {
            // InternalOML.g:5564:3: ( ( ruleReference ) )
            // InternalOML.g:5565:4: ( ruleReference )
            {
            // InternalOML.g:5565:4: ( ruleReference )
            // InternalOML.g:5566:5: ruleReference
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

            otherlv_1=(Token)match(input,69,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5584:3: ( ( ruleReference ) )
            // InternalOML.g:5585:4: ( ruleReference )
            {
            // InternalOML.g:5585:4: ( ruleReference )
            // InternalOML.g:5586:5: ruleReference
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

            otherlv_3=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_48); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:5608:3: ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )*
            loop38:
            do {
                int alt38=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA38_2 = input.LA(2);

                    if ( (LA38_2==22) ) {
                        int LA38_5 = input.LA(3);

                        if ( (LA38_5==25) ) {
                            alt38=1;
                        }
                        else if ( (LA38_5==RULE_STRING||(LA38_5>=RULE_INT && LA38_5<=RULE_FLOAT)) ) {
                            alt38=2;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA38_3 = input.LA(2);

                    if ( (LA38_3==22) ) {
                        int LA38_5 = input.LA(3);

                        if ( (LA38_5==25) ) {
                            alt38=1;
                        }
                        else if ( (LA38_5==RULE_STRING||(LA38_5>=RULE_INT && LA38_5<=RULE_FLOAT)) ) {
                            alt38=2;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA38_4 = input.LA(2);

                    if ( (LA38_4==22) ) {
                        int LA38_5 = input.LA(3);

                        if ( (LA38_5==25) ) {
                            alt38=1;
                        }
                        else if ( (LA38_5==RULE_STRING||(LA38_5>=RULE_INT && LA38_5<=RULE_FLOAT)) ) {
                            alt38=2;
                        }


                    }


                    }
                    break;

                }

                switch (alt38) {
            	case 1 :
            	    // InternalOML.g:5609:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5609:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5610:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5610:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5611:6: lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    // InternalOML.g:5629:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5629:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:5630:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5630:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:5631:6: lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop38;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:5657:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:5657:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:5658:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
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
    // InternalOML.g:5664:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_structuredPropertyTuples_3_0 = null;

        EObject lv_scalarDataPropertyValues_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5670:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) )
            // InternalOML.g:5671:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            {
            // InternalOML.g:5671:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            // InternalOML.g:5672:3: ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}'
            {
            // InternalOML.g:5672:3: ( ( ruleReference ) )
            // InternalOML.g:5673:4: ( ruleReference )
            {
            // InternalOML.g:5673:4: ( ruleReference )
            // InternalOML.g:5674:5: ruleReference
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

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_48); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5696:3: ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )*
            loop39:
            do {
                int alt39=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA39_2 = input.LA(2);

                    if ( (LA39_2==22) ) {
                        int LA39_5 = input.LA(3);

                        if ( (LA39_5==RULE_STRING||(LA39_5>=RULE_INT && LA39_5<=RULE_FLOAT)) ) {
                            alt39=2;
                        }
                        else if ( (LA39_5==25) ) {
                            alt39=1;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA39_3 = input.LA(2);

                    if ( (LA39_3==22) ) {
                        int LA39_5 = input.LA(3);

                        if ( (LA39_5==RULE_STRING||(LA39_5>=RULE_INT && LA39_5<=RULE_FLOAT)) ) {
                            alt39=2;
                        }
                        else if ( (LA39_5==25) ) {
                            alt39=1;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA39_4 = input.LA(2);

                    if ( (LA39_4==22) ) {
                        int LA39_5 = input.LA(3);

                        if ( (LA39_5==RULE_STRING||(LA39_5>=RULE_INT && LA39_5<=RULE_FLOAT)) ) {
                            alt39=2;
                        }
                        else if ( (LA39_5==25) ) {
                            alt39=1;
                        }


                    }


                    }
                    break;

                }

                switch (alt39) {
            	case 1 :
            	    // InternalOML.g:5697:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5697:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5698:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5698:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5699:6: lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    // InternalOML.g:5717:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5717:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:5718:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5718:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:5719:6: lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_48);
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
            	    break loop39;
                }
            } while (true);

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:5745:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5745:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:5746:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
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
    // InternalOML.g:5752:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5758:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) )
            // InternalOML.g:5759:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            {
            // InternalOML.g:5759:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            // InternalOML.g:5760:3: ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            {
            // InternalOML.g:5760:3: ( ( ruleReference ) )
            // InternalOML.g:5761:4: ( ruleReference )
            {
            // InternalOML.g:5761:4: ( ruleReference )
            // InternalOML.g:5762:5: ruleReference
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

            otherlv_1=(Token)match(input,22,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalOML.g:5780:3: ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            // InternalOML.g:5781:4: (lv_scalarPropertyValue_2_0= ruleValue )
            {
            // InternalOML.g:5781:4: (lv_scalarPropertyValue_2_0= ruleValue )
            // InternalOML.g:5782:5: lv_scalarPropertyValue_2_0= ruleValue
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
    // InternalOML.g:5803:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:5803:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:5804:2: iv_ruleConceptInstance= ruleConceptInstance EOF
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
    // InternalOML.g:5810:1: ruleConceptInstance returns [EObject current=null] : (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleConceptInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5816:2: ( (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:5817:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:5817:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:5818:3: otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5826:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5827:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5827:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5828:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_49); 

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

            otherlv_3=(Token)match(input,99,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getConceptInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:5848:3: ( ( ruleReference ) )
            // InternalOML.g:5849:4: ( ruleReference )
            {
            // InternalOML.g:5849:4: ( ruleReference )
            // InternalOML.g:5850:5: ruleReference
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

            otherlv_5=(Token)match(input,65,FOLLOW_2); 

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
    // InternalOML.g:5872:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:5872:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:5873:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
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
    // InternalOML.g:5879:1: ruleReifiedRelationshipInstance returns [EObject current=null] : (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5885:2: ( (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:5886:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:5886:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:5887:3: otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5895:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5896:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5896:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5897:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_49); 

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

            otherlv_3=(Token)match(input,99,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:5917:3: ( ( ruleReference ) )
            // InternalOML.g:5918:4: ( ruleReference )
            {
            // InternalOML.g:5918:4: ( ruleReference )
            // InternalOML.g:5919:5: ruleReference
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

            otherlv_5=(Token)match(input,65,FOLLOW_2); 

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
    // InternalOML.g:5941:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:5941:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:5942:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
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
    // InternalOML.g:5948:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:5954:2: ( (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:5955:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:5955:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:5956:3: otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5964:3: ( ( ruleReference ) )
            // InternalOML.g:5965:4: ( ruleReference )
            {
            // InternalOML.g:5965:4: ( ruleReference )
            // InternalOML.g:5966:5: ruleReference
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

            otherlv_3=(Token)match(input,65,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:5988:3: ( ( ruleReference ) )
            // InternalOML.g:5989:4: ( ruleReference )
            {
            // InternalOML.g:5989:4: ( ruleReference )
            // InternalOML.g:5990:5: ruleReference
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
    // InternalOML.g:6008:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:6008:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:6009:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
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
    // InternalOML.g:6015:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:6021:2: ( (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:6022:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:6022:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:6023:3: otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:6031:3: ( ( ruleReference ) )
            // InternalOML.g:6032:4: ( ruleReference )
            {
            // InternalOML.g:6032:4: ( ruleReference )
            // InternalOML.g:6033:5: ruleReference
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

            otherlv_3=(Token)match(input,65,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:6055:3: ( ( ruleReference ) )
            // InternalOML.g:6056:4: ( ruleReference )
            {
            // InternalOML.g:6056:4: ( ruleReference )
            // InternalOML.g:6057:5: ruleReference
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
    // InternalOML.g:6075:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:6075:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:6076:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
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
    // InternalOML.g:6082:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:6088:2: ( (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:6089:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:6089:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:6090:3: otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,53,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2());
            		
            // InternalOML.g:6102:3: ( ( ruleReference ) )
            // InternalOML.g:6103:4: ( ruleReference )
            {
            // InternalOML.g:6103:4: ( ruleReference )
            // InternalOML.g:6104:5: ruleReference
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

            otherlv_4=(Token)match(input,58,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4());
            		
            // InternalOML.g:6122:3: ( ( ruleReference ) )
            // InternalOML.g:6123:4: ( ruleReference )
            {
            // InternalOML.g:6123:4: ( ruleReference )
            // InternalOML.g:6124:5: ruleReference
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

            otherlv_6=(Token)match(input,59,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6());
            		
            // InternalOML.g:6142:3: ( ( ruleReference ) )
            // InternalOML.g:6143:4: ( ruleReference )
            {
            // InternalOML.g:6143:4: ( ruleReference )
            // InternalOML.g:6144:5: ruleReference
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

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

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
    // InternalOML.g:6166:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:6166:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:6167:2: iv_ruleReference= ruleReference EOF
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
    // InternalOML.g:6173:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6179:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:6180:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:6180:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_IRI) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ABBREV_IRI||LA40_0==RULE_ID) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalOML.g:6181:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6189:3: this_QNAME_1= ruleQNAME
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
    // InternalOML.g:6203:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:6203:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:6204:2: iv_ruleExternalReference= ruleExternalReference EOF
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
    // InternalOML.g:6210:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:6216:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:6217:2: this_IRI_0= RULE_IRI
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
    // InternalOML.g:6227:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:6227:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:6228:2: iv_ruleQNAME= ruleQNAME EOF
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
    // InternalOML.g:6234:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6240:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:6241:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:6241:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ABBREV_IRI) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_ID) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalOML.g:6242:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6250:3: this_ValidID_1= ruleValidID
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
    // InternalOML.g:6264:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:6264:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:6265:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOML.g:6271:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:6277:2: (this_ID_0= RULE_ID )
            // InternalOML.g:6278:2: this_ID_0= RULE_ID
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
    // InternalOML.g:6288:1: entryRuleValue returns [String current=null] : iv_ruleValue= ruleValue EOF ;
    public final String entryRuleValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValue = null;


        try {
            // InternalOML.g:6288:45: (iv_ruleValue= ruleValue EOF )
            // InternalOML.g:6289:2: iv_ruleValue= ruleValue EOF
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
    // InternalOML.g:6295:1: ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECIMAL_0=null;
        Token this_STRING_1=null;
        Token this_INT_2=null;
        Token this_UUID_3=null;
        Token this_HEX_4=null;
        Token this_FLOAT_5=null;


        	enterRule();

        try {
            // InternalOML.g:6301:2: ( (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) )
            // InternalOML.g:6302:2: (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            {
            // InternalOML.g:6302:2: (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            int alt42=6;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL:
                {
                alt42=1;
                }
                break;
            case RULE_STRING:
                {
                alt42=2;
                }
                break;
            case RULE_INT:
                {
                alt42=3;
                }
                break;
            case RULE_UUID:
                {
                alt42=4;
                }
                break;
            case RULE_HEX:
                {
                alt42=5;
                }
                break;
            case RULE_FLOAT:
                {
                alt42=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalOML.g:6303:3: this_DECIMAL_0= RULE_DECIMAL
                    {
                    this_DECIMAL_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    			current.merge(this_DECIMAL_0);
                    		

                    			newLeafNode(this_DECIMAL_0, grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6311:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:6319:3: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_2);
                    		

                    			newLeafNode(this_INT_2, grammarAccess.getValueAccess().getINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:6327:3: this_UUID_3= RULE_UUID
                    {
                    this_UUID_3=(Token)match(input,RULE_UUID,FOLLOW_2); 

                    			current.merge(this_UUID_3);
                    		

                    			newLeafNode(this_UUID_3, grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:6335:3: this_HEX_4= RULE_HEX
                    {
                    this_HEX_4=(Token)match(input,RULE_HEX,FOLLOW_2); 

                    			current.merge(this_HEX_4);
                    		

                    			newLeafNode(this_HEX_4, grammarAccess.getValueAccess().getHEXTerminalRuleCall_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:6343:3: this_FLOAT_5= RULE_FLOAT
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
    // InternalOML.g:6354:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6360:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:6361:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:6361:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==102) ) {
                alt43=1;
            }
            else if ( (LA43_0==103) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalOML.g:6362:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:6362:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:6363:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6370:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:6370:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:6371:4: enumLiteral_1= 'closed'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); 

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
    // InternalOML.g:6381:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6387:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:6388:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:6388:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==104) ) {
                alt44=1;
            }
            else if ( (LA44_0==105) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalOML.g:6389:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:6389:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:6390:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6397:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:6397:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:6398:4: enumLiteral_1= 'partial'
                    {
                    enumLiteral_1=(Token)match(input,105,FOLLOW_2); 

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
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String dfa_1s = "\7\uffff";
    static final String dfa_2s = "\1\27\1\4\2\uffff\1\26\1\6\1\27";
    static final String dfa_3s = "\1\151\1\4\2\uffff\1\26\1\6\1\151";
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
    static final String dfa_8s = "\1\27\1\4\2\30\1\26\2\uffff\1\6\1\27";
    static final String dfa_9s = "\1\147\1\4\2\33\1\26\2\uffff\1\6\1\147";
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
    static final String dfa_13s = "\24\uffff";
    static final String dfa_14s = "\1\4\11\uffff\3\105\1\4\3\26\1\6\2\uffff";
    static final String dfa_15s = "\1\145\11\uffff\3\105\1\7\3\26\1\31\2\uffff";
    static final String dfa_16s = "\1\uffff\1\13\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff\1\12\1\11";
    static final String dfa_17s = "\24\uffff}>";
    static final String[] dfa_18s = {
            "\1\13\1\12\1\uffff\1\14\17\uffff\1\2\2\uffff\1\1\6\uffff\1\3\30\uffff\1\7\1\10\45\uffff\1\4\1\5\1\uffff\1\6\1\11",
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
            "\1\23\1\uffff\5\23\14\uffff\1\22",
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
    static final String dfa_19s = "\13\uffff";
    static final String dfa_20s = "\1\50\12\uffff";
    static final String dfa_21s = "\1\61\12\uffff";
    static final String dfa_22s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_23s = "\1\0\12\uffff}>";
    static final String[] dfa_24s = {
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

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "()* loopback of 2000:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
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
                        if ( (LA24_0==49) ) {s = 1;}

                        else if ( LA24_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA24_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA24_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA24_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA24_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA24_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA24_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA24_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA24_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
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
    static final String dfa_25s = "\1\63\12\uffff";
    static final String[] dfa_26s = {
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
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_19;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_25;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 2372:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
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
                        if ( (LA26_0==51) ) {s = 1;}

                        else if ( LA26_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA26_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA26_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA26_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA26_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA26_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA26_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA26_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA26_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000A00002L,0x000003C000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000800000L,0x000000C000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x71E000E6448000B0L,0x00000001F4285890L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x71E000E6648000B0L,0x00000001F4285894L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010A00000L,0x000003C000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0C000002048000B0L,0x0000003600000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0003FF0000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0009FF0000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0200000000000080L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x8000000004000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000078000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000178000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000003C40000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000008178000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000001F40L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000040000B0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000000L});

}
