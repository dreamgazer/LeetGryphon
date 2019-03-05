class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailSet = new HashSet<String>();
	for(String email: emails){
		String[] names = email.split("@");
		String localName = names[0].split("\\+")[0];
		String domainName = names[1];
		localName = localName.replace(".", "");
		emailSet.add(localName + "@" + domainName);
	} 
	return emailSet.size();
    }
}
