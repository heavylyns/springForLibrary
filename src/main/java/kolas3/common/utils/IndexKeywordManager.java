package kolas3.common.utils;

public class IndexKeywordManager
{
  private char[] RemoveCharSet = new char[78];
  private char[] Latin = new char[118];
  private char[] Cyrillic = new char[87];
  private boolean CharCheck = false;
  private String ResultString = "";

  public IndexKeywordManager()
  {
    this.RemoveCharSet[0] = '\000';this.RemoveCharSet[1] = '\037';this.RemoveCharSet[2] = ' ';this.RemoveCharSet[3] = '/';
    this.RemoveCharSet[4] = ':';this.RemoveCharSet[5] = '@';this.RemoveCharSet[6] = '[';this.RemoveCharSet[7] = '`';
    this.RemoveCharSet[8] = '{';this.RemoveCharSet[9] = '¿';this.RemoveCharSet[10] = 'Ƞ';this.RemoveCharSet[11] = 'ȡ';
    this.RemoveCharSet[12] = 'ʹ';this.RemoveCharSet[13] = 'ʿ';this.RemoveCharSet[14] = '˂';this.RemoveCharSet[15] = '˟';
    this.RemoveCharSet[16] = '˥';this.RemoveCharSet[17] = 'ˮ';this.RemoveCharSet[18] = '̀';this.RemoveCharSet[19] = 'ͯ';
    this.RemoveCharSet[20] = ' ';this.RemoveCharSet[21] = '⁯';this.RemoveCharSet[22] = '⁰';this.RemoveCharSet[23] = '₟';
    this.RemoveCharSet[24] = '₠';this.RemoveCharSet[25] = '⃏';this.RemoveCharSet[26] = '⃐';this.RemoveCharSet[27] = '⃿';
    this.RemoveCharSet[28] = '←';this.RemoveCharSet[29] = '⇿';this.RemoveCharSet[30] = '∀';this.RemoveCharSet[31] = '⋿';
    this.RemoveCharSet[32] = '⌀';this.RemoveCharSet[33] = '⏿';this.RemoveCharSet[34] = '␀';this.RemoveCharSet[35] = '␿';
    this.RemoveCharSet[36] = '⑀';this.RemoveCharSet[37] = '⑟';this.RemoveCharSet[38] = '①';this.RemoveCharSet[39] = '⓿';
    this.RemoveCharSet[40] = '─';this.RemoveCharSet[41] = '╿';this.RemoveCharSet[42] = '▀';this.RemoveCharSet[43] = '▟';
    this.RemoveCharSet[44] = '■';this.RemoveCharSet[45] = '◿';this.RemoveCharSet[46] = '☀';this.RemoveCharSet[47] = '⛿';
    this.RemoveCharSet[48] = '✀';this.RemoveCharSet[49] = '⟏';this.RemoveCharSet[50] = '⠀';this.RemoveCharSet[51] = '⣿';
    this.RemoveCharSet[52] = '　';this.RemoveCharSet[53] = '〿';this.RemoveCharSet[54] = '㈀';this.RemoveCharSet[55] = '㋿';
    this.RemoveCharSet[56] = 40960;this.RemoveCharSet[57] = 42127;this.RemoveCharSet[58] = 42128;this.RemoveCharSet[59] = 42191;
    this.RemoveCharSet[60] = 61440;this.RemoveCharSet[61] = 61695;this.RemoveCharSet[62] = 65056;this.RemoveCharSet[63] = 65071;
    this.RemoveCharSet[64] = 65072;this.RemoveCharSet[65] = 65103;this.RemoveCharSet[66] = 65104;this.RemoveCharSet[67] = 65135;
    this.RemoveCharSet[68] = 65280;this.RemoveCharSet[69] = 65295;this.RemoveCharSet[70] = 65306;this.RemoveCharSet[71] = 65312;
    this.RemoveCharSet[72] = 65339;this.RemoveCharSet[73] = 65344;this.RemoveCharSet[74] = 65371;this.RemoveCharSet[75] = 65381;
    this.RemoveCharSet[76] = 65504;this.RemoveCharSet[77] = 65535;



    this.Latin[0] = 'À';this.Latin[1] = 'A';this.Latin[2] = 'Á';this.Latin[3] = 'A';this.Latin[4] = 'Â';
    this.Latin[5] = 'A';this.Latin[6] = 'Ã';this.Latin[7] = 'A';this.Latin[8] = 'Ä';this.Latin[9] = 'A';
    this.Latin[10] = 'Å';this.Latin[11] = 'A';this.Latin[12] = 'Æ';this.Latin[13] = 'A';this.Latin[14] = 'Ç';
    this.Latin[15] = 'C';this.Latin[16] = 'È';this.Latin[17] = 'E';this.Latin[18] = 'É';this.Latin[19] = 'E';
    this.Latin[20] = 'Ê';this.Latin[21] = 'E';this.Latin[22] = 'Ë';this.Latin[23] = 'E';this.Latin[24] = 'Ì';
    this.Latin[25] = 'I';this.Latin[26] = 'Í';this.Latin[27] = 'I';this.Latin[28] = 'Î';this.Latin[29] = 'I';
    this.Latin[30] = 'Ï';this.Latin[31] = 'I';this.Latin[32] = 'Ð';this.Latin[33] = 'D';this.Latin[34] = 'Ñ';
    this.Latin[35] = 'N';this.Latin[36] = 'Ò';this.Latin[37] = 'O';this.Latin[38] = 'Ó';this.Latin[39] = 'O';
    this.Latin[40] = 'Ô';this.Latin[41] = 'O';this.Latin[42] = 'Õ';this.Latin[43] = 'O';this.Latin[44] = 'Ö';
    this.Latin[45] = 'O';this.Latin[46] = 'Ø';this.Latin[47] = 'O';this.Latin[48] = 'Ù';this.Latin[49] = 'U';
    this.Latin[50] = 'Ú';this.Latin[51] = 'U';this.Latin[52] = 'Û';this.Latin[53] = 'U';this.Latin[54] = 'Ü';
    this.Latin[55] = 'U';this.Latin[56] = 'à';this.Latin[57] = 'a';this.Latin[58] = 'á';this.Latin[59] = 'a';
    this.Latin[60] = 'â';this.Latin[61] = 'a';this.Latin[62] = 'ã';this.Latin[63] = 'a';this.Latin[64] = 'ä';
    this.Latin[65] = 'a';this.Latin[66] = 'å';this.Latin[67] = 'a';this.Latin[68] = 'æ';this.Latin[69] = 'c';
    this.Latin[70] = 'ç';this.Latin[71] = 'c';this.Latin[72] = 'è';this.Latin[73] = 'e';this.Latin[74] = 'é';
    this.Latin[75] = 'e';this.Latin[76] = 'ê';this.Latin[77] = 'e';this.Latin[78] = 'ë';this.Latin[79] = 'e';
    this.Latin[80] = 'ì';this.Latin[81] = 'i';this.Latin[82] = 'í';this.Latin[83] = 'i';this.Latin[84] = 'î';
    this.Latin[85] = 'i';this.Latin[86] = 'ï';this.Latin[87] = 'i';this.Latin[88] = 'ð';this.Latin[89] = 'd';
    this.Latin[90] = 'ñ';this.Latin[91] = 'n';this.Latin[92] = 'ò';this.Latin[93] = 'o';this.Latin[94] = 'ó';
    this.Latin[95] = 'o';this.Latin[96] = 'ô';this.Latin[97] = 'o';this.Latin[98] = 'õ';this.Latin[99] = 'o';
    this.Latin[100] = 'ö';this.Latin[101] = 'o';this.Latin[102] = '÷';this.Latin[103] = 'o';this.Latin[104] = 'ø';
    this.Latin[105] = 'o';this.Latin[106] = 'ù';this.Latin[107] = 'u';this.Latin[108] = 'ú';this.Latin[109] = 'u';
    this.Latin[110] = 'û';this.Latin[111] = 'u';this.Latin[112] = 'ü';this.Latin[113] = 'u';this.Latin[114] = 'ý';
    this.Latin[115] = 'y';this.Latin[116] = 'ÿ';this.Latin[117] = 'y';


    this.Cyrillic[0] = 'Ѐ';this.Cyrillic[1] = 'Е';this.Cyrillic[2] = 'Ё';this.Cyrillic[3] = 'Е';this.Cyrillic[4] = 'Ѓ';
    this.Cyrillic[5] = 'Г';this.Cyrillic[6] = 'Ќ';this.Cyrillic[7] = 'К';this.Cyrillic[8] = 'Ѝ';this.Cyrillic[9] = 'И';
    this.Cyrillic[10] = 'Ў';this.Cyrillic[11] = 'У';this.Cyrillic[12] = 'ѐ';this.Cyrillic[13] = 'е';this.Cyrillic[14] = 'ё';
    this.Cyrillic[15] = 'е';this.Cyrillic[16] = 'г';this.Cyrillic[17] = 'ќ';this.Cyrillic[18] = 'к';this.Cyrillic[19] = 'ѝ';
    this.Cyrillic[20] = 'и';this.Cyrillic[21] = 'ў';this.Cyrillic[22] = 'у';this.Cyrillic[23] = 'Ѹ';this.Cyrillic[24] = 'У';
    this.Cyrillic[25] = 'ү';this.Cyrillic[26] = 'У';this.Cyrillic[27] = 'Ӂ';this.Cyrillic[28] = 'Ж';this.Cyrillic[29] = 'ӂ';
    this.Cyrillic[30] = 'ж';this.Cyrillic[31] = 'Ӑ';this.Cyrillic[32] = 'А';this.Cyrillic[33] = 'ӑ';this.Cyrillic[34] = 'е';
    this.Cyrillic[35] = 'Ӓ';this.Cyrillic[36] = 'А';this.Cyrillic[37] = 'ӓ';this.Cyrillic[38] = 'а';this.Cyrillic[39] = 'Ӗ';
    this.Cyrillic[40] = 'Е';this.Cyrillic[41] = 'ӗ';this.Cyrillic[42] = 'е';this.Cyrillic[43] = 'Ӝ';this.Cyrillic[44] = 'Ж';
    this.Cyrillic[45] = 'ӝ';this.Cyrillic[46] = 'ж';this.Cyrillic[47] = 'Ӟ';this.Cyrillic[48] = 'З';this.Cyrillic[49] = 'ӟ';
    this.Cyrillic[50] = 'з';this.Cyrillic[51] = 'Ӣ';this.Cyrillic[52] = 'И';this.Cyrillic[53] = 'ӣ';this.Cyrillic[54] = 'и';
    this.Cyrillic[55] = 'Ӥ';this.Cyrillic[56] = 'И';this.Cyrillic[57] = 'ӥ';this.Cyrillic[58] = 'и';this.Cyrillic[59] = 'Ӧ';
    this.Cyrillic[60] = 'О';this.Cyrillic[61] = 'ӧ';this.Cyrillic[62] = 'о';this.Cyrillic[63] = 'Ӭ';this.Cyrillic[64] = 'Э';
    this.Cyrillic[65] = 'ӭ';this.Cyrillic[66] = 'э';this.Cyrillic[67] = 'Ӯ';this.Cyrillic[68] = 'У';this.Cyrillic[69] = 'ӯ';
    this.Cyrillic[70] = 'у';this.Cyrillic[71] = 'Ӱ';this.Cyrillic[72] = 'У';this.Cyrillic[73] = 'ӱ';this.Cyrillic[74] = 'у';
    this.Cyrillic[75] = 'Ӳ';this.Cyrillic[76] = 'У';this.Cyrillic[77] = 'ӳ';this.Cyrillic[78] = 'у';this.Cyrillic[79] = 'Ӵ';
    this.Cyrillic[80] = 'Ч';this.Cyrillic[81] = 'ӵ';this.Cyrillic[82] = 'ч';this.Cyrillic[83] = 'Ӹ';this.Cyrillic[84] = 'Ы';
    this.Cyrillic[85] = 'ӹ';this.Cyrillic[86] = 'ы';
  }

