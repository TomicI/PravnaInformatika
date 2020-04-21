package com.example.demo.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.14.
 */
@SuppressWarnings("rawtypes")
public class UgovorKupoprodaja2 /*extends Contract*/ {
  /*  public static final String BINARY = "6001805460a060020a61ffff02191681556010805460ff191690911790556012805461010061ffff19918216811790925560168054909116909117905560c0604052600660808190527f6e6573746f20000000000000000000000000000000000000000000000000000060a09081526200007d91601b9190620000ae565b50601c805460ff191690553480156200009557600080fd5b5060008054600160a060020a0319163317905562000153565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620000f157805160ff191683800117855562000121565b8280016001018555821562000121579182015b828111156200012157825182559160200191906001019062000104565b506200012f92915062000133565b5090565b6200015091905b808211156200012f57600081556001016200013a565b90565b61138580620001636000396000f3006080604052600436106101f85763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663112b38a781146101fd5780631cb572f814610214578063209822a11461029e57806326640d5f146102d757806326d7e8a0146102ec57806336bbd2fa1461034e5780633c6521b01461037057806348805254146103975780634ffca14a146103c057806351118c25146103d5578063532dc27b146103ea57806359fe01fd146103ff5780635e5f9ee6146104145780636201b6411461042957806368982af61461043e5780636e2601d1146104d55780636e8daa93146104ea578063709b3b51146104ff578063760488eb146105145780637db368ac146105295780637feaa68e1461053e578063830808f4146105535780638aa593e11461055b5780638e55a60f146105705780638f20061a1461058557806398435a161461059a578063a23cbc24146105a2578063a67f63c6146105b7578063ab1694bf146105cc578063b1e8c3f4146105e1578063bcb66c3f146105f6578063be0584121461060b578063c411afe9146106b0578063db8e1597146106c5578063dbb15e25146106da578063dc1f6864146106ef578063e3bda3ec14610704578063f653b7ea146107a8578063f9b4dc58146107bd578063fcd3f3ba146107d2578063ffebb7a8146107e7575b600080fd5b34801561020957600080fd5b506102126107fc565b005b34801561022057600080fd5b50610229610889565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561026357818101518382015260200161024b565b50505050905090810190601f1680156102905780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102aa57600080fd5b506102b3610917565b604051808260018111156102c357fe5b60ff16815260200191505060405180910390f35b3480156102e357600080fd5b50610229610921565b3480156102f857600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261021294369492936024939284019190819084018382808284375094975050843595505050602090920135915061097c9050565b34801561035a57600080fd5b5061021260043515156024351515604435610a01565b34801561037c57600080fd5b50610385610ae0565b60408051918252519081900360200190f35b3480156103a357600080fd5b506103ac610ae6565b604080519115158252519081900360200190f35b3480156103cc57600080fd5b50610385610b07565b3480156103e157600080fd5b50610385610b0d565b3480156103f657600080fd5b50610385610b13565b34801561040b57600080fd5b506103ac610b19565b34801561042057600080fd5b50610385610b22565b34801561043557600080fd5b50610385610b28565b34801561044a57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261021294369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610b2e9650505050505050565b3480156104e157600080fd5b506103ac610b55565b3480156104f657600080fd5b50610229610b63565b34801561050b57600080fd5b506103ac610bbb565b34801561052057600080fd5b50610385610bc4565b34801561053557600080fd5b50610229610bca565b34801561054a57600080fd5b506103ac610c25565b610212610c33565b34801561056757600080fd5b506103ac610d2b565b34801561057c57600080fd5b50610212610d34565b34801561059157600080fd5b50610212610d98565b610212610dfb565b3480156105ae57600080fd5b506103ac610f04565b3480156105c357600080fd5b50610385610f26565b3480156105d857600080fd5b50610229610f2c565b3480156105ed57600080fd5b50610385610f87565b34801561060257600080fd5b50610229610f8d565b34801561061757600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610212958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610fe89650505050505050565b3480156106bc57600080fd5b50610385611037565b3480156106d157600080fd5b5061022961103d565b3480156106e657600080fd5b50610229611098565b3480156106fb57600080fd5b506102126110f3565b34801561071057600080fd5b506040805160206004803580820135601f8101849004840285018401909552848452610212943694929360249392840191908190840183828082843750949750508435955050506020830135926040810135925060608101359150608081013515159060a081013515159060c081013515159060e081013590610100810135906101208101359061014081013590610160013561118c565b3480156107b457600080fd5b50610385611234565b3480156107c957600080fd5b5061038561123a565b3480156107de57600080fd5b50610385611240565b3480156107f357600080fd5b50610229611246565b600154600160a060020a0316331461084c576040805160e560020a62461bcd028152602060048201526017602482015260008051602061133a833981519152604482015290519081900360640190fd5b6001805475ff0000000000000000000000000000000000000000001916750100000000000000000000000000000000000000000017905542600855565b6011805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b820191906000526020600020905b8154815290600101906020018083116108f257829003601f168201915b505050505081565b60105460ff165b90565b6006805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b8160011015801561098e575080600110155b151561099957600080fd5b8160018111156109a557fe5b6010805460ff1916600183818111156109ba57fe5b02179055508060018111156109cb57fe5b6016805461ff0019166101008360018111156109e357fe5b021790555082516109fb9060119060208601906112a1565b50505050565b600154600160a060020a03163314610a51576040805160e560020a62461bcd028152602060048201526017602482015260008051602061133a833981519152604482015290519081900360640190fd5b60135460155460085401014211610adb57426009556001821515148015610a855750601a5460ff6101009091041615156001145b15610a9957601c805460ff19169055610adb565b60018315151415610ac8576001805475ff00000000000000000000000000000000000000000019169055610adb565b6000811115610adb57600b805482900390555b505050565b60175481565b60015474010000000000000000000000000000000000000000900460ff1681565b600f5481565b60145481565b60155481565b601a5460ff1681565b60135481565b600d5481565b8151610b419060059060208501906112a1565b508051610adb9060079060208401906112a1565b601254610100900460ff1681565b6002805460408051602060018416156101000260001901909316849004601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b601c5460ff1681565b600e5481565b6007805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b601a54610100900460ff1681565b600154600160a060020a03163314610c83576040805160e560020a62461bcd028152602060048201526017602482015260008051602061133a833981519152604482015290519081900360640190fd5b60015474010000000000000000000000000000000000000000900460ff168015610cc857506001547501000000000000000000000000000000000000000000900460ff165b1515610cd357600080fd5b600b543414610ce157600080fd5b600154604051600160a060020a0390911690303180156108fc02916000818181858888f19350505050158015610d1b573d6000803e3d6000fd5b50601c805460ff19166001179055565b60125460ff1681565b600154600160a060020a03163314610d84576040805160e560020a62461bcd028152602060048201526017602482015260008051602061133a833981519152604482015290519081900360640190fd5b601454600854014211610d9657426009555b565b600154600160a060020a03163314610de8576040805160e560020a62461bcd028152602060048201526017602482015260008051602061133a833981519152604482015290519081900360640190fd5b600f54600854014211610d965742600955565b600054600160a060020a03163314610e5d576040805160e560020a62461bcd02815260206004820152601a60248201527f6f6d6f6775c487656e6f206a6564696e6f2070726f6461766375000000000000604482015290519081900360640190fd5b60015474010000000000000000000000000000000000000000900460ff168015610ea257506001547501000000000000000000000000000000000000000000900460ff165b1515610ead57600080fd5b600b543414610ebb57600080fd5b60006009541115610d965760008054604051600160a060020a0390911691303180156108fc02929091818181858888f19350505050158015610f01573d6000803e3d6000fd5b50565b6001547501000000000000000000000000000000000000000000900460ff1681565b600b5481565b6004805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b60095481565b6003805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b6001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03851617905581516110239060049060208501906112a1565b5080516109fb9060069060208401906112a1565b60085481565b601b805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b6005805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b600054600160a060020a03163314611155576040805160e560020a62461bcd02815260206004820152601a60248201527f6f6d6f6775c487656e6f206a6564696e6f2070726f6461766375000000000000604482015290519081900360640190fd5b6001805474ff0000000000000000000000000000000000000000191674010000000000000000000000000000000000000000179055565b826001101561119a57600080fd5b8c600390805190602001906111b09291906112a1565b50600a8c9055600b8b9055600c8a9055600d899055601a80546012805460ff199081168b151517909155168915151761ff001916610100881515021790556015859055601484905582600181111561120457fe5b6016805460ff19166001838181111561121957fe5b0217905550600f91909155600e555050505050505050505050565b600c5481565b600a5481565b60185481565b6019805460408051602060026001851615610100026000190190941693909304601f8101849004840282018401909252818152929183018282801561090f5780601f106108e45761010080835404028352916020019161090f565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106112e257805160ff191683800117855561130f565b8280016001018555821561130f579182015b8281111561130f5782518255916020019190600101906112f4565b5061131b92915061131f565b5090565b61091e91905b8082111561131b576000815560010161132556006f6d6f6775c487656e6f206a6564696e6f206b75706375000000000000000000a165627a7a723058205980cf36142a46ce95327311a7f056c3e19b21d0cd1f997a95a65fe0a1f0b2090029";

    public static final String FUNC_SAGLASNOSTKUPCA = "saglasnostKupca";

    public static final String FUNC_IZVRSITELJISPORUKE = "izvrsiteljIsporuke";

    public static final String FUNC_GETSNOSITROSKOVE = "getSnosiTroskove";

    public static final String FUNC_ADRESAKUPAC = "adresaKupac";

    public static final String FUNC_SETISPORUKA = "setIsporuka";

    public static final String FUNC_SAOBRAZNOSTKUPAC = "saobraznostKupac";

    public static final String FUNC_BROJPRIMERAKA = "brojPrimeraka";

    public static final String FUNC_PRODAVACSAGLASAN = "prodavacSaglasan";

    public static final String FUNC_ROKVRACANJAROBE = "rokVracanjaRobe";

    public static final String FUNC_ROKODUSTANAK = "rokOdustanak";

    public static final String FUNC_ROKODPRELASKARIZIKANAKUPCA = "rokOdPrelaskaRizikaNaKupca";

    public static final String FUNC_KUPACODGOVORANZASTETUNEPREUZIMANJA = "kupacOdgovoranZaStetuNepreuzimanja";

    public static final String FUNC_ROKSAOBRAZNOST = "rokSaobraznost";

    public static final String FUNC_ROKISPORUKEMAX = "rokIsporukeMax";

    public static final String FUNC_SETPRODAVAC = "setProdavac";

    public static final String FUNC_PRAVOSAOBRAZNOST = "pravoSaobraznost";

    public static final String FUNC_ROBA = "roba";

    public static final String FUNC_ROBAPRIMLJENA = "robaPrimljena";

    public static final String FUNC_ROKVRACANJANOVCA = "rokVracanjaNovca";

    public static final String FUNC_ADRESAPRODAVAC = "adresaProdavac";

    public static final String FUNC_NESAOBRAZNOSTZAMENOM = "nesaobraznostZamenom";

    public static final String FUNC_UPLATAKUPCA = "uplataKupca";

    public static final String FUNC_UPUTSTVO = "uputstvo";

    public static final String FUNC_ODUSTANAKKUPAC = "odustanakKupac";

    public static final String FUNC_VRACANJEROBE = "vracanjeRobe";

    public static final String FUNC_UPLATAPRODAVCAPOVRACAJ = "uplataProdavcaPovracaj";

    public static final String FUNC_KUPACSAGLASAN = "kupacSaglasan";

    public static final String FUNC_CENA = "cena";

    public static final String FUNC_PODACIKUPAC = "podaciKupac";

    public static final String FUNC_ROBAVRACENADANA = "robaVracenaDana";

    public static final String FUNC_OPISROBE = "opisRobe";

    public static final String FUNC_SETKUPAC = "setKupac";

    public static final String FUNC_ZAKLJUCENDANA = "zakljucenDana";

    public static final String FUNC_NESTO = "nesto";

    public static final String FUNC_PODACIPRODAVAC = "podaciProdavac";

    public static final String FUNC_SAGLASNOSTPRODAVCA = "saglasnostProdavca";

    public static final String FUNC_SETROBA = "setRoba";

    public static final String FUNC_ROKISPORUKE = "rokIsporuke";

    public static final String FUNC_KOLICINAROBE = "kolicinaRobe";

    public static final String FUNC_BROJPRIMERAKAKUPAC = "brojPrimerakaKupac";

    public static final String FUNC_ZAKLJUCENU = "zakljucenU";

    @Deprecated
    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> saglasnostKupca() {
        final Function function = new Function(
                FUNC_SAGLASNOSTKUPCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> izvrsiteljIsporuke() {
        final Function function = new Function(FUNC_IZVRSITELJISPORUKE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getSnosiTroskove() {
        final Function function = new Function(FUNC_GETSNOSITROSKOVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> adresaKupac() {
        final Function function = new Function(FUNC_ADRESAKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setIsporuka(String _izvrsiteljIsporuke, BigInteger strana, BigInteger _troskoviOdustanak) {
        final Function function = new Function(
                FUNC_SETISPORUKA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_izvrsiteljIsporuke), 
                new org.web3j.abi.datatypes.generated.Uint256(strana), 
                new org.web3j.abi.datatypes.generated.Uint256(_troskoviOdustanak)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> saobraznostKupac(Boolean _raskiniUgovor, Boolean _zamena, BigInteger umanjenjaCena) {
        final Function function = new Function(
                FUNC_SAOBRAZNOSTKUPAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(_raskiniUgovor), 
                new org.web3j.abi.datatypes.Bool(_zamena), 
                new org.web3j.abi.datatypes.generated.Uint256(umanjenjaCena)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> brojPrimeraka() {
        final Function function = new Function(FUNC_BROJPRIMERAKA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> prodavacSaglasan() {
        final Function function = new Function(FUNC_PRODAVACSAGLASAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> rokVracanjaRobe() {
        final Function function = new Function(FUNC_ROKVRACANJAROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokOdustanak() {
        final Function function = new Function(FUNC_ROKODUSTANAK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokOdPrelaskaRizikaNaKupca() {
        final Function function = new Function(FUNC_ROKODPRELASKARIZIKANAKUPCA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> kupacOdgovoranZaStetuNepreuzimanja() {
        final Function function = new Function(FUNC_KUPACODGOVORANZASTETUNEPREUZIMANJA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> rokSaobraznost() {
        final Function function = new Function(FUNC_ROKSAOBRAZNOST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokIsporukeMax() {
        final Function function = new Function(FUNC_ROKISPORUKEMAX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setProdavac(String _podaciProdavac, String _adresaProdavac) {
        final Function function = new Function(
                FUNC_SETPRODAVAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_podaciProdavac), 
                new org.web3j.abi.datatypes.Utf8String(_adresaProdavac)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> pravoSaobraznost() {
        final Function function = new Function(FUNC_PRAVOSAOBRAZNOST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> roba() {
        final Function function = new Function(FUNC_ROBA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> robaPrimljena() {
        final Function function = new Function(FUNC_ROBAPRIMLJENA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> rokVracanjaNovca() {
        final Function function = new Function(FUNC_ROKVRACANJANOVCA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> adresaProdavac() {
        final Function function = new Function(FUNC_ADRESAPRODAVAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> nesaobraznostZamenom() {
        final Function function = new Function(FUNC_NESAOBRAZNOSTZAMENOM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> uplataKupca(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_UPLATAKUPCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Boolean> uputstvo() {
        final Function function = new Function(FUNC_UPUTSTVO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> odustanakKupac() {
        final Function function = new Function(
                FUNC_ODUSTANAKKUPAC, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> vracanjeRobe() {
        final Function function = new Function(
                FUNC_VRACANJEROBE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> uplataProdavcaPovracaj(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_UPLATAPRODAVCAPOVRACAJ, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Boolean> kupacSaglasan() {
        final Function function = new Function(FUNC_KUPACSAGLASAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> cena() {
        final Function function = new Function(FUNC_CENA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> podaciKupac() {
        final Function function = new Function(FUNC_PODACIKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> robaVracenaDana() {
        final Function function = new Function(FUNC_ROBAVRACENADANA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> opisRobe() {
        final Function function = new Function(FUNC_OPISROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setKupac(String _kupac, String _podaciKupac, String _adresaKupac) {
        final Function function = new Function(
                FUNC_SETKUPAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _kupac), 
                new org.web3j.abi.datatypes.Utf8String(_podaciKupac), 
                new org.web3j.abi.datatypes.Utf8String(_adresaKupac)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> zakljucenDana() {
        final Function function = new Function(FUNC_ZAKLJUCENDANA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> nesto() {
        final Function function = new Function(FUNC_NESTO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> podaciProdavac() {
        final Function function = new Function(FUNC_PODACIPRODAVAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> saglasnostProdavca() {
        final Function function = new Function(
                FUNC_SAGLASNOSTPRODAVCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setRoba(String _opisRobe, BigInteger _kolicinaRobe, BigInteger _cena, BigInteger _rokIsporuke, BigInteger _rokIsporukeMax, Boolean _kupacOdg, Boolean _uputstvo, Boolean _nesaobraznostZamenom, BigInteger _rokOdPrelaskaRizikaNaKupca, BigInteger _rokOdustanak, BigInteger _deoRobe, BigInteger _rokVracanjaRobe, BigInteger _rokVracanjaNovca) {
        final Function function = new Function(
                FUNC_SETROBA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_opisRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_kolicinaRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_cena), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokIsporuke), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokIsporukeMax), 
                new org.web3j.abi.datatypes.Bool(_kupacOdg), 
                new org.web3j.abi.datatypes.Bool(_uputstvo), 
                new org.web3j.abi.datatypes.Bool(_nesaobraznostZamenom), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokOdPrelaskaRizikaNaKupca), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokOdustanak), 
                new org.web3j.abi.datatypes.generated.Uint256(_deoRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokVracanjaRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokVracanjaNovca)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> rokIsporuke() {
        final Function function = new Function(FUNC_ROKISPORUKE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> kolicinaRobe() {
        final Function function = new Function(FUNC_KOLICINAROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> brojPrimerakaKupac() {
        final Function function = new Function(FUNC_BROJPRIMERAKAKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> zakljucenU() {
        final Function function = new Function(FUNC_ZAKLJUCENU, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UgovorKupoprodaja(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UgovorKupoprodaja(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UgovorKupoprodaja(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UgovorKupoprodaja(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }*/
}
