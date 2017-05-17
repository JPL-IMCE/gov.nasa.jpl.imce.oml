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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ABBREV_IRI", "RULE_IRI", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_DECIMAL", "RULE_UUID", "RULE_HEX", "RULE_FLOAT", "RULE_HEX_8DIGITS", "RULE_HEX_4DIGITS", "RULE_HEX_12DIGITS", "RULE_HEX_DIGIT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'annotationProperty'", "'='", "'@'", "'terminology'", "'{'", "'}'", "'bundle'", "'bundles'", "'conceptDesignationTerminologyAxiom'", "'designatedTerminology'", "'designatedConcept'", "'extends'", "'terminologyNestingAxiom'", "'nestingTerminology'", "'nestingContext'", "'aspect'", "'concept'", "'reifiedRelationship'", "'functional'", "'inverseFunctional'", "'essential'", "'inverseEssential'", "'symmetric'", "'asymmetric'", "'reflexive'", "'irreflexive'", "'transitive'", "'unreified'", "'inverse'", "'source'", "'target'", "'unreifiedRelationship'", "'scalar'", "'structure'", "'entityStructuredDataProperty'", "'+'", "'domain'", "'range'", "'entityScalarDataProperty'", "'structuredDataProperty'", "'scalarDataProperty'", "'anonymousConceptUnion'", "'('", "')'", "'rootConceptTaxonomy'", "'disjointLeaf'", "'someEntities'", "'.'", "'in'", "'allEntities'", "'extendsAspect'", "'extendsConcept'", "'extendsRelationship'", "'someData'", "'allData'", "','", "'binaryScalarRestriction'", "'length'", "'minLength'", "'maxLength'", "'restrictedRange'", "'iriScalarRestriction'", "'pattern'", "'numericScalarRestriction'", "'minInclusive'", "'maxInclusive'", "'minExclusive'", "'maxExclusive'", "'plainLiteralScalarRestriction'", "'langRange'", "'scalarOneOfRestriction'", "'oneOf'", "'stringScalarRestriction'", "'synonymScalarRestriction'", "'timeScalarRestriction'", "'descriptionBox'", "'refines'", "'conceptInstance'", "'is-a'", "'reifiedRelationshipInstance'", "'tuple'", "'open'", "'closed'", "'final'", "'partial'"
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
                else if ( ((LA1_0>=102 && LA1_0<=105)) ) {
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
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=102 && LA2_0<=103)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=104 && LA2_0<=105)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
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
            int LA3_0 = input.LA(1);

            if ( (LA3_0==102) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==24) ) {
                    alt3=2;
                }
                else if ( (LA3_1==27) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==103) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==24) ) {
                    alt3=2;
                }
                else if ( (LA3_2==27) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
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
    // InternalOML.g:345:1: ruleTerminologyGraph returns [EObject current=null] : ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'terminology' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTerminologyGraph() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_iri_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_boxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;



        	enterRule();

        try {
            // InternalOML.g:351:2: ( ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'terminology' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' ) )
            // InternalOML.g:352:2: ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'terminology' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' )
            {
            // InternalOML.g:352:2: ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'terminology' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}' )
            // InternalOML.g:353:3: ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'terminology' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )* otherlv_7= '}'
            {
            // InternalOML.g:353:3: ( (lv_kind_0_0= ruleTerminologyKind ) )
            // InternalOML.g:354:4: (lv_kind_0_0= ruleTerminologyKind )
            {
            // InternalOML.g:354:4: (lv_kind_0_0= ruleTerminologyKind )
            // InternalOML.g:355:5: lv_kind_0_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getTerminologyGraphAccess().getKindTerminologyKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_kind_0_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyGraphAccess().getTerminologyKeyword_1());
            		
            // InternalOML.g:376:3: ( (lv_iri_2_0= RULE_IRI ) )
            // InternalOML.g:377:4: (lv_iri_2_0= RULE_IRI )
            {
            // InternalOML.g:377:4: (lv_iri_2_0= RULE_IRI )
            // InternalOML.g:378:5: lv_iri_2_0= RULE_IRI
            {
            lv_iri_2_0=(Token)match(input,RULE_IRI,FOLLOW_9); 

            					newLeafNode(lv_iri_2_0, grammarAccess.getTerminologyGraphAccess().getIriIRITerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyGraphRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getTerminologyGraphAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:398:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 23:
                    {
                    alt4=1;
                    }
                    break;
                case 29:
                case 32:
                case 33:
                    {
                    alt4=2;
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
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalOML.g:399:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:399:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    // InternalOML.g:400:5: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:400:5: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalOML.g:401:6: lv_annotations_4_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTerminologyGraphRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:419:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:419:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:420:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:420:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:421:6: lv_boxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
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
            	case 3 :
            	    // InternalOML.g:439:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:439:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:440:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:440:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:441:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getTerminologyGraphAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_10);
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
            	    break loop4;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTerminologyGraphAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalOML.g:467:1: entryRuleBundle returns [EObject current=null] : iv_ruleBundle= ruleBundle EOF ;
    public final EObject entryRuleBundle() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundle = null;


        try {
            // InternalOML.g:467:47: (iv_ruleBundle= ruleBundle EOF )
            // InternalOML.g:468:2: iv_ruleBundle= ruleBundle EOF
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
    // InternalOML.g:474:1: ruleBundle returns [EObject current=null] : ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'bundle' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleBundle() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_iri_2_0=null;
        Token otherlv_3=null;
        Token otherlv_9=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_annotations_4_0 = null;

        EObject lv_boxAxioms_5_0 = null;

        EObject lv_boxStatements_6_0 = null;

        EObject lv_bundleStatements_7_0 = null;

        EObject lv_bundleAxioms_8_0 = null;



        	enterRule();

        try {
            // InternalOML.g:480:2: ( ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'bundle' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' ) )
            // InternalOML.g:481:2: ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'bundle' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' )
            {
            // InternalOML.g:481:2: ( ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'bundle' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}' )
            // InternalOML.g:482:3: ( (lv_kind_0_0= ruleTerminologyKind ) ) otherlv_1= 'bundle' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )* otherlv_9= '}'
            {
            // InternalOML.g:482:3: ( (lv_kind_0_0= ruleTerminologyKind ) )
            // InternalOML.g:483:4: (lv_kind_0_0= ruleTerminologyKind )
            {
            // InternalOML.g:483:4: (lv_kind_0_0= ruleTerminologyKind )
            // InternalOML.g:484:5: lv_kind_0_0= ruleTerminologyKind
            {

            					newCompositeNode(grammarAccess.getBundleAccess().getKindTerminologyKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_kind_0_0=ruleTerminologyKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBundleRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.TerminologyKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBundleAccess().getBundleKeyword_1());
            		
            // InternalOML.g:505:3: ( (lv_iri_2_0= RULE_IRI ) )
            // InternalOML.g:506:4: (lv_iri_2_0= RULE_IRI )
            {
            // InternalOML.g:506:4: (lv_iri_2_0= RULE_IRI )
            // InternalOML.g:507:5: lv_iri_2_0= RULE_IRI
            {
            lv_iri_2_0=(Token)match(input,RULE_IRI,FOLLOW_9); 

            					newLeafNode(lv_iri_2_0, grammarAccess.getBundleAccess().getIriIRITerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBundleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getBundleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:527:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) ) | ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) ) | ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) ) | ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) ) )*
            loop5:
            do {
                int alt5=6;
                switch ( input.LA(1) ) {
                case 23:
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
                case 65:
                    {
                    alt5=4;
                    }
                    break;
                case 28:
                    {
                    alt5=5;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // InternalOML.g:528:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:528:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    // InternalOML.g:529:5: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:529:5: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalOML.g:530:6: lv_annotations_4_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBundleRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:548:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    {
            	    // InternalOML.g:548:4: ( (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom ) )
            	    // InternalOML.g:549:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    {
            	    // InternalOML.g:549:5: (lv_boxAxioms_5_0= ruleTerminologyBoxAxiom )
            	    // InternalOML.g:550:6: lv_boxAxioms_5_0= ruleTerminologyBoxAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxAxiomsTerminologyBoxAxiomParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	case 3 :
            	    // InternalOML.g:568:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    {
            	    // InternalOML.g:568:4: ( (lv_boxStatements_6_0= ruleTerminologyBoxStatement ) )
            	    // InternalOML.g:569:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    {
            	    // InternalOML.g:569:5: (lv_boxStatements_6_0= ruleTerminologyBoxStatement )
            	    // InternalOML.g:570:6: lv_boxStatements_6_0= ruleTerminologyBoxStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBoxStatementsTerminologyBoxStatementParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	case 4 :
            	    // InternalOML.g:588:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    {
            	    // InternalOML.g:588:4: ( (lv_bundleStatements_7_0= ruleTerminologyBundleStatement ) )
            	    // InternalOML.g:589:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    {
            	    // InternalOML.g:589:5: (lv_bundleStatements_7_0= ruleTerminologyBundleStatement )
            	    // InternalOML.g:590:6: lv_bundleStatements_7_0= ruleTerminologyBundleStatement
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleStatementsTerminologyBundleStatementParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	case 5 :
            	    // InternalOML.g:608:4: ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    {
            	    // InternalOML.g:608:4: ( (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom ) )
            	    // InternalOML.g:609:5: (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    {
            	    // InternalOML.g:609:5: (lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom )
            	    // InternalOML.g:610:6: lv_bundleAxioms_8_0= ruleTerminologyBundleAxiom
            	    {

            	    						newCompositeNode(grammarAccess.getBundleAccess().getBundleAxiomsTerminologyBundleAxiomParserRuleCall_4_4_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	    break loop5;
                }
            } while (true);

            otherlv_9=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBundleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleTerminologyBoxAxiom"
    // InternalOML.g:636:1: entryRuleTerminologyBoxAxiom returns [EObject current=null] : iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF ;
    public final EObject entryRuleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxAxiom = null;


        try {
            // InternalOML.g:636:60: (iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF )
            // InternalOML.g:637:2: iv_ruleTerminologyBoxAxiom= ruleTerminologyBoxAxiom EOF
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
    // InternalOML.g:643:1: ruleTerminologyBoxAxiom returns [EObject current=null] : (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) ;
    public final EObject ruleTerminologyBoxAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptDesignationTerminologyAxiom_0 = null;

        EObject this_TerminologyExtensionAxiom_1 = null;

        EObject this_TerminologyNestingAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:649:2: ( (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom ) )
            // InternalOML.g:650:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            {
            // InternalOML.g:650:2: (this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom | this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom | this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt6=1;
                }
                break;
            case 32:
                {
                alt6=2;
                }
                break;
            case 33:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalOML.g:651:3: this_ConceptDesignationTerminologyAxiom_0= ruleConceptDesignationTerminologyAxiom
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
                    // InternalOML.g:660:3: this_TerminologyExtensionAxiom_1= ruleTerminologyExtensionAxiom
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
                    // InternalOML.g:669:3: this_TerminologyNestingAxiom_2= ruleTerminologyNestingAxiom
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
    // InternalOML.g:681:1: entryRuleBundledTerminologyAxiom returns [EObject current=null] : iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF ;
    public final EObject entryRuleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBundledTerminologyAxiom = null;


        try {
            // InternalOML.g:681:64: (iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF )
            // InternalOML.g:682:2: iv_ruleBundledTerminologyAxiom= ruleBundledTerminologyAxiom EOF
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
    // InternalOML.g:688:1: ruleBundledTerminologyAxiom returns [EObject current=null] : (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleBundledTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:694:2: ( (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:695:2: (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:695:2: (otherlv_0= 'bundles' ( ( ruleExternalReference ) ) )
            // InternalOML.g:696:3: otherlv_0= 'bundles' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getBundledTerminologyAxiomAccess().getBundlesKeyword_0());
            		
            // InternalOML.g:700:3: ( ( ruleExternalReference ) )
            // InternalOML.g:701:4: ( ruleExternalReference )
            {
            // InternalOML.g:701:4: ( ruleExternalReference )
            // InternalOML.g:702:5: ruleExternalReference
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
    // InternalOML.g:720:1: entryRuleConceptDesignationTerminologyAxiom returns [EObject current=null] : iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF ;
    public final EObject entryRuleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptDesignationTerminologyAxiom = null;


        try {
            // InternalOML.g:720:75: (iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF )
            // InternalOML.g:721:2: iv_ruleConceptDesignationTerminologyAxiom= ruleConceptDesignationTerminologyAxiom EOF
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
    // InternalOML.g:727:1: ruleConceptDesignationTerminologyAxiom returns [EObject current=null] : (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleConceptDesignationTerminologyAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalOML.g:733:2: ( (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:734:2: (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:734:2: (otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:735:3: otherlv_0= 'conceptDesignationTerminologyAxiom' otherlv_1= '{' otherlv_2= 'designatedTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'designatedConcept' ( ( ruleReference ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getConceptDesignationTerminologyAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyKeyword_2());
            		
            // InternalOML.g:747:3: ( ( ruleExternalReference ) )
            // InternalOML.g:748:4: ( ruleExternalReference )
            {
            // InternalOML.g:748:4: ( ruleExternalReference )
            // InternalOML.g:749:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_14);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,31,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptKeyword_4());
            		
            // InternalOML.g:767:3: ( ( ruleReference ) )
            // InternalOML.g:768:4: ( ruleReference )
            {
            // InternalOML.g:768:4: ( ruleReference )
            // InternalOML.g:769:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptDesignationTerminologyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptDesignationTerminologyAxiomAccess().getDesignatedConceptConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:791:1: entryRuleTerminologyExtensionAxiom returns [EObject current=null] : iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF ;
    public final EObject entryRuleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyExtensionAxiom = null;


        try {
            // InternalOML.g:791:66: (iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF )
            // InternalOML.g:792:2: iv_ruleTerminologyExtensionAxiom= ruleTerminologyExtensionAxiom EOF
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
    // InternalOML.g:798:1: ruleTerminologyExtensionAxiom returns [EObject current=null] : (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleTerminologyExtensionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:804:2: ( (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:805:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:805:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:806:3: otherlv_0= 'extends' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminologyExtensionAxiomAccess().getExtendsKeyword_0());
            		
            // InternalOML.g:810:3: ( ( ruleExternalReference ) )
            // InternalOML.g:811:4: ( ruleExternalReference )
            {
            // InternalOML.g:811:4: ( ruleExternalReference )
            // InternalOML.g:812:5: ruleExternalReference
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
    // InternalOML.g:830:1: entryRuleTerminologyNestingAxiom returns [EObject current=null] : iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF ;
    public final EObject entryRuleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyNestingAxiom = null;


        try {
            // InternalOML.g:830:64: (iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF )
            // InternalOML.g:831:2: iv_ruleTerminologyNestingAxiom= ruleTerminologyNestingAxiom EOF
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
    // InternalOML.g:837:1: ruleTerminologyNestingAxiom returns [EObject current=null] : (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' ) ;
    public final EObject ruleTerminologyNestingAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalOML.g:843:2: ( (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' ) )
            // InternalOML.g:844:2: (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' )
            {
            // InternalOML.g:844:2: (otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}' )
            // InternalOML.g:845:3: otherlv_0= 'terminologyNestingAxiom' otherlv_1= '{' otherlv_2= 'nestingTerminology' ( ( ruleExternalReference ) ) otherlv_4= 'nestingContext' ( ( ruleReference ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getTerminologyNestingAxiomAccess().getTerminologyNestingAxiomKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getTerminologyNestingAxiomAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyKeyword_2());
            		
            // InternalOML.g:857:3: ( ( ruleExternalReference ) )
            // InternalOML.g:858:4: ( ruleExternalReference )
            {
            // InternalOML.g:858:4: ( ruleExternalReference )
            // InternalOML.g:859:5: ruleExternalReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingTerminologyTerminologyBoxCrossReference_3_0());
            				
            pushFollow(FOLLOW_18);
            ruleExternalReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,35,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextKeyword_4());
            		
            // InternalOML.g:877:3: ( ( ruleReference ) )
            // InternalOML.g:878:4: ( ruleReference )
            {
            // InternalOML.g:878:4: ( ruleReference )
            // InternalOML.g:879:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTerminologyNestingAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTerminologyNestingAxiomAccess().getNestingContextConceptCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:901:1: entryRuleTerminologyBoxStatement returns [EObject current=null] : iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF ;
    public final EObject entryRuleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBoxStatement = null;


        try {
            // InternalOML.g:901:64: (iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF )
            // InternalOML.g:902:2: iv_ruleTerminologyBoxStatement= ruleTerminologyBoxStatement EOF
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
    // InternalOML.g:908:1: ruleTerminologyBoxStatement returns [EObject current=null] : (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) ;
    public final EObject ruleTerminologyBoxStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TermAxiom_0 = null;

        EObject this_Term_1 = null;



        	enterRule();

        try {
            // InternalOML.g:914:2: ( (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm ) )
            // InternalOML.g:915:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            {
            // InternalOML.g:915:2: (this_TermAxiom_0= ruleTermAxiom | this_Term_1= ruleTerm )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ABBREV_IRI && LA7_0<=RULE_IRI)||LA7_0==RULE_ID||LA7_0==67||LA7_0==70||(LA7_0>=74 && LA7_0<=75)||LA7_0==92) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=36 && LA7_0<=38)||(LA7_0>=52 && LA7_0<=55)||(LA7_0>=59 && LA7_0<=61)||LA7_0==77||LA7_0==82||LA7_0==84||LA7_0==89||LA7_0==91||(LA7_0>=93 && LA7_0<=95)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOML.g:916:3: this_TermAxiom_0= ruleTermAxiom
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
                    // InternalOML.g:925:3: this_Term_1= ruleTerm
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
    // InternalOML.g:937:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalOML.g:937:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalOML.g:938:2: iv_ruleTerm= ruleTerm EOF
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
    // InternalOML.g:944:1: ruleTerm returns [EObject current=null] : (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicEntity_0 = null;

        EObject this_EntityRelationship_1 = null;

        EObject this_Datatype_2 = null;

        EObject this_DataRelationship_3 = null;



        	enterRule();

        try {
            // InternalOML.g:950:2: ( (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship ) )
            // InternalOML.g:951:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            {
            // InternalOML.g:951:2: (this_AtomicEntity_0= ruleAtomicEntity | this_EntityRelationship_1= ruleEntityRelationship | this_Datatype_2= ruleDatatype | this_DataRelationship_3= ruleDataRelationship )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 36:
            case 37:
                {
                alt8=1;
                }
                break;
            case 38:
            case 52:
                {
                alt8=2;
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
                alt8=3;
                }
                break;
            case 55:
            case 59:
            case 60:
            case 61:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalOML.g:952:3: this_AtomicEntity_0= ruleAtomicEntity
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
                    // InternalOML.g:961:3: this_EntityRelationship_1= ruleEntityRelationship
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
                    // InternalOML.g:970:3: this_Datatype_2= ruleDatatype
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
                    // InternalOML.g:979:3: this_DataRelationship_3= ruleDataRelationship
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
    // InternalOML.g:991:1: entryRuleAtomicEntity returns [EObject current=null] : iv_ruleAtomicEntity= ruleAtomicEntity EOF ;
    public final EObject entryRuleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicEntity = null;


        try {
            // InternalOML.g:991:53: (iv_ruleAtomicEntity= ruleAtomicEntity EOF )
            // InternalOML.g:992:2: iv_ruleAtomicEntity= ruleAtomicEntity EOF
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
    // InternalOML.g:998:1: ruleAtomicEntity returns [EObject current=null] : (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) ;
    public final EObject ruleAtomicEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Aspect_0 = null;

        EObject this_Concept_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1004:2: ( (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept ) )
            // InternalOML.g:1005:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            {
            // InternalOML.g:1005:2: (this_Aspect_0= ruleAspect | this_Concept_1= ruleConcept )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==36) ) {
                alt9=1;
            }
            else if ( (LA9_0==37) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalOML.g:1006:3: this_Aspect_0= ruleAspect
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
                    // InternalOML.g:1015:3: this_Concept_1= ruleConcept
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
    // InternalOML.g:1027:1: entryRuleEntityRelationship returns [EObject current=null] : iv_ruleEntityRelationship= ruleEntityRelationship EOF ;
    public final EObject entryRuleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRelationship = null;


        try {
            // InternalOML.g:1027:59: (iv_ruleEntityRelationship= ruleEntityRelationship EOF )
            // InternalOML.g:1028:2: iv_ruleEntityRelationship= ruleEntityRelationship EOF
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
    // InternalOML.g:1034:1: ruleEntityRelationship returns [EObject current=null] : (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) ;
    public final EObject ruleEntityRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_ReifiedRelationship_0 = null;

        EObject this_UnreifiedRelationship_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1040:2: ( (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship ) )
            // InternalOML.g:1041:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            {
            // InternalOML.g:1041:2: (this_ReifiedRelationship_0= ruleReifiedRelationship | this_UnreifiedRelationship_1= ruleUnreifiedRelationship )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==38) ) {
                alt10=1;
            }
            else if ( (LA10_0==52) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalOML.g:1042:3: this_ReifiedRelationship_0= ruleReifiedRelationship
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
                    // InternalOML.g:1051:3: this_UnreifiedRelationship_1= ruleUnreifiedRelationship
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
    // InternalOML.g:1063:1: entryRuleDatatype returns [EObject current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final EObject entryRuleDatatype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatype = null;


        try {
            // InternalOML.g:1063:49: (iv_ruleDatatype= ruleDatatype EOF )
            // InternalOML.g:1064:2: iv_ruleDatatype= ruleDatatype EOF
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
    // InternalOML.g:1070:1: ruleDatatype returns [EObject current=null] : (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) ;
    public final EObject ruleDatatype() throws RecognitionException {
        EObject current = null;

        EObject this_ScalarDataRange_0 = null;

        EObject this_Structure_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1076:2: ( (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure ) )
            // InternalOML.g:1077:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            {
            // InternalOML.g:1077:2: (this_ScalarDataRange_0= ruleScalarDataRange | this_Structure_1= ruleStructure )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==53||LA11_0==77||LA11_0==82||LA11_0==84||LA11_0==89||LA11_0==91||(LA11_0>=93 && LA11_0<=95)) ) {
                alt11=1;
            }
            else if ( (LA11_0==54) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOML.g:1078:3: this_ScalarDataRange_0= ruleScalarDataRange
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
                    // InternalOML.g:1087:3: this_Structure_1= ruleStructure
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
    // InternalOML.g:1099:1: entryRuleScalarDataRange returns [EObject current=null] : iv_ruleScalarDataRange= ruleScalarDataRange EOF ;
    public final EObject entryRuleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataRange = null;


        try {
            // InternalOML.g:1099:56: (iv_ruleScalarDataRange= ruleScalarDataRange EOF )
            // InternalOML.g:1100:2: iv_ruleScalarDataRange= ruleScalarDataRange EOF
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
    // InternalOML.g:1106:1: ruleScalarDataRange returns [EObject current=null] : (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) ;
    public final EObject ruleScalarDataRange() throws RecognitionException {
        EObject current = null;

        EObject this_Scalar_0 = null;

        EObject this_RestrictedDataRange_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1112:2: ( (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange ) )
            // InternalOML.g:1113:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            {
            // InternalOML.g:1113:2: (this_Scalar_0= ruleScalar | this_RestrictedDataRange_1= ruleRestrictedDataRange )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==53) ) {
                alt12=1;
            }
            else if ( (LA12_0==77||LA12_0==82||LA12_0==84||LA12_0==89||LA12_0==91||(LA12_0>=93 && LA12_0<=95)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOML.g:1114:3: this_Scalar_0= ruleScalar
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
                    // InternalOML.g:1123:3: this_RestrictedDataRange_1= ruleRestrictedDataRange
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
    // InternalOML.g:1135:1: entryRuleRestrictedDataRange returns [EObject current=null] : iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF ;
    public final EObject entryRuleRestrictedDataRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestrictedDataRange = null;


        try {
            // InternalOML.g:1135:60: (iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF )
            // InternalOML.g:1136:2: iv_ruleRestrictedDataRange= ruleRestrictedDataRange EOF
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
    // InternalOML.g:1142:1: ruleRestrictedDataRange returns [EObject current=null] : (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) ;
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
            // InternalOML.g:1148:2: ( (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction ) )
            // InternalOML.g:1149:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            {
            // InternalOML.g:1149:2: (this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction | this_IRIScalarRestriction_1= ruleIRIScalarRestriction | this_NumericScalarRestriction_2= ruleNumericScalarRestriction | this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction | this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction | this_StringScalarRestriction_5= ruleStringScalarRestriction | this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction | this_TimeScalarRestriction_7= ruleTimeScalarRestriction )
            int alt13=8;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt13=1;
                }
                break;
            case 82:
                {
                alt13=2;
                }
                break;
            case 84:
                {
                alt13=3;
                }
                break;
            case 89:
                {
                alt13=4;
                }
                break;
            case 91:
                {
                alt13=5;
                }
                break;
            case 93:
                {
                alt13=6;
                }
                break;
            case 94:
                {
                alt13=7;
                }
                break;
            case 95:
                {
                alt13=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOML.g:1150:3: this_BinaryScalarRestriction_0= ruleBinaryScalarRestriction
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
                    // InternalOML.g:1159:3: this_IRIScalarRestriction_1= ruleIRIScalarRestriction
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
                    // InternalOML.g:1168:3: this_NumericScalarRestriction_2= ruleNumericScalarRestriction
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
                    // InternalOML.g:1177:3: this_PlainLiteralScalarRestriction_3= rulePlainLiteralScalarRestriction
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
                    // InternalOML.g:1186:3: this_ScalarOneOfRestriction_4= ruleScalarOneOfRestriction
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
                    // InternalOML.g:1195:3: this_StringScalarRestriction_5= ruleStringScalarRestriction
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
                    // InternalOML.g:1204:3: this_SynonymScalarRestriction_6= ruleSynonymScalarRestriction
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
                    // InternalOML.g:1213:3: this_TimeScalarRestriction_7= ruleTimeScalarRestriction
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
    // InternalOML.g:1225:1: entryRuleDataRelationship returns [EObject current=null] : iv_ruleDataRelationship= ruleDataRelationship EOF ;
    public final EObject entryRuleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataRelationship = null;


        try {
            // InternalOML.g:1225:57: (iv_ruleDataRelationship= ruleDataRelationship EOF )
            // InternalOML.g:1226:2: iv_ruleDataRelationship= ruleDataRelationship EOF
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
    // InternalOML.g:1232:1: ruleDataRelationship returns [EObject current=null] : (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) ;
    public final EObject ruleDataRelationship() throws RecognitionException {
        EObject current = null;

        EObject this_EntityStructuredDataProperty_0 = null;

        EObject this_EntityScalarDataProperty_1 = null;

        EObject this_StructuredDataProperty_2 = null;

        EObject this_ScalarDataProperty_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1238:2: ( (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty ) )
            // InternalOML.g:1239:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            {
            // InternalOML.g:1239:2: (this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty | this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty | this_StructuredDataProperty_2= ruleStructuredDataProperty | this_ScalarDataProperty_3= ruleScalarDataProperty )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt14=1;
                }
                break;
            case 59:
                {
                alt14=2;
                }
                break;
            case 60:
                {
                alt14=3;
                }
                break;
            case 61:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalOML.g:1240:3: this_EntityStructuredDataProperty_0= ruleEntityStructuredDataProperty
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
                    // InternalOML.g:1249:3: this_EntityScalarDataProperty_1= ruleEntityScalarDataProperty
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
                    // InternalOML.g:1258:3: this_StructuredDataProperty_2= ruleStructuredDataProperty
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
                    // InternalOML.g:1267:3: this_ScalarDataProperty_3= ruleScalarDataProperty
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
    // InternalOML.g:1279:1: entryRuleTermAxiom returns [EObject current=null] : iv_ruleTermAxiom= ruleTermAxiom EOF ;
    public final EObject entryRuleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermAxiom = null;


        try {
            // InternalOML.g:1279:50: (iv_ruleTermAxiom= ruleTermAxiom EOF )
            // InternalOML.g:1280:2: iv_ruleTermAxiom= ruleTermAxiom EOF
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
    // InternalOML.g:1286:1: ruleTermAxiom returns [EObject current=null] : (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom ) ;
    public final EObject ruleTermAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyRestrictionAxiom_1 = null;

        EObject this_ScalarOneOfLiteralAxiom_2 = null;

        EObject this_SpecializationAxiom_3 = null;



        	enterRule();

        try {
            // InternalOML.g:1292:2: ( (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom ) )
            // InternalOML.g:1293:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom )
            {
            // InternalOML.g:1293:2: (this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom | this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom | this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom | this_SpecializationAxiom_3= ruleSpecializationAxiom )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 67:
            case 70:
                {
                alt15=1;
                }
                break;
            case 74:
            case 75:
                {
                alt15=2;
                }
                break;
            case 92:
                {
                alt15=3;
                }
                break;
            case RULE_ABBREV_IRI:
            case RULE_IRI:
            case RULE_ID:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalOML.g:1294:3: this_EntityRestrictionAxiom_0= ruleEntityRestrictionAxiom
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
                    // InternalOML.g:1303:3: this_EntityScalarDataPropertyRestrictionAxiom_1= ruleEntityScalarDataPropertyRestrictionAxiom
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
                    // InternalOML.g:1312:3: this_ScalarOneOfLiteralAxiom_2= ruleScalarOneOfLiteralAxiom
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
                    // InternalOML.g:1321:3: this_SpecializationAxiom_3= ruleSpecializationAxiom
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
    // InternalOML.g:1333:1: entryRuleEntityRestrictionAxiom returns [EObject current=null] : iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF ;
    public final EObject entryRuleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityRestrictionAxiom = null;


        try {
            // InternalOML.g:1333:63: (iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF )
            // InternalOML.g:1334:2: iv_ruleEntityRestrictionAxiom= ruleEntityRestrictionAxiom EOF
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
    // InternalOML.g:1340:1: ruleEntityRestrictionAxiom returns [EObject current=null] : (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityExistentialRestrictionAxiom_0 = null;

        EObject this_EntityUniversalRestrictionAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1346:2: ( (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom ) )
            // InternalOML.g:1347:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            {
            // InternalOML.g:1347:2: (this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom | this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==67) ) {
                alt16=1;
            }
            else if ( (LA16_0==70) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOML.g:1348:3: this_EntityExistentialRestrictionAxiom_0= ruleEntityExistentialRestrictionAxiom
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
                    // InternalOML.g:1357:3: this_EntityUniversalRestrictionAxiom_1= ruleEntityUniversalRestrictionAxiom
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
    // InternalOML.g:1369:1: entryRuleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyRestrictionAxiom = null;


        try {
            // InternalOML.g:1369:81: (iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF )
            // InternalOML.g:1370:2: iv_ruleEntityScalarDataPropertyRestrictionAxiom= ruleEntityScalarDataPropertyRestrictionAxiom EOF
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
    // InternalOML.g:1376:1: ruleEntityScalarDataPropertyRestrictionAxiom returns [EObject current=null] : (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) ;
    public final EObject ruleEntityScalarDataPropertyRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_EntityScalarDataPropertyExistentialRestrictionAxiom_0 = null;

        EObject this_EntityScalarDataPropertyParticularRestrictionAxiom_1 = null;

        EObject this_EntityScalarDataPropertyUniversalRestrictionAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1382:2: ( (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom ) )
            // InternalOML.g:1383:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            {
            // InternalOML.g:1383:2: (this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom | this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom | this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==74) ) {
                alt17=1;
            }
            else if ( (LA17_0==75) ) {
                switch ( input.LA(2) ) {
                case RULE_IRI:
                    {
                    int LA17_3 = input.LA(3);

                    if ( (LA17_3==68) ) {
                        alt17=3;
                    }
                    else if ( (LA17_3==76) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA17_4 = input.LA(3);

                    if ( (LA17_4==68) ) {
                        alt17=3;
                    }
                    else if ( (LA17_4==76) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                    {
                    int LA17_5 = input.LA(3);

                    if ( (LA17_5==68) ) {
                        alt17=3;
                    }
                    else if ( (LA17_5==76) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOML.g:1384:3: this_EntityScalarDataPropertyExistentialRestrictionAxiom_0= ruleEntityScalarDataPropertyExistentialRestrictionAxiom
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
                    // InternalOML.g:1393:3: this_EntityScalarDataPropertyParticularRestrictionAxiom_1= ruleEntityScalarDataPropertyParticularRestrictionAxiom
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
                    // InternalOML.g:1402:3: this_EntityScalarDataPropertyUniversalRestrictionAxiom_2= ruleEntityScalarDataPropertyUniversalRestrictionAxiom
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
    // InternalOML.g:1414:1: entryRuleSpecializationAxiom returns [EObject current=null] : iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF ;
    public final EObject entryRuleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecializationAxiom = null;


        try {
            // InternalOML.g:1414:60: (iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF )
            // InternalOML.g:1415:2: iv_ruleSpecializationAxiom= ruleSpecializationAxiom EOF
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
    // InternalOML.g:1421:1: ruleSpecializationAxiom returns [EObject current=null] : (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) ;
    public final EObject ruleSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptSpecializationAxiom_0 = null;

        EObject this_AspectSpecializationAxiom_1 = null;

        EObject this_ReifiedRelationshipSpecializationAxiom_2 = null;



        	enterRule();

        try {
            // InternalOML.g:1427:2: ( (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom ) )
            // InternalOML.g:1428:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            {
            // InternalOML.g:1428:2: (this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom | this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom | this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_IRI:
                {
                switch ( input.LA(2) ) {
                case 72:
                    {
                    alt18=1;
                    }
                    break;
                case 71:
                    {
                    alt18=2;
                    }
                    break;
                case 73:
                    {
                    alt18=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ABBREV_IRI:
                {
                switch ( input.LA(2) ) {
                case 72:
                    {
                    alt18=1;
                    }
                    break;
                case 71:
                    {
                    alt18=2;
                    }
                    break;
                case 73:
                    {
                    alt18=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 73:
                    {
                    alt18=3;
                    }
                    break;
                case 72:
                    {
                    alt18=1;
                    }
                    break;
                case 71:
                    {
                    alt18=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOML.g:1429:3: this_ConceptSpecializationAxiom_0= ruleConceptSpecializationAxiom
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
                    // InternalOML.g:1438:3: this_AspectSpecializationAxiom_1= ruleAspectSpecializationAxiom
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
                    // InternalOML.g:1447:3: this_ReifiedRelationshipSpecializationAxiom_2= ruleReifiedRelationshipSpecializationAxiom
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
    // InternalOML.g:1459:1: entryRuleTerminologyBundleStatement returns [EObject current=null] : iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF ;
    public final EObject entryRuleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleStatement = null;


        try {
            // InternalOML.g:1459:67: (iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF )
            // InternalOML.g:1460:2: iv_ruleTerminologyBundleStatement= ruleTerminologyBundleStatement EOF
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
    // InternalOML.g:1466:1: ruleTerminologyBundleStatement returns [EObject current=null] : this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom ;
    public final EObject ruleTerminologyBundleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_RootConceptTaxonomyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1472:2: (this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom )
            // InternalOML.g:1473:2: this_RootConceptTaxonomyAxiom_0= ruleRootConceptTaxonomyAxiom
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
    // InternalOML.g:1484:1: entryRuleTerminologyBundleAxiom returns [EObject current=null] : iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF ;
    public final EObject entryRuleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminologyBundleAxiom = null;


        try {
            // InternalOML.g:1484:63: (iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF )
            // InternalOML.g:1485:2: iv_ruleTerminologyBundleAxiom= ruleTerminologyBundleAxiom EOF
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
    // InternalOML.g:1491:1: ruleTerminologyBundleAxiom returns [EObject current=null] : this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom ;
    public final EObject ruleTerminologyBundleAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_BundledTerminologyAxiom_0 = null;



        	enterRule();

        try {
            // InternalOML.g:1497:2: (this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom )
            // InternalOML.g:1498:2: this_BundledTerminologyAxiom_0= ruleBundledTerminologyAxiom
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
    // InternalOML.g:1509:1: entryRuleDisjointUnionOfConceptsAxiom returns [EObject current=null] : iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF ;
    public final EObject entryRuleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjointUnionOfConceptsAxiom = null;


        try {
            // InternalOML.g:1509:69: (iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF )
            // InternalOML.g:1510:2: iv_ruleDisjointUnionOfConceptsAxiom= ruleDisjointUnionOfConceptsAxiom EOF
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
    // InternalOML.g:1516:1: ruleDisjointUnionOfConceptsAxiom returns [EObject current=null] : (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) ;
    public final EObject ruleDisjointUnionOfConceptsAxiom() throws RecognitionException {
        EObject current = null;

        EObject this_AnonymousConceptUnionAxiom_0 = null;

        EObject this_SpecificDisjointConceptAxiom_1 = null;



        	enterRule();

        try {
            // InternalOML.g:1522:2: ( (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom ) )
            // InternalOML.g:1523:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            {
            // InternalOML.g:1523:2: (this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom | this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==62) ) {
                alt19=1;
            }
            else if ( (LA19_0==66) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalOML.g:1524:3: this_AnonymousConceptUnionAxiom_0= ruleAnonymousConceptUnionAxiom
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
                    // InternalOML.g:1533:3: this_SpecificDisjointConceptAxiom_1= ruleSpecificDisjointConceptAxiom
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
    // InternalOML.g:1545:1: entryRuleAspect returns [EObject current=null] : iv_ruleAspect= ruleAspect EOF ;
    public final EObject entryRuleAspect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspect = null;


        try {
            // InternalOML.g:1545:47: (iv_ruleAspect= ruleAspect EOF )
            // InternalOML.g:1546:2: iv_ruleAspect= ruleAspect EOF
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
    // InternalOML.g:1552:1: ruleAspect returns [EObject current=null] : (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleAspect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1558:2: ( (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1559:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1559:2: (otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1560:3: otherlv_0= 'aspect' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getAspectAccess().getAspectKeyword_0());
            		
            // InternalOML.g:1564:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1565:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1565:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1566:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:1586:1: entryRuleConcept returns [EObject current=null] : iv_ruleConcept= ruleConcept EOF ;
    public final EObject entryRuleConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcept = null;


        try {
            // InternalOML.g:1586:48: (iv_ruleConcept= ruleConcept EOF )
            // InternalOML.g:1587:2: iv_ruleConcept= ruleConcept EOF
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
    // InternalOML.g:1593:1: ruleConcept returns [EObject current=null] : (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcept() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:1599:2: ( (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:1600:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:1600:2: (otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:1601:3: otherlv_0= 'concept' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptAccess().getConceptKeyword_0());
            		
            // InternalOML.g:1605:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1606:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1606:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1607:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:1627:1: entryRuleReifiedRelationship returns [EObject current=null] : iv_ruleReifiedRelationship= ruleReifiedRelationship EOF ;
    public final EObject entryRuleReifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationship = null;


        try {
            // InternalOML.g:1627:60: (iv_ruleReifiedRelationship= ruleReifiedRelationship EOF )
            // InternalOML.g:1628:2: iv_ruleReifiedRelationship= ruleReifiedRelationship EOF
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
    // InternalOML.g:1634:1: ruleReifiedRelationship returns [EObject current=null] : (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) ;
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
            // InternalOML.g:1640:2: ( (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' ) )
            // InternalOML.g:1641:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            {
            // InternalOML.g:1641:2: (otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}' )
            // InternalOML.g:1642:3: otherlv_0= 'reifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'unreified' otherlv_14= '=' ( (lv_unreifiedPropertyName_15_0= RULE_ID ) ) (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )? otherlv_19= 'source' otherlv_20= '=' ( ( ruleReference ) ) otherlv_22= 'target' otherlv_23= '=' ( ( ruleReference ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipAccess().getReifiedRelationshipKeyword_0());
            		
            // InternalOML.g:1646:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:1647:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:1647:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:1648:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getReifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:1668:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:1669:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:1669:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:1670:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:1673:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:1674:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:1674:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop20:
            do {
                int alt20=10;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // InternalOML.g:1675:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:1675:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:1676:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:1676:116: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:1677:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:1680:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:1680:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1680:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:1680:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:1680:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:1681:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,39,FOLLOW_20); 

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
            	    // InternalOML.g:1698:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:1698:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:1699:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:1699:116: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:1700:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:1703:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:1703:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1703:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:1703:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:1703:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:1704:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,40,FOLLOW_20); 

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
            	    // InternalOML.g:1721:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:1721:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:1722:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:1722:116: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:1723:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:1726:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:1726:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1726:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:1726:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:1726:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:1727:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,41,FOLLOW_20); 

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
            	    // InternalOML.g:1744:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:1744:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:1745:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:1745:116: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:1746:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:1749:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:1749:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1749:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:1749:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:1749:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:1750:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,42,FOLLOW_20); 

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
            	    // InternalOML.g:1767:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:1767:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:1768:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:1768:116: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:1769:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:1772:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:1772:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1772:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:1772:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:1772:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:1773:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,43,FOLLOW_20); 

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
            	    // InternalOML.g:1790:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:1790:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:1791:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:1791:116: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:1792:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:1795:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:1795:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1795:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:1795:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:1795:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:1796:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,44,FOLLOW_20); 

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
            	    // InternalOML.g:1813:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:1813:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:1814:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:1814:116: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:1815:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:1818:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:1818:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1818:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:1818:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:1818:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:1819:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,45,FOLLOW_20); 

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
            	    // InternalOML.g:1836:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:1836:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:1837:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:1837:116: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:1838:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:1841:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:1841:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1841:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:1841:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:1841:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:1842:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,46,FOLLOW_20); 

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
            	    // InternalOML.g:1859:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:1859:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:1860:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:1860:116: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:1861:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:1864:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:1864:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReifiedRelationship", "true");
            	    }
            	    // InternalOML.g:1864:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:1864:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:1864:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:1865:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,47,FOLLOW_20); 

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
            	    break loop20;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3());
            				

            }

            otherlv_13=(Token)match(input,48,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getReifiedRelationshipAccess().getUnreifiedKeyword_4());
            		
            otherlv_14=(Token)match(input,22,FOLLOW_19); 

            			newLeafNode(otherlv_14, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:1897:3: ( (lv_unreifiedPropertyName_15_0= RULE_ID ) )
            // InternalOML.g:1898:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            {
            // InternalOML.g:1898:4: (lv_unreifiedPropertyName_15_0= RULE_ID )
            // InternalOML.g:1899:5: lv_unreifiedPropertyName_15_0= RULE_ID
            {
            lv_unreifiedPropertyName_15_0=(Token)match(input,RULE_ID,FOLLOW_21); 

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

            // InternalOML.g:1915:3: (otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==49) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOML.g:1916:4: otherlv_16= 'inverse' otherlv_17= '=' ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    {
                    otherlv_16=(Token)match(input,49,FOLLOW_5); 

                    				newLeafNode(otherlv_16, grammarAccess.getReifiedRelationshipAccess().getInverseKeyword_7_0());
                    			
                    otherlv_17=(Token)match(input,22,FOLLOW_19); 

                    				newLeafNode(otherlv_17, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_7_1());
                    			
                    // InternalOML.g:1924:4: ( (lv_unreifiedInversePropertyName_18_0= RULE_ID ) )
                    // InternalOML.g:1925:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    {
                    // InternalOML.g:1925:5: (lv_unreifiedInversePropertyName_18_0= RULE_ID )
                    // InternalOML.g:1926:6: lv_unreifiedInversePropertyName_18_0= RULE_ID
                    {
                    lv_unreifiedInversePropertyName_18_0=(Token)match(input,RULE_ID,FOLLOW_22); 

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
            		
            otherlv_20=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_20, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_9());
            		
            // InternalOML.g:1951:3: ( ( ruleReference ) )
            // InternalOML.g:1952:4: ( ruleReference )
            {
            // InternalOML.g:1952:4: ( ruleReference )
            // InternalOML.g:1953:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getSourceEntityCrossReference_10_0());
            				
            pushFollow(FOLLOW_23);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_22=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_22, grammarAccess.getReifiedRelationshipAccess().getTargetKeyword_11());
            		
            otherlv_23=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_23, grammarAccess.getReifiedRelationshipAccess().getEqualsSignKeyword_12());
            		
            // InternalOML.g:1975:3: ( ( ruleReference ) )
            // InternalOML.g:1976:4: ( ruleReference )
            {
            // InternalOML.g:1976:4: ( ruleReference )
            // InternalOML.g:1977:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipAccess().getTargetEntityCrossReference_13_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:1999:1: entryRuleUnreifiedRelationship returns [EObject current=null] : iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF ;
    public final EObject entryRuleUnreifiedRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationship = null;


        try {
            // InternalOML.g:1999:62: (iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF )
            // InternalOML.g:2000:2: iv_ruleUnreifiedRelationship= ruleUnreifiedRelationship EOF
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
    // InternalOML.g:2006:1: ruleUnreifiedRelationship returns [EObject current=null] : (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) ;
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
            // InternalOML.g:2012:2: ( (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' ) )
            // InternalOML.g:2013:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            {
            // InternalOML.g:2013:2: (otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}' )
            // InternalOML.g:2014:3: otherlv_0= 'unreifiedRelationship' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) ) otherlv_13= 'source' otherlv_14= '=' ( ( ruleReference ) ) otherlv_16= 'target' otherlv_17= '=' ( ( ruleReference ) ) otherlv_19= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipAccess().getUnreifiedRelationshipKeyword_0());
            		
            // InternalOML.g:2018:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2019:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2019:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2020:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:2040:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) ) )
            // InternalOML.g:2041:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            {
            // InternalOML.g:2041:4: ( ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* ) )
            // InternalOML.g:2042:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:2045:5: ( ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )* )
            // InternalOML.g:2046:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            {
            // InternalOML.g:2046:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*
            loop22:
            do {
                int alt22=10;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // InternalOML.g:2047:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2047:4: ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) )
            	    // InternalOML.g:2048:5: {...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:2048:118: ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) )
            	    // InternalOML.g:2049:6: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:2052:9: ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) )
            	    // InternalOML.g:2052:10: {...}? => ( (lv_isFunctional_4_0= 'functional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2052:19: ( (lv_isFunctional_4_0= 'functional' ) )
            	    // InternalOML.g:2052:20: (lv_isFunctional_4_0= 'functional' )
            	    {
            	    // InternalOML.g:2052:20: (lv_isFunctional_4_0= 'functional' )
            	    // InternalOML.g:2053:10: lv_isFunctional_4_0= 'functional'
            	    {
            	    lv_isFunctional_4_0=(Token)match(input,39,FOLLOW_24); 

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
            	    // InternalOML.g:2070:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    {
            	    // InternalOML.g:2070:4: ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) )
            	    // InternalOML.g:2071:5: {...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:2071:118: ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) )
            	    // InternalOML.g:2072:6: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:2075:9: ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) )
            	    // InternalOML.g:2075:10: {...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2075:19: ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) )
            	    // InternalOML.g:2075:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    {
            	    // InternalOML.g:2075:20: (lv_isInverseFunctional_5_0= 'inverseFunctional' )
            	    // InternalOML.g:2076:10: lv_isInverseFunctional_5_0= 'inverseFunctional'
            	    {
            	    lv_isInverseFunctional_5_0=(Token)match(input,40,FOLLOW_24); 

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
            	    // InternalOML.g:2093:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2093:4: ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) )
            	    // InternalOML.g:2094:5: {...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:2094:118: ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) )
            	    // InternalOML.g:2095:6: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:2098:9: ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) )
            	    // InternalOML.g:2098:10: {...}? => ( (lv_isEssential_6_0= 'essential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2098:19: ( (lv_isEssential_6_0= 'essential' ) )
            	    // InternalOML.g:2098:20: (lv_isEssential_6_0= 'essential' )
            	    {
            	    // InternalOML.g:2098:20: (lv_isEssential_6_0= 'essential' )
            	    // InternalOML.g:2099:10: lv_isEssential_6_0= 'essential'
            	    {
            	    lv_isEssential_6_0=(Token)match(input,41,FOLLOW_24); 

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
            	    // InternalOML.g:2116:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    {
            	    // InternalOML.g:2116:4: ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) )
            	    // InternalOML.g:2117:5: {...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:2117:118: ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) )
            	    // InternalOML.g:2118:6: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:2121:9: ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) )
            	    // InternalOML.g:2121:10: {...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2121:19: ( (lv_isInverseEssential_7_0= 'inverseEssential' ) )
            	    // InternalOML.g:2121:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    {
            	    // InternalOML.g:2121:20: (lv_isInverseEssential_7_0= 'inverseEssential' )
            	    // InternalOML.g:2122:10: lv_isInverseEssential_7_0= 'inverseEssential'
            	    {
            	    lv_isInverseEssential_7_0=(Token)match(input,42,FOLLOW_24); 

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
            	    // InternalOML.g:2139:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2139:4: ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) )
            	    // InternalOML.g:2140:5: {...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:2140:118: ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) )
            	    // InternalOML.g:2141:6: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:2144:9: ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) )
            	    // InternalOML.g:2144:10: {...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2144:19: ( (lv_isSymmetric_8_0= 'symmetric' ) )
            	    // InternalOML.g:2144:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    {
            	    // InternalOML.g:2144:20: (lv_isSymmetric_8_0= 'symmetric' )
            	    // InternalOML.g:2145:10: lv_isSymmetric_8_0= 'symmetric'
            	    {
            	    lv_isSymmetric_8_0=(Token)match(input,43,FOLLOW_24); 

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
            	    // InternalOML.g:2162:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    {
            	    // InternalOML.g:2162:4: ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) )
            	    // InternalOML.g:2163:5: {...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // InternalOML.g:2163:118: ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) )
            	    // InternalOML.g:2164:6: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5);
            	    					
            	    // InternalOML.g:2167:9: ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) )
            	    // InternalOML.g:2167:10: {...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2167:19: ( (lv_isAsymmetric_9_0= 'asymmetric' ) )
            	    // InternalOML.g:2167:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    {
            	    // InternalOML.g:2167:20: (lv_isAsymmetric_9_0= 'asymmetric' )
            	    // InternalOML.g:2168:10: lv_isAsymmetric_9_0= 'asymmetric'
            	    {
            	    lv_isAsymmetric_9_0=(Token)match(input,44,FOLLOW_24); 

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
            	    // InternalOML.g:2185:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2185:4: ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) )
            	    // InternalOML.g:2186:5: {...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // InternalOML.g:2186:118: ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) )
            	    // InternalOML.g:2187:6: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6);
            	    					
            	    // InternalOML.g:2190:9: ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) )
            	    // InternalOML.g:2190:10: {...}? => ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2190:19: ( (lv_isReflexive_10_0= 'reflexive' ) )
            	    // InternalOML.g:2190:20: (lv_isReflexive_10_0= 'reflexive' )
            	    {
            	    // InternalOML.g:2190:20: (lv_isReflexive_10_0= 'reflexive' )
            	    // InternalOML.g:2191:10: lv_isReflexive_10_0= 'reflexive'
            	    {
            	    lv_isReflexive_10_0=(Token)match(input,45,FOLLOW_24); 

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
            	    // InternalOML.g:2208:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2208:4: ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) )
            	    // InternalOML.g:2209:5: {...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // InternalOML.g:2209:118: ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) )
            	    // InternalOML.g:2210:6: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7);
            	    					
            	    // InternalOML.g:2213:9: ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) )
            	    // InternalOML.g:2213:10: {...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2213:19: ( (lv_isIrreflexive_11_0= 'irreflexive' ) )
            	    // InternalOML.g:2213:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    {
            	    // InternalOML.g:2213:20: (lv_isIrreflexive_11_0= 'irreflexive' )
            	    // InternalOML.g:2214:10: lv_isIrreflexive_11_0= 'irreflexive'
            	    {
            	    lv_isIrreflexive_11_0=(Token)match(input,46,FOLLOW_24); 

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
            	    // InternalOML.g:2231:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    {
            	    // InternalOML.g:2231:4: ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) )
            	    // InternalOML.g:2232:5: {...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // InternalOML.g:2232:118: ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) )
            	    // InternalOML.g:2233:6: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8);
            	    					
            	    // InternalOML.g:2236:9: ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) )
            	    // InternalOML.g:2236:10: {...}? => ( (lv_isTransitive_12_0= 'transitive' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleUnreifiedRelationship", "true");
            	    }
            	    // InternalOML.g:2236:19: ( (lv_isTransitive_12_0= 'transitive' ) )
            	    // InternalOML.g:2236:20: (lv_isTransitive_12_0= 'transitive' )
            	    {
            	    // InternalOML.g:2236:20: (lv_isTransitive_12_0= 'transitive' )
            	    // InternalOML.g:2237:10: lv_isTransitive_12_0= 'transitive'
            	    {
            	    lv_isTransitive_12_0=(Token)match(input,47,FOLLOW_24); 

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
            	    break loop22;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3());
            				

            }

            otherlv_13=(Token)match(input,50,FOLLOW_5); 

            			newLeafNode(otherlv_13, grammarAccess.getUnreifiedRelationshipAccess().getSourceKeyword_4());
            		
            otherlv_14=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_14, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_5());
            		
            // InternalOML.g:2269:3: ( ( ruleReference ) )
            // InternalOML.g:2270:4: ( ruleReference )
            {
            // InternalOML.g:2270:4: ( ruleReference )
            // InternalOML.g:2271:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getSourceEntityCrossReference_6_0());
            				
            pushFollow(FOLLOW_23);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_16, grammarAccess.getUnreifiedRelationshipAccess().getTargetKeyword_7());
            		
            otherlv_17=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_17, grammarAccess.getUnreifiedRelationshipAccess().getEqualsSignKeyword_8());
            		
            // InternalOML.g:2293:3: ( ( ruleReference ) )
            // InternalOML.g:2294:4: ( ruleReference )
            {
            // InternalOML.g:2294:4: ( ruleReference )
            // InternalOML.g:2295:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipAccess().getTargetEntityCrossReference_9_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:2317:1: entryRuleScalar returns [EObject current=null] : iv_ruleScalar= ruleScalar EOF ;
    public final EObject entryRuleScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalar = null;


        try {
            // InternalOML.g:2317:47: (iv_ruleScalar= ruleScalar EOF )
            // InternalOML.g:2318:2: iv_ruleScalar= ruleScalar EOF
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
    // InternalOML.g:2324:1: ruleScalar returns [EObject current=null] : (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2330:2: ( (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2331:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2331:2: (otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2332:3: otherlv_0= 'scalar' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,53,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarAccess().getScalarKeyword_0());
            		
            // InternalOML.g:2336:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2337:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2337:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2338:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:2358:1: entryRuleStructure returns [EObject current=null] : iv_ruleStructure= ruleStructure EOF ;
    public final EObject entryRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructure = null;


        try {
            // InternalOML.g:2358:50: (iv_ruleStructure= ruleStructure EOF )
            // InternalOML.g:2359:2: iv_ruleStructure= ruleStructure EOF
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
    // InternalOML.g:2365:1: ruleStructure returns [EObject current=null] : (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOML.g:2371:2: ( (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalOML.g:2372:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalOML.g:2372:2: (otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalOML.g:2373:3: otherlv_0= 'structure' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStructureAccess().getStructureKeyword_0());
            		
            // InternalOML.g:2377:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2378:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2378:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2379:5: lv_name_1_0= RULE_ID
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
    // InternalOML.g:2399:1: entryRuleEntityStructuredDataProperty returns [EObject current=null] : iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF ;
    public final EObject entryRuleEntityStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityStructuredDataProperty = null;


        try {
            // InternalOML.g:2399:69: (iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF )
            // InternalOML.g:2400:2: iv_ruleEntityStructuredDataProperty= ruleEntityStructuredDataProperty EOF
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
    // InternalOML.g:2406:1: ruleEntityStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:2412:2: ( (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2413:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2413:2: (otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2414:3: otherlv_0= 'entityStructuredDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityStructuredDataPropertyAccess().getEntityStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2418:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==56) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOML.g:2419:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2419:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2420:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,56,FOLLOW_19); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityStructuredDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2432:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2433:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2433:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2434:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_3=(Token)match(input,25,FOLLOW_26); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,57,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityStructuredDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2458:3: ( ( ruleReference ) )
            // InternalOML.g:2459:4: ( ruleReference )
            {
            // InternalOML.g:2459:4: ( ruleReference )
            // InternalOML.g:2460:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getDomainEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityStructuredDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2478:3: ( ( ruleReference ) )
            // InternalOML.g:2479:4: ( ruleReference )
            {
            // InternalOML.g:2479:4: ( ruleReference )
            // InternalOML.g:2480:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityStructuredDataPropertyAccess().getRangeStructureCrossReference_7_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:2502:1: entryRuleEntityScalarDataProperty returns [EObject current=null] : iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF ;
    public final EObject entryRuleEntityScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataProperty = null;


        try {
            // InternalOML.g:2502:65: (iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF )
            // InternalOML.g:2503:2: iv_ruleEntityScalarDataProperty= ruleEntityScalarDataProperty EOF
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
    // InternalOML.g:2509:1: ruleEntityScalarDataProperty returns [EObject current=null] : (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:2515:2: ( (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:2516:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:2516:2: (otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:2517:3: otherlv_0= 'entityScalarDataProperty' ( (lv_isIdentityCriteria_1_0= '+' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyAccess().getEntityScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:2521:3: ( (lv_isIdentityCriteria_1_0= '+' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==56) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalOML.g:2522:4: (lv_isIdentityCriteria_1_0= '+' )
                    {
                    // InternalOML.g:2522:4: (lv_isIdentityCriteria_1_0= '+' )
                    // InternalOML.g:2523:5: lv_isIdentityCriteria_1_0= '+'
                    {
                    lv_isIdentityCriteria_1_0=(Token)match(input,56,FOLLOW_19); 

                    					newLeafNode(lv_isIdentityCriteria_1_0, grammarAccess.getEntityScalarDataPropertyAccess().getIsIdentityCriteriaPlusSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
                    					}
                    					setWithLastConsumed(current, "isIdentityCriteria", true, "+");
                    				

                    }


                    }
                    break;

            }

            // InternalOML.g:2535:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2536:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2536:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2537:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_3=(Token)match(input,25,FOLLOW_26); 

            			newLeafNode(otherlv_3, grammarAccess.getEntityScalarDataPropertyAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,57,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyAccess().getDomainKeyword_4());
            		
            // InternalOML.g:2561:3: ( ( ruleReference ) )
            // InternalOML.g:2562:4: ( ruleReference )
            {
            // InternalOML.g:2562:4: ( ruleReference )
            // InternalOML.g:2563:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getDomainEntityCrossReference_5_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getEntityScalarDataPropertyAccess().getRangeKeyword_6());
            		
            // InternalOML.g:2581:3: ( ( ruleReference ) )
            // InternalOML.g:2582:4: ( ruleReference )
            {
            // InternalOML.g:2582:4: ( ruleReference )
            // InternalOML.g:2583:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyAccess().getRangeDataRangeCrossReference_7_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:2605:1: entryRuleStructuredDataProperty returns [EObject current=null] : iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF ;
    public final EObject entryRuleStructuredDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataProperty = null;


        try {
            // InternalOML.g:2605:63: (iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF )
            // InternalOML.g:2606:2: iv_ruleStructuredDataProperty= ruleStructuredDataProperty EOF
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
    // InternalOML.g:2612:1: ruleStructuredDataProperty returns [EObject current=null] : (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:2618:2: ( (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:2619:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:2619:2: (otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:2620:3: otherlv_0= 'structuredDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStructuredDataPropertyAccess().getStructuredDataPropertyKeyword_0());
            		
            // InternalOML.g:2624:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2625:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2625:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2626:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,57,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getStructuredDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:2650:3: ( ( ruleReference ) )
            // InternalOML.g:2651:4: ( ruleReference )
            {
            // InternalOML.g:2651:4: ( ruleReference )
            // InternalOML.g:2652:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,58,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getStructuredDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:2670:3: ( ( ruleReference ) )
            // InternalOML.g:2671:4: ( ruleReference )
            {
            // InternalOML.g:2671:4: ( ruleReference )
            // InternalOML.g:2672:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStructuredDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStructuredDataPropertyAccess().getRangeStructureCrossReference_6_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:2694:1: entryRuleScalarDataProperty returns [EObject current=null] : iv_ruleScalarDataProperty= ruleScalarDataProperty EOF ;
    public final EObject entryRuleScalarDataProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataProperty = null;


        try {
            // InternalOML.g:2694:59: (iv_ruleScalarDataProperty= ruleScalarDataProperty EOF )
            // InternalOML.g:2695:2: iv_ruleScalarDataProperty= ruleScalarDataProperty EOF
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
    // InternalOML.g:2701:1: ruleScalarDataProperty returns [EObject current=null] : (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) ;
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
            // InternalOML.g:2707:2: ( (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' ) )
            // InternalOML.g:2708:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            {
            // InternalOML.g:2708:2: (otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}' )
            // InternalOML.g:2709:3: otherlv_0= 'scalarDataProperty' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'domain' ( ( ruleReference ) ) otherlv_5= 'range' ( ( ruleReference ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,61,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarDataPropertyAccess().getScalarDataPropertyKeyword_0());
            		
            // InternalOML.g:2713:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:2714:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:2714:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:2715:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_26); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarDataPropertyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,57,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarDataPropertyAccess().getDomainKeyword_3());
            		
            // InternalOML.g:2739:3: ( ( ruleReference ) )
            // InternalOML.g:2740:4: ( ruleReference )
            {
            // InternalOML.g:2740:4: ( ruleReference )
            // InternalOML.g:2741:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getDomainStructureCrossReference_4_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,58,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getScalarDataPropertyAccess().getRangeKeyword_5());
            		
            // InternalOML.g:2759:3: ( ( ruleReference ) )
            // InternalOML.g:2760:4: ( ruleReference )
            {
            // InternalOML.g:2760:4: ( ruleReference )
            // InternalOML.g:2761:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarDataPropertyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarDataPropertyAccess().getRangeDataRangeCrossReference_6_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:2783:1: entryRuleAnonymousConceptUnionAxiom returns [EObject current=null] : iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF ;
    public final EObject entryRuleAnonymousConceptUnionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousConceptUnionAxiom = null;


        try {
            // InternalOML.g:2783:67: (iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF )
            // InternalOML.g:2784:2: iv_ruleAnonymousConceptUnionAxiom= ruleAnonymousConceptUnionAxiom EOF
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
    // InternalOML.g:2790:1: ruleAnonymousConceptUnionAxiom returns [EObject current=null] : (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:2796:2: ( (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:2797:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:2797:2: (otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:2798:3: otherlv_0= 'anonymousConceptUnion' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getAnonymousConceptUnionAxiomAccess().getAnonymousConceptUnionKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:2806:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:2807:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:2807:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:2808:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_29); 

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

            otherlv_3=(Token)match(input,64,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getAnonymousConceptUnionAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_4, grammarAccess.getAnonymousConceptUnionAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:2832:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==62||LA25_0==66) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOML.g:2833:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:2833:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:2834:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getAnonymousConceptUnionAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_30);
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
            	    break loop25;
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
    // InternalOML.g:2859:1: entryRuleRootConceptTaxonomyAxiom returns [EObject current=null] : iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF ;
    public final EObject entryRuleRootConceptTaxonomyAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootConceptTaxonomyAxiom = null;


        try {
            // InternalOML.g:2859:65: (iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF )
            // InternalOML.g:2860:2: iv_ruleRootConceptTaxonomyAxiom= ruleRootConceptTaxonomyAxiom EOF
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
    // InternalOML.g:2866:1: ruleRootConceptTaxonomyAxiom returns [EObject current=null] : (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) ;
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
            // InternalOML.g:2872:2: ( (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' ) )
            // InternalOML.g:2873:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            {
            // InternalOML.g:2873:2: (otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}' )
            // InternalOML.g:2874:3: otherlv_0= 'rootConceptTaxonomy' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptTaxonomyKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:2882:3: ( ( ruleReference ) )
            // InternalOML.g:2883:4: ( ruleReference )
            {
            // InternalOML.g:2883:4: ( ruleReference )
            // InternalOML.g:2884:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRootConceptTaxonomyAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getRootConceptCrossReference_2_0());
            				
            pushFollow(FOLLOW_29);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getRootConceptTaxonomyAxiomAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_30); 

            			newLeafNode(otherlv_4, grammarAccess.getRootConceptTaxonomyAxiomAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:2906:3: ( (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==62||LA26_0==66) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOML.g:2907:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    {
            	    // InternalOML.g:2907:4: (lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom )
            	    // InternalOML.g:2908:5: lv_disjunctions_5_0= ruleDisjointUnionOfConceptsAxiom
            	    {

            	    					newCompositeNode(grammarAccess.getRootConceptTaxonomyAxiomAccess().getDisjunctionsDisjointUnionOfConceptsAxiomParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_30);
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
            	    break loop26;
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
    // InternalOML.g:2933:1: entryRuleSpecificDisjointConceptAxiom returns [EObject current=null] : iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF ;
    public final EObject entryRuleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDisjointConceptAxiom = null;


        try {
            // InternalOML.g:2933:69: (iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF )
            // InternalOML.g:2934:2: iv_ruleSpecificDisjointConceptAxiom= ruleSpecificDisjointConceptAxiom EOF
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
    // InternalOML.g:2940:1: ruleSpecificDisjointConceptAxiom returns [EObject current=null] : (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) ;
    public final EObject ruleSpecificDisjointConceptAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalOML.g:2946:2: ( (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' ) )
            // InternalOML.g:2947:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            {
            // InternalOML.g:2947:2: (otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' )
            // InternalOML.g:2948:3: otherlv_0= 'disjointLeaf' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getSpecificDisjointConceptAxiomAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:2956:3: ( ( ruleReference ) )
            // InternalOML.g:2957:4: ( ruleReference )
            {
            // InternalOML.g:2957:4: ( ruleReference )
            // InternalOML.g:2958:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSpecificDisjointConceptAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSpecificDisjointConceptAxiomAccess().getDisjointLeafConceptCrossReference_2_0());
            				
            pushFollow(FOLLOW_29);
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
    // InternalOML.g:2980:1: entryRuleEntityExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:2980:74: (iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF )
            // InternalOML.g:2981:2: iv_ruleEntityExistentialRestrictionAxiom= ruleEntityExistentialRestrictionAxiom EOF
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
    // InternalOML.g:2987:1: ruleEntityExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:2993:2: ( (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:2994:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:2994:2: (otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:2995:3: otherlv_0= 'someEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getSomeEntitiesKeyword_0());
            		
            // InternalOML.g:2999:3: ( ( ruleReference ) )
            // InternalOML.g:3000:4: ( ruleReference )
            {
            // InternalOML.g:3000:4: ( ruleReference )
            // InternalOML.g:3001:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3019:3: ( ( ruleReference ) )
            // InternalOML.g:3020:4: ( ruleReference )
            {
            // InternalOML.g:3020:4: ( ruleReference )
            // InternalOML.g:3021:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityExistentialRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3039:3: ( ( ruleReference ) )
            // InternalOML.g:3040:4: ( ruleReference )
            {
            // InternalOML.g:3040:4: ( ruleReference )
            // InternalOML.g:3041:5: ruleReference
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
    // InternalOML.g:3059:1: entryRuleEntityUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3059:72: (iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF )
            // InternalOML.g:3060:2: iv_ruleEntityUniversalRestrictionAxiom= ruleEntityUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3066:1: ruleEntityUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3072:2: ( (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3073:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3073:2: (otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3074:3: otherlv_0= 'allEntities' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,70,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getAllEntitiesKeyword_0());
            		
            // InternalOML.g:3078:3: ( ( ruleReference ) )
            // InternalOML.g:3079:4: ( ruleReference )
            {
            // InternalOML.g:3079:4: ( ruleReference )
            // InternalOML.g:3080:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedDomainEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3098:3: ( ( ruleReference ) )
            // InternalOML.g:3099:4: ( ruleReference )
            {
            // InternalOML.g:3099:4: ( ruleReference )
            // InternalOML.g:3100:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityUniversalRestrictionAxiomAccess().getRestrictedRelationReifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3118:3: ( ( ruleReference ) )
            // InternalOML.g:3119:4: ( ruleReference )
            {
            // InternalOML.g:3119:4: ( ruleReference )
            // InternalOML.g:3120:5: ruleReference
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
    // InternalOML.g:3138:1: entryRuleAspectSpecializationAxiom returns [EObject current=null] : iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF ;
    public final EObject entryRuleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAspectSpecializationAxiom = null;


        try {
            // InternalOML.g:3138:66: (iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF )
            // InternalOML.g:3139:2: iv_ruleAspectSpecializationAxiom= ruleAspectSpecializationAxiom EOF
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
    // InternalOML.g:3145:1: ruleAspectSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) ;
    public final EObject ruleAspectSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3151:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) ) )
            // InternalOML.g:3152:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3152:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) ) )
            // InternalOML.g:3153:3: ( ( ruleReference ) ) otherlv_1= 'extendsAspect' ( ( ruleReference ) )
            {
            // InternalOML.g:3153:3: ( ( ruleReference ) )
            // InternalOML.g:3154:4: ( ruleReference )
            {
            // InternalOML.g:3154:4: ( ruleReference )
            // InternalOML.g:3155:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAspectSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAspectSpecializationAxiomAccess().getSubEntityEntityCrossReference_0_0());
            				
            pushFollow(FOLLOW_33);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,71,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getAspectSpecializationAxiomAccess().getExtendsAspectKeyword_1());
            		
            // InternalOML.g:3173:3: ( ( ruleReference ) )
            // InternalOML.g:3174:4: ( ruleReference )
            {
            // InternalOML.g:3174:4: ( ruleReference )
            // InternalOML.g:3175:5: ruleReference
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
    // InternalOML.g:3193:1: entryRuleConceptSpecializationAxiom returns [EObject current=null] : iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF ;
    public final EObject entryRuleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptSpecializationAxiom = null;


        try {
            // InternalOML.g:3193:67: (iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF )
            // InternalOML.g:3194:2: iv_ruleConceptSpecializationAxiom= ruleConceptSpecializationAxiom EOF
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
    // InternalOML.g:3200:1: ruleConceptSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) ;
    public final EObject ruleConceptSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3206:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) ) )
            // InternalOML.g:3207:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3207:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) ) )
            // InternalOML.g:3208:3: ( ( ruleReference ) ) otherlv_1= 'extendsConcept' ( ( ruleReference ) )
            {
            // InternalOML.g:3208:3: ( ( ruleReference ) )
            // InternalOML.g:3209:4: ( ruleReference )
            {
            // InternalOML.g:3209:4: ( ruleReference )
            // InternalOML.g:3210:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptSpecializationAxiomAccess().getSubConceptConceptCrossReference_0_0());
            				
            pushFollow(FOLLOW_34);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptSpecializationAxiomAccess().getExtendsConceptKeyword_1());
            		
            // InternalOML.g:3228:3: ( ( ruleReference ) )
            // InternalOML.g:3229:4: ( ruleReference )
            {
            // InternalOML.g:3229:4: ( ruleReference )
            // InternalOML.g:3230:5: ruleReference
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
    // InternalOML.g:3248:1: entryRuleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF ;
    public final EObject entryRuleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipSpecializationAxiom = null;


        try {
            // InternalOML.g:3248:79: (iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF )
            // InternalOML.g:3249:2: iv_ruleReifiedRelationshipSpecializationAxiom= ruleReifiedRelationshipSpecializationAxiom EOF
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
    // InternalOML.g:3255:1: ruleReifiedRelationshipSpecializationAxiom returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipSpecializationAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOML.g:3261:2: ( ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) ) )
            // InternalOML.g:3262:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3262:2: ( ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) ) )
            // InternalOML.g:3263:3: ( ( ruleReference ) ) otherlv_1= 'extendsRelationship' ( ( ruleReference ) )
            {
            // InternalOML.g:3263:3: ( ( ruleReference ) )
            // InternalOML.g:3264:4: ( ruleReference )
            {
            // InternalOML.g:3264:4: ( ruleReference )
            // InternalOML.g:3265:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipSpecializationAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getSubRelationshipReifiedRelationshipCrossReference_0_0());
            				
            pushFollow(FOLLOW_35);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,73,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipSpecializationAxiomAccess().getExtendsRelationshipKeyword_1());
            		
            // InternalOML.g:3283:3: ( ( ruleReference ) )
            // InternalOML.g:3284:4: ( ruleReference )
            {
            // InternalOML.g:3284:4: ( ruleReference )
            // InternalOML.g:3285:5: ruleReference
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
    // InternalOML.g:3303:1: entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom = null;


        try {
            // InternalOML.g:3303:92: (iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF )
            // InternalOML.g:3304:2: iv_ruleEntityScalarDataPropertyExistentialRestrictionAxiom= ruleEntityScalarDataPropertyExistentialRestrictionAxiom EOF
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
    // InternalOML.g:3310:1: ruleEntityScalarDataPropertyExistentialRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyExistentialRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3316:2: ( (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3317:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3317:2: (otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3318:3: otherlv_0= 'someData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getSomeDataKeyword_0());
            		
            // InternalOML.g:3322:3: ( ( ruleReference ) )
            // InternalOML.g:3323:4: ( ruleReference )
            {
            // InternalOML.g:3323:4: ( ruleReference )
            // InternalOML.g:3324:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3342:3: ( ( ruleReference ) )
            // InternalOML.g:3343:4: ( ruleReference )
            {
            // InternalOML.g:3343:4: ( ruleReference )
            // InternalOML.g:3344:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyExistentialRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3362:3: ( ( ruleReference ) )
            // InternalOML.g:3363:4: ( ruleReference )
            {
            // InternalOML.g:3363:4: ( ruleReference )
            // InternalOML.g:3364:5: ruleReference
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
    // InternalOML.g:3382:1: entryRuleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom = null;


        try {
            // InternalOML.g:3382:91: (iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF )
            // InternalOML.g:3383:2: iv_ruleEntityScalarDataPropertyParticularRestrictionAxiom= ruleEntityScalarDataPropertyParticularRestrictionAxiom EOF
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
    // InternalOML.g:3389:1: ruleEntityScalarDataPropertyParticularRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyParticularRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_literalValue_5_0=null;


        	enterRule();

        try {
            // InternalOML.g:3395:2: ( (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) ) )
            // InternalOML.g:3396:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) )
            {
            // InternalOML.g:3396:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) ) )
            // InternalOML.g:3397:3: otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= ',' ( ( ruleReference ) ) otherlv_4= '=' ( (lv_literalValue_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getAllDataKeyword_0());
            		
            // InternalOML.g:3401:3: ( ( ruleReference ) )
            // InternalOML.g:3402:4: ( ruleReference )
            {
            // InternalOML.g:3402:4: ( ruleReference )
            // InternalOML.g:3403:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_36);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,76,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyParticularRestrictionAxiomAccess().getCommaKeyword_2());
            		
            // InternalOML.g:3421:3: ( ( ruleReference ) )
            // InternalOML.g:3422:4: ( ruleReference )
            {
            // InternalOML.g:3422:4: ( ruleReference )
            // InternalOML.g:3423:5: ruleReference
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
            		
            // InternalOML.g:3441:3: ( (lv_literalValue_5_0= RULE_STRING ) )
            // InternalOML.g:3442:4: (lv_literalValue_5_0= RULE_STRING )
            {
            // InternalOML.g:3442:4: (lv_literalValue_5_0= RULE_STRING )
            // InternalOML.g:3443:5: lv_literalValue_5_0= RULE_STRING
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
    // InternalOML.g:3463:1: entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF ;
    public final EObject entryRuleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom = null;


        try {
            // InternalOML.g:3463:90: (iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF )
            // InternalOML.g:3464:2: iv_ruleEntityScalarDataPropertyUniversalRestrictionAxiom= ruleEntityScalarDataPropertyUniversalRestrictionAxiom EOF
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
    // InternalOML.g:3470:1: ruleEntityScalarDataPropertyUniversalRestrictionAxiom returns [EObject current=null] : (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) ;
    public final EObject ruleEntityScalarDataPropertyUniversalRestrictionAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:3476:2: ( (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) ) )
            // InternalOML.g:3477:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            {
            // InternalOML.g:3477:2: (otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) ) )
            // InternalOML.g:3478:3: otherlv_0= 'allData' ( ( ruleReference ) ) otherlv_2= '.' ( ( ruleReference ) ) otherlv_4= 'in' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,75,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getAllDataKeyword_0());
            		
            // InternalOML.g:3482:3: ( ( ruleReference ) )
            // InternalOML.g:3483:4: ( ruleReference )
            {
            // InternalOML.g:3483:4: ( ruleReference )
            // InternalOML.g:3484:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getRestrictedEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getFullStopKeyword_2());
            		
            // InternalOML.g:3502:3: ( ( ruleReference ) )
            // InternalOML.g:3503:4: ( ruleReference )
            {
            // InternalOML.g:3503:4: ( ruleReference )
            // InternalOML.g:3504:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getScalarPropertyEntityScalarDataPropertyCrossReference_3_0());
            				
            pushFollow(FOLLOW_32);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,69,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getEntityScalarDataPropertyUniversalRestrictionAxiomAccess().getInKeyword_4());
            		
            // InternalOML.g:3522:3: ( ( ruleReference ) )
            // InternalOML.g:3523:4: ( ruleReference )
            {
            // InternalOML.g:3523:4: ( ruleReference )
            // InternalOML.g:3524:5: ruleReference
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
    // InternalOML.g:3542:1: entryRuleBinaryScalarRestriction returns [EObject current=null] : iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF ;
    public final EObject entryRuleBinaryScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryScalarRestriction = null;


        try {
            // InternalOML.g:3542:64: (iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF )
            // InternalOML.g:3543:2: iv_ruleBinaryScalarRestriction= ruleBinaryScalarRestriction EOF
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
    // InternalOML.g:3549:1: ruleBinaryScalarRestriction returns [EObject current=null] : (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) ;
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
            // InternalOML.g:3555:2: ( (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' ) )
            // InternalOML.g:3556:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            {
            // InternalOML.g:3556:2: (otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}' )
            // InternalOML.g:3557:3: otherlv_0= 'binaryScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) ) otherlv_10= 'restrictedRange' ( ( ruleReference ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryScalarRestrictionAccess().getBinaryScalarRestrictionKeyword_0());
            		
            // InternalOML.g:3561:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3562:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3562:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3563:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getBinaryScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:3583:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:3584:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:3584:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* ) )
            // InternalOML.g:3585:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:3588:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )* )
            // InternalOML.g:3589:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            {
            // InternalOML.g:3589:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) )*
            loop27:
            do {
                int alt27=4;
                int LA27_0 = input.LA(1);

                if ( LA27_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt27=1;
                }
                else if ( LA27_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt27=2;
                }
                else if ( LA27_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt27=3;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOML.g:3590:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3590:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3591:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:3591:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3592:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:3595:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3595:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3595:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:3595:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_38); 

            	    									newLeafNode(otherlv_4, grammarAccess.getBinaryScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:3599:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:3600:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:3600:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:3601:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_37); 

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
            	    // InternalOML.g:3623:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3623:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3624:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:3624:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3625:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:3628:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3628:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3628:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:3628:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_38); 

            	    									newLeafNode(otherlv_6, grammarAccess.getBinaryScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:3632:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:3633:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:3633:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:3634:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_37); 

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
            	    // InternalOML.g:3656:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3656:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3657:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:3657:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3658:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:3661:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3661:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBinaryScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3661:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:3661:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_38); 

            	    									newLeafNode(otherlv_8, grammarAccess.getBinaryScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:3665:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:3666:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:3666:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:3667:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_37); 

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
            	    break loop27;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBinaryScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_10=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_10, grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:3700:3: ( ( ruleReference ) )
            // InternalOML.g:3701:4: ( ruleReference )
            {
            // InternalOML.g:3701:4: ( ruleReference )
            // InternalOML.g:3702:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBinaryScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBinaryScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:3724:1: entryRuleIRIScalarRestriction returns [EObject current=null] : iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF ;
    public final EObject entryRuleIRIScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIRIScalarRestriction = null;


        try {
            // InternalOML.g:3724:61: (iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF )
            // InternalOML.g:3725:2: iv_ruleIRIScalarRestriction= ruleIRIScalarRestriction EOF
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
    // InternalOML.g:3731:1: ruleIRIScalarRestriction returns [EObject current=null] : (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:3737:2: ( (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:3738:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:3738:2: (otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:3739:3: otherlv_0= 'iriScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getIRIScalarRestrictionAccess().getIriScalarRestrictionKeyword_0());
            		
            // InternalOML.g:3743:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3744:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3744:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3745:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getIRIScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:3765:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:3766:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:3766:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:3767:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:3770:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:3771:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:3771:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop28:
            do {
                int alt28=5;
                int LA28_0 = input.LA(1);

                if ( LA28_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt28=1;
                }
                else if ( LA28_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt28=2;
                }
                else if ( LA28_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt28=3;
                }
                else if ( LA28_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt28=4;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOML.g:3772:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3772:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3773:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:3773:117: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3774:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:3777:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3777:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3777:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:3777:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_38); 

            	    									newLeafNode(otherlv_4, grammarAccess.getIRIScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:3781:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:3782:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:3782:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:3783:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:3805:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3805:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3806:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:3806:117: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3807:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:3810:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3810:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3810:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:3810:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_38); 

            	    									newLeafNode(otherlv_6, grammarAccess.getIRIScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:3814:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:3815:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:3815:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:3816:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:3838:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3838:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:3839:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:3839:117: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:3840:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:3843:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:3843:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3843:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:3843:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_38); 

            	    									newLeafNode(otherlv_8, grammarAccess.getIRIScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:3847:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:3848:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:3848:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:3849:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:3871:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3871:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:3872:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:3872:117: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:3873:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:3876:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:3876:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleIRIScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3876:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:3876:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getIRIScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:3880:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:3881:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:3881:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:3882:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_39); 

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
            	    break loop28;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getIRIScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:3915:3: ( ( ruleReference ) )
            // InternalOML.g:3916:4: ( ruleReference )
            {
            // InternalOML.g:3916:4: ( ruleReference )
            // InternalOML.g:3917:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIRIScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getIRIScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:3939:1: entryRuleNumericScalarRestriction returns [EObject current=null] : iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF ;
    public final EObject entryRuleNumericScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericScalarRestriction = null;


        try {
            // InternalOML.g:3939:65: (iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF )
            // InternalOML.g:3940:2: iv_ruleNumericScalarRestriction= ruleNumericScalarRestriction EOF
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
    // InternalOML.g:3946:1: ruleNumericScalarRestriction returns [EObject current=null] : (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:3952:2: ( (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:3953:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:3953:2: (otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:3954:3: otherlv_0= 'numericScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericScalarRestrictionAccess().getNumericScalarRestrictionKeyword_0());
            		
            // InternalOML.g:3958:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:3959:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:3959:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:3960:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getNumericScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:3980:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:3981:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:3981:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:3982:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:3985:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:3986:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:3986:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop29:
            do {
                int alt29=5;
                int LA29_0 = input.LA(1);

                if ( LA29_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt29=1;
                }
                else if ( LA29_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt29=2;
                }
                else if ( LA29_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt29=3;
                }
                else if ( LA29_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt29=4;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOML.g:3987:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:3987:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:3988:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:3988:121: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:3989:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:3992:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:3992:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:3992:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:3992:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,85,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getNumericScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:3996:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:3997:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:3997:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:3998:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4020:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4020:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4021:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4021:121: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4022:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4025:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4025:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4025:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:4025:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getNumericScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4029:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:4030:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4030:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:4031:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4053:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4053:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4054:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4054:121: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4055:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4058:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4058:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4058:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:4058:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getNumericScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4062:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:4063:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4063:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:4064:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4086:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4086:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4087:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4087:121: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4088:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4091:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4091:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleNumericScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4091:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4091:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getNumericScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4095:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:4096:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4096:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:4097:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    break loop29;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getNumericScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4130:3: ( ( ruleReference ) )
            // InternalOML.g:4131:4: ( ruleReference )
            {
            // InternalOML.g:4131:4: ( ruleReference )
            // InternalOML.g:4132:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNumericScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getNumericScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:4154:1: entryRulePlainLiteralScalarRestriction returns [EObject current=null] : iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF ;
    public final EObject entryRulePlainLiteralScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlainLiteralScalarRestriction = null;


        try {
            // InternalOML.g:4154:70: (iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF )
            // InternalOML.g:4155:2: iv_rulePlainLiteralScalarRestriction= rulePlainLiteralScalarRestriction EOF
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
    // InternalOML.g:4161:1: rulePlainLiteralScalarRestriction returns [EObject current=null] : (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) ;
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
            // InternalOML.g:4167:2: ( (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' ) )
            // InternalOML.g:4168:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            {
            // InternalOML.g:4168:2: (otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}' )
            // InternalOML.g:4169:3: otherlv_0= 'plainLiteralScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_14= 'restrictedRange' ( ( ruleReference ) ) otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPlainLiteralScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4173:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4174:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4174:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4175:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4195:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4196:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4196:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4197:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4200:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4201:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4201:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) ) )*
            loop30:
            do {
                int alt30=6;
                int LA30_0 = input.LA(1);

                if ( LA30_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt30=1;
                }
                else if ( LA30_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt30=2;
                }
                else if ( LA30_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt30=3;
                }
                else if ( LA30_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt30=4;
                }
                else if ( LA30_0 == 90 && getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
                    alt30=5;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalOML.g:4202:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4202:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4203:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4203:126: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4204:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4207:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4207:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4207:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4207:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_38); 

            	    									newLeafNode(otherlv_4, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4211:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4212:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4212:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4213:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    // InternalOML.g:4235:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4235:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4236:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4236:126: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4237:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4240:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4240:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4240:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4240:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_38); 

            	    									newLeafNode(otherlv_6, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4244:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4245:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4245:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4246:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    // InternalOML.g:4268:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4268:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4269:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4269:126: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4270:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4273:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4273:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4273:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4273:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_38); 

            	    									newLeafNode(otherlv_8, grammarAccess.getPlainLiteralScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4277:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4278:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4278:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4279:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_41); 

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
            	    // InternalOML.g:4301:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4301:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4302:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4302:126: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4303:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4306:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4306:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4306:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4306:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getPlainLiteralScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4310:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4311:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4311:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4312:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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
            	    // InternalOML.g:4334:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4334:4: ({...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4335:5: {...}? => ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // InternalOML.g:4335:126: ( ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4336:6: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3(), 4);
            	    					
            	    // InternalOML.g:4339:9: ({...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4339:10: {...}? => (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "rulePlainLiteralScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4339:19: (otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) ) )
            	    // InternalOML.g:4339:20: otherlv_12= 'langRange' ( (lv_langRange_13_0= RULE_STRING ) )
            	    {
            	    otherlv_12=(Token)match(input,90,FOLLOW_7); 

            	    									newLeafNode(otherlv_12, grammarAccess.getPlainLiteralScalarRestrictionAccess().getLangRangeKeyword_3_4_0());
            	    								
            	    // InternalOML.g:4343:9: ( (lv_langRange_13_0= RULE_STRING ) )
            	    // InternalOML.g:4344:10: (lv_langRange_13_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4344:10: (lv_langRange_13_0= RULE_STRING )
            	    // InternalOML.g:4345:11: lv_langRange_13_0= RULE_STRING
            	    {
            	    lv_langRange_13_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

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
            	    break loop30;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPlainLiteralScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_14=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_14, grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4378:3: ( ( ruleReference ) )
            // InternalOML.g:4379:4: ( ruleReference )
            {
            // InternalOML.g:4379:4: ( ruleReference )
            // InternalOML.g:4380:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPlainLiteralScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPlainLiteralScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:4402:1: entryRuleScalarOneOfRestriction returns [EObject current=null] : iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF ;
    public final EObject entryRuleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfRestriction = null;


        try {
            // InternalOML.g:4402:63: (iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF )
            // InternalOML.g:4403:2: iv_ruleScalarOneOfRestriction= ruleScalarOneOfRestriction EOF
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
    // InternalOML.g:4409:1: ruleScalarOneOfRestriction returns [EObject current=null] : (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleScalarOneOfRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:4415:2: ( (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:4416:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:4416:2: (otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:4417:3: otherlv_0= 'scalarOneOfRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,91,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfRestrictionAccess().getScalarOneOfRestrictionKeyword_0());
            		
            // InternalOML.g:4421:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4422:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4422:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4423:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getScalarOneOfRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:4447:3: ( ( ruleReference ) )
            // InternalOML.g:4448:4: ( ruleReference )
            {
            // InternalOML.g:4448:4: ( ruleReference )
            // InternalOML.g:4449:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getScalarOneOfRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getScalarOneOfRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:4471:1: entryRuleScalarOneOfLiteralAxiom returns [EObject current=null] : iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF ;
    public final EObject entryRuleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarOneOfLiteralAxiom = null;


        try {
            // InternalOML.g:4471:64: (iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF )
            // InternalOML.g:4472:2: iv_ruleScalarOneOfLiteralAxiom= ruleScalarOneOfLiteralAxiom EOF
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
    // InternalOML.g:4478:1: ruleScalarOneOfLiteralAxiom returns [EObject current=null] : (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleScalarOneOfLiteralAxiom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;


        	enterRule();

        try {
            // InternalOML.g:4484:2: ( (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) ) )
            // InternalOML.g:4485:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            {
            // InternalOML.g:4485:2: (otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) ) )
            // InternalOML.g:4486:3: otherlv_0= 'oneOf' ( ( ruleReference ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,92,FOLLOW_15); 

            			newLeafNode(otherlv_0, grammarAccess.getScalarOneOfLiteralAxiomAccess().getOneOfKeyword_0());
            		
            // InternalOML.g:4490:3: ( ( ruleReference ) )
            // InternalOML.g:4491:4: ( ruleReference )
            {
            // InternalOML.g:4491:4: ( ruleReference )
            // InternalOML.g:4492:5: ruleReference
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
            		
            // InternalOML.g:4510:3: ( (lv_value_3_0= RULE_STRING ) )
            // InternalOML.g:4511:4: (lv_value_3_0= RULE_STRING )
            {
            // InternalOML.g:4511:4: (lv_value_3_0= RULE_STRING )
            // InternalOML.g:4512:5: lv_value_3_0= RULE_STRING
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
    // InternalOML.g:4532:1: entryRuleStringScalarRestriction returns [EObject current=null] : iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF ;
    public final EObject entryRuleStringScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringScalarRestriction = null;


        try {
            // InternalOML.g:4532:64: (iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF )
            // InternalOML.g:4533:2: iv_ruleStringScalarRestriction= ruleStringScalarRestriction EOF
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
    // InternalOML.g:4539:1: ruleStringScalarRestriction returns [EObject current=null] : (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:4545:2: ( (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4546:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4546:2: (otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4547:3: otherlv_0= 'stringScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getStringScalarRestrictionAccess().getStringScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4551:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4552:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4552:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4553:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_39); 

            			newLeafNode(otherlv_2, grammarAccess.getStringScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4573:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4574:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4574:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4575:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4578:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4579:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4579:6: ( ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop31:
            do {
                int alt31=5;
                int LA31_0 = input.LA(1);

                if ( LA31_0 == 78 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt31=1;
                }
                else if ( LA31_0 == 79 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt31=2;
                }
                else if ( LA31_0 == 80 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt31=3;
                }
                else if ( LA31_0 == 83 && getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt31=4;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalOML.g:4580:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4580:4: ({...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4581:5: {...}? => ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4581:120: ( ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4582:6: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4585:9: ({...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4585:10: {...}? => (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4585:19: (otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) ) )
            	    // InternalOML.g:4585:20: otherlv_4= 'length' ( (lv_length_5_0= RULE_INT ) )
            	    {
            	    otherlv_4=(Token)match(input,78,FOLLOW_38); 

            	    									newLeafNode(otherlv_4, grammarAccess.getStringScalarRestrictionAccess().getLengthKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4589:9: ( (lv_length_5_0= RULE_INT ) )
            	    // InternalOML.g:4590:10: (lv_length_5_0= RULE_INT )
            	    {
            	    // InternalOML.g:4590:10: (lv_length_5_0= RULE_INT )
            	    // InternalOML.g:4591:11: lv_length_5_0= RULE_INT
            	    {
            	    lv_length_5_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:4613:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4613:4: ({...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4614:5: {...}? => ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4614:120: ( ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4615:6: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4618:9: ({...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4618:10: {...}? => (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4618:19: (otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) ) )
            	    // InternalOML.g:4618:20: otherlv_6= 'minLength' ( (lv_minLength_7_0= RULE_INT ) )
            	    {
            	    otherlv_6=(Token)match(input,79,FOLLOW_38); 

            	    									newLeafNode(otherlv_6, grammarAccess.getStringScalarRestrictionAccess().getMinLengthKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4622:9: ( (lv_minLength_7_0= RULE_INT ) )
            	    // InternalOML.g:4623:10: (lv_minLength_7_0= RULE_INT )
            	    {
            	    // InternalOML.g:4623:10: (lv_minLength_7_0= RULE_INT )
            	    // InternalOML.g:4624:11: lv_minLength_7_0= RULE_INT
            	    {
            	    lv_minLength_7_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:4646:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4646:4: ({...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) ) )
            	    // InternalOML.g:4647:5: {...}? => ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4647:120: ( ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) ) )
            	    // InternalOML.g:4648:6: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4651:9: ({...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) ) )
            	    // InternalOML.g:4651:10: {...}? => (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4651:19: (otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) ) )
            	    // InternalOML.g:4651:20: otherlv_8= 'maxLength' ( (lv_maxLength_9_0= RULE_INT ) )
            	    {
            	    otherlv_8=(Token)match(input,80,FOLLOW_38); 

            	    									newLeafNode(otherlv_8, grammarAccess.getStringScalarRestrictionAccess().getMaxLengthKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4655:9: ( (lv_maxLength_9_0= RULE_INT ) )
            	    // InternalOML.g:4656:10: (lv_maxLength_9_0= RULE_INT )
            	    {
            	    // InternalOML.g:4656:10: (lv_maxLength_9_0= RULE_INT )
            	    // InternalOML.g:4657:11: lv_maxLength_9_0= RULE_INT
            	    {
            	    lv_maxLength_9_0=(Token)match(input,RULE_INT,FOLLOW_39); 

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
            	    // InternalOML.g:4679:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4679:4: ({...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4680:5: {...}? => ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4680:120: ( ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4681:6: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4684:9: ({...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4684:10: {...}? => (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleStringScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4684:19: (otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4684:20: otherlv_10= 'pattern' ( (lv_pattern_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,83,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getStringScalarRestrictionAccess().getPatternKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4688:9: ( (lv_pattern_11_0= RULE_STRING ) )
            	    // InternalOML.g:4689:10: (lv_pattern_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4689:10: (lv_pattern_11_0= RULE_STRING )
            	    // InternalOML.g:4690:11: lv_pattern_11_0= RULE_STRING
            	    {
            	    lv_pattern_11_0=(Token)match(input,RULE_STRING,FOLLOW_39); 

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
            	    break loop31;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getStringScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:4723:3: ( ( ruleReference ) )
            // InternalOML.g:4724:4: ( ruleReference )
            {
            // InternalOML.g:4724:4: ( ruleReference )
            // InternalOML.g:4725:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStringScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:4747:1: entryRuleSynonymScalarRestriction returns [EObject current=null] : iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF ;
    public final EObject entryRuleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSynonymScalarRestriction = null;


        try {
            // InternalOML.g:4747:65: (iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF )
            // InternalOML.g:4748:2: iv_ruleSynonymScalarRestriction= ruleSynonymScalarRestriction EOF
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
    // InternalOML.g:4754:1: ruleSynonymScalarRestriction returns [EObject current=null] : (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) ;
    public final EObject ruleSynonymScalarRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:4760:2: ( (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' ) )
            // InternalOML.g:4761:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            {
            // InternalOML.g:4761:2: (otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}' )
            // InternalOML.g:4762:3: otherlv_0= 'synonymScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'restrictedRange' ( ( ruleReference ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getSynonymScalarRestrictionAccess().getSynonymScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4766:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4767:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4767:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4768:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getSynonymScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeKeyword_3());
            		
            // InternalOML.g:4792:3: ( ( ruleReference ) )
            // InternalOML.g:4793:4: ( ruleReference )
            {
            // InternalOML.g:4793:4: ( ruleReference )
            // InternalOML.g:4794:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSynonymScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSynonymScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_4_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:4816:1: entryRuleTimeScalarRestriction returns [EObject current=null] : iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF ;
    public final EObject entryRuleTimeScalarRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeScalarRestriction = null;


        try {
            // InternalOML.g:4816:62: (iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF )
            // InternalOML.g:4817:2: iv_ruleTimeScalarRestriction= ruleTimeScalarRestriction EOF
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
    // InternalOML.g:4823:1: ruleTimeScalarRestriction returns [EObject current=null] : (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) ;
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
            // InternalOML.g:4829:2: ( (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' ) )
            // InternalOML.g:4830:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            {
            // InternalOML.g:4830:2: (otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}' )
            // InternalOML.g:4831:3: otherlv_0= 'timeScalarRestriction' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) ) otherlv_12= 'restrictedRange' ( ( ruleReference ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_19); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeScalarRestrictionAccess().getTimeScalarRestrictionKeyword_0());
            		
            // InternalOML.g:4835:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOML.g:4836:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOML.g:4836:4: (lv_name_1_0= RULE_ID )
            // InternalOML.g:4837:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,25,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeScalarRestrictionAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:4857:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) ) )
            // InternalOML.g:4858:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            {
            // InternalOML.g:4858:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* ) )
            // InternalOML.g:4859:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				
            // InternalOML.g:4862:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )* )
            // InternalOML.g:4863:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            {
            // InternalOML.g:4863:6: ( ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) ) )*
            loop32:
            do {
                int alt32=5;
                int LA32_0 = input.LA(1);

                if ( LA32_0 == 85 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
                    alt32=1;
                }
                else if ( LA32_0 == 86 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
                    alt32=2;
                }
                else if ( LA32_0 == 87 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
                    alt32=3;
                }
                else if ( LA32_0 == 88 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
                    alt32=4;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalOML.g:4864:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4864:4: ({...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4865:5: {...}? => ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalOML.g:4865:118: ( ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4866:6: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalOML.g:4869:9: ({...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4869:10: {...}? => (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4869:19: (otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) ) )
            	    // InternalOML.g:4869:20: otherlv_4= 'minInclusive' ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,85,FOLLOW_7); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimeScalarRestrictionAccess().getMinInclusiveKeyword_3_0_0());
            	    								
            	    // InternalOML.g:4873:9: ( (lv_minInclusive_5_0= RULE_STRING ) )
            	    // InternalOML.g:4874:10: (lv_minInclusive_5_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4874:10: (lv_minInclusive_5_0= RULE_STRING )
            	    // InternalOML.g:4875:11: lv_minInclusive_5_0= RULE_STRING
            	    {
            	    lv_minInclusive_5_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4897:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4897:4: ({...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4898:5: {...}? => ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalOML.g:4898:118: ( ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4899:6: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalOML.g:4902:9: ({...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4902:10: {...}? => (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4902:19: (otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) ) )
            	    // InternalOML.g:4902:20: otherlv_6= 'maxInclusive' ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    {
            	    otherlv_6=(Token)match(input,86,FOLLOW_7); 

            	    									newLeafNode(otherlv_6, grammarAccess.getTimeScalarRestrictionAccess().getMaxInclusiveKeyword_3_1_0());
            	    								
            	    // InternalOML.g:4906:9: ( (lv_maxInclusive_7_0= RULE_STRING ) )
            	    // InternalOML.g:4907:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4907:10: (lv_maxInclusive_7_0= RULE_STRING )
            	    // InternalOML.g:4908:11: lv_maxInclusive_7_0= RULE_STRING
            	    {
            	    lv_maxInclusive_7_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4930:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4930:4: ({...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4931:5: {...}? => ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalOML.g:4931:118: ( ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4932:6: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalOML.g:4935:9: ({...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4935:10: {...}? => (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4935:19: (otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) ) )
            	    // InternalOML.g:4935:20: otherlv_8= 'minExclusive' ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    {
            	    otherlv_8=(Token)match(input,87,FOLLOW_7); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimeScalarRestrictionAccess().getMinExclusiveKeyword_3_2_0());
            	    								
            	    // InternalOML.g:4939:9: ( (lv_minExclusive_9_0= RULE_STRING ) )
            	    // InternalOML.g:4940:10: (lv_minExclusive_9_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4940:10: (lv_minExclusive_9_0= RULE_STRING )
            	    // InternalOML.g:4941:11: lv_minExclusive_9_0= RULE_STRING
            	    {
            	    lv_minExclusive_9_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    // InternalOML.g:4963:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalOML.g:4963:4: ({...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) ) )
            	    // InternalOML.g:4964:5: {...}? => ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalOML.g:4964:118: ( ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) ) )
            	    // InternalOML.g:4965:6: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalOML.g:4968:9: ({...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) ) )
            	    // InternalOML.g:4968:10: {...}? => (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimeScalarRestriction", "true");
            	    }
            	    // InternalOML.g:4968:19: (otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) ) )
            	    // InternalOML.g:4968:20: otherlv_10= 'maxExclusive' ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    {
            	    otherlv_10=(Token)match(input,88,FOLLOW_7); 

            	    									newLeafNode(otherlv_10, grammarAccess.getTimeScalarRestrictionAccess().getMaxExclusiveKeyword_3_3_0());
            	    								
            	    // InternalOML.g:4972:9: ( (lv_maxExclusive_11_0= RULE_STRING ) )
            	    // InternalOML.g:4973:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    {
            	    // InternalOML.g:4973:10: (lv_maxExclusive_11_0= RULE_STRING )
            	    // InternalOML.g:4974:11: lv_maxExclusive_11_0= RULE_STRING
            	    {
            	    lv_maxExclusive_11_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

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
            	    break loop32;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimeScalarRestrictionAccess().getUnorderedGroup_3());
            				

            }

            otherlv_12=(Token)match(input,81,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeKeyword_4());
            		
            // InternalOML.g:5007:3: ( ( ruleReference ) )
            // InternalOML.g:5008:4: ( ruleReference )
            {
            // InternalOML.g:5008:4: ( ruleReference )
            // InternalOML.g:5009:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeScalarRestrictionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTimeScalarRestrictionAccess().getRestrictedRangeDataRangeCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
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


    // $ANTLR start "entryRuleDescriptionBox"
    // InternalOML.g:5031:1: entryRuleDescriptionBox returns [EObject current=null] : iv_ruleDescriptionBox= ruleDescriptionBox EOF ;
    public final EObject entryRuleDescriptionBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBox = null;


        try {
            // InternalOML.g:5031:55: (iv_ruleDescriptionBox= ruleDescriptionBox EOF )
            // InternalOML.g:5032:2: iv_ruleDescriptionBox= ruleDescriptionBox EOF
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
    // InternalOML.g:5038:1: ruleDescriptionBox returns [EObject current=null] : ( ( (lv_kind_0_0= ruleDescriptionKind ) ) otherlv_1= 'descriptionBox' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' ) ;
    public final EObject ruleDescriptionBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_iri_2_0=null;
        Token otherlv_3=null;
        Token otherlv_14=null;
        Enumerator lv_kind_0_0 = null;

        EObject lv_annotations_4_0 = null;

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
            // InternalOML.g:5044:2: ( ( ( (lv_kind_0_0= ruleDescriptionKind ) ) otherlv_1= 'descriptionBox' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' ) )
            // InternalOML.g:5045:2: ( ( (lv_kind_0_0= ruleDescriptionKind ) ) otherlv_1= 'descriptionBox' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' )
            {
            // InternalOML.g:5045:2: ( ( (lv_kind_0_0= ruleDescriptionKind ) ) otherlv_1= 'descriptionBox' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}' )
            // InternalOML.g:5046:3: ( (lv_kind_0_0= ruleDescriptionKind ) ) otherlv_1= 'descriptionBox' ( (lv_iri_2_0= RULE_IRI ) ) otherlv_3= '{' ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )* otherlv_14= '}'
            {
            // InternalOML.g:5046:3: ( (lv_kind_0_0= ruleDescriptionKind ) )
            // InternalOML.g:5047:4: (lv_kind_0_0= ruleDescriptionKind )
            {
            // InternalOML.g:5047:4: (lv_kind_0_0= ruleDescriptionKind )
            // InternalOML.g:5048:5: lv_kind_0_0= ruleDescriptionKind
            {

            					newCompositeNode(grammarAccess.getDescriptionBoxAccess().getKindDescriptionKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_43);
            lv_kind_0_0=ruleDescriptionKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.DescriptionKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,96,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getDescriptionBoxAccess().getDescriptionBoxKeyword_1());
            		
            // InternalOML.g:5069:3: ( (lv_iri_2_0= RULE_IRI ) )
            // InternalOML.g:5070:4: (lv_iri_2_0= RULE_IRI )
            {
            // InternalOML.g:5070:4: (lv_iri_2_0= RULE_IRI )
            // InternalOML.g:5071:5: lv_iri_2_0= RULE_IRI
            {
            lv_iri_2_0=(Token)match(input,RULE_IRI,FOLLOW_9); 

            					newLeafNode(lv_iri_2_0, grammarAccess.getDescriptionBoxAccess().getIriIRITerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDescriptionBoxRule());
            					}
            					setWithLastConsumed(
            						current,
            						"iri",
            						lv_iri_2_0,
            						"gov.nasa.jpl.imce.oml.dsl.OML.IRI");
            				

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_44); 

            			newLeafNode(otherlv_3, grammarAccess.getDescriptionBoxAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalOML.g:5091:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*
            loop33:
            do {
                int alt33=11;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // InternalOML.g:5092:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    {
            	    // InternalOML.g:5092:4: ( (lv_annotations_4_0= ruleAnnotation ) )
            	    // InternalOML.g:5093:5: (lv_annotations_4_0= ruleAnnotation )
            	    {
            	    // InternalOML.g:5093:5: (lv_annotations_4_0= ruleAnnotation )
            	    // InternalOML.g:5094:6: lv_annotations_4_0= ruleAnnotation
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getAnnotationsAnnotationParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_annotations_4_0=ruleAnnotation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDescriptionBoxRule());
            	    						}
            	    						add(
            	    							current,
            	    							"annotations",
            	    							lv_annotations_4_0,
            	    							"gov.nasa.jpl.imce.oml.dsl.OML.Annotation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalOML.g:5112:4: ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    {
            	    // InternalOML.g:5112:4: ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) )
            	    // InternalOML.g:5113:5: (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    {
            	    // InternalOML.g:5113:5: (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions )
            	    // InternalOML.g:5114:6: lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getClosedWorldDefinitionsDescriptionBoxExtendsClosedWorldDefinitionsParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 3 :
            	    // InternalOML.g:5132:4: ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) )
            	    {
            	    // InternalOML.g:5132:4: ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) )
            	    // InternalOML.g:5133:5: (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement )
            	    {
            	    // InternalOML.g:5133:5: (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement )
            	    // InternalOML.g:5134:6: lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getDescriptionBoxRefinementsDescriptionBoxRefinementParserRuleCall_4_2_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 4 :
            	    // InternalOML.g:5152:4: ( (lv_conceptInstances_7_0= ruleConceptInstance ) )
            	    {
            	    // InternalOML.g:5152:4: ( (lv_conceptInstances_7_0= ruleConceptInstance ) )
            	    // InternalOML.g:5153:5: (lv_conceptInstances_7_0= ruleConceptInstance )
            	    {
            	    // InternalOML.g:5153:5: (lv_conceptInstances_7_0= ruleConceptInstance )
            	    // InternalOML.g:5154:6: lv_conceptInstances_7_0= ruleConceptInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getConceptInstancesConceptInstanceParserRuleCall_4_3_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 5 :
            	    // InternalOML.g:5172:4: ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) )
            	    {
            	    // InternalOML.g:5172:4: ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) )
            	    // InternalOML.g:5173:5: (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance )
            	    {
            	    // InternalOML.g:5173:5: (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance )
            	    // InternalOML.g:5174:6: lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstancesReifiedRelationshipInstanceParserRuleCall_4_4_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 6 :
            	    // InternalOML.g:5192:4: ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) )
            	    {
            	    // InternalOML.g:5192:4: ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) )
            	    // InternalOML.g:5193:5: (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain )
            	    {
            	    // InternalOML.g:5193:5: (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain )
            	    // InternalOML.g:5194:6: lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceDomainsReifiedRelationshipInstanceDomainParserRuleCall_4_5_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 7 :
            	    // InternalOML.g:5212:4: ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) )
            	    {
            	    // InternalOML.g:5212:4: ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) )
            	    // InternalOML.g:5213:5: (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange )
            	    {
            	    // InternalOML.g:5213:5: (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange )
            	    // InternalOML.g:5214:6: lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getReifiedRelationshipInstanceRangesReifiedRelationshipInstanceRangeParserRuleCall_4_6_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 8 :
            	    // InternalOML.g:5232:4: ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    {
            	    // InternalOML.g:5232:4: ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) )
            	    // InternalOML.g:5233:5: (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple )
            	    {
            	    // InternalOML.g:5233:5: (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple )
            	    // InternalOML.g:5234:6: lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getUnreifiedRelationshipInstanceTuplesUnreifiedRelationshipInstanceTupleParserRuleCall_4_7_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 9 :
            	    // InternalOML.g:5252:4: ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5252:4: ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) )
            	    // InternalOML.g:5253:5: (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5253:5: (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue )
            	    // InternalOML.g:5254:6: lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonScalarDataPropertyValuesSingletonInstanceScalarDataPropertyValueParserRuleCall_4_8_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	case 10 :
            	    // InternalOML.g:5272:4: ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5272:4: ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) )
            	    // InternalOML.g:5273:5: (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    {
            	    // InternalOML.g:5273:5: (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue )
            	    // InternalOML.g:5274:6: lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getDescriptionBoxAccess().getSingletonStructuredDataPropertyValuesSingletonInstanceStructuredDataPropertyValueParserRuleCall_4_9_0());
            	    					
            	    pushFollow(FOLLOW_44);
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
            	    break loop33;
                }
            } while (true);

            otherlv_14=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getDescriptionBoxAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleConceptualEntitySingletonInstance"
    // InternalOML.g:5300:1: entryRuleConceptualEntitySingletonInstance returns [EObject current=null] : iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF ;
    public final EObject entryRuleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptualEntitySingletonInstance = null;


        try {
            // InternalOML.g:5300:74: (iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF )
            // InternalOML.g:5301:2: iv_ruleConceptualEntitySingletonInstance= ruleConceptualEntitySingletonInstance EOF
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
    // InternalOML.g:5307:1: ruleConceptualEntitySingletonInstance returns [EObject current=null] : (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) ;
    public final EObject ruleConceptualEntitySingletonInstance() throws RecognitionException {
        EObject current = null;

        EObject this_ConceptInstance_0 = null;

        EObject this_ReifiedRelationshipInstance_1 = null;



        	enterRule();

        try {
            // InternalOML.g:5313:2: ( (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance ) )
            // InternalOML.g:5314:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            {
            // InternalOML.g:5314:2: (this_ConceptInstance_0= ruleConceptInstance | this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==98) ) {
                alt34=1;
            }
            else if ( (LA34_0==100) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalOML.g:5315:3: this_ConceptInstance_0= ruleConceptInstance
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
                    // InternalOML.g:5324:3: this_ReifiedRelationshipInstance_1= ruleReifiedRelationshipInstance
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
    // InternalOML.g:5336:1: entryRuleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF ;
    public final EObject entryRuleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxExtendsClosedWorldDefinitions = null;


        try {
            // InternalOML.g:5336:84: (iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF )
            // InternalOML.g:5337:2: iv_ruleDescriptionBoxExtendsClosedWorldDefinitions= ruleDescriptionBoxExtendsClosedWorldDefinitions EOF
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
    // InternalOML.g:5343:1: ruleDescriptionBoxExtendsClosedWorldDefinitions returns [EObject current=null] : (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxExtendsClosedWorldDefinitions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5349:2: ( (otherlv_0= 'extends' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5350:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5350:2: (otherlv_0= 'extends' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5351:3: otherlv_0= 'extends' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxExtendsClosedWorldDefinitionsAccess().getExtendsKeyword_0());
            		
            // InternalOML.g:5355:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5356:4: ( ruleExternalReference )
            {
            // InternalOML.g:5356:4: ( ruleExternalReference )
            // InternalOML.g:5357:5: ruleExternalReference
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
    // InternalOML.g:5375:1: entryRuleDescriptionBoxRefinement returns [EObject current=null] : iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF ;
    public final EObject entryRuleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionBoxRefinement = null;


        try {
            // InternalOML.g:5375:65: (iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF )
            // InternalOML.g:5376:2: iv_ruleDescriptionBoxRefinement= ruleDescriptionBoxRefinement EOF
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
    // InternalOML.g:5382:1: ruleDescriptionBoxRefinement returns [EObject current=null] : (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) ;
    public final EObject ruleDescriptionBoxRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOML.g:5388:2: ( (otherlv_0= 'refines' ( ( ruleExternalReference ) ) ) )
            // InternalOML.g:5389:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            {
            // InternalOML.g:5389:2: (otherlv_0= 'refines' ( ( ruleExternalReference ) ) )
            // InternalOML.g:5390:3: otherlv_0= 'refines' ( ( ruleExternalReference ) )
            {
            otherlv_0=(Token)match(input,97,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getDescriptionBoxRefinementAccess().getRefinesKeyword_0());
            		
            // InternalOML.g:5394:3: ( ( ruleExternalReference ) )
            // InternalOML.g:5395:4: ( ruleExternalReference )
            {
            // InternalOML.g:5395:4: ( ruleExternalReference )
            // InternalOML.g:5396:5: ruleExternalReference
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
    // InternalOML.g:5414:1: entryRuleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5414:81: (iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF )
            // InternalOML.g:5415:2: iv_ruleSingletonInstanceScalarDataPropertyValue= ruleSingletonInstanceScalarDataPropertyValue EOF
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
    // InternalOML.g:5421:1: ruleSingletonInstanceScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) ;
    public final EObject ruleSingletonInstanceScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5427:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) ) )
            // InternalOML.g:5428:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            {
            // InternalOML.g:5428:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) ) )
            // InternalOML.g:5429:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            {
            // InternalOML.g:5429:3: ( ( ruleReference ) )
            // InternalOML.g:5430:4: ( ruleReference )
            {
            // InternalOML.g:5430:4: ( ruleReference )
            // InternalOML.g:5431:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceScalarDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5449:3: ( ( ruleReference ) )
            // InternalOML.g:5450:4: ( ruleReference )
            {
            // InternalOML.g:5450:4: ( ruleReference )
            // InternalOML.g:5451:5: ruleReference
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

            otherlv_3=(Token)match(input,22,FOLLOW_45); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceScalarDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            // InternalOML.g:5469:3: ( (lv_scalarPropertyValue_4_0= ruleValue ) )
            // InternalOML.g:5470:4: (lv_scalarPropertyValue_4_0= ruleValue )
            {
            // InternalOML.g:5470:4: (lv_scalarPropertyValue_4_0= ruleValue )
            // InternalOML.g:5471:5: lv_scalarPropertyValue_4_0= ruleValue
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
    // InternalOML.g:5492:1: entryRuleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF ;
    public final EObject entryRuleSingletonInstanceStructuredDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingletonInstanceStructuredDataPropertyValue = null;


        try {
            // InternalOML.g:5492:85: (iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF )
            // InternalOML.g:5493:2: iv_ruleSingletonInstanceStructuredDataPropertyValue= ruleSingletonInstanceStructuredDataPropertyValue EOF
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
    // InternalOML.g:5499:1: ruleSingletonInstanceStructuredDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) ;
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
            // InternalOML.g:5505:2: ( ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' ) )
            // InternalOML.g:5506:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            {
            // InternalOML.g:5506:2: ( ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}' )
            // InternalOML.g:5507:3: ( ( ruleReference ) ) otherlv_1= '.' ( ( ruleReference ) ) otherlv_3= '=' otherlv_4= '{' ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )* otherlv_7= '}'
            {
            // InternalOML.g:5507:3: ( ( ruleReference ) )
            // InternalOML.g:5508:4: ( ruleReference )
            {
            // InternalOML.g:5508:4: ( ruleReference )
            // InternalOML.g:5509:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingletonInstanceStructuredDataPropertyValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getSingletonInstanceConceptualEntitySingletonInstanceCrossReference_0_0());
            				
            pushFollow(FOLLOW_31);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getFullStopKeyword_1());
            		
            // InternalOML.g:5527:3: ( ( ruleReference ) )
            // InternalOML.g:5528:4: ( ruleReference )
            {
            // InternalOML.g:5528:4: ( ruleReference )
            // InternalOML.g:5529:5: ruleReference
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

            otherlv_3=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getEqualsSignKeyword_3());
            		
            otherlv_4=(Token)match(input,25,FOLLOW_46); 

            			newLeafNode(otherlv_4, grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalOML.g:5551:3: ( ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) ) )*
            loop35:
            do {
                int alt35=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==22) ) {
                        int LA35_5 = input.LA(3);

                        if ( (LA35_5==RULE_STRING||(LA35_5>=RULE_INT && LA35_5<=RULE_FLOAT)) ) {
                            alt35=2;
                        }
                        else if ( (LA35_5==25) ) {
                            alt35=1;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (LA35_3==22) ) {
                        int LA35_5 = input.LA(3);

                        if ( (LA35_5==RULE_STRING||(LA35_5>=RULE_INT && LA35_5<=RULE_FLOAT)) ) {
                            alt35=2;
                        }
                        else if ( (LA35_5==25) ) {
                            alt35=1;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA35_4 = input.LA(2);

                    if ( (LA35_4==22) ) {
                        int LA35_5 = input.LA(3);

                        if ( (LA35_5==RULE_STRING||(LA35_5>=RULE_INT && LA35_5<=RULE_FLOAT)) ) {
                            alt35=2;
                        }
                        else if ( (LA35_5==25) ) {
                            alt35=1;
                        }


                    }


                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // InternalOML.g:5552:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5552:4: ( (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5553:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5553:5: (lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5554:6: lv_structuredPropertyTuples_5_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    // InternalOML.g:5572:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5572:4: ( (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:5573:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5573:5: (lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:5574:6: lv_scalarDataPropertyValues_6_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getSingletonInstanceStructuredDataPropertyValueAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop35;
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
    // InternalOML.g:5600:1: entryRuleStructuredDataPropertyTuple returns [EObject current=null] : iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF ;
    public final EObject entryRuleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructuredDataPropertyTuple = null;


        try {
            // InternalOML.g:5600:68: (iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF )
            // InternalOML.g:5601:2: iv_ruleStructuredDataPropertyTuple= ruleStructuredDataPropertyTuple EOF
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
    // InternalOML.g:5607:1: ruleStructuredDataPropertyTuple returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleStructuredDataPropertyTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_structuredPropertyTuples_3_0 = null;

        EObject lv_scalarDataPropertyValues_4_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5613:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' ) )
            // InternalOML.g:5614:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            {
            // InternalOML.g:5614:2: ( ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}' )
            // InternalOML.g:5615:3: ( ( ruleReference ) ) otherlv_1= '=' otherlv_2= '{' ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )* otherlv_5= '}'
            {
            // InternalOML.g:5615:3: ( ( ruleReference ) )
            // InternalOML.g:5616:4: ( ruleReference )
            {
            // InternalOML.g:5616:4: ( ruleReference )
            // InternalOML.g:5617:5: ruleReference
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

            otherlv_1=(Token)match(input,22,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getStructuredDataPropertyTupleAccess().getEqualsSignKeyword_1());
            		
            otherlv_2=(Token)match(input,25,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getStructuredDataPropertyTupleAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOML.g:5639:3: ( ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) ) | ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) ) )*
            loop36:
            do {
                int alt36=3;
                switch ( input.LA(1) ) {
                case RULE_IRI:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (LA36_2==22) ) {
                        int LA36_5 = input.LA(3);

                        if ( (LA36_5==25) ) {
                            alt36=1;
                        }
                        else if ( (LA36_5==RULE_STRING||(LA36_5>=RULE_INT && LA36_5<=RULE_FLOAT)) ) {
                            alt36=2;
                        }


                    }


                    }
                    break;
                case RULE_ABBREV_IRI:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (LA36_3==22) ) {
                        int LA36_5 = input.LA(3);

                        if ( (LA36_5==25) ) {
                            alt36=1;
                        }
                        else if ( (LA36_5==RULE_STRING||(LA36_5>=RULE_INT && LA36_5<=RULE_FLOAT)) ) {
                            alt36=2;
                        }


                    }


                    }
                    break;
                case RULE_ID:
                    {
                    int LA36_4 = input.LA(2);

                    if ( (LA36_4==22) ) {
                        int LA36_5 = input.LA(3);

                        if ( (LA36_5==25) ) {
                            alt36=1;
                        }
                        else if ( (LA36_5==RULE_STRING||(LA36_5>=RULE_INT && LA36_5<=RULE_FLOAT)) ) {
                            alt36=2;
                        }


                    }


                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // InternalOML.g:5640:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    {
            	    // InternalOML.g:5640:4: ( (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple ) )
            	    // InternalOML.g:5641:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    {
            	    // InternalOML.g:5641:5: (lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple )
            	    // InternalOML.g:5642:6: lv_structuredPropertyTuples_3_0= ruleStructuredDataPropertyTuple
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getStructuredPropertyTuplesStructuredDataPropertyTupleParserRuleCall_3_0_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    // InternalOML.g:5660:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    {
            	    // InternalOML.g:5660:4: ( (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue ) )
            	    // InternalOML.g:5661:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    {
            	    // InternalOML.g:5661:5: (lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue )
            	    // InternalOML.g:5662:6: lv_scalarDataPropertyValues_4_0= ruleScalarDataPropertyValue
            	    {

            	    						newCompositeNode(grammarAccess.getStructuredDataPropertyTupleAccess().getScalarDataPropertyValuesScalarDataPropertyValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_46);
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
            	    break loop36;
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
    // InternalOML.g:5688:1: entryRuleScalarDataPropertyValue returns [EObject current=null] : iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF ;
    public final EObject entryRuleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarDataPropertyValue = null;


        try {
            // InternalOML.g:5688:64: (iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF )
            // InternalOML.g:5689:2: iv_ruleScalarDataPropertyValue= ruleScalarDataPropertyValue EOF
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
    // InternalOML.g:5695:1: ruleScalarDataPropertyValue returns [EObject current=null] : ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) ;
    public final EObject ruleScalarDataPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_scalarPropertyValue_2_0 = null;



        	enterRule();

        try {
            // InternalOML.g:5701:2: ( ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) ) )
            // InternalOML.g:5702:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            {
            // InternalOML.g:5702:2: ( ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) ) )
            // InternalOML.g:5703:3: ( ( ruleReference ) ) otherlv_1= '=' ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            {
            // InternalOML.g:5703:3: ( ( ruleReference ) )
            // InternalOML.g:5704:4: ( ruleReference )
            {
            // InternalOML.g:5704:4: ( ruleReference )
            // InternalOML.g:5705:5: ruleReference
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

            otherlv_1=(Token)match(input,22,FOLLOW_45); 

            			newLeafNode(otherlv_1, grammarAccess.getScalarDataPropertyValueAccess().getEqualsSignKeyword_1());
            		
            // InternalOML.g:5723:3: ( (lv_scalarPropertyValue_2_0= ruleValue ) )
            // InternalOML.g:5724:4: (lv_scalarPropertyValue_2_0= ruleValue )
            {
            // InternalOML.g:5724:4: (lv_scalarPropertyValue_2_0= ruleValue )
            // InternalOML.g:5725:5: lv_scalarPropertyValue_2_0= ruleValue
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
    // InternalOML.g:5746:1: entryRuleConceptInstance returns [EObject current=null] : iv_ruleConceptInstance= ruleConceptInstance EOF ;
    public final EObject entryRuleConceptInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConceptInstance = null;


        try {
            // InternalOML.g:5746:56: (iv_ruleConceptInstance= ruleConceptInstance EOF )
            // InternalOML.g:5747:2: iv_ruleConceptInstance= ruleConceptInstance EOF
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
    // InternalOML.g:5753:1: ruleConceptInstance returns [EObject current=null] : (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleConceptInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5759:2: ( (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:5760:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:5760:2: (otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:5761:3: otherlv_0= 'conceptInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,98,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getConceptInstanceAccess().getConceptInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getConceptInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5769:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5770:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5770:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5771:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            otherlv_3=(Token)match(input,99,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getConceptInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:5791:3: ( ( ruleReference ) )
            // InternalOML.g:5792:4: ( ruleReference )
            {
            // InternalOML.g:5792:4: ( ruleReference )
            // InternalOML.g:5793:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConceptInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConceptInstanceAccess().getSingletonConceptClassifierConceptCrossReference_4_0());
            				
            pushFollow(FOLLOW_29);
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
    // InternalOML.g:5815:1: entryRuleReifiedRelationshipInstance returns [EObject current=null] : iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF ;
    public final EObject entryRuleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstance = null;


        try {
            // InternalOML.g:5815:68: (iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF )
            // InternalOML.g:5816:2: iv_ruleReifiedRelationshipInstance= ruleReifiedRelationshipInstance EOF
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
    // InternalOML.g:5822:1: ruleReifiedRelationshipInstance returns [EObject current=null] : (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) ;
    public final EObject ruleReifiedRelationshipInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalOML.g:5828:2: ( (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' ) )
            // InternalOML.g:5829:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            {
            // InternalOML.g:5829:2: (otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')' )
            // InternalOML.g:5830:3: otherlv_0= 'reifiedRelationshipInstance' otherlv_1= '(' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is-a' ( ( ruleReference ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceAccess().getReifiedRelationshipInstanceKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5838:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalOML.g:5839:4: (lv_name_2_0= RULE_ID )
            {
            // InternalOML.g:5839:4: (lv_name_2_0= RULE_ID )
            // InternalOML.g:5840:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_47); 

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

            otherlv_3=(Token)match(input,99,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceAccess().getIsAKeyword_3());
            		
            // InternalOML.g:5860:3: ( ( ruleReference ) )
            // InternalOML.g:5861:4: ( ruleReference )
            {
            // InternalOML.g:5861:4: ( ruleReference )
            // InternalOML.g:5862:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceAccess().getSingletonReifiedRelationshipClassifierReifiedRelationshipCrossReference_4_0());
            				
            pushFollow(FOLLOW_29);
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
    // InternalOML.g:5884:1: entryRuleReifiedRelationshipInstanceDomain returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceDomain = null;


        try {
            // InternalOML.g:5884:74: (iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF )
            // InternalOML.g:5885:2: iv_ruleReifiedRelationshipInstanceDomain= ruleReifiedRelationshipInstanceDomain EOF
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
    // InternalOML.g:5891:1: ruleReifiedRelationshipInstanceDomain returns [EObject current=null] : (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceDomain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:5897:2: ( (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:5898:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:5898:2: (otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:5899:3: otherlv_0= 'domain' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getDomainKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5907:3: ( ( ruleReference ) )
            // InternalOML.g:5908:4: ( ruleReference )
            {
            // InternalOML.g:5908:4: ( ruleReference )
            // InternalOML.g:5909:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceDomainRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceDomainAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
            				
            pushFollow(FOLLOW_29);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceDomainAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:5931:3: ( ( ruleReference ) )
            // InternalOML.g:5932:4: ( ruleReference )
            {
            // InternalOML.g:5932:4: ( ruleReference )
            // InternalOML.g:5933:5: ruleReference
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
    // InternalOML.g:5951:1: entryRuleReifiedRelationshipInstanceRange returns [EObject current=null] : iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF ;
    public final EObject entryRuleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReifiedRelationshipInstanceRange = null;


        try {
            // InternalOML.g:5951:73: (iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF )
            // InternalOML.g:5952:2: iv_ruleReifiedRelationshipInstanceRange= ruleReifiedRelationshipInstanceRange EOF
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
    // InternalOML.g:5958:1: ruleReifiedRelationshipInstanceRange returns [EObject current=null] : (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) ;
    public final EObject ruleReifiedRelationshipInstanceRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalOML.g:5964:2: ( (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) ) )
            // InternalOML.g:5965:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            {
            // InternalOML.g:5965:2: (otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) ) )
            // InternalOML.g:5966:3: otherlv_0= 'range' otherlv_1= '(' ( ( ruleReference ) ) otherlv_3= ')' otherlv_4= '=' ( ( ruleReference ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRangeKeyword_0());
            		
            otherlv_1=(Token)match(input,63,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOML.g:5974:3: ( ( ruleReference ) )
            // InternalOML.g:5975:4: ( ruleReference )
            {
            // InternalOML.g:5975:4: ( ruleReference )
            // InternalOML.g:5976:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getReifiedRelationshipInstanceRangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getReifiedRelationshipInstanceRangeAccess().getReifiedRelationshipInstanceReifiedRelationshipInstanceCrossReference_2_0());
            				
            pushFollow(FOLLOW_29);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getRightParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getReifiedRelationshipInstanceRangeAccess().getEqualsSignKeyword_4());
            		
            // InternalOML.g:5998:3: ( ( ruleReference ) )
            // InternalOML.g:5999:4: ( ruleReference )
            {
            // InternalOML.g:5999:4: ( ruleReference )
            // InternalOML.g:6000:5: ruleReference
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
    // InternalOML.g:6018:1: entryRuleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF ;
    public final EObject entryRuleUnreifiedRelationshipInstanceTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnreifiedRelationshipInstanceTuple = null;


        try {
            // InternalOML.g:6018:75: (iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF )
            // InternalOML.g:6019:2: iv_ruleUnreifiedRelationshipInstanceTuple= ruleUnreifiedRelationshipInstanceTuple EOF
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
    // InternalOML.g:6025:1: ruleUnreifiedRelationshipInstanceTuple returns [EObject current=null] : (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) ;
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
            // InternalOML.g:6031:2: ( (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' ) )
            // InternalOML.g:6032:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            {
            // InternalOML.g:6032:2: (otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}' )
            // InternalOML.g:6033:3: otherlv_0= 'tuple' otherlv_1= '{' otherlv_2= 'unreifiedRelationship' ( ( ruleReference ) ) otherlv_4= 'domain' ( ( ruleReference ) ) otherlv_6= 'range' ( ( ruleReference ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,101,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getTupleKeyword_0());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_48); 

            			newLeafNode(otherlv_1, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,52,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipKeyword_2());
            		
            // InternalOML.g:6045:3: ( ( ruleReference ) )
            // InternalOML.g:6046:4: ( ruleReference )
            {
            // InternalOML.g:6046:4: ( ruleReference )
            // InternalOML.g:6047:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getUnreifiedRelationshipUnreifiedRelationshipCrossReference_3_0());
            				
            pushFollow(FOLLOW_26);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,57,FOLLOW_15); 

            			newLeafNode(otherlv_4, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainKeyword_4());
            		
            // InternalOML.g:6065:3: ( ( ruleReference ) )
            // InternalOML.g:6066:4: ( ruleReference )
            {
            // InternalOML.g:6066:4: ( ruleReference )
            // InternalOML.g:6067:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getDomainConceptualEntitySingletonInstanceCrossReference_5_0());
            				
            pushFollow(FOLLOW_27);
            ruleReference();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,58,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeKeyword_6());
            		
            // InternalOML.g:6085:3: ( ( ruleReference ) )
            // InternalOML.g:6086:4: ( ruleReference )
            {
            // InternalOML.g:6086:4: ( ruleReference )
            // InternalOML.g:6087:5: ruleReference
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUnreifiedRelationshipInstanceTupleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getUnreifiedRelationshipInstanceTupleAccess().getRangeConceptualEntitySingletonInstanceCrossReference_7_0());
            				
            pushFollow(FOLLOW_16);
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
    // InternalOML.g:6109:1: entryRuleReference returns [String current=null] : iv_ruleReference= ruleReference EOF ;
    public final String entryRuleReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReference = null;


        try {
            // InternalOML.g:6109:49: (iv_ruleReference= ruleReference EOF )
            // InternalOML.g:6110:2: iv_ruleReference= ruleReference EOF
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
    // InternalOML.g:6116:1: ruleReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) ;
    public final AntlrDatatypeRuleToken ruleReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;
        AntlrDatatypeRuleToken this_QNAME_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6122:2: ( (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME ) )
            // InternalOML.g:6123:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            {
            // InternalOML.g:6123:2: (this_IRI_0= RULE_IRI | this_QNAME_1= ruleQNAME )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_IRI) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_ABBREV_IRI||LA37_0==RULE_ID) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalOML.g:6124:3: this_IRI_0= RULE_IRI
                    {
                    this_IRI_0=(Token)match(input,RULE_IRI,FOLLOW_2); 

                    			current.merge(this_IRI_0);
                    		

                    			newLeafNode(this_IRI_0, grammarAccess.getReferenceAccess().getIRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6132:3: this_QNAME_1= ruleQNAME
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
    // InternalOML.g:6146:1: entryRuleExternalReference returns [String current=null] : iv_ruleExternalReference= ruleExternalReference EOF ;
    public final String entryRuleExternalReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExternalReference = null;


        try {
            // InternalOML.g:6146:57: (iv_ruleExternalReference= ruleExternalReference EOF )
            // InternalOML.g:6147:2: iv_ruleExternalReference= ruleExternalReference EOF
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
    // InternalOML.g:6153:1: ruleExternalReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_IRI_0= RULE_IRI ;
    public final AntlrDatatypeRuleToken ruleExternalReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_IRI_0=null;


        	enterRule();

        try {
            // InternalOML.g:6159:2: (this_IRI_0= RULE_IRI )
            // InternalOML.g:6160:2: this_IRI_0= RULE_IRI
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
    // InternalOML.g:6170:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalOML.g:6170:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalOML.g:6171:2: iv_ruleQNAME= ruleQNAME EOF
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
    // InternalOML.g:6177:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ABBREV_IRI_0=null;
        AntlrDatatypeRuleToken this_ValidID_1 = null;



        	enterRule();

        try {
            // InternalOML.g:6183:2: ( (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID ) )
            // InternalOML.g:6184:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            {
            // InternalOML.g:6184:2: (this_ABBREV_IRI_0= RULE_ABBREV_IRI | this_ValidID_1= ruleValidID )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ABBREV_IRI) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ID) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalOML.g:6185:3: this_ABBREV_IRI_0= RULE_ABBREV_IRI
                    {
                    this_ABBREV_IRI_0=(Token)match(input,RULE_ABBREV_IRI,FOLLOW_2); 

                    			current.merge(this_ABBREV_IRI_0);
                    		

                    			newLeafNode(this_ABBREV_IRI_0, grammarAccess.getQNAMEAccess().getABBREV_IRITerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6193:3: this_ValidID_1= ruleValidID
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
    // InternalOML.g:6207:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalOML.g:6207:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalOML.g:6208:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalOML.g:6214:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOML.g:6220:2: (this_ID_0= RULE_ID )
            // InternalOML.g:6221:2: this_ID_0= RULE_ID
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
    // InternalOML.g:6231:1: entryRuleValue returns [String current=null] : iv_ruleValue= ruleValue EOF ;
    public final String entryRuleValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValue = null;


        try {
            // InternalOML.g:6231:45: (iv_ruleValue= ruleValue EOF )
            // InternalOML.g:6232:2: iv_ruleValue= ruleValue EOF
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
    // InternalOML.g:6238:1: ruleValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) ;
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
            // InternalOML.g:6244:2: ( (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT ) )
            // InternalOML.g:6245:2: (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            {
            // InternalOML.g:6245:2: (this_DECIMAL_0= RULE_DECIMAL | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_UUID_3= RULE_UUID | this_HEX_4= RULE_HEX | this_FLOAT_5= RULE_FLOAT )
            int alt39=6;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL:
                {
                alt39=1;
                }
                break;
            case RULE_STRING:
                {
                alt39=2;
                }
                break;
            case RULE_INT:
                {
                alt39=3;
                }
                break;
            case RULE_UUID:
                {
                alt39=4;
                }
                break;
            case RULE_HEX:
                {
                alt39=5;
                }
                break;
            case RULE_FLOAT:
                {
                alt39=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalOML.g:6246:3: this_DECIMAL_0= RULE_DECIMAL
                    {
                    this_DECIMAL_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    			current.merge(this_DECIMAL_0);
                    		

                    			newLeafNode(this_DECIMAL_0, grammarAccess.getValueAccess().getDECIMALTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOML.g:6254:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOML.g:6262:3: this_INT_2= RULE_INT
                    {
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_2);
                    		

                    			newLeafNode(this_INT_2, grammarAccess.getValueAccess().getINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalOML.g:6270:3: this_UUID_3= RULE_UUID
                    {
                    this_UUID_3=(Token)match(input,RULE_UUID,FOLLOW_2); 

                    			current.merge(this_UUID_3);
                    		

                    			newLeafNode(this_UUID_3, grammarAccess.getValueAccess().getUUIDTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalOML.g:6278:3: this_HEX_4= RULE_HEX
                    {
                    this_HEX_4=(Token)match(input,RULE_HEX,FOLLOW_2); 

                    			current.merge(this_HEX_4);
                    		

                    			newLeafNode(this_HEX_4, grammarAccess.getValueAccess().getHEXTerminalRuleCall_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalOML.g:6286:3: this_FLOAT_5= RULE_FLOAT
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
    // InternalOML.g:6297:1: ruleTerminologyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) ;
    public final Enumerator ruleTerminologyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6303:2: ( ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) ) )
            // InternalOML.g:6304:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            {
            // InternalOML.g:6304:2: ( (enumLiteral_0= 'open' ) | (enumLiteral_1= 'closed' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==102) ) {
                alt40=1;
            }
            else if ( (LA40_0==103) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalOML.g:6305:3: (enumLiteral_0= 'open' )
                    {
                    // InternalOML.g:6305:3: (enumLiteral_0= 'open' )
                    // InternalOML.g:6306:4: enumLiteral_0= 'open'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTerminologyKindAccess().getOpenWorldDefinitionsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6313:3: (enumLiteral_1= 'closed' )
                    {
                    // InternalOML.g:6313:3: (enumLiteral_1= 'closed' )
                    // InternalOML.g:6314:4: enumLiteral_1= 'closed'
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
    // InternalOML.g:6324:1: ruleDescriptionKind returns [Enumerator current=null] : ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) ;
    public final Enumerator ruleDescriptionKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalOML.g:6330:2: ( ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) ) )
            // InternalOML.g:6331:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            {
            // InternalOML.g:6331:2: ( (enumLiteral_0= 'final' ) | (enumLiteral_1= 'partial' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==104) ) {
                alt41=1;
            }
            else if ( (LA41_0==105) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalOML.g:6332:3: (enumLiteral_0= 'final' )
                    {
                    // InternalOML.g:6332:3: (enumLiteral_0= 'final' )
                    // InternalOML.g:6333:4: enumLiteral_0= 'final'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDescriptionKindAccess().getFinalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOML.g:6340:3: (enumLiteral_1= 'partial' )
                    {
                    // InternalOML.g:6340:3: (enumLiteral_1= 'partial' )
                    // InternalOML.g:6341:4: enumLiteral_1= 'partial'
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


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\47\12\uffff";
    static final String dfa_3s = "\1\60\12\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_5s = "\1\0\12\uffff}>";
    static final String[] dfa_6s = {
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 1674:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_0 = input.LA(1);

                         
                        int index20_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_0==48) ) {s = 1;}

                        else if ( LA20_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA20_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA20_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA20_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA20_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA20_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA20_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA20_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA20_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getReifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index20_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\1\62\12\uffff";
    static final String[] dfa_8s = {
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
    static final char[] dfa_7 = DFA.unpackEncodedStringToUnsignedChars(dfa_7s);
    static final short[][] dfa_8 = unpackEncodedStringArray(dfa_8s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_7;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_8;
        }
        public String getDescription() {
            return "()* loopback of 2046:6: ( ({...}? => ( ({...}? => ( (lv_isFunctional_4_0= 'functional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseFunctional_5_0= 'inverseFunctional' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isEssential_6_0= 'essential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isInverseEssential_7_0= 'inverseEssential' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isSymmetric_8_0= 'symmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isAsymmetric_9_0= 'asymmetric' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isReflexive_10_0= 'reflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isIrreflexive_11_0= 'irreflexive' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_isTransitive_12_0= 'transitive' ) ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0==50) ) {s = 1;}

                        else if ( LA22_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA22_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA22_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA22_0 == 42 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA22_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA22_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA22_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA22_0 == 46 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA22_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnreifiedRelationshipAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_9s = "\24\uffff";
    static final String dfa_10s = "\1\4\11\uffff\3\104\1\4\3\26\1\6\2\uffff";
    static final String dfa_11s = "\1\145\11\uffff\3\104\1\7\3\26\1\31\2\uffff";
    static final String dfa_12s = "\1\uffff\1\13\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\10\uffff\1\12\1\11";
    static final String dfa_13s = "\24\uffff}>";
    static final String[] dfa_14s = {
            "\1\13\1\12\1\uffff\1\14\17\uffff\1\2\2\uffff\1\1\5\uffff\1\3\30\uffff\1\7\1\10\46\uffff\1\4\1\5\1\uffff\1\6\1\11",
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

    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_9;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 5091:3: ( ( (lv_annotations_4_0= ruleAnnotation ) ) | ( (lv_closedWorldDefinitions_5_0= ruleDescriptionBoxExtendsClosedWorldDefinitions ) ) | ( (lv_descriptionBoxRefinements_6_0= ruleDescriptionBoxRefinement ) ) | ( (lv_conceptInstances_7_0= ruleConceptInstance ) ) | ( (lv_reifiedRelationshipInstances_8_0= ruleReifiedRelationshipInstance ) ) | ( (lv_reifiedRelationshipInstanceDomains_9_0= ruleReifiedRelationshipInstanceDomain ) ) | ( (lv_reifiedRelationshipInstanceRanges_10_0= ruleReifiedRelationshipInstanceRange ) ) | ( (lv_unreifiedRelationshipInstanceTuples_11_0= ruleUnreifiedRelationshipInstanceTuple ) ) | ( (lv_singletonScalarDataPropertyValues_12_0= ruleSingletonInstanceScalarDataPropertyValue ) ) | ( (lv_singletonStructuredDataPropertyValues_13_0= ruleSingletonInstanceStructuredDataPropertyValue ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200002L,0x000003C000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x38F00073248000B0L,0x00000000FA142C48L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x38F00073348000B0L,0x00000000FA142C4AL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0001FF8000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0004FF8000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0100000000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4000000004000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x000000000003C000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x00000000000BC000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000001E20000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x00000000040BC000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x06000001048000B0L,0x0000003600000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000001F40L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x00000000040000B0L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010000000000000L});

}
