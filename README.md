CREATE TABLE ActionTypes_Lookup (
ActionTypes_LookupID INT NOT NULL,
ActionTypes_LookupDescription VARCHAR(100) NOT NULL,
SupplCategoryLevel1Code VARCHAR(100) NULL,
SupplCategoryLevel2Code VARCHAR(100) NULL);


CREATE TABLE ApplicationDocs(
ApplicationDocsID INT NOT NULL,
ApplicationDocsTypeID INT NOT NULL,
ApplNo CHAR(6) NOT NULL,
SubmissionType CHAR(10) NOT NULL,
SubmissionNo INT NOT NULL,
ApplicationDocsTitle VARCHAR(100) NULL,
ApplicationDocsURL VARCHAR(200) NULL,
ApplicationDocsDate TIMESTAMP NULL);

CREATE TABLE Applications(
ApplNo CHAR(6) NOT NULL,
ApplType CHAR(5) NOT NULL,
ApplPublicNotes TEXT NULL,
SponsorName CHAR(500) NULL);

CREATE TABLE ApplicationsDocsType_Lookup(
ApplicationDocsType_Lookup_ID INT NOT NULL,
ApplicationDocsType_Lookup_Description VARCHAR(200) NOT NULL);


CREATE TABLE MarketingStatus(
ApplNo CHAR(6) NOT NULL,
ProductNo CHAR(3) NOT NULL,
MarketingStatusID INT NOT NULL);

CREATE TABLE MarketingStatus_Lookup(
MarketingStatusID INT NOT NULL,
MarketingStatusDescription VARCHAR(200) NOT NULL);

CREATE TABLE Products(
ApplNo CHAR(6) NOT NULL,
ProductNo CHAR(6) NOT NULL,
Form VARCHAR(255) NULL,
Strength VARCHAR(240) NULL,
ReferenceDrug INT NULL,
DrugName VARCHAR(125) NULL,
ActiveIngredient VARCHAR(255) NULL,
ReferenceStandard INT NULL);


CREATE TABLE SubmissionClass_Lookup(
SubmissionClassCodeID INT NOT NULL,
SubmissionClassCode VARCHAR(50) NOT NULL,
SubmissionClassCodeDescription VARCHAR(500) NULL);

CREATE TABLE SubmissionPropertyType(
ApplNo CHAR(6) NOT NULL,
SubmissionType CHAR(10) NOT NULL,
SubmissionNo INT NOT NULL,
SubmissionPropertyTypeCode VARCHAR(50) NOT NULL,
SubmissionPropertyTypeID int NOT NULL);

ALTER TABLE SubmissionPropertyType 
   ADD CONSTRAINT SubmissionPropertyTypeCode_IN 
   CHECK (SubmissionPropertyTypeCode = 'Orphan' OR SubmissionPropertyTypeCode = 'NULL');

CREATE TABLE Submissions(
ApplNo CHAR(6) NOT NULL,
SubmissionClassCodeID INT NULL,
SubmissionType CHAR(10) NOT NULL,
SubmissionNo INT NOT NULL,
SubmissionStatus CHAR(2) NULL,
SubmissionStatusDate TIMESTAMP NULL,
SubmissionsPublicNotes TEXT NULL,
ReviewPriority VARCHAR(20));

ALTER TABLE Submissions 
   ADD CONSTRAINT ReviewPriority_IN 
   CHECK (ReviewPriority = 'Standard' OR ReviewPriority = 'Priority' OR ReviewPriority='NULL');

 
CREATE TABLE TE(
ApplNo CHAR(6) NOT NULL,
ProductNo CHAR(3) NOT NULL,
MarketingStatusID INT NOT NULL,
TECode VARCHAR(100) NOT NULL)