  public char[] getCyrillic()
  {
    return this.Cyrillic;
  }

  public void setCyrillic(char[] cyrillic)
  {
    this.Cyrillic = cyrillic;
  }

  public char[] getLatin()
  {
    return this.Latin;
  }

  public void setLatin(char[] latin)
  {
    this.Latin = latin;
  }

  public char[] getRemoveCharSet()
  {
    return this.RemoveCharSet;
  }

  public void setRemoveCharSet(char[] removeCharSet)
  {
    this.RemoveCharSet = removeCharSet;
  }

  public String getResultString()
  {
    return this.ResultString;
  }

  public void setResultString(String resultString)
  {
    this.ResultString = resultString;
  }

  public String CharacterSetControl(String ValidaterStr)
  {
    String TempStr = "";
    String TempFirstStr = "";

    char FirstCharacterSet = '\000';
    try
    {
      setResultString("");

      TempStr = ValidaterStr.toUpperCase();
      TempStr = TempStr.replaceAll(" ", "");
      for (int idx = 0; idx < TempStr.length(); idx++)
      {
        TempFirstStr = TempStr.substring(idx, idx + 1);
        FirstCharacterSet = TempFirstStr.charAt(0);



        byte[] ChararterSetEncoding = TempFirstStr.getBytes();

        this.CharCheck = CharacterSetRemove(FirstCharacterSet);
        if (this.CharCheck) {
          TempFirstStr = "";
        }
        if (!TempFirstStr.equals("")) {
          this.ResultString += CharacterSetModify(TempFirstStr);
        }
        if (TempFirstStr.equals("")) {
          this.ResultString += TempFirstStr;
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return this.ResultString;
  }

  public boolean CharacterSetRemove(char TempCharacterSet)
  {
    int TempCharidx = 0;
    for (int TempCharCount = 0; TempCharCount < this.RemoveCharSet.length; TempCharCount++)
    {
      if (TempCharidx == 78) {
        break;
      }
      if ((TempCharacterSet >= this.RemoveCharSet[(TempCharidx++)]) && (TempCharacterSet <= this.RemoveCharSet[(TempCharidx++)])) {
        return true;
      }
    }
    return false;
  }

  public String CharacterSetModify(String S_resultStr)
  {
    int LatinCharidx = 0;
    int CyrilCharidx = 0;

    char ModifyCharValidate = '\000';
    try
    {
      ModifyCharValidate = S_resultStr.charAt(0);
      for (int TempCharCount = 0; TempCharCount < this.Latin.length; TempCharCount++)
      {
        if ((LatinCharidx % 2 == 0) || (LatinCharidx == 0)) {
          if (ModifyCharValidate == this.Latin[(LatinCharidx++)]) {
            return String.valueOf(this.Latin[LatinCharidx++]);
          }
        }
        if (LatinCharidx == 117) {
          break;
        }
        LatinCharidx++;
      }
      for (int TempCharCount = 0; TempCharCount < this.Cyrillic.length; TempCharCount++)
      {
        if ((CyrilCharidx % 2 == 0) || (CyrilCharidx == 0)) {
          if (ModifyCharValidate == this.Cyrillic[(CyrilCharidx++)]) {
            return String.valueOf(this.Cyrillic[(CyrilCharidx++)]);
          }
        }
        if (CyrilCharidx == 87) {
          break;
        }
        CyrilCharidx++;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return S_resultStr;
  }
}
