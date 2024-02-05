import MuiTypography from "../../atoms/typography";
import IconComponent from "../../atoms/icon";
import { SocialLoginProps } from "../../../utils/interfaces";
import { StylesBox } from "./styles";

const SocialLogin = ({ text, src }: SocialLoginProps) => {
  return (
    <StylesBox data-testid="socialIconComponent">
      <IconComponent src={src} />
      <MuiTypography text={text} sx={{ color: "#7D7D89" }} />
    </StylesBox>
  );
};
export default SocialLogin;
