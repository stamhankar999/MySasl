package com.datastax;

import java.io.File;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import java.util.HashMap;
import java.util.Map;
import sun.security.krb5.internal.ktab.KeyTab;
import sun.security.krb5.internal.ktab.KeyTabEntry;

public class Main {

    public static void main(String[] args) throws SaslException {
        Map<String, String> props = new HashMap<>();
        props.put(javax.security.sasl.Sasl.SERVER_AUTH, "true");
        props.put(javax.security.sasl.Sasl.QOP, "auth");
        String[] protocols = new String[]{"GSSAPI"};
//        SaslClient client = javax.security.sasl.Sasl.createSaslClient(
//                protocols,
//                null,
//                "dse",
//                "localhost",
//                props, null);
      KeyTab keyTab = KeyTab.getInstance("/Users/sandeeptamhankar/tmp/cassandra.keytab2");
      KeyTabEntry[] entries = keyTab.getEntries();
      for (KeyTabEntry entry : entries) {
        System.out.println(entry.getService().getName());
      }
    }
}
