import { Button, ButtonProps } from "@mui/material";

interface ButtonPropsInterface extends ButtonProps {}

const MuiButton = ({ ...buttonProps }: ButtonPropsInterface) => {
  return <Button {...buttonProps} disableElevation disableRipple />;
};

export default MuiButton;
